package com.java.se.thread.pc.pc1;

/**
 * @Author: PeiYiDing
 * @Date: 2020/12/30
 * @Description: com.java.se.thread.pc
 */
public class Goods {
    // 定义变量
    private String brand;
    private String product;

    public Goods() {

    }

    public Goods(String brand, String product) {
        this.brand = brand;
        this.product = product;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getProduct() {
        return product;
    }

    public void setProduct(String product) {
        this.product = product;
    }
}
