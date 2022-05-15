package com.decoderprojectead.authuser.exception;

import org.springframework.http.HttpStatus;

public abstract class HttpException extends RuntimeException{

    public HttpException(String message) {
        super(message);
    }

    public abstract HttpError getError();

    public abstract HttpStatus getStatus();
}
