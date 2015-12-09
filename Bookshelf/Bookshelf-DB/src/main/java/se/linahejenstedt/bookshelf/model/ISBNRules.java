package se.linahejenstedt.bookshelf.model;

public class ISBNRules {

	public boolean correctFormatOfISBN(Long iSBN) {

		if (iSBN == null) {
			return false;
		}

		String iSBNAsString = iSBN.toString();

		if (!is13DigitsLong(iSBNAsString)) {
			return false;
		}
		if (!startsWith978or979(iSBNAsString)) {
			return false;
		}

		return true;
	}

	private boolean startsWith978or979(String iSBNAsString) {
		return iSBNAsString.startsWith("978") || iSBNAsString.startsWith("979");
	}

	private boolean is13DigitsLong(String iSBN) {
		return iSBN.length() == 13;
	}

}
