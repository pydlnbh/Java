package com.java.se.oop.Test;

import com.java.se.oop.entity.Book;

/**
 * @Author: PeiYiDing
 * @Date: 2020/12/25
 * @Description: com.java.se.oop.Test
 */
public class TestBook {

    public static void main(String[] args) {
        Book book = new Book("breaking bad", "James", "U.S", 100);
        book.introduced();
    }
}
