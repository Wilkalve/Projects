package bestseller;

import java.io.IOException;

public class BookException extends IOException {

	private static final long serialVersionUID = 123456789L;

// handle BookException errors
	public BookException(String errorMessage) {
		super(errorMessage);
		
		System.err.println("BooKException" + errorMessage);
	}
}
