package com.test.hibernate;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "bk_table")
public class Book implements Serializable {
	@Id
	@Column(name = "bookid")
	private long bookid;
	private String title;
	private double price;
	private int volume;
	private String publishdate;
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name = "subjectid")
	private Subject subjectid;

	public Book() {

	}

	public Book( long bookid,String title, double price, int volume, String publishdate) {
		super();
		this.bookid=bookid;
		this.title = title;
		this.price = price;
		this.volume = volume;
		this.publishdate = publishdate;

	}

	

	public long getBookid() {
		return bookid;
	}

	public void setBookid(long bookid) {
		this.bookid = bookid;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public int getVolume() {
		return volume;
	}

	public void setVolume(int volume) {
		this.volume = volume;
	}

	public String getPublishdate() {
		return publishdate;
	}

	public void setPublishdate(String publishdate) {
		this.publishdate = publishdate;
	}

	public Subject getSubjectid() {
		return subjectid;
	}

	public void setSubjectid(Subject subjectid) {
		this.subjectid = subjectid;
	}

}
