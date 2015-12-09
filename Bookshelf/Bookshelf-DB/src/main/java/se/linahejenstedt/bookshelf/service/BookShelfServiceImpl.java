package se.linahejenstedt.bookshelf.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import se.linahejenstedt.bookshelf.entities.Book;
import se.linahejenstedt.bookshelf.repositories.BookRepository;

public final class BookShelfServiceImpl implements BookShelfService {

	private BookRepository bookrepository;

	@Autowired
	public BookShelfServiceImpl(BookRepository bookrepository) {
		this.bookrepository = bookrepository;
	}

	@Override
	public Book save(Book book) {
		return bookrepository.save(book);
	}

	@Override
	public List<Book> getBooks() {
		return (List<Book>) bookrepository.findAll();
	}

	@Override
	public Book findByISBN(String iSBN) {
		// TODO Auto-generated method stub
		return null;
	}

//	@Override
//	public Book getBook(Book book) {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//	@Override
//	public List<Book> getBooksByTitle(String title) {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//	@Override
//	public Author save(Author author) {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//	@Override
//	public List<Author> getAuthors() {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//	@Override
//	public Author getAuthor(Author author) {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//	@Override
//	public List<Author> getAuthorsByLastName(String lastname) {
//		// TODO Auto-generated method stub
//		return null;
//	}

}
