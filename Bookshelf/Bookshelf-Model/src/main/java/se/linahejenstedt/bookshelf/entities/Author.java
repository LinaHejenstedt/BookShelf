package se.linahejenstedt.bookshelf.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;

@Entity
public class Author extends AbstractEntity {

	private String firstName;
	private String lastName;

	@ManyToMany
	private List<Book> books;

	public Author(String firstName, String lastName) {
		books = new ArrayList<>();
		this.firstName = firstName;
		this.lastName = lastName;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result += prime * ((firstName == null) ? 0 : firstName.hashCode());
		result += prime * ((lastName == null) ? 0 : lastName.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if ((obj == null) || (getClass() != obj.getClass()))
			return false;
		Author other = (Author) obj;

		if (firstName == null) {
			if (other.firstName != null)
				return false;
		} else if (!firstName.equals(other.firstName))
			return false;
		if (lastName == null) {
			if (other.lastName != null)
				return false;
		} else if (!lastName.equals(other.lastName))
			return false;
		return true;
	}

	public List<Book> getBooks() {
		return books;
	}

	public void setBooks(List<Book> books) {
		books.forEach(b -> addBook(b));
	}

	public void addBook(Book book) {
		books.add(book);

		if (!book.getAuthors().contains(this)) {
			book.addAuthor(this);
		}

	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

}
