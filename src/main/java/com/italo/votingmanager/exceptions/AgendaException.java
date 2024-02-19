package com.italo.votingmanager.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class AgendaException extends RuntimeException{
    public AgendaException(String message) {
        super(message);
    }
}
