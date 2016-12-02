package com.dexusint.resource;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.dexusint.dao.BookDAO;
import com.dexusint.model.Book;

@Path("books")
public class BookResource {
	
	BookDAO bookDao = new BookDAO();
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Book> getAllBooks() {
		return bookDao.getAllBooks();
	}

}
