package se.linahejenstedt.bookshelf.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import se.linahejenstedt.bookshelf.entities.Author;
import se.linahejenstedt.bookshelf.entities.Book;
import se.linahejenstedt.bookshelf.repositories.BookRepository;
import se.linahejenstedt.bookshelf.repositories.BookRepositoryInMemory;

public class BookServiceTest {

	private BookShelfService bookService;

	@Before
	public void setUp() {
		BookRepository bookrepository = new BookRepositoryInMemory();
		bookService = new BookShelfServiceImpl(bookrepository);
	}

	@Test
	public void savedBookCanBeRetrieved() {
		Book book = new Book();

		bookService.save(book);

		assertTrue(bookService.getBooks().contains(book));
	}

	@Test
	public void aBookSavedWithAuthor_BookCanBeRetrievedFromAuthor() {
		Book book = new Book(123, "Title", new Author("FirstName", "LastName"));

		List<Book> books = new ArrayList<>();
		for (Author author : book.getAuthors()) {
			books.addAll(author.getBooks());
		}

		assertTrue("The book could not be retrieved from the aúthor", books.contains(book));
	}

	@Test
	public void aBookSavedWithTwoAuthors_BookCanBeRetrievedFromBothAuthor() {
		List<Author> authors = new ArrayList<>();

		authors.add(new Author("FirstName", "LastName"));
		authors.add(new Author("Second", "last"));
		Book book = new Book(123, "Title", authors);

		int count = 0;
		for (Author a : book.getAuthors()) {
			assertTrue("The book could not be retrieved from the aúthor " + a.getFirstName(),
					a.getBooks().contains(book));
			count++;
		}

		assertEquals(2, count);
	}
}
