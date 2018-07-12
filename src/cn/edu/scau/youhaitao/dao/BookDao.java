package cn.edu.scau.youhaitao.dao;

import java.sql.SQLException;
import java.util.List;

import cn.edu.scau.youhaitao.domain.Book;

public interface BookDao {
	
	/**
	 * 查找所有图书
	 * @return
	 * @throws SQLException 
	 */
	public List<Book> findAllBooks() throws SQLException;
	
	/**
	 * 添加图书
	 * @param book
	 * @throws SQLException 
	 */
	public void addBook(Book book) throws SQLException;
	/**
	 * 通过ID查找图书
	 * @param id
	 * @return
	 * @throws SQLException 
	 */
	public Book findBookById(String isbn) throws SQLException;
	
	/**
	 * 修改图书 
	 * @param book
	 * @throws SQLException 
	 */
	public void updateBook(Book book) throws SQLException;
	
	/**
	 * 通过id删除图书
	 * @param id
	 * @throws SQLException 
	 */
	public void delBook(String isbn) throws SQLException;	
	
	/**
	 * 批量删除图书
	 * @param ids
	 * @throws SQLException 
	 */
	public void deleteAllBooks(String[] ids) throws SQLException;
	/**
	 * 查询图书
	 * @param id
	 * @param category
	 * @param name
	 * @param minprice
	 * @param maxprice
	 * @return
	 * @throws SQLException 
	 */
	public List<Book> searchBooks(String isbn, String category, String name, String minprice, String maxprice) throws SQLException;

}
