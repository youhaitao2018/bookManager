package cn.edu.scau.youhaitao.web.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.edu.scau.youhaitao.domain.Book;
import cn.edu.scau.youhaitao.service.BookService;
import cn.edu.scau.youhaitao.serviceImpl.BookServiceImpl;

/**
 * Servlet implementation class FindBookByIdServlet
 */
@WebServlet(name = "findBookByIdServlet", urlPatterns = { "/findBookByIdServlet" })
public class FindBookByIdServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FindBookByIdServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("html/text;charset:UTF-8");
		//获取表单数据
		String isbn = request.getParameter("isbn");
		//处理业务逻辑
		BookService bs = new BookServiceImpl();	
		Book book = bs.findBookById(isbn);
		//分发转向
		request.setAttribute("book", book);
		request.getRequestDispatcher("/admin/products/edit.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
