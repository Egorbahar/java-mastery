package com.godeltech.task1.exception;

public class InjectRandomValueException extends RuntimeException {
    public InjectRandomValueException(String invalidType) {
        super(invalidType);
    }
}
