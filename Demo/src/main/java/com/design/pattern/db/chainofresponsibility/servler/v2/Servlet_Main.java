package com.design.pattern.db.chainofresponsibility.servler.v2;

public class Servlet_Main {
    public static void main(String[] args) {
        Request request = new Request();
        request.setStr("<>>, :)");

        Response response = new Response();
        response.setStr("");

        FilterChain filterChain = new FilterChain();
        filterChain.add(new DateFilter()).add(new CharterFilter());
        filterChain.doFilter(request, response);
        System.out.println(request);
        System.out.println(response);
    }
}
