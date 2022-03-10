package com.godeltech.processor;

import com.godeltech.annotation.InjectRandomValue;
import com.godeltech.inject.Inject;
import com.godeltech.inject.InjectBoolean;
import com.godeltech.inject.InjectInteger;
import com.godeltech.inject.InjectString;

import java.lang.reflect.Field;
import java.util.*;

public class InjectRandomValueAnnotationProcessor {
    private final Map<Class<?>, Inject> injectMap = new HashMap<>();

    public void process(Object obj) throws IllegalAccessException {
        Field[] fields = obj.getClass().getDeclaredFields();
        injectMap.put(String.class, new InjectString());
        injectMap.put(Boolean.class, new InjectBoolean());
        injectMap.put(Integer.class, new InjectInteger());
        for (Field field : fields) {
            InjectRandomValue annotation = field.getAnnotation(InjectRandomValue.class);
            if (annotation != null) {
                Inject inject = Optional.ofNullable(injectMap.get(field.getType()))
                        .orElseThrow(() -> new RuntimeException("Invalid type"));
                inject.injectValue(field, obj);
            }
        }
    }
}
