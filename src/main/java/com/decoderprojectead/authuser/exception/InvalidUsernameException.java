package com.decoderprojectead.authuser.exception;

import lombok.Getter;
import org.springframework.http.HttpStatus;
@Getter
public class InvalidUsernameException extends HttpException{

    private static final String DEFAULT_MESSAGE = "error.invalidUsername";

    private final HttpError error;

    public InvalidUsernameException(HttpError error) {
        super(DEFAULT_MESSAGE);
        this.error = new HttpError(DEFAULT_MESSAGE);
        this.error.addDetail(error);
    }

    @Override
    public HttpError getError() {
        return error;
    }

    @Override
    public HttpStatus getStatus() {
        return HttpStatus.BAD_REQUEST;
    }
}
