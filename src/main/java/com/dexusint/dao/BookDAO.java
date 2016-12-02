package com.dexusint.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.Query;
import com.dexusint.model.Book;

public class BookDAO {
	SessionFactory sessionFactory = null;
	Session session = null;
	
	public BookDAO() {
		sessionFactory = new Configuration().configure().buildSessionFactory();
	}
	
	public Book saveBook(Book book) {
		try {
		session = sessionFactory.openSession();
		session.beginTransaction();
		session.save(book);
		session.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(e.toString());
			session.getTransaction().rollback();
		}
		
		return book;
	}
	
	public List<Book> getAllBooks() {

		// get all book info from database
		List<Book> lstBook = sessionFactory.getCurrentSession().createCriteria(Book.class).list();
		return lstBook;
	}
	

}
