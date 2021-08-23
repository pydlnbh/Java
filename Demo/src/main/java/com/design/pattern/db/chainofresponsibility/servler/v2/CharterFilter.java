package com.design.pattern.db.chainofresponsibility.servler.v2;

public class CharterFilter implements Filter {
    @Override
    public boolean doFilter(Request request, Response response) {
        String r = request.getStr();
        r = r.replace(":)", "^v^");
        request.setStr(r);
        response.str += " --CharterFilter";
        return true;
    }
}
