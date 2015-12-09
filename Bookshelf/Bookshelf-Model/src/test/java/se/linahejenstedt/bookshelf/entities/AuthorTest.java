package se.linahejenstedt.bookshelf.entities;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import org.junit.Test;

public class AuthorTest {

	@Test
	public void whenTwoAuthorHaveSameFirstAndLastName_ThenTheyAreEqual() {
		String lastName = "last";
		String firstName = "first";
		Author authorOne = new Author(firstName, lastName);
		Author authorTwo = new Author(firstName, lastName);

		assertThat(authorOne, equalTo(authorTwo));
	}

	@Test
	public void whenTwoAuhtorsShareFirstButNotLastName_ThenTheyAreNotEqual() {
		String firstName = "First";
		Author authorOne = new Author(firstName, "Last");
		Author authorTwo = new Author(firstName, "Other Last");

		assertThat(authorOne, not(equalTo(authorTwo)));
	}

	@Test
	public void whenTwoAuthorsShareLastButNotFirstNAme_ThenTHeyAreNotEqual() {
		String lastName = "Last";
		Author authorOne = new Author("first", lastName);
		Author authorTwo = new Author("Other first", lastName);

		assertThat(authorOne, not(equalTo(authorTwo)));
	}
}
