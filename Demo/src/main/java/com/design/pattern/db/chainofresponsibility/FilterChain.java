package com.design.pattern.db.chainofresponsibility;

import java.util.ArrayList;
import java.util.List;

public class FilterChain implements Filter{

    List<Filter> filters = new ArrayList<>();

    public FilterChain add(Filter filter) {
        filters.add(filter);
        return this;
    }

    public boolean doFilter(Msg msg) {
        for (Filter f : filters) {
            if (!f.doFilter(msg)) {
                return false;
            }
        }
        return true;
    }
}
