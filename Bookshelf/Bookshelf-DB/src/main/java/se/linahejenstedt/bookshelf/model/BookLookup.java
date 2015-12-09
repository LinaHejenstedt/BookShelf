package se.linahejenstedt.bookshelf.model;

import se.linahejenstedt.bookshelf.entities.Book;

public interface BookLookup {

	Book findBook(long isbn);

}
