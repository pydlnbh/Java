package com.design.pattern.book.abstactFactoryPattern;

import com.design.pattern.book.abstactFactoryPattern.humanFactory.MaleHumanFactory;
import com.design.pattern.book.abstactFactoryPattern.humanFactory.FemaleHumanFactory;

public class NvWa {
    public static void main(String[] args) {
        MaleHumanFactory maleHumanFactory = new MaleHumanFactory();
        FemaleHumanFactory femaleHumanFactory = new FemaleHumanFactory();

        Human yellowHuman = maleHumanFactory.createYellowHuman();
        Human blackHuman = femaleHumanFactory.createBlackHuman();

        yellowHuman.cry();
        yellowHuman.sex();
        blackHuman.laugh();
        blackHuman.sex();
    }
}
