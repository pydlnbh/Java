package com.design.pattern.db.chainofresponsibility.servler.v3;

import java.util.ArrayList;
import java.util.List;

public class FilterChain implements Filter {

    int index = 0;
    List<Filter> filters = new ArrayList<>();

    public FilterChain add(Filter filter) {
        filters.add(filter);
        return this;
    }

    @Override
    public boolean doFilter(Request request, Response response, FilterChain chain) {
        if (index == filters.size()) {
            return false;
        }

        Filter f = filters.get(index);
        index++;

        return f.doFilter(request, response, chain);
    }
}
