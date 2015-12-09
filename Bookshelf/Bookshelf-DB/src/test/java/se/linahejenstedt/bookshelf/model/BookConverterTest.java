package se.linahejenstedt.bookshelf.model;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasProperty;
import static org.hamcrest.core.Is.isA;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import se.linahejenstedt.bookshelf.entities.Author;
import se.linahejenstedt.bookshelf.entities.Book;
import se.linahejenstedt.bookshelf.exceptions.IncorrectISBNException;
import se.linahejenstedt.bookshelf.util.ISBNTestBuilder;

public class BookConverterTest {

	private BookConverter bookConverter;
	private BookLookupSource lookupSource;

	@Before
	public void setUp() {
		lookupSource = Mockito.mock(BookLookupSource.class);
		BookLookup bookLookup = new BookLookupImpl(lookupSource);
		bookConverter = new BookConverterImpl(bookLookup, new ISBNRules());
	}

	@Test
	public void whenInsertingISBN_BookWithSameISBNValueisReturned() {
		long iSBN = ISBNTestBuilder.anISBN().with13DigitLength().build();
		Book book = new Book(iSBN, "Title", new Author("First", "Last"));
		Mockito.when(lookupSource.findBook(iSBN)).thenReturn(book);
		Book convertedBook = bookConverter.convertToBook(iSBN);

		Mockito.verify(lookupSource, Mockito.times(1)).findBook(iSBN);
		assertThat(convertedBook, isA(Book.class));
		assertThat(convertedBook, hasProperty("title", equalTo(book.getTitle())));
		assertThat(convertedBook.getISBN13(), equalTo(iSBN));
	}

	@Test(expected = IncorrectISBNException.class)
	public void whenInsertingZeroAsISBN_thenIncorrectISBNExceptionWillBeThrown() {
		long iSBN = 0;
		bookConverter.convertToBook(iSBN);
	}

}
