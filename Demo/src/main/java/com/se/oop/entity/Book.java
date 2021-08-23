package com.se.oop.entity;

/**
 * @Author: PeiYiDing
 * @Date: 2020/12/25
 * @Description: com.java.se.oop.entity
 */
public class Book {

    private String bookName;
    private String author;
    private String publish;
    private int price;

    public void introduced() {
        System.out.println("书名：" + bookName);
        System.out.println("作者：" + author);
        System.out.println("出版社：" + publish);
        System.out.println("价格：" + price);
    }

    public Book() {
    }

    public Book(String bookName, String author, String publish, int price) {
        this.bookName = bookName;
        this.author = author;
        this.publish = publish;
        this.price = price;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getPublish() {
        return publish;
    }

    public void setPublish(String publish) {
        this.publish = publish;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
