package com.design.pattern.db.chainofresponsibility;

public class Main {
    public static void main(String[] args) {
        Msg msg = new Msg();
        msg.setMsg("I am a IT boy, I have 5k every month, I work in 996! :)");

/*
        List<Filter> filters = new ArrayList<>();
        filters.add(new DateFilter());
        filters.add(new SensitiveFilter());

        for (Filter f : filters) {
            f.doFilter(msg);
        }
*/

        System.out.println(msg);

        FilterChain filterChain = new FilterChain();
        FilterChain fc = new FilterChain();
        filterChain.add(new DateFilter()).add(new SensitiveFilter()).add(new CharacterFilter());
        fc.add(new CharacterFilter());
        filterChain.add(fc);
        filterChain.doFilter(msg);
        System.out.println(msg);
    }
}
