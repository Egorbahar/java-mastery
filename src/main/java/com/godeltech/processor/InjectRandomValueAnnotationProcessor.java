package com.godeltech.processor;

import com.godeltech.annotation.InjectRandomValue;
import com.godeltech.exception.InjectRandomValueException;
import com.godeltech.inject.AbstractInjector;
import com.godeltech.inject.BooleanInjector;
import com.godeltech.inject.IntegerInjector;
import com.godeltech.inject.StringInjector;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class InjectRandomValueAnnotationProcessor {
    private final Map<Class<?>, AbstractInjector> injectMap = new HashMap<>();

    public void process(Object obj) throws IllegalAccessException {
        Field[] fields = obj.getClass().getDeclaredFields();
        injectMap.put(String.class, new StringInjector());
        injectMap.put(Boolean.class, new BooleanInjector());
        injectMap.put(Integer.class, new IntegerInjector());
        for (Field field : fields) {
            InjectRandomValue annotation = field.getAnnotation(InjectRandomValue.class);
            if (annotation != null) {
                AbstractInjector inject = Optional.ofNullable(injectMap.get(field.getType()))
                        .orElseThrow(() -> new InjectRandomValueException("Invalid type " + field.getType()));
                inject.injectValue(field, obj);
            }
        }
    }
}
