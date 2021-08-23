package com.design.pattern.db.flyweight;

public class Main {
    public static void main(String[] args) {
        BulletPool bulletPool = new BulletPool();

        for (int i = 0; i < 10; i++) {
            Bullet bullet = bulletPool.getBullet();
            System.out.println(bullet);
        }
    }
}
