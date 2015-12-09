package se.linahejenstedt.bookshelf.model;

import se.linahejenstedt.bookshelf.entities.Book;
import se.linahejenstedt.bookshelf.exceptions.IncorrectISBNException;

public class BookConverterImpl implements BookConverter {

	private BookLookup bookLookup;
	private ISBNRules iSBNRules;
//TODO: ISBN får bli en egen klass som har isbnrules i sig själv
	public BookConverterImpl(BookLookup bookLookup, ISBNRules isbnRules) {
		this.bookLookup = bookLookup;
		this.iSBNRules = isbnRules;
	}

	@Override
	public Book convertToBook(long iSBN) {
		if (!iSBNRules.correctFormatOfISBN(iSBN)) {
			throw new IncorrectISBNException();
		}
	
		//TODO: Kolla först om boken redan finns i databasen och hämta info därifrån
		//TODO: Om det inte finns i databasen ska det kollas mot Google
		
		Book findBook = bookLookup.findBook(iSBN);
		return findBook;
	}

}
