package cn.edu.scau.youhaitao.dao;

import java.sql.SQLException;
import java.util.List;

import cn.edu.scau.youhaitao.domain.Book;

public interface BookDao {
	
	/**
	 * ��������ͼ��
	 * @return
	 * @throws SQLException 
	 */
	public List<Book> findAllBooks() throws SQLException;
	
	/**
	 * ���ͼ��
	 * @param book
	 * @throws SQLException 
	 */
	public void addBook(Book book) throws SQLException;
	/**
	 * ͨ��ID����ͼ��
	 * @param id
	 * @return
	 * @throws SQLException 
	 */
	public Book findBookById(String isbn) throws SQLException;
	
	/**
	 * �޸�ͼ�� 
	 * @param book
	 * @throws SQLException 
	 */
	public void updateBook(Book book) throws SQLException;
	
	/**
	 * ͨ��idɾ��ͼ��
	 * @param id
	 * @throws SQLException 
	 */
	public void delBook(String isbn) throws SQLException;	
	
	/**
	 * ����ɾ��ͼ��
	 * @param ids
	 * @throws SQLException 
	 */
	public void deleteAllBooks(String[] ids) throws SQLException;
	/**
	 * ��ѯͼ��
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
