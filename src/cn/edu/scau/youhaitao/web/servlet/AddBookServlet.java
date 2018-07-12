package cn.edu.scau.youhaitao.web.servlet;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.io.FilenameUtils;

import cn.edu.scau.youhaitao.domain.Book;
import cn.edu.scau.youhaitao.service.BookService;
import cn.edu.scau.youhaitao.serviceImpl.BookServiceImpl;
import cn.edu.scau.youhaitao.util.UUIDUtil;

/**
 * Servlet implementation class AddBookServlet
 */
@WebServlet(name = "addBookServlet", urlPatterns = { "/addBookServlet" })
public class AddBookServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AddBookServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		 request.setCharacterEncoding("UTF-8");
		 response.setContentType("UTF-8");
		// ����һ��DiskFileItemFactory����
		DiskFileItemFactory factory = new DiskFileItemFactory();
		// ����һ��ServletFileUpload����
		ServletFileUpload sfu = new ServletFileUpload(factory);
		sfu.setHeaderEncoding("UTF-8");// ����ϴ��ļ�������
		// ����request���󣬷������б���
		List<FileItem> fileItems = new ArrayList<FileItem>(0);
		// ���ڷ�װ��ͨ���������
		Map<String, String[]> map = new HashMap<String, String[]>();
		try {
			fileItems = sfu.parseRequest(request);

			// ����fileItems����
			for (FileItem fileItem : fileItems) {
				if (fileItem.isFormField()) {
					// ��ͨ����
					String name = fileItem.getFieldName();// �õ��ֶε���
					String value = fileItem.getString("UTF-8");// �õ��ֶ�ֵ
					map.put(name, new String[] { value });// ��map�и�ֵ

				} else {
					// �ļ�����
					InputStream inputStream = fileItem.getInputStream();
					String filename = fileItem.getName();// �õ��ϴ����ļ���
					String extension = FilenameUtils.getExtension(filename);
					if (!("jsp".equals(extension) || "exe".equals(extension))) {// �ϴ����ļ�������jsp��exe
						// ����Ŀ¼
						File storeDirectory = new File(this.getServletContext().getRealPath("/upload"));
						if (!storeDirectory.exists()) {
							storeDirectory.mkdirs();// ���Ŀ¼�����ڣ��ʹ���
						}
						// �����ļ���
						if (filename != null) {
							filename = FilenameUtils.getName(filename);
						}
						// Ŀ¼��ɢ
						String childDirectory = makeChildDirectory(storeDirectory, filename); // a/b

						filename = childDirectory + File.separator + filename;
						// �ļ��ϴ�
						fileItem.write(new File(storeDirectory, filename));
						fileItem.delete(); // ɾ����ʱ�ļ�

					}
					map.put(fileItem.getFieldName(), new String[] { filename });// ��ͼƬ�����name��value���浽map��
				}
			}

			Book book = new Book();
			BeanUtils.populate(book, map);
			book.setIsbn(UUIDUtil.getUUID());// ����ͼ����

			// ����ҵ���߼�
			BookServiceImpl bs = new BookServiceImpl();
			bs.addBook(book);

			// �ַ�ת��
			// ��д/�������·��������ڱ����·��
			request.getRequestDispatcher("BookListServlet").forward(request, response);
		} catch (FileUploadException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}

		/*
		 * request.setCharacterEncoding("UTF-8");
		 * response.setContentType("UTF-8");
		 * 
		 * //BookService bs = new BookServiceImpl(); Book book = new Book();
		 * //��ȡ������ try { BeanUtils.populate(book, request.getParameterMap());
		 * book.setIsbn(UUIDUtil.getUUID());//�������һ��isbn } catch
		 * (IllegalAccessException e) { // TODO Auto-generated catch block
		 * e.printStackTrace(); } catch (InvocationTargetException e) { // TODO
		 * Auto-generated catch block e.printStackTrace(); } //����ҵ���߼�
		 * BookService bs = new BookServiceImpl(); bs.addBook(book); //�ַ�ת�� //
		 * ��д/�������·��������ڱ����·��
		 * request.getRequestDispatcher("BookListServlet").forward(request,
		 * response);
		 */

	}

	// Ŀ¼��ɢ
	private String makeChildDirectory(File storeDirectory, String filename) {
		int hashcode = filename.hashCode();// �����ַ�ת����32λhashcode��
		System.out.println(hashcode);
		String code = Integer.toHexString(hashcode); // ��hashcodeת��Ϊ16���Ƶ��ַ�
														// abdsaf2131safsd
		System.out.println(code);
		String childDirectory = code.charAt(0) + File.separator + code.charAt(1); // a/b

		// ����ָ��Ŀ¼
		File file = new File(storeDirectory, childDirectory);
		if (!file.exists()) {
			file.mkdirs();
		}
		return childDirectory;
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
