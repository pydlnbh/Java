package com.design.pattern.book.facadePattern;

public class LetterProcessImpl implements LetterProcess{
    @Override
    public void writeContext(String context) {
        System.out.println("填写信的内容" + context);
    }

    @Override
    public void fillEnvelope(String address) {
        System.out.println("送去" + address);
    }

    @Override
    public void letterIntoEnvelope() {
        System.out.println("把信放到信封里...");
    }

    @Override
    public void sendLetter() {
        System.out.println("邮递邮件...");
    }
}
