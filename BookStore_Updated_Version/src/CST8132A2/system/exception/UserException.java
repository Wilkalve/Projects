package CST8132A2.system.exception;

import java.io.IOException;

public class UserException extends IOException{

    private  static final long serialVersionUID = 123456789L;

    public UserException(String errorMessage){
        super(errorMessage);
        System.err.println("UserException" + errorMessage);
    }
}
