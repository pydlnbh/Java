package com.design.pattern.db.facade;

public interface LetterProcess {
    public abstract void writeContext(String context);
    public abstract void fillEnvelope(String address);
    public abstract void letterIntoEnvelope();
    public void sendLetter();
}
