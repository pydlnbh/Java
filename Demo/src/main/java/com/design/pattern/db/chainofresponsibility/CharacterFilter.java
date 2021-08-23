package com.design.pattern.db.chainofresponsibility;

public class CharacterFilter implements Filter{
    @Override
    public boolean doFilter(Msg msg) {
        String r = msg.getMsg();
        r = r.replace(":)", "^v^");
        msg.setMsg(r);
        return true;
    }
}
