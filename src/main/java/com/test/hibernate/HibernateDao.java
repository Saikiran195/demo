package com.test.hibernate;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class HibernateDao {

	public static void saveBookSubject() {
		SessionFactory sf = null;
		Session session = null;
		Transaction tr = null;

		try {

			sf = HibernateUtil.getSessionFactory();
			session = sf.openSession();
			tr = session.beginTransaction();

			Book book1 = new Book(1004, "corejava", 200, 2, null);
			Book book2 = new Book(1003, "servlet", 300, 3, null);
			Book book3 = new Book(1005, "spring", 400, 4, null);

			Subject javaSubject = new Subject(2007, "J2ee", 3); // Subject
			// javaSubject1 = new Subject(2001,"spring",4); // Subject
			// javaSubject2 = new Subject(2002,"html",5);
			book1.setSubjectid(javaSubject);
			book2.setSubjectid(javaSubject);
			book3.setSubjectid(javaSubject);
			Set<Book> bookset = new HashSet<Book>();
			bookset.add(book1);
			bookset.add(book2);
			bookset.add(book3);
			javaSubject.setBooks(bookset);
			Long SubjectId = (Long) session.save(javaSubject);
			System.out.println(SubjectId);

			tr.commit();
			session.close();

		}

		catch (Exception e) {
			System.out.println(e + "  Error with insert block");

			session.close();
			tr.commit();
		}

	}

	public static List<Book> getALLBookList() {

		List<Book> bookList = null;
		SessionFactory sf = null;
		Session session = null;
		Transaction tr = null;

		try {

			sf = HibernateUtil.getSessionFactory();
			session = sf.openSession();
			tr = session.beginTransaction();
			// String queryStr = "select * from Book";
			Query query = (Query) session.createQuery("from Book");

		} catch (Exception ex) {
			ex.printStackTrace();
			// handle exception here
		} finally {
			try {
				if (session != null)
					session.close();
			} catch (Exception ex) {
			}
		}
		return bookList;
	}

	public void getSearchById() {
		SessionFactory sf = null;
		Session session = null;
		Transaction tr = null;
		Book book = null;
		try {

			sf = HibernateUtil.getSessionFactory();
			session = sf.openSession();
			tr = session.beginTransaction();

			Subject sub = (Subject) session.get(Subject.class, (long) 2007);
			System.out.println(".......sub...." + sub.getSubjectid());
			book = (Book) session.get(Book.class, (long) 1004);
			System.out.println(book.getSubjectid().getBooks().size());
			Set<Book> bookset = book.getSubjectid().getBooks();
			bookset.forEach(b -> System.out.println(b.getTitle()));

		} catch (Exception ex) {
			ex.printStackTrace();
			// handle exception here
		} finally {
			try {
				if (session != null)
					session.close();
			} catch (Exception ex) {
			}
		}
	}

	public void getDeleteById() {
		SessionFactory sf = null;
		Session session = null;
		Transaction tr = null;
		Book book = null;
		try {

			sf = HibernateUtil.getSessionFactory();
			session = sf.openSession();
			tr = session.beginTransaction();

			Subject sub = (Subject) session.get(Subject.class, (long) 2000);
			session.delete(sub);
			tr.commit();
			System.out.println("........delete....." + sub);

		} catch (Exception ex) {
			ex.printStackTrace();
			// handle exception here
		} finally {
			try {
				if (session != null)
					session.close();
			} catch (Exception ex) {
			}
		}
	}

}
