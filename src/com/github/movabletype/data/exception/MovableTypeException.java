package com.github.movabletype.data.exception;

public class MovableTypeException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public MovableTypeException() {
        super();
    }

    public MovableTypeException(String message, Throwable cause) {
        super(message, cause);
    }

    public MovableTypeException(String message) {
        super(message);
    }

    public MovableTypeException(Throwable cause) {
        super(cause);
    }

}
