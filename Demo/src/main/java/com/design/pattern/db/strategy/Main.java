package com.design.pattern.db.strategy;

public class Main {

    // 生成随机数组
    public static int[] generateRandomArray(int maxSize, int maxValue) {
        int[] arr = new int[(int) ((maxSize + 1) * Math.random())];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) ((maxValue + 1) * Math.random() - maxValue * Math.random() );
        }
        return arr;
    }

    // 打印数组
    public static void printArray(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    // 打印数组
    public static void printArray(Cat[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {

        Sorter sorter = new Sorter();

        int[] arr = Main.generateRandomArray(10, 1000);
        sorter.SelectionSort(arr);
        printArray(arr);

        Cat[] cat = {new Cat(3, 3), new Cat(8, 8), new Cat(2, 2)};
        sorter.BubbleSort(cat);
        printArray(cat);

        Cat[] height =  {new Cat(3, 3), new Cat(8, 8), new Cat(2, 2)};
        sorter.InsertionSort(height, new CatHeightComparator());
        printArray(height);

        Cat[] weight = {new Cat(3, 3), new Cat(8, 8), new Cat(2, 2)};
        sorter.InsertionSort(weight, new CatWeightComparator());
        printArray(weight);

        Sorter<Cat> sort = new Sorter<>();
        Cat[] lambda =  {new Cat(3, 3), new Cat(8, 8), new Cat(2, 2)};
        sort.InsertionSort(lambda, (o1, o2) -> {
            if (o1.height > o2.height) {
               return 1;
            } else if (o1.height < o2.height) {
                return -1;
            } else {
                return 0;
            }
        });
        printArray(lambda);
    }
}
