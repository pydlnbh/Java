package com.design.pattern.db.chainofresponsibility.servler.v1;

import com.design.pattern.db.chainofresponsibility.servler.v2.Request;
import com.design.pattern.db.chainofresponsibility.servler.v2.Response;

public class DateFilter implements Filter{
    @Override
    public boolean doFilter(Request request, Response response) {
        String r = request.getStr();
        r = r.replaceAll("<", "{").replaceAll(">", "}");
        request.setStr(r);
        return true;
    }
}
