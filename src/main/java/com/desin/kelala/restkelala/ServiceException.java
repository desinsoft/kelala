package com.desin.kelala.restkelala;

public class ServiceException extends Exception {
    public ServiceException(String exceptionMessage, Throwable innerException) {
        super(exceptionMessage, innerException);
    }

    public ServiceException(String exceptionMessage) {
        super(exceptionMessage);
    }
}
