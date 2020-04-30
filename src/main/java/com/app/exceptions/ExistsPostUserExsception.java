
package com.app.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;


@ResponseStatus(value = HttpStatus.EXPECTATION_FAILED)
public class ExistsPostUserExsception extends   RuntimeException {

    public ExistsPostUserExsception() {
    }

    public ExistsPostUserExsception(String message) {
        super(message);
    }

    public ExistsPostUserExsception(String message, Throwable cause) {
        super(message, cause);
    }
    
    
}
