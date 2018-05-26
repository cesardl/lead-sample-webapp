package com.javachap.service.exceptions;

public class ServiceException extends RuntimeException {

    private static final long serialVersionUID = 7310051840977064714L;

    public ServiceException(Throwable cause) {
        super(cause);
    }
}
