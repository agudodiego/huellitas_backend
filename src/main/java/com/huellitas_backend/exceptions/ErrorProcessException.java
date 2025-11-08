package com.huellitas_backend.exceptions;

public class ErrorProcessException extends RuntimeException{
    public ErrorProcessException() {
    }

    public ErrorProcessException(String message) {
        super(message);
    }
}