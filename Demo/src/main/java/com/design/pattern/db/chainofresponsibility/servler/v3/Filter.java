package com.design.pattern.db.chainofresponsibility.servler.v3;

public interface Filter {
    boolean doFilter(Request request, Response response, FilterChain chain);
}
