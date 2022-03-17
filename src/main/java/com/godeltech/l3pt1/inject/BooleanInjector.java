package com.godeltech.l3pt1.inject;

import java.lang.reflect.Field;

public class BooleanInjector extends AbstractInjector {
    @Override
    public void injectValue(Field field, Object obj) throws IllegalAccessException {
        field.setAccessible(true);
        field.set(obj, random.nextBoolean());
    }
}
