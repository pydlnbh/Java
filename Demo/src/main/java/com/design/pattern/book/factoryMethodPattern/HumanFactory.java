package com.design.pattern.book.factoryMethodPattern;

import java.util.List;
import java.util.Random;

public class HumanFactory {

    public static Human createHuman(Class clazz) {
        Human human = null;

        try {
            human = (Human) Class.forName(clazz.getName()).newInstance();
        } catch (InstantiationException e) {
            System.out.println("必须指定人类的颜色");
        } catch (IllegalAccessException e) {
            System.out.println("人类定义错误");
        } catch (ClassNotFoundException e) {
            System.out.println("找不到人类");
        }

        return human;
    }

     public static Human createHuman() {
        Human human = null;

         List<Class> concreteHumanList = ClassUtils.getAllClassByInterface(Human.class);
         Random random = new Random();
         int rand = random.nextInt(concreteHumanList.size());

         human = createHuman(concreteHumanList.get(rand));

         return human;
     }
}
