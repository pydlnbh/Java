package com.design.pattern.book.facadePattern;

public class Client {
    public static void main(String[] args) {
        LetterProcess letterProcess = new LetterProcessImpl();
        letterProcess.writeContext("Hi James");
        letterProcess.fillEnvelope("China");
        letterProcess.letterIntoEnvelope();
        letterProcess.sendLetter();

        ModernPostOffice modernPostOffice = new ModernPostOffice();
        modernPostOffice.sendLetter("Hi Bob", "Japan");

        modernPostOffice.sendAndCheckLetter("Hi Jack", "American");
    }
}
