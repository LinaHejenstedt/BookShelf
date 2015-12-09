package se.linahejenstedt.bookshelf.model;

import se.linahejenstedt.bookshelf.entities.Book;

public interface BookConverter {

	Book convertToBook(long iSBN);
	
}
