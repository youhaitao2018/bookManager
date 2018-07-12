package cn.edu.scau.youhaitao.web.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.edu.scau.youhaitao.domain.Book;
import cn.edu.scau.youhaitao.serviceImpl.BookServiceImpl;

/**
 * Servlet implementation class SearchBooksServlet
 */
@WebServlet(name = "searchBooksServlet", urlPatterns = { "/searchBooksServlet" })
public class SearchBooksServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SearchBooksServlet() {
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
		String category = request.getParameter("category");
		String name = request.getParameter("name");
		String minprice = request.getParameter("minprice");
		String maxprice = request.getParameter("maxprice");
		
		//调用业务逻辑
		
		BookServiceImpl bs = new BookServiceImpl();
		List<Book> list = bs.searchBooks(isbn,category,name,minprice,maxprice);
		
		//分发转向
		request.setAttribute("books", list);//把list放入request对象中
		request.getRequestDispatcher("/admin/products/list.jsp").forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
