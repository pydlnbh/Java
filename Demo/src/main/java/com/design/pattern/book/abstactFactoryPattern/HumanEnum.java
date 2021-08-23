package com.design.pattern.book.abstactFactoryPattern;

public enum HumanEnum {
    YellowMaleHuman("pers.design.pattern.AbstactFactoryPattern.YellowPeople.YellowMaleHuman"),
    YellowFemaleHuman("pers.design.pattern.AbstactFactoryPattern.YellowPeople.YellowFemaleHuman"),
    BlackMaleHuman("pers.design.pattern.AbstactFactoryPattern.BlackPeople.BlackMaleHuman"),
    BlackFemaleHuman("pers.design.pattern.AbstactFactoryPattern.BlackPeople.BlackFemaleHuman"),
    WhiteMaleHuman("pers.design.pattern.AbstactFactoryPattern.WhitePeople.WhiteMaleHuman"),
    WhiteFemaleHuman("pers.design.pattern.AbstactFactoryPattern.WhitePeople.WhiteFemaleHuman")
    ;

    private String value = "";

    private HumanEnum(String value) {
        this.value = value;
    }

    public String getValue() {
        return this.value;
    }
}
