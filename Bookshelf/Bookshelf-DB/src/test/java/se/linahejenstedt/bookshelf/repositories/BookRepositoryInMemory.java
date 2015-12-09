package se.linahejenstedt.bookshelf.repositories;

import java.util.ArrayList;
import java.util.List;

import se.linahejenstedt.bookshelf.entities.Book;

public class BookRepositoryInMemory implements BookRepository {

	List<Book> books;

	public BookRepositoryInMemory() {
		books = new ArrayList<>();
	}

	@Override
	public long count() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void delete(Long arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(Book arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(Iterable<? extends Book> arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteAll() {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean exists(Long arg0) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Iterable<Book> findAll() {
		return books;
	}

	@Override
	public Iterable<Book> findAll(Iterable<Long> arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Book findOne(Long arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends Book> S save(S book) {
		books.add(book);
		return book;
	}

	@Override
	public <S extends Book> Iterable<S> save(Iterable<S> arg0) {
		// TODO Auto-generated method stub
		return null;
	}

}
