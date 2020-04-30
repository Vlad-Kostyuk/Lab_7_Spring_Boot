
package com.app.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;


@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class NoSuchPostException  extends   RuntimeException {

    public NoSuchPostException() {
    }

    public NoSuchPostException(String message) {
        super(message);
    }

    public NoSuchPostException(String message, Throwable cause) {
        super(message, cause);
    }
    
}
