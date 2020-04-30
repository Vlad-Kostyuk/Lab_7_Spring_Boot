
package com.app.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;


@ResponseStatus(value = HttpStatus.EXPECTATION_FAILED)
public class ExistBlockedUserException extends RuntimeException{

    public ExistBlockedUserException() {
    }

    public ExistBlockedUserException(String message) {
        super(message);
    }

    public ExistBlockedUserException(String message, Throwable cause) {
        super(message, cause);
    }
    
    
}
