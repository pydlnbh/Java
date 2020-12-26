package com.java.se.oop.entity;

/**
 * @Author: PeiYiDing
 * @Date: 2020/12/25
 * @Description: com.java.se.oop.enetity
 * @Version: 1.0
 */
public class User {
    private int id;
    private String password;
    private String email;

    public User() {

    }

    public User(int id, String password) {
        this.id = id;
        this.password = password;
        this.email = id + "@gameschool.com";
    }

    public User(int id, String password, String email) {
        this.id = id;
        this.password = password;
        this.email = email;
    }

    public static void main(String[] args) {
        User user = new User(12, "dfa34");
        System.out.println("id is " + user.id + ", password is " + user.password + ", email is " + user.email);
    }
}
