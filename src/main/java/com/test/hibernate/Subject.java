package com.test.hibernate;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name = "sub_table")
public class Subject implements Serializable {
	@Id
	@Column(name = "subjectid")
	private long subjectid;
	@Column(name = "subtitle")
	private String subtitle;
	@Column(name = "durationInHours")
	private int durationInHours;

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "subjectid", fetch = FetchType.EAGER)
	private Set<Book> books = new HashSet<Book>();

	public Subject(long subjectid, String subtitle, int durationInHours) {
		super();
		this.subjectid =subjectid;
		this.subtitle = subtitle;
		this.durationInHours = durationInHours;
	}

	public Subject() {

	}

	
	public long getSubjectid() {
		return subjectid;
	}

	public void setSubjectid(long subjectid) {
		this.subjectid = subjectid;
	}

	public String getSubtitle() {
		return subtitle;
	}

	public void setSubtitle(String subtitle) {
		this.subtitle = subtitle;
	}

	public int getDurationInHours() {
		return durationInHours;
	}

	public void setDurationInHours(int durationInHours) {
		this.durationInHours = durationInHours;
	}

	public Set<Book> getBooks() {
		return books;
	}

	public void setBooks(Set<Book> books) {
		this.books = books;
	}

}