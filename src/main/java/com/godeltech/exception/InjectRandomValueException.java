package com.godeltech.exception;

public class InjectRandomValueException extends RuntimeException {
    public InjectRandomValueException(String invalidType) {
        super(invalidType);
    }
}
