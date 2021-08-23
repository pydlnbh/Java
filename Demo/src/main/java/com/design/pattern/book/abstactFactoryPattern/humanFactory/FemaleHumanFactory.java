package com.design.pattern.book.abstactFactoryPattern.humanFactory;

import com.design.pattern.book.abstactFactoryPattern.Human;
import com.design.pattern.book.abstactFactoryPattern.HumanEnum;

public class FemaleHumanFactory extends AbstractHumanFactory{
    @Override
    public Human createYellowHuman() {
        return super.createHuman(HumanEnum.YellowFemaleHuman);
    }

    @Override
    public Human createBlackHuman() {
        return super.createHuman(HumanEnum.BlackFemaleHuman);
    }

    @Override
    public Human createWhiteHuman() {
        return super.createHuman(HumanEnum.WhiteFemaleHuman);
    }
}
