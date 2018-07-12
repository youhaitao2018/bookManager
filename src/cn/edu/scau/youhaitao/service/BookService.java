package cn.edu.scau.youhaitao.service;

import java.util.List;

import cn.edu.scau.youhaitao.domain.Book;
import cn.edu.scau.youhaitao.domain.PageBean;

public interface BookService {
	/**
	 * ����ȫ��ͼ��
	 * @return
	 */
	public List<Book> findAllBooks();
	
	/**���ͼ��
	 * 
	 * @param book
	 */
	public void addBook(Book book);
	
	/**
	 * ͨ��id����ͼ��
	 * @param id
	 * @return
	 */
	public Book findBookById(String isbn);
	
	/**
	 * ����ͼ��
	 * @param book
	 */
	public void updateBook(Book book);
	
	/**
	 * ͨ��idɾ��ͼ��
	 * @param id
	 */

	public void delBook(String isbn);
	
	/**
	 * ����ɾ��ͼ��
	 * @param ids
	 */
	public void deleteAllBooks(String[] ids);
	
	/**
	 * ��ѯͼ��
	 * @param id
	 * @param category
	 * @param name
	 * @param minprice
	 * @param maxprice
	 * @return
	 */
	public List<Book> searchBooks(String isbn, String category, String name, String minprice, String maxprice);


}
