package com.se.oop.entity;

/**
 * @Author: PeiYiDing
 * @Date: 2020/12/25
 * @Description: com.java.se.oop.entity
 */
public class Product {

    private String pid;
    private String name;
    private int amount;
    private double price;
    private Shop category;

    public Product() {
    }

    public Product(String pid, String name, int amount, double price, Shop category) {
        this.pid = pid;
        this.name = name;
        this.amount = amount;
        this.price = price;
        this.category = category;
    }

    public String getPid() {
        return pid;
    }

    public void setPid(String pid) {
        this.pid = pid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        if (amount < 0) {
            System.out.println("Stock is tight, please replenish");
        }
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Shop getCategory() {
        return category;
    }

    public void setCategory(Shop category) {
        this.category = category;
    }

    public void check() {
        System.out.println("商品名称：" + this.name);
        System.out.println("所属类别：" + this.category.getName());
        System.out.println("库存数量：" + this.amount);
        System.out.println("商品售价：" + this.price);
        System.out.println("商品总价：" + this.amount * this.price);
    }
}
