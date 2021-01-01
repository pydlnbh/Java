package com.java.se.lambda.FunctionalInterface;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

/**
 * @Author: PeiYiDing
 * @Date: 2021/1/1
 * @Description: com.java.se.lambda.FunctionalInterface
 */
public class LambdaTest {
    public static void main(String[] args) {
        // 匿名内部类
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                System.out.println("run0...");
            }
        };
        runnable.run();

        // lambda表达式
        Runnable runnable1 = () -> {
            System.out.println("run1...");
        };
        runnable1.run();

        // lambda表达式不带括号
        Runnable runnable2 = () -> System.out.println("run2...");
        runnable2.run();

        // 实现者定义了一个没有参数的方法，称为calL
        Callable<String> callable = new Callable() {
            @Override
            public String call() throws Exception {
                return "pydlnbh0";
            }
        };
        try {
            // 打印, 返回结果可能引发异常
            System.out.println(callable.call());
        } catch (Exception e) {
            e.printStackTrace();
        }

        // lambda表达式Callable
        Callable<String> callable1 = () -> {
            return "pydlnbh1";
        };
        try {
            // 打印
            System.out.println(callable1.call());
        } catch (Exception e) {
            e.printStackTrace();
        }

        // lambda表达式Callable不带大括号
        Callable<String> callable2 = () -> "pydlnbh2";
        try {
            System.out.println(callable2.call());
        } catch (Exception e) {
            e.printStackTrace();
        }

        // 匿名内部类
        StudentDao studentDao = new StudentDao() {
            @Override
            public void insert(Student student) {
                System.out.println("insert student0");
            }
        };

        // lambda表达式
        StudentDao studentDao1 = (student) -> {
            System.out.println("student1: " + student);
        };

        // lambda表达式不带大括号
        StudentDao studentDao2 = (Student student) -> System.out.println("student2:" + student);

        // 打印
        studentDao.insert(new Student());
        studentDao1.insert(new Student());
        studentDao2.insert(new Student());

        // 匿名内部类
        TeacherDao teacherDao = new TeacherDao() {
            @Override
            public int get(Teacher teacher) {
                return 1;
            }
        };

        // lambda表达式
        TeacherDao teacherDao1 = (teacher) -> {
            return 2;
        };
        TeacherDao teacherDao2 = (Teacher teacher) -> {
            return 3;
        };
        TeacherDao teacherDao3 = (teacher) -> 4;
        TeacherDao teacherDao4 = (Teacher teacher) -> 5;

        System.out.println(teacherDao.get(new Teacher()));
        System.out.println(teacherDao1.get(new Teacher()));
        System.out.println(teacherDao2.get(new Teacher()));
        System.out.println(teacherDao3.get(new Teacher()));
        System.out.println(teacherDao4.get(new Teacher()));

        // 在Java中提供了一系列的函数式接口, 用来接受后续传入的逻辑, 但是对输入和输出有要求
        // 代表一个函数,接受一个参数,返回一个结果
        Function<String, Integer> function = (str) -> {
            return str.length();
        };
        // 给定的参数应用这个功能
        System.out.println(function.apply("sjadkl"));

        // 实例化一个Supplier对象
        Supplier<String> supplier = () -> {
            return "pyd";
        };
        Supplier<String> supplier1 = () -> "pydlnbh";
        // 得到一个结果
        System.out.println(supplier.get());
        System.out.println(supplier1.get());

        // 表示接受单个输入参数且不返回结果的操作
        Consumer<String> consumer = (str) -> System.out.println(str);
        // 对给定的参数执行这个操作
        consumer.accept("pydlhh");

        // 代表了一个函数,它接受两个参数并产生一个结果
        BiFunction<String, String, Integer> biFunction = (a, b) -> a.length() + b.length();
        BiFunction<String, String, String> biFunction1 = (a, b) -> a + b;
        // 这个函数适用于给定的参数
        System.out.println(biFunction.apply("nbh", " is beautiful"));
        System.out.println(biFunction1.apply("nbh", " is beautiful"));

        // 使用Runnable函数式接口
        Runnable runnable3 = () -> get();
        Runnable runnable4 = () -> exec();
        // Runnable runnable5 = () -> 100; err
        // Runnable runnable6 = () -> ""; err
        runnable3.run();

        // 自定义函数式接口
        LambdaInterface lambdaInterface = () -> get();
        // LambdaInterface lambdaInterface1 = () -> find(); err
        // LambdaInterface lambdaInterface2 = () -> "abc"; err
        LambdaInterface lambdaInterface3 = () -> true ? 1 : 0;
        System.out.println(lambdaInterface.get());

        // 使用数组的asList方法的可变参数传入参数转化为list集合
        List<String> list = Arrays.asList("a", "b", "c");
        for (String str : list) {
            System.out.print(str);
        }
        // 使用lambda表达式进行遍历
        list.forEach(System.out::print);
    }

    static int get() {
        return 1;
    }

    static String find() {
        return "find...";
    }

    static void exec() {
        find();
    }
}
