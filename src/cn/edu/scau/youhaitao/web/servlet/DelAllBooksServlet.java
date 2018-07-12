package cn.edu.scau.youhaitao.web.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.edu.scau.youhaitao.service.BookService;
import cn.edu.scau.youhaitao.serviceImpl.BookServiceImpl;

/**
 * Servlet implementation class DelAllBooksServlet
 */
@WebServlet(name = "delAllBooksServlet", urlPatterns = { "/delAllBooksServlet" })
public class DelAllBooksServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DelAllBooksServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//得到所有id
		String ids[] = request.getParameterValues("ids");
		//调用删除业务
		BookService bs = new BookServiceImpl();
		bs.deleteAllBooks(ids);
		//分发转向
		request.getRequestDispatcher("BookListServlet").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
