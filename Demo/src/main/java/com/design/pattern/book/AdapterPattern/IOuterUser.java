package com.design.pattern.book.AdapterPattern;

import java.util.Map;

public interface IOuterUser {
    public abstract Map getUserBaseInfo();
    public abstract Map getUserOfficeInfo();
    public abstract Map getUserHomeInfo();
}
