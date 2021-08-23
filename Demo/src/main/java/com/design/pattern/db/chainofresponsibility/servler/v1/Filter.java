package com.design.pattern.db.chainofresponsibility.servler.v1;

import com.design.pattern.db.chainofresponsibility.servler.v2.Request;
import com.design.pattern.db.chainofresponsibility.servler.v2.Response;

public interface Filter {
    boolean doFilter(Request request, Response response);
}
