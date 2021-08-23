package com.design.pattern.db.chainofresponsibility;

public class Msg {
    String msg;
    String name;

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getMsg() {
        return msg;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String toString() {
        return "Msg => " + msg;
    }

}
