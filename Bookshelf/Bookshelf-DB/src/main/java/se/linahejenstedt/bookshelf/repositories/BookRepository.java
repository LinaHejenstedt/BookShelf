package se.linahejenstedt.bookshelf.repositories;

import org.springframework.data.repository.CrudRepository;

import se.linahejenstedt.bookshelf.entities.Book;

public interface BookRepository extends CrudRepository<Book, Long> {

}
