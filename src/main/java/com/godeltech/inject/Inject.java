package com.godeltech.inject;

import java.lang.reflect.Field;
import java.util.Random;

public abstract class Inject {
    protected Random random = new Random();

    public abstract void injectValue(Field field, Object obj) throws IllegalAccessException ;
}
