package cn.edu.scau.youhaitao.serviceImpl;

import java.sql.SQLException;
import java.util.List;

import cn.edu.scau.youhaitao.dao.BookDao;
import cn.edu.scau.youhaitao.daoImpl.BookDaoImpl;
import cn.edu.scau.youhaitao.domain.Book;
import cn.edu.scau.youhaitao.domain.PageBean;
import cn.edu.scau.youhaitao.service.BookService;

public class BookServiceImpl implements BookService{
	BookDao bd = new BookDaoImpl();

	@Override
	public List<Book> findAllBooks() {
		try {
			return bd.findAllBooks();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return null;
	}

	@Override
	public void addBook(Book book) {
		try {
			bd.addBook(book);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public Book findBookById(String isbn) {
		try {
			return bd.findBookById(isbn);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public void updateBook(Book book) {
		try {
			bd.updateBook(book);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public void delBook(String isbn) {
		try {
			bd.delBook(isbn);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public void deleteAllBooks(String[] ids) {
		try {
			bd.deleteAllBooks(ids);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public List<Book> searchBooks(String isbn, String category, String name, String minprice, String maxprice) {
		try {
			return bd.searchBooks(isbn,category,name,minprice,maxprice);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

}
