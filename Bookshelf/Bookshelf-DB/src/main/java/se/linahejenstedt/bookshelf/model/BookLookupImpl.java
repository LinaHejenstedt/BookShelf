package se.linahejenstedt.bookshelf.model;

import se.linahejenstedt.bookshelf.entities.Book;

public class BookLookupImpl implements BookLookup {

	private BookLookupSource lookupSource;

	public BookLookupImpl(BookLookupSource lookupSource) {
		this.lookupSource = lookupSource;
	}

	@Override
	public Book findBook(long isbn) {
		return lookupSource.findBook(isbn);
	}

}
