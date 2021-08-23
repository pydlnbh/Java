package com.design.pattern.book.factoryMethodPattern;

public class NvWa {
    public static void main(String[] args) {
        Human human = HumanFactory.createHuman(WhitePeople.class);
        human.cry();
        human.laugh();
        human.talk();

        Human human1 = HumanFactory.createHuman(BlackPeople.class);
        human1.cry();
        human1.laugh();
        human1.talk();

        Human human2 = HumanFactory.createHuman(YellowPeople.class);
        human2.cry();
        human2.laugh();
        human2.talk();

        Human human3 = HumanFactory.createHuman();
        human3.cry();
    }
}
