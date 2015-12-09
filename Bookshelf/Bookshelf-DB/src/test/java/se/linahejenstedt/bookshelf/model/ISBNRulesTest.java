package se.linahejenstedt.bookshelf.model;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import se.linahejenstedt.bookshelf.util.ISBNTestBuilder;

public class ISBNRulesTest {

	private ISBNRules isbnRules;

	@Before
	public void setUp() {
		isbnRules = new ISBNRules();
	}

	@Test
	public void whenISBNIs12DigitsLong_ThenFalseIsReturned() {
		long shortIsbn = ISBNTestBuilder.anISBN().with12DigitLength().build();
		assertFalse(isbnRules.correctFormatOfISBN(shortIsbn));
	}

	@Test
	public void whenISBNIs14DigitsLong_ThenFalseIsReturend() {
		long longIsbn = ISBNTestBuilder.anISBN().with14DigitLength().build();
		assertFalse(isbnRules.correctFormatOfISBN(longIsbn));
	}

	@Test
	public void whenCorrectISBN_ThenTrueIsReturned() {
		long correctISBN = ISBNTestBuilder.anISBN().withCorrectStart().with13DigitLength().build();
		assertTrue(isbnRules.correctFormatOfISBN(correctISBN));
	}
	
	@Test
	public void whenISBNIsNull_ThenFalseIsReturned(){
		assertFalse(isbnRules.correctFormatOfISBN(null));
	}
}
