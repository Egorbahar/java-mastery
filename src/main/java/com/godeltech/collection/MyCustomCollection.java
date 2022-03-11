package com.godeltech.collection;

import java.util.Collection;
import java.util.Iterator;

public class MyCustomCollection<E> implements CustomCollection<E> {
    private static final int DEFAULT_CAPACITY_COLUMN = 10;
    private static final int DEFAULT_CAPACITY_LINE = 10;
    private int sizeArrayLine;
    private int sizeArrayColumn;
    private Object[][] array;
    private int size;

    public MyCustomCollection() {
        this.array = new Object[DEFAULT_CAPACITY_LINE][DEFAULT_CAPACITY_COLUMN];
    }

    public MyCustomCollection(int line, int column) {
        this.array = new Object[line][column];
    }

    @SuppressWarnings("unchecked")
    public E get(int line, int column) {
        return (E) array[line][column];
    }

    public Object set(int line, int column, Object object) {
        if (line <= sizeArrayLine && column <= array[line].length) {
            Object oldValue = this.array[line][column];
            this.array[line][column] = object;
            return oldValue;
        }
        return object;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        int count = 0;
        for (Object[] objects : array) {
            for (Object object : objects) {
                if (object != null) {
                    count++;
                }
            }
        }
        return count == 0;
    }

    @Override
    public boolean contains(Object o) {
        boolean contain = false;
        for (Object[] objects : array) {
            for (Object object : objects) {
                if (object == o) {
                    contain = true;
                    break;
                }
            }
        }
        return contain;
    }

    @Override
    public Iterator<E> iterator() {
        return new Iterator<E>() {
            int lineIndex = 0;
            int columnIndex = 0;

            @Override
            public boolean hasNext() {

                return lineIndex < array.length && columnIndex < array[lineIndex].length && array[lineIndex][columnIndex] != null;
            }

            @Override
            @SuppressWarnings("unchecked")
            public E next() {
                E obj = (E) array[lineIndex][columnIndex++];
                if (columnIndex >= array[lineIndex].length) {
                    lineIndex++;
                    columnIndex = 0;
                }
                return obj;
            }
        };
    }

    @Override
    public Object[] toArray() {
        throw new UnsupportedOperationException("Unsupported Operation");
    }

    @Override
    public <T> T[] toArray(T[] a) {
        throw new UnsupportedOperationException("Unsupported Operation");
    }

    @Override
    public boolean add(E e) {
        if (sizeArrayLine >= array.length) {
            int newLineCapacity = (int) (array.length*1.5);
            int newColumnCapacity = array[0].length;
            Object[][] buf = new Object[newLineCapacity][newColumnCapacity];
            for (int i = 0; i < array.length; i++) {
                System.arraycopy(array[i], 0, buf[i], 0, array[i].length);
            }
            this.array = buf;
        }
        array[sizeArrayLine][sizeArrayColumn++] = e;
        size++;
        if (sizeArrayColumn >= array[sizeArrayLine].length) {
            sizeArrayLine++;
            sizeArrayColumn = 0;
            return true;
        }
        return false;
    }

    @Override
    public boolean remove(Object o) {
        throw new UnsupportedOperationException("Unsupported Operation");
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        throw new UnsupportedOperationException("Unsupported Operation");
    }

    @Override
    public boolean addAll(Collection<? extends E> c) {
        throw new UnsupportedOperationException("Unsupported Operation");
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        throw new UnsupportedOperationException("Unsupported Operation");
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        throw new UnsupportedOperationException("Unsupported Operation");
    }

    @Override
    public void clear() {
        throw new UnsupportedOperationException("Unsupported Operation");
    }
}
