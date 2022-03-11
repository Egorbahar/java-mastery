package com.godeltech.collection;

import java.util.Collection;

public interface CustomCollection<E> extends Collection<E> {
    Object get(int line, int column);
    public Object set(int line,int column, Object object);
}
