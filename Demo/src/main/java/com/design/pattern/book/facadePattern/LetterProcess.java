package com.design.pattern.book.facadePattern;

public interface LetterProcess {
    public abstract void writeContext(String context);
    public abstract void fillEnvelope(String address);
    public abstract void letterIntoEnvelope();
    public void sendLetter();
}
