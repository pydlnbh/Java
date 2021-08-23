package com.design.pattern.db.chainofresponsibility.servler.v4;

public interface Filter {
    void doFilter(Request request, Response response, FilterChain chain);
}
