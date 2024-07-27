package CST8132A2.system.exception;

import java.io.IOException;

public class BookException extends IOException {

    private static final long serialVersionUID = 123456789L;

    public BookException(String errorMessage){
        super(errorMessage);
        System.err.println("BookException" + errorMessage);
    }
}
