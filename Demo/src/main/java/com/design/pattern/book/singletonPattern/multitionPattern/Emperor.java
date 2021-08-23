package com.design.pattern.book.singletonPattern.multitionPattern;

import java.util.ArrayList;
import java.util.Random;

public class Emperor {
    private static int maxNumOfEmperor = 2;
    private static ArrayList emperorInfoList = new ArrayList(maxNumOfEmperor);
    private static ArrayList emperorList = new ArrayList(maxNumOfEmperor);
    private static int countNumOfEmperor = 0;

    private Emperor() {

    }

    static {
        for (int i = 0; i < maxNumOfEmperor; i++) {
            emperorList.add(new Emperor(i + "代皇帝"));
        }
    }

    private Emperor(String info) {
        emperorInfoList.add(info);
    }

    public static Emperor getInstance() {
        Random random = new Random();
        countNumOfEmperor = random.nextInt(maxNumOfEmperor);
        return (Emperor) emperorList.get(countNumOfEmperor);
    }

    public void emperorInfo() {
        System.out.println(emperorInfoList.get(countNumOfEmperor));
    }
}
