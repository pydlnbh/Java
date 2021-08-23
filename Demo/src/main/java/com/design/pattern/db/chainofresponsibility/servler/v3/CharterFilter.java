package com.design.pattern.db.chainofresponsibility.servler.v3;

public class CharterFilter implements Filter {
    @Override
    public boolean doFilter(Request request, Response response, FilterChain chain) {
        request.str.replace(":)", "^v^");
        chain.doFilter(request, response, chain);
        request.str += " -- CharterFilter";
        response.str += " --CharterFilter";
        return true;
    }
}
