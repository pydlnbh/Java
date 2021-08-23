package com.design.pattern.book.abstactFactoryPattern.humanFactory;

import com.design.pattern.book.abstactFactoryPattern.Human;
import com.design.pattern.book.abstactFactoryPattern.HumanEnum;
import com.design.pattern.book.abstactFactoryPattern.HumanFactory;

public abstract class AbstractHumanFactory implements HumanFactory {
    protected Human createHuman(HumanEnum humanEnum) {
        Human human = null;

        if (!"".equals(humanEnum.getValue())) {
            try {
                human = (Human) Class.forName(humanEnum.getValue()).newInstance();
            } catch (InstantiationException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        }

        return human;
    }
}
