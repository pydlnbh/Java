package com.design.pattern.db.chainofresponsibility.servler.v2;

public class DateFilter implements Filter {
    @Override
    public boolean doFilter(Request request, Response response) {
        String r = request.getStr();
        r = r.replaceAll("<", "{").replaceAll(">", "}");
        request.setStr(r);
        response.str += " --DateFilter";
        return true;
    }
}
