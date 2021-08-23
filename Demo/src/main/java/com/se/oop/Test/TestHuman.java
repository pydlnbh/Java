package com.se.oop.Test;

import com.se.oop.entity.Actor;
import com.se.oop.entity.Human;
import com.se.oop.entity.Sportsman;

/**
 * @Author: PeiYiDing
 * @Date: 2020/12/25
 * @Description: com.java.se.oop.Test
 */
public class TestHuman {

    public static void main(String[] args) {
        // human
        Human human = new Human();

        System.out.println("============================");

        // sportsman
        Sportsman sportsman = new Sportsman("lx", 23, "male", "200 miles Run", "22 seconds");
        sportsman.showMe();

        System.out.println("============================");

        // Actor
        Actor actor = new Actor("BeijingColleges", "SmallHotCat");
        actor.showMe();

        Human h = new Actor();
        Actor a = new Actor();
        System.out.println("==========");
        h.showMe();
        System.out.println();
        a.showMe();
    }
}
