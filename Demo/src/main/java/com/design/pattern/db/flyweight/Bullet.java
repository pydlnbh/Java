package com.design.pattern.db.flyweight;

import java.util.UUID;

public class Bullet {
    boolean living = true;
    public UUID uuid = UUID.randomUUID();

    @Override
    public String toString() {
        return "Bullet{" +
                "living=" + living +
                ", uuid=" + uuid +
                '}';
    }
}
