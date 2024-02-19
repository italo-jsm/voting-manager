package com.italo.votingmanager.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class EnumParseException extends RuntimeException{
    public EnumParseException(String message) {
        super(message);
    }
}
