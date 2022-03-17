package com.godeltech.l3pt1.collection;

import java.util.*;

public class TwoDimensionalArray<E> extends AbstractCollection<E> {
    private static final int DEFAULT_COLUMN_CAPACITY = 10;
    private static final int DEFAULT_ROW_CAPACITY = 10;
    private Object[][] array;

    /**
     * The size of the two-dimensional array (the number of elements it contains).
     */
    private int size;

    private int rowIndex;

    private int columnIndex;
    /**
     * The size of rows two-dimensional array
     */
    private int rowSize;

    public TwoDimensionalArray() {
        this.array = new Object[DEFAULT_ROW_CAPACITY][DEFAULT_COLUMN_CAPACITY];
    }

    public TwoDimensionalArray(int rowCapacity, int columnCapacity) {
        this.array = new Object[rowCapacity][columnCapacity];
    }

    @SuppressWarnings("unchecked")
    public E get(int rowIndex, int columnIndex) {
        return (E) array[rowIndex][columnIndex];
    }

    @SuppressWarnings("unchecked")
    public E set(int rowIndex, int columnIndex, E e) {
        Objects.checkIndex(rowIndex * array[rowIndex].length + columnIndex, size);
        E oldValue = (E) array[rowIndex][columnIndex];
        this.array[rowIndex][columnIndex] = e;
        return oldValue;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public Iterator<E> iterator() {
        return new Iterator<>() {
            int rowIndex = 0;
            int columnIndex = 0;

            @Override
            public boolean hasNext() {
                return rowIndex < array.length && columnIndex < array[rowIndex].length && array[rowIndex][columnIndex] != null;
            }

            @Override
            @SuppressWarnings("unchecked")
            public E next() {
                E obj = (E) array[rowIndex][columnIndex++];
                if (columnIndex >= array[rowIndex].length) {
                    rowIndex++;
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
        if (rowIndex >= array.length) {
            int newLineCapacity = (int) (array.length * 1.5);
            int newColumnCapacity = array[0].length;
            Object[][] buf = new Object[newLineCapacity][newColumnCapacity];
            for (int i = 0; i < array.length; i++) {
                System.arraycopy(array[i], 0, buf[i], 0, array[i].length);
            }
            array = buf;
        }
        if (columnIndex == 0) {
            rowSize++;
        }
        array[rowIndex][columnIndex++] = e;
        size++;
        if (columnIndex >= array[rowIndex].length) {
            rowIndex++;
            columnIndex = 0;
        }
        return true;
    }

    @Override
    public boolean remove(Object o) {
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
