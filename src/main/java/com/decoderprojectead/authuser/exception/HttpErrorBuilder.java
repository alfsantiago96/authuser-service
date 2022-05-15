package com.decoderprojectead.authuser.exception;

public class HttpErrorBuilder {

    protected HttpError error;

    public HttpErrorBuilder(String message, Object... args) {
        error = new HttpError(message, args);
    }

    public static HttpErrorBuilder create(String message, Object... args) {
        return new HttpErrorBuilder(message, args);
    }

    public HttpErrorBuilder code(String code) {
        error.setCode(code);
        return this;
    }

    public HttpErrorBuilder object(Object objeto) {
        error.setObject(objeto);
        return this;
    }

    public HttpErrorBuilder detail(HttpError detail) {
        error.addDetail(detail);
        return this;
    }

    public HttpError build() {
        return error;
    }
}
