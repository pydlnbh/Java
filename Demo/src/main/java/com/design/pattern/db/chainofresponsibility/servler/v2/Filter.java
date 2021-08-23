package com.design.pattern.db.chainofresponsibility.servler.v2;

public interface Filter {
    boolean doFilter(Request request, Response response);
}
