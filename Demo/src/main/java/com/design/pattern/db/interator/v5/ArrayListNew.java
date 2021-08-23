package com.design.pattern.db.interator.v5;

public class ArrayListNew<E> implements CollectionNew<E> {
    E[] arr = (E[]) new Object[10];
    private int index = 0;

    @Override
    public void add(E o) {
        if (index == arr.length) {
            E[] newArr = (E[]) new Object[arr.length * 2];
            System.arraycopy(arr, 0, newArr, 0, arr.length);
            arr = newArr;
        }
        arr[index] = o;
        index++;
    }

    @Override
    public int size() {
        return index;
    }

    @Override
    public IteratorNew<E> iterator() {
        return new ArrayListIterator<E>();
    }

    private class ArrayListIterator<E> implements IteratorNew<E> {
        private int CurIndex = 0;
        @Override
        public boolean hasNext() {
            return CurIndex < index;
        }

        @Override
        public E next() {
            E val = (E) arr[CurIndex];
            CurIndex++;
            return val;
        }
    }
}
