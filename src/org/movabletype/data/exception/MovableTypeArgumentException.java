package com.github.movabletype.data.exception;

public class MovableTypeArgumentException extends MovableTypeException {

    private static final long serialVersionUID = 1L;

    public MovableTypeArgumentException() {
        super();
    }

    public MovableTypeArgumentException(String message, Throwable cause) {
        super(message, cause);
    }

    public MovableTypeArgumentException(String message) {
        super(message);
    }

    public MovableTypeArgumentException(Throwable cause) {
        super(cause);
    }

}