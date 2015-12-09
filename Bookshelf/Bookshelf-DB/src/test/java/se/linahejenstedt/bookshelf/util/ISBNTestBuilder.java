package se.linahejenstedt.bookshelf.util;

public class ISBNTestBuilder {

	StringBuilder isbnString;

	private ISBNTestBuilder() {
		isbnString = new StringBuilder("979");
	}

	public static ISBNTestBuilder anISBN() {

		return new ISBNTestBuilder();
	}

	public ISBNTestBuilder withCorrectStart() {
		return this;
	}

	public ISBNTestBuilder withInCorrectStart() {
		isbnString.replace(2, 2, "5");
		return this;
	}

	public ISBNTestBuilder with13DigitLength() {
		while (isbnString.length() < 13) {
			isbnString.append("1");
		}
		return this;
	}

	public ISBNTestBuilder with14DigitLength() {
		while (isbnString.length() < 14) {
			isbnString.append("1");
		}
		return this;
	}

	public ISBNTestBuilder with12DigitLength() {
		int length = isbnString.length();
		if (length < 12) {
			while (isbnString.length() < 12) {
				isbnString.append("1");
			}
		}
		return this;
	}

	public long build() {
		return Long.valueOf(isbnString.toString());
	}
}
