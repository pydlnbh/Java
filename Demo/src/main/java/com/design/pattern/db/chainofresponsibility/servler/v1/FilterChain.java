package com.design.pattern.db.chainofresponsibility.servler.v1;

import com.design.pattern.db.chainofresponsibility.servler.v2.Request;
import com.design.pattern.db.chainofresponsibility.servler.v2.Response;

import java.util.ArrayList;
import java.util.List;

public class FilterChain implements Filter{

    List<Filter> filters = new ArrayList<>();

    public FilterChain add(Filter filter) {
        filters.add(filter);
        return this;
    }

    @Override
    public boolean doFilter(Request request, Response response) {
        for (Filter filter : filters) {
            filter.doFilter(request, response);
        }
        return true;
    }
}
