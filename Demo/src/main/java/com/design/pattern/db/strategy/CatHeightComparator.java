package com.design.pattern.db.strategy;

public class CatHeightComparator implements Comparator<Cat>{
    @Override
    public int compara(Cat o1, Cat o2) {
        if (o1.height > o2.height) {
            return 1;
        } else if (o1.height < o2.height) {
            return -1;
        } else {
            return 0;
        }
    }
}
