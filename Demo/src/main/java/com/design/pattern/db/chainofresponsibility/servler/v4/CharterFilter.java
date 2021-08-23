package com.design.pattern.db.chainofresponsibility.servler.v4;

public class CharterFilter implements Filter {
    @Override
    public void doFilter(Request request, Response response, FilterChain chain) {
        request.str.replace(":)", "^v^");
        request.str += " -- CharterFilter";
        chain.doFilter(request, response);
        response.str += " --CharterFilter";
    }
}
