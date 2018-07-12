package cn.edu.scau.youhaitao.daoImpl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import cn.edu.scau.youhaitao.dao.BookDao;
import cn.edu.scau.youhaitao.domain.Book;
import cn.edu.scau.youhaitao.util.C3P0Util;

public class BookDaoImpl implements BookDao {

	@Override
	public List<Book> findAllBooks() throws SQLException {
		QueryRunner qr = new QueryRunner(C3P0Util.getDataSource());
		return qr.query("select * from book", new BeanListHandler<Book>(Book.class));
	}

	@Override
	public void addBook(Book book) throws SQLException {
		QueryRunner qr = new QueryRunner(C3P0Util.getDataSource());
		qr.update("insert into book values(?,?,?,?,?,?,?)", book.getIsbn(), book.getName(), book.getPrice(), book.getPnum(),
				book.getCategory(), book.getDescription(),book.getBookCoverPath());

	}

	@Override
	public Book findBookById(String isbn) throws SQLException {
		QueryRunner qr = new QueryRunner(C3P0Util.getDataSource());
		return qr.query("select * from book where isbn=?", new BeanHandler<Book>(Book.class), isbn);
	}

	@Override
	public void updateBook(Book book) throws SQLException {
		QueryRunner qr = new QueryRunner(C3P0Util.getDataSource());
		qr.update("update book set name=?,price=?,pnum=?,category=?,description=? where isbn=?", book.getName(),
				book.getPrice(), book.getPnum(), book.getCategory(), book.getDescription(), book.getIsbn());

	}

	@Override
	public void delBook(String isbn) throws SQLException {
		QueryRunner qr = new QueryRunner(C3P0Util.getDataSource());
		qr.update("delete from book where isbn=?", isbn);

	}

	@Override
	public void deleteAllBooks(String[] ids) throws SQLException {
		QueryRunner qr = new QueryRunner(C3P0Util.getDataSource());
		Object[][] params = new Object[ids.length][];
		for (int i = 0; i < params.length; i++) {
			params[i] = new Object[] { ids[i] }; // 循环给每个一维数组中的元素赋值，值是id
		}
		qr.batch("delete from book where isbn=?", params);
	}

	@Override
	public List<Book> searchBooks(String isbn, String category, String name, String minprice, String maxprice) throws SQLException {
		QueryRunner qr = new QueryRunner(C3P0Util.getDataSource());
		String sql = "select * from book where 1=1";
		List list = new ArrayList();
		if(!"".equals(isbn.trim())){
			sql+=" and isbn like ?"; //  不能在这写%   %'1002'%
			list.add("%"+isbn.trim()+"%");// '%1002%'
		}
		
		if(!"".equals(category.trim())){
			sql+=" and category=?";
			list.add(category.trim());
		}
		
		if(!"".equals(name.trim())){
			sql+=" and name like ?";
			list.add("%"+name.trim()+"%");
		}
		
		if(!"".equals(minprice.trim())){
			sql+=" and price>?";
			list.add(minprice.trim());
		}
		if(!"".equals(maxprice.trim())){
			sql+=" and price< ?";
			list.add(maxprice.trim());
		}
		
		return qr.query(sql, new BeanListHandler<Book>(Book.class),list.toArray());
	}
}
