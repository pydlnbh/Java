package com.design.pattern.db.chainofresponsibility;

public interface Filter {
    boolean doFilter(Msg msg);
}
