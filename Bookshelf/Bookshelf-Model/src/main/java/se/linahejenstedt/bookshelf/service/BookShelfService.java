package se.linahejenstedt.bookshelf.service;

import java.util.List;

import se.linahejenstedt.bookshelf.entities.Book;

public interface BookShelfService {

	Book save(Book book);

	List<Book> getBooks();
	
	Book findByISBN(String iSBN);
	
//	Book getBook(Book book);
//	
//	List<Book> getBooksByTitle(String title);
//
//	Author save(Author author);
//
//	List<Author> getAuthors();
//	
//	Author getAuthor(Author author);
//	
//	List<Author> getAuthorsByLastName(String lastname);
}
