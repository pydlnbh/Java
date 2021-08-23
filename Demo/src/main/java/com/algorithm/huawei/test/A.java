package com.algorithm.huawei.test;

import java.util.ArrayList;
import java.util.Scanner;

public class A {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num1 = sc.nextInt();
        int num2 = sc.nextInt();
        String s = "";
        ArrayList list = new ArrayList();
        ArrayList arrayList = new ArrayList();

        for (int i = 0; i <= num2; i++) {
            String str = sc.nextLine();
            if (str != null && !"".equals(str)) {
                list.add(str);
            }
        }

            for (int i = 0; i < list.size(); i++) {
                s = (String) list.get(i);

                if (s.length() > 0) {
                    String[] str = s.split(",");
                    for (int j = 0; j < num1; j++) {
                        arrayList.add(str[j]);
                    }
                    s = s.substring(num1, s.length() - 1);
                    continue;
                } else {
                    break;
                }

            }

        for (int i = 0; i < arrayList.size(); i++) {
            if (i != arrayList.size() - 1) {
                System.out.print(arrayList.get(i) + ",");
            } else {

                System.out.print(arrayList.get(i));
            }
        }
    }
}
