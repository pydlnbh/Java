package com.design.pattern.db.chainofresponsibility.servler.v1;

import com.design.pattern.db.chainofresponsibility.servler.v2.Request;
import com.design.pattern.db.chainofresponsibility.servler.v2.Response;

public class Servlet_Main {
    public static void main(String[] args) {
        com.design.pattern.db.chainofresponsibility.servler.v2.Request request = new Request();
        request.setStr("<>>, :)");

        Response response = new Response();
        response.setStr("");

        FilterChain filterChain = new FilterChain();
        filterChain.add(new DateFilter()).add(new CharterFilter());
        filterChain.doFilter(request, response);
        System.out.println(request);
    }
}
