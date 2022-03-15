package com.godeltech.task1.inject;

import java.lang.reflect.Field;
import java.util.Random;

public abstract class AbstractInjector {
    protected Random random = new Random();

    public abstract void injectValue(Field field, Object obj) throws IllegalAccessException;
}
