package se.linahejenstedt.bookshelf.entities;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.not;

import org.junit.Test;

public class BookTest {

	@Test
	public void whenTwoBooksHasSameISBN13_ThenBooksAreEqual() {
		Book bookOne = new Book(123L, "Title1", new Author("", ""));
		Book bookTwo = new Book(123L, "Annan titel", new Author("new", "author"));

		assertThat(bookOne, equalTo(bookTwo));
	}

	@Test
	public void whenTwoBooksHasSameTitleAndAuthor_ButDifferentISBN_ThenBooksAreNotEqual() {
		String title = "Title1";
		Author author = new Author("", "");
		Book bookOne = new Book(123L, title, author);
		Book bookTwo = new Book(124L, title, author);

		assertThat(bookOne, not(equalTo(bookTwo)));
	}

}
