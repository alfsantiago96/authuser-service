package com.decoderprojectead.authuser.exception;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.ArrayList;
import java.util.List;

public class HttpError {

    private String message;
    private String code;
    private Object object;
    private List<HttpError> details;

    @JsonIgnore
    private Object[] messageArgs;

    public HttpError() {
    }

    public HttpError(String message, Object... args) {
        this.message = message;
        this.messageArgs = args;
    }

    public static HttpErrorBuilder message(String message, Object... args) {
        return new HttpErrorBuilder(message, args);
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Object getObject() {
        return object;
    }

    public void setObject(Object object) {
        this.object = object;
    }

    public List<HttpError> getDetails() {
        return details;
    }

    public void setDetails(List<HttpError> details) {
        this.details = details;
    }

    public void addDetail(HttpError detailError) {
        if(details == null) {
            details = new ArrayList<>();
        }
        details.add(detailError);
    }

    public void addDetail(String detailMessage, Object... detailMessageArgs) {
        addDetail(new HttpError(detailMessage, detailMessageArgs));
    }

    public Object[] getMessageArgs() {
        return (messageArgs == null || messageArgs.length == 0) ? null : messageArgs;
    }

}
