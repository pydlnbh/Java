package com.java.se.collection;

/**
 * @Author: PeiYiDing
 * @Date: 2020/12/26
 * @Description: com.java.se.collection
 */
public class TestGeneric2 {
    public static void main(String[] args) {
        // 泛型为String
        GenericClass<String> gen = new GenericClass<>();
        gen.setA("String");
        gen.setId(12);
        gen.show();

        // 泛型为Integer
        GenericClass<Integer> gen2 = new GenericClass<Integer>();
        gen2.setA(23);
        gen2.show();

        // 泛型为Person
        GenericClass<Person> gen3 = new GenericClass<>();
        gen3.setA(new Person("person", 11));
        gen3.show();
    }
}
