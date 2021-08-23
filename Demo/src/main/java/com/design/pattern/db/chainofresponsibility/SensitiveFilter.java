package com.design.pattern.db.chainofresponsibility;

public class SensitiveFilter implements Filter{
    @Override
    public boolean doFilter(Msg msg) {
        String r = msg.getMsg();
        r = r.replace("5k", "10k");
        msg.setMsg(r);
        return false;
    }
}
