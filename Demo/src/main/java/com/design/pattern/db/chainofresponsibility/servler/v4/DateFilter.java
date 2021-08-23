package com.design.pattern.db.chainofresponsibility.servler.v4;

public class DateFilter implements Filter {
    @Override
    public void doFilter(Request request, Response response, FilterChain chain) {
        request.str = request.str.replaceAll("<", "{").replaceAll(">", "}");
        request.str += " -- DateFilter";
        chain.doFilter(request, response);
        response.str += " --DateFilter";
    }
}
