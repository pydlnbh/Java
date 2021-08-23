package com.design.pattern.db.interator.v5;

public interface CollectionNew<E> {
    void add(E o);

    int size();

    IteratorNew<E> iterator();
}
