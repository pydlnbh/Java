package com.algorithm.practice.day03;

public class Main {
    public static void main(String[] args) {
        int testTimes = 1000;   // 测试次数
        int maxSize = 100;  // 数组长度
        int maxValue = 100; // 数组大小
        boolean succeed = true; // 成功标志

        // 循环测试次数
        for (int i = 0; i < testTimes; i++) {
            int[] arr1 = genRanArr(maxSize, maxValue);  // 生成随机数组, 用于打印
            int[] arr2 = cpArr(arr1);   // 复制生成的随机数组, 用于排序后的比较
            int[] arr3 = cpArr(arr1);   // 复制生成的随机数组, 用于排序后的比较

            SelectionSort(arr2);    // 选择排序
            InsertionSort(arr3);    // 插入排序

            // 如果排序后的两个数组不相等
            if (!isEqual(arr2, arr3)) {
                succeed = false;    // 成功标志设置为false
                priArr(arr1);   // 打印未排序的数组
                priArr(arr2);   // 打印选择排序的数组
                priArr(arr3);   // 打印插入排序的数组
                break;  // 终止循环测试
            }
        }

        System.out.println(succeed ? "true" : "false"); // 打印成功标志
    }

    /**
     * 生成随机数组
     *
     * @param maxSize 数组最大长度
     * @param maxValue 数组最大值*/
    private static int[] genRanArr(int maxSize, int maxValue) {
        int[] arr = new int[(int) (maxSize * Math.random() + 1)];   // 声明数组对象

        // 循环遍历
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) ((maxValue + 1) * Math.random()) - (int) (maxValue * Math.random()); // 赋值
        }

        return arr; // 返回数组
    }

    /**
     * 复制数组
     *
     * @param arr 数组
     */
    private static int[] cpArr(int[] arr) {
        // 判断边界条件
        if (arr == null) {
            return null;    // 返回null
        }

        int[] res = new int[arr.length];    // 声明数组

        // 循环遍历
        for (int i = 0; i < arr.length; i++) {
            res[i] = arr[i];    // 赋值
        }

        return res; // 返回数组
    }

    /**
     * 选择排序
     *
     * @param arr 数组
     */
    private static void SelectionSort(int[] arr) {
        // 判断边界条件
        if (arr == null || arr.length < 2) {
            return; // 退出
        }

        // 外层循环遍历
        for (int i = 0; i < arr.length - 1; i++) {
            int minIndex = i;   // 假设最小数组下标为i
            // 外层遍历, 从i + 1开始到数组结束
            for (int j = i + 1; j < arr.length; j++) {
                minIndex = arr[j] > arr[minIndex] ? minIndex : j;   // 利用三位运算符比较最小下标
            }
            // 如果minIndex不等于i
            if (minIndex != i) {
                swap(arr, minIndex, i); // 交换
            }
        }
    }

    /**
     * 插入排序
     *
     * @param arr 数组
     */
    private static void InsertionSort(int[] arr) {
        // 判断边界条件
        if (arr == null || arr.length < 2) {
            return; // 退出
        }

        // 外层循环遍历
        for (int i = 1; i < arr.length; i++) {
            // 内层循环遍历
            for (int j = i - 1; j >= 0; j--) {
                // 如果前一个数组大于后一个数组
                if (arr[j] > arr[j + 1]) {
                    swap(arr, j, j + 1);    // 交换
                }
            }
        }
    }

    /**
     * 交换
     *
     * @param i 下标i
     * @param j 下标j
     */
    private static void swap(int[] arr, int i, int j) {
        arr[i] = arr[i] ^ arr[j];   // 异或运算: 相同为0, 不同为1
        arr[j] = arr[i] ^ arr[j];
        arr[i] = arr[i] ^ arr[j];
    }

    /**
     * 判断两个数组是否相等
     *
     * @param arr1 数组1
     * @param arr2 数组2
     */
    private static boolean isEqual(int[] arr1, int[] arr2) {
        // 如果数组1和数组2某一个等于null, 另一个不等于null
        if ((arr1 == null && arr2 != null) || (arr1 != null && arr2 == null)) {
            return false;   // 返回false
        }

        // 如果数组1的长度不等于数组2的长度
        if (arr1.length != arr2.length) {
            return false;   // 返回false
        }

        // 如果数组1和数组2都等于null
        if (arr1 == null && arr2 == null) {
            return true;    // 返回true
        }

        // 循环遍历数组
        for (int i = 0; i < arr1.length; i++) {
            // 如果数组的值相等
            if (arr1[i] != arr2[i]) {
                return false;   // 返回false
            }
        }

        return true;    // 如果上述条件不满足, 返回true
    }

    /**
     * 打印数组
     *
     * @param arr 需要打印的数组
     */
    private static void priArr(int[] arr) {
        // 循环遍历
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " "); // 打印
        }
        System.out.println();   // 换行
    }
}
