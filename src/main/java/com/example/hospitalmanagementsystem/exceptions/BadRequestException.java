package com.example.hospitalmanagementsystem.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class BadRequestException extends RuntimeException{
    private String resourceName;
    private String fieldName;

    public BadRequestException(String resourceName, String fieldName) {
        super(String.format("%s has wrong %s value'", resourceName, fieldName));
        this.resourceName = resourceName;
        this.fieldName = fieldName;
    }
}
