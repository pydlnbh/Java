package com.java.se.oop.Test;

import com.java.se.oop.entity.CenMonster;
import com.java.se.oop.entity.SnakeMonster;

/**
 * @Author: PeiYiDing
 * @Date: 2020/12/25
 * @Description: com.java.se.oop.Test
 */
public class TestMonster {

    public static void main(String[] args) {
        // snake
        SnakeMonster snake = new SnakeMonster("snake", 5, 20);
        snake.attack();
        System.out.println("HP is " + snake.getHp());
        System.out.println("Power is " + snake.getPower());
        snake.showHp();
        snake.move();

        System.out.println("=======================================");

        // centipede
        CenMonster centipede = new CenMonster("centipede", 60, 15);
        centipede.attack();
        System.out.println("hp is " + centipede.getHp());
        System.out.println("power is " + centipede.getPower());
        centipede.move();
    }
}
