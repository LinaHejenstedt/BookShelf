package se.linahejenstedt.bookshelf.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;

@Entity
public class Book extends AbstractEntity {

	private long iSBN13;
	private String title;

	@ManyToMany
	private List<Author> authors;

	public Book() {
		authors = new ArrayList<>();
	}

	public Book(long isbn13, String title, Author author) {
		this.authors = new ArrayList<>();

		iSBN13 = isbn13;
		this.title = title;
		addAuthor(author);
	}

	public Book(long iSBN13, String title, List<Author> authors) {
		this.authors = new ArrayList<>();
		this.iSBN13 = iSBN13;
		this.title = title;
		setAuthors(authors);
	}

	public Book(long iSBN13) {
		this.iSBN13=iSBN13;
	}

	public void setAuthors(List<Author> authors) {
		authors.forEach(a -> addAuthor(a));
	}

	public void addAuthor(Author a) {
		authors.add(a);

		if (!a.getBooks().contains(this)) {
			a.addBook(this);
		}
	}

	@Override
	public int hashCode() {
		final int prime = 37;
		int result = 1;
		result += prime * ((iSBN13 == 0) ? 0 : ((Long) iSBN13).hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;

		if ((obj == null) || (getClass() != obj.getClass()))
			return false;

		Book other = (Book) obj;
		if (iSBN13 != other.iSBN13)
			return false;

		return true;
	}

	public long getISBN13() {
		return iSBN13;
	}

	public String getTitle() {
		return title;
	}

	public List<Author> getAuthors() {
		return authors;
	}

}
