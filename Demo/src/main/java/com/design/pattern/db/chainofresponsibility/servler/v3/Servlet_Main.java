package com.design.pattern.db.chainofresponsibility.servler.v3;

public class Servlet_Main {
    public static void main(String[] args) {
        Request request = new Request();
        request.setStr("<>>, :)");

        Response response = new Response();
        response.setStr("");

        FilterChain chian = new FilterChain();
        chian.add(new DateFilter()).add(new CharterFilter());
        chian.doFilter(request, response, chian);
        System.out.println(request);
        System.out.println(response);
    }
}
