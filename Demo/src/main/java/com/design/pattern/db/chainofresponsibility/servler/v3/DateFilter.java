package com.design.pattern.db.chainofresponsibility.servler.v3;

public class DateFilter implements Filter {
    @Override
    public boolean doFilter(Request request, Response response, FilterChain chain) {
        request.str = request.str.replaceAll("<", "{").replaceAll(">", "}");
        chain.doFilter(request, response, chain);
        request.str += " -- DateFilter";
        response.str += " --DateFilter";
        return true;
    }
}
