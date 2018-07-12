package cn.edu.scau.youhaitao.service;

import java.util.List;

import cn.edu.scau.youhaitao.domain.Book;
import cn.edu.scau.youhaitao.domain.PageBean;

public interface BookService {
	/**
	 * 查找全部图书
	 * @return
	 */
	public List<Book> findAllBooks();
	
	/**添加图书
	 * 
	 * @param book
	 */
	public void addBook(Book book);
	
	/**
	 * 通过id查找图书
	 * @param id
	 * @return
	 */
	public Book findBookById(String isbn);
	
	/**
	 * 更新图书
	 * @param book
	 */
	public void updateBook(Book book);
	
	/**
	 * 通过id删除图书
	 * @param id
	 */

	public void delBook(String isbn);
	
	/**
	 * 批量删除图书
	 * @param ids
	 */
	public void deleteAllBooks(String[] ids);
	
	/**
	 * 查询图书
	 * @param id
	 * @param category
	 * @param name
	 * @param minprice
	 * @param maxprice
	 * @return
	 */
	public List<Book> searchBooks(String isbn, String category, String name, String minprice, String maxprice);


}
