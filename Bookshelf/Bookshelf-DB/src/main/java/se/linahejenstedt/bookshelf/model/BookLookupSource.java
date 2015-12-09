package se.linahejenstedt.bookshelf.model;

import se.linahejenstedt.bookshelf.entities.Book;

public interface BookLookupSource {

	Book findBook(long isbn);

}
