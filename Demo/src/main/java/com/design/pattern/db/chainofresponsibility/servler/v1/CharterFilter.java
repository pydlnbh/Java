package com.design.pattern.db.chainofresponsibility.servler.v1;

import com.design.pattern.db.chainofresponsibility.servler.v2.Request;
import com.design.pattern.db.chainofresponsibility.servler.v2.Response;

public class CharterFilter implements Filter{
    @Override
    public boolean doFilter(Request request, Response response) {
        String r = request.getStr();
        r = r.replace(":)", "^v^");
        request.setStr(r);
        return true;
    }
}
