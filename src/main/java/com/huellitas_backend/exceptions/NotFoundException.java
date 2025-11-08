package com.huellitas_backend.exceptions;

public class NotFoundException extends RuntimeException{
    public NotFoundException(String detail) {
        super(detail);
    }
}
