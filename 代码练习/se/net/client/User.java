package com.java.se.net.client;

import java.io.Serializable;

/**
 * @Author: PeiYiDing
 * @Date: 2021/1/1
 * @Description: com.java.se.net.client
 */
public class User implements Serializable {
    // 序列化ID
    private static final long serialVersionUID = -3763679271711628753L;
    // 成员变量
    private String name;
    private String password;

    public User() {}

    public User(String name, String password) {
        this.name = name;
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
