package com.godeltech.inject;

import java.lang.reflect.Field;

public class InjectInteger extends Inject {

    @Override
    public void injectValue(Field field, Object obj) throws IllegalAccessException {
        field.setAccessible(true);
        field.set(obj, random.nextInt());
    }
}
