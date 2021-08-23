package com.design.pattern.db.strategy;

public class CatWeightComparator implements Comparator<Cat>{
    @Override
    public int compara(Cat o1, Cat o2) {
        if (o1.weight > o2.weight) {
            return 1;
        } else if (o1.weight < o2.weight) {
            return -1;
        } else {
            return 0;
        }
    }
}
