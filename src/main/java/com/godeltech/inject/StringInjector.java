package com.godeltech.inject;

import com.godeltech.annotation.InjectRandomValue;

import java.lang.reflect.Field;

public class StringInjector extends AbstractInjector {
    @Override
    public void injectValue(Field field, Object obj) throws IllegalAccessException {
        InjectRandomValue annotation = field.getAnnotation(InjectRandomValue.class);
        field.setAccessible(true);
        field.set(obj, generateRandomString(annotation.stringCapacity()));
    }

    private String generateRandomString(int length) {
        StringBuilder randomString = new StringBuilder();
        while (randomString.length() < length) {
            randomString.append(Integer.toHexString(random.nextInt()));
        }
        return randomString.substring(0, length);
    }
}