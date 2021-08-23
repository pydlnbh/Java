package com.algorithm.practice.day02;

/**
 * 对数器注释版
 *
 * @author peiyiding
 * */
public class Main {
    public static void main(String[] args) {
        int testTimes = 1000;   // 测试次数
        int maxSize = 1000;  // 数组最大长度
        int maxValue = 1000; // 数组最大值
        boolean succeed = true; // 成功标志

        // 对数器循环测试
        for (int i = 0; i < testTimes; i++) {
            int[] arr1 = genRanArr(maxSize, maxValue);  // 生成随机数组
            int[] arr2 = cpArr(arr1);   // 复制生成的随机数组
            int[] arr3 = cpArr(arr1);   // 复制生成的随机数组

            selectionSort(arr1);    // 选择排序
            insertionSort(arr2);    // 插入排序

            // 如果两个数组不相等
            if (!isEqual(arr1, arr2)) {
                succeed = false;    // 成功标志表示设为false
                priArr(arr3);   // 打印排序前的数组
                priArr(arr1);   // 打印排序后的源数组
                priArr(arr2);   // 打印排序后的复制数组
                break;  // 结束
            }
        }

        System.out.println(succeed ? "YES!" : "NO!");    // 打印成功标志
    }

    /**
     * 生成随机数组
     *
     * @param maxSize  数组最大长度
     * @param maxValue 数组最大值
     */
    private static int[] genRanArr(int maxSize, int maxValue) {
        int[] arr = new int[(int) (maxSize * Math.random())];   // 声明随机数组长度

        // 循环遍历数组
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) ((maxValue + 1) * Math.random()) - (int) (maxValue * Math.random()); // 数组赋随机值
        }

        return arr; //返回随机生成的数组
    }

    /**
     * 复制数组
     *
     * @param arr 需要复制的数组
     * */
    private static int[] cpArr(int[] arr) {
        // 判断边界条件
        if (arr == null) {
            return null; // 退出
        }

        int[] res = new int[arr.length];    // 声明复制后的数组对象

        // 循环遍历源数组
        for (int i = 0; i < arr.length; i++) {
            res[i] = arr[i];    // 向复制数组赋值
        }
        return res; //返回赋值后的数组
    }

    /**
     * 选择排序
     *
     * @param arr 需要排序的数组
     * */
    private static void selectionSort(int[] arr) {
       // 判断边界条件
        if (arr == null || arr.length < 2) {
            return; // 退出
        }

        // 循环遍历, 从第一个下标开始到倒数第二个下标
        for (int i = 0; i < arr.length - 1; i++) {
            int minIndex = i;  // 假设最小值的下标是i

            // 循环遍历, 从i后面一个下标开始到数组最后一个下标
            for (int j = i + 1; j < arr.length; j++) {
                minIndex = arr[minIndex] > arr[j] ? j : minIndex;   // 使用三位运算符[boolean?:], 判断最小值的小标
            }

            // 如果minIndex不等于当前i
            if (minIndex != i) {
                swap(arr, minIndex, i); // 交换数值
            }
        }
    }

    /**
     * 插入排序
     *
     * @param arr 需要排序的数组
     */
    private static void insertionSort(int[] arr) {
        // 判断边界条件
        if (arr == null || arr.length < 2) {
            return; // 退出
        }

        // 遍历数组, 从第二个下标开始到长度-1
        for (int i = 1; i < arr.length; i++) {
            // 遍历数组, 从数组下标i-1(下标0)开始到j不小于0; 条件表达式中写上短路与, 如果前一个下标大于后一个下标
            for (int j = i - 1; j >= 0 && arr[j] > arr[j + 1]; j--) {
                swap(arr, j, j + 1);    // 交换数值
            }
        }
    }

    /**
     * 交换数组里的值
     *
     * @param arr 目标数组
     * @param i 需要交换的数组下标
     * @param j 需要交换的数组下标
     * */
    private static void swap(int[] arr, int i, int j) {
        arr[i] = arr[i] ^ arr[j];   // 异或运算
        arr[j] = arr[i] ^ arr[j];
        arr[i] = arr[i] ^ arr[j];
    }

    /**
     * 判断两个数组是否相等
     *
     * @param arr1 需要判断的第一个数组
     * @param arr2 需要判断的第二个数组
     */
    private static boolean isEqual(int[] arr1, int[] arr2) {
        // 如果一个数组为空, 另一个数组不为空
        if ((arr1 == null && arr2 != null) && (arr1 != null && arr2 == null)) {
            return false;   // 返回false
        }

        // 如果两个数组都为空
        if (arr1 == null && arr2 == null) {
            return true;    // 返回true
        }

        // 如果数组长度不同
        if (arr1.length != arr2.length) {
            return false;   // 返回false
        }

        // 遍历数组
        for (int i = 0; i < arr1.length; i++) {
            // 如果值不相等
            if (arr1[i] != arr2[i]) {
                return false;   // 返回false
            }
        }

        return true;   // 如果以上条件都不满足, 返回true
    }

    /**
     * 打印数组
     *
     * @param arr 需要打印的数组
     */
    private static void priArr(int[] arr) {
        // 判断边界条件
        if (arr == null) {
            return; //  退出
        }

        // 循环遍历数组
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " "); // 打印输出
        }

        System.out.println();   // 换行
    }
}
