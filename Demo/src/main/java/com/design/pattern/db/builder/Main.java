package com.design.pattern.db.builder;

public class Main {
    public static void main(String[] args) {
        TerrainBuilder builder = new ComplexTerrainBuilder();
        Terrain t = builder.buildFort().buildMine().buildWall().build();

        Person p = new Person.PersonBuilder().basicInfo(1, "zs", 22).weight(120).build();
        System.out.println(p);
    }
}
