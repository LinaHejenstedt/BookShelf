package se.linahejenstedt.bookshelf.exceptions;

public class IncorrectISBNException extends RuntimeException{

	private static final long serialVersionUID = 1536003563565451556L;

	public IncorrectISBNException() {
		super("Incorrect ISBN format");
	}

	public IncorrectISBNException(String arg0, Throwable arg1, boolean arg2, boolean arg3) {
		super(arg0, arg1, arg2, arg3);
	}

	public IncorrectISBNException(String arg0, Throwable arg1) {
		super(arg0, arg1);
	}

	public IncorrectISBNException(String arg0) {
		super(arg0);
	}

	public IncorrectISBNException(Throwable arg0) {
		super(arg0);
	}

	
	
}
