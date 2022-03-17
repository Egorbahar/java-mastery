package com.godeltech.l3pt1.exception;

public class InjectRandomValueException extends RuntimeException {
    public InjectRandomValueException(String invalidType) {
        super(invalidType);
    }
}
