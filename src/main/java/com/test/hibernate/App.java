package com.test.hibernate;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

/**
 * Hello world!
 *
 */
public class App {

	public static void main(String[] a) {
		HibernateDao dao = new HibernateDao();

	//	 dao.saveBookSubject();

  
	
		
		dao.getSearchById();
		// System.out.println("bookfound"+dao.getBookById((long) 1001));

		//dao.getDeleteById();
		
		
	}

}