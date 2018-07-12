package cn.edu.scau.youhaitao.domain;

import java.io.Serializable;

public class Book implements Serializable{
	private String isbn;
	private String name;
	private double price;
	private int pnum;
	private String category;
	private String description;
	private String bookCoverPath;

	public String getBookCoverPath() {
		return bookCoverPath;
	}
	public void setBookCoverPath(String bookCoverPath) {
		this.bookCoverPath = bookCoverPath;
	}
	public String getIsbn() {
		return isbn;
	}
	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public int getPnum() {
		return pnum;
	}
	public void setPnum(int pnum) {
		this.pnum = pnum;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	

}
