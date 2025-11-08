package com.huellitas_backend.exceptions;

public class DuplicateException extends RuntimeException{
    public DuplicateException(String message) {
        super(message);
    }
}