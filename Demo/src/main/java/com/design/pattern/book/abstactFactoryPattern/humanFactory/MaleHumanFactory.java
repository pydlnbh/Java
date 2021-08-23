package com.design.pattern.book.abstactFactoryPattern.humanFactory;

import com.design.pattern.book.abstactFactoryPattern.Human;
import com.design.pattern.book.abstactFactoryPattern.HumanEnum;

public class MaleHumanFactory extends AbstractHumanFactory{
    @Override
    public Human createYellowHuman() {
        return super.createHuman(HumanEnum.YellowMaleHuman);
    }

    @Override
    public Human createBlackHuman() {
        return super.createHuman(HumanEnum.BlackMaleHuman);
    }

    @Override
    public Human createWhiteHuman() {
        return super.createHuman(HumanEnum.WhiteMaleHuman);
    }
}
