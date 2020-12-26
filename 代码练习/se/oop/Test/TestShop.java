package com.java.se.oop.Test;

import com.java.se.oop.entity.Product;
import com.java.se.oop.entity.Shop;

/**
 * @Author: PeiYiDing
 * @Date: 2020/12/25
 * @Description: com.java.se.oop.Test
 */
public class TestShop {

    public static void main(String[] args) {
        Shop shop = new Shop("11", "clothes");
        Product pro = new Product("111", "T-shirt", 15, 40.5, shop);
        pro.check();
    }
}
