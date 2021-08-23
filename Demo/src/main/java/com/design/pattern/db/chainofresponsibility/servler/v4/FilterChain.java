package com.design.pattern.db.chainofresponsibility.servler.v4;

import java.util.ArrayList;
import java.util.List;

public class FilterChain {

    int index = 0;
    List<Filter> filters = new ArrayList<>();

    public FilterChain add(Filter filter) {
        filters.add(filter);
        return this;
    }

    public void doFilter(Request request, Response response) {
        if (index == filters.size()) {
            return;
        }

        Filter f = filters.get(index);
        index++;

        f.doFilter(request, response, this);
    }
}
