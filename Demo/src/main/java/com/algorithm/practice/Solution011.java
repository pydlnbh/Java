package com.algorithm.practice;

import com.sun.jndi.ldap.Ber;

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * 复习之前的代码
 */
public class Solution011 {

    /**
     * 打印int整型的二进制
     *
     * @param num 参数
     */
    public static void printBinary(int num) {
        String binary = "";
        for (int i = 31; i >= 0; i--) {
            binary += (num & (1 << i)) == 0 ? "0" : "1";
        }
        System.out.println(num + "的二进制: " + binary);
    }

    /**
     * 阶乘之和
     *
     * @param num 参数
     * @return long
     */
    public static long factorialSum(int num) {
        long ans = 0;
        long cur = 1;
        for (int i = 1; i <= num; i++) {
            cur *= i;
            ans += cur;
        }
        return ans;
    }

    /**
     * 选择排序
     *
     * @param arr 数组
     */
    public static void selectionSort(int[] arr) {
        // 边界条件
        if (arr == null || arr.length < 2) {
            return;
        }
        // 循环遍历
        for (int i = 0; i < arr.length; i++) {
            // 定义最小下标
            int minIndex = i;
            // 循环遍历
            for (int j = 0; j <= i; j++) {
                // 判断赋值
                minIndex = arr[j] < arr[minIndex] ? j : minIndex;
            }
            // 交换
            swap(arr, minIndex, i);
        }
    }

    /**
     * 冒泡排序
     *
     * @param arr 参数
     */
    public static void bubbleSort(int[] arr) {
        // 边界条件
        if (arr == null || arr.length < 2) {
            return;
        }
        // 双层for循环
        for (int i = arr.length - 1; i >= 0; i--) {
            for (int j = 0; j < i; j++) {
                if (arr[j] > arr[j + 1]) {
                    swap(arr, j, j + 1);
                }
            }
        }
    }

    /**
     * 插入排序
     *
     * @param arr 参数
     */
    public static void insertionSort(int[] arr) {
        // 边界条件
        if (arr == null || arr.length < 2) {
            return;
        }
        // 双层循环
        for (int i = 1; i < arr.length; i++) {
            for (int j = i - 1; j >= 0; j--) {
                if (arr[j] > arr[j + 1]) {
                    swap(arr, j, j + 1);
                }
            }
        }
    }

    /**
     * 交换方法
     *
     * @param arr 数组arr
     * @param i   下标i
     * @param j   下标j
     */
    public static void swap(int[] arr, int i, int j) {
        int t = arr[i];
        arr[i] = arr[j];
        arr[j] = t;
    }

    /**
     * 生成随机数组
     *
     * @param maxLength 数组最大长度
     * @param maxValue  数组最大值
     * @return int[]
     */
    public static int[] generateRandomArray(int maxLength, int maxValue) {
        // 初始化数组对象
        int[] arr = new int[(int) ((Math.random() * maxLength) + 1)];
        // 循环遍历
        for (int i = 0; i < arr.length; i++) {
            // 赋值
            arr[i] = (int) (Math.random() * maxValue) - (int) (Math.random() * maxValue);
        }
        // 返回
        return arr;
    }

    /**
     * 拷贝数组
     *
     * @param arr 数组
     * @return int[]
     */
    public static int[] copyArray(int[] arr) {
        // 声明新数组
        int[] ans = new int[arr.length];
        // 循环遍历
        for (int i = 0; i < arr.length; i++) {
            // 赋值
            ans[i] = arr[i];
        }
        // 返回
        return arr;
    }

    /**
     * 判断两个数组是否相等
     *
     * @param source 源数组
     * @param target 目标数组
     * @return boolean
     */
    public static boolean isEqual(int[] source, int[] target) {
        // 循环遍历
        for (int i = 0; i < source.length; i++) {
            // 判断
            return source[i] == target[i];
        }
        // 不满足以上条件返回false
        return false;
    }

    /**
     * 打印数组
     *
     * @param arr 参数
     */
    public static void printArray(int[] arr) {
        // 循环遍历
        for (int i = 0; i < arr.length; i++) {
            // 打印
            System.out.print(arr[i] + " ");
        }
        // 换行
        System.out.println();
    }

    /**
     * 前缀和数组
     */
    public static class PreSum {
        private int[] arr;

        /**
         * 前缀和数组构造方法
         *
         * @param arr 数组
         */
        public PreSum(int[] arr) {
            // 定义数组长度
            this.arr = new int[arr.length];
            // 给数组第一个下标赋值
            this.arr[0] = arr[0];
            // 从下标1开始遍历
            for (int i = 1; i < arr.length; i++) {
                // 新数组当前位置的值等于新数组前一个位置的值加上传过来数组当前位置的值
                this.arr[i] = this.arr[i - 1] + arr[i];
            }
        }

        /**
         * 从left到right的和
         *
         * @param left  左边下标
         * @param right 右边下标
         * @return int
         */
        public int rangeSum(int left, int right) {
            return left == 0 ? arr[right] : arr[right] - arr[left - 1];
        }
    }

    public static class PreSumTest {
        private int[] arr;

        public PreSumTest(int[] arr) {
            this.arr = arr;
        }

        public int rangeSum(int left, int right) {
            int ans = 0;
            for (int i = left; i <= right; i++) {
                ans += arr[i];
            }
            return ans;
        }
    }

    /**
     * 排序算法对数器
     *
     * @param succeed   成功标志
     * @param testTimes 测试次数
     * @param maxLength 数组最大长度
     * @param maxValue  数组最大数值
     * @return boolean
     */
    private static boolean sortTest(boolean succeed, int testTimes, int maxLength, int maxValue) {
        // 开始测试
        for (int i = 0; i < testTimes; i++) {
            int[] arr = generateRandomArray(maxLength, maxValue);
            int[] copyArray = copyArray(arr);
            int[] backupArray = copyArray(arr);
            // 自己写的排序算法
//            selectionSort(arr);
//            bubbleSort(arr);
            insertionSort(arr);
            // 系统提供的排序算法
            Arrays.sort(copyArray);
            // 判断两个排过序的数组是否相等
            if (!isEqual(arr, copyArray)) {
                succeed = false;
                // 打印未排序的数组
                printArray(backupArray);
                // 打印自己写的排序算法排序的数组
                printArray(arr);
                // 打印正确的排序数组
                printArray(copyArray);
                // 跳出循环
                break;
            }
        }
        // 返回
        return succeed;
    }

    /**
     * 前缀和数组对数器测试
     *
     * @param succeed 测试标识
     * @param testTimes 测试次数
     * @param maxLength 数组最大长度
     * @param maxValue 数组最大数值
     * @return boolean
     */
    private static boolean PreSumTest(boolean succeed, int testTimes, int maxLength, int maxValue) {
        // 开始测试
        for (int i = 0; i < testTimes; i++) {
            // 生成随机数组
            int[] arr = generateRandomArray(maxLength, maxValue);
            // 生成一个大于0小于数组长度的两个下标
            int left, right;
            do {
                left = (int) (Math.random() * maxValue);
                right = (int) (Math.random() * maxValue);
            } while (left < 0 || left > arr.length - 1 || right < 0 || right > arr.length - 1);
            // 给两个数字排序, 当左边下标和右边下标
            if (left > right) {
                int t = left;
                left = right;
                right = t;
            }
            // 前缀和方法
            int sum = new PreSum(arr).rangeSum(left, right);
            // 前缀和测试
            int ans = new PreSumTest(arr).rangeSum(left, right);
            // 判断是否相等
            if (sum != ans) {
                System.out.println("left: " + left + ", right: " + right);
                System.out.println("前缀和: " + sum + ", test: " + ans);
                printArray(arr);
                succeed = false;
                break;
            }
        }
        // 返回
        return succeed;
    }

    /**
     * 从a-b随机到c-d随机
     * 例: 已知方法等概率返回8 ~ 22, 给出等该率返回3 ~ 19
     */
    public static class EqualProbability {

        /**
         * 等概率返回8 ~ 22
         *
         * @return int
         */
        public int f() {
            return (int) (Math.random() * 15) + 8;
        }

        /**
         * 等概率返回0 ~ 1
         *
         * @return int
         */
        public int f1() {
            int ans = 0;
            do {
                ans = f();
            } while (ans == 15);
            return ans < 15 ? 0 : 1;
        }

        /**
         * 等概率返回0 ~ 31
         *
         * @return int
         */
        public int f2() {
            return (f1() << 4) + (f1() << 3) + (f1() << 2) + (f1() << 1) + f1();
        }

        /**
         * 等概率返回0 ~ 16
         *
         * @return int
         */
        public int f3() {
            int ans = 0;
            do {
                ans = f2();
            } while (ans > 16);
            return ans;
        }

        /**
         * 等概率返回3 ~ 19
         */
        public int g() {
            return f3() + 3;
        }

        /**
         * 不等概率返回0 ~ 1
         *
         * @return int
         */
        public int fun() {
            return Math.random() < 0.82 ? 0 : 1;
        }

        /**
         * 等概率返回0 ~ 1
         *
         * @return int
         */
        public int fun01() {
            // [0, 1) * 2 -> (int) [0, 2) -> [0, 1]
            return (int) (Math.random() * 2);
        }

        /**
         * 01不等概率到01等概率随机
         *
         * @return int
         */
        public int res() {
            int ans = 0;
            do {
                ans = fun();
            } while (ans == fun());
            return ans;
        }

    }

    /**
     * 从a-b随机到c-d随机
     *
     * @param testTimes 测试次数
     */
    private static void equalProbability(int testTimes) {
        int[] counts = new int[20];
        for (int i = 0; i < testTimes; i++) {
            counts[new EqualProbability().g()]++;
        }
        for (int i = 3; i < counts.length; i++) {
            System.out.println(i + "出现了" + counts[i] + "次！");
        }
    }

    /**
     * 01不等概率到01等概率随机 测试
     *
     * @param testTimes 测试次数
     */
    private static void zeroOneEqualProbability(int testTimes) {
        System.out.println("01不等概率随机");
        int[] counts = new int[2];
        for (int i = 0; i < testTimes; i++) {
            counts[new EqualProbability().fun()]++;
        }
        for (int i = 0; i < counts.length; i++) {
            System.out.println(i + "出现了" + counts[i] + "次！");
        }

        System.out.println("==========");

        System.out.println("01等概率随机");
        counts = new int[2];
        for (int i = 0; i < testTimes; i++) {
            counts[new EqualProbability().fun01()]++;
        }
        for (int i = 0; i < counts.length; i++) {
            System.out.println(i + "出现了" + counts[i] + "次！");
        }

        System.out.println("===========");

        System.out.println("01等概率随机");
        counts = new int[2];
        for (int i = 0; i < testTimes; i++) {
            counts[new EqualProbability().res()]++;
        }
        for (int i = 0; i < counts.length; i++) {
            System.out.println(i + "出现了" + counts[i] + "次！");
        }
    }

    /**
     * 二分查找有序数组中num是否存在
     *
     * @param arr 数组
     * @param num 数值
     */
    public static boolean binarySearch(int[] arr, int num) {
        // 定义变量
        int left = 0;
        int right = arr.length - 1;
        // 开始二分
        while (left <= right) {
            // 定义中点
            int mid = (left + right) / 2;
            if (arr[mid] == num) {
                return true;
            } else if (arr[mid] > num) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return false;
    }

    /**
     * 循环查找有序数组中num是否存在
     *
     * @param arr 数组
     * @param num 数值
     * @return boolean
     */
    public static boolean testBinarySearch(int[] arr, int num) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == num) {
                return true;
            }
        }
        return false;
    }

    /**
     * 生成随机数
     *
     * @param maxValue 最大数值
     * @return int
     */
    public static int generateRandomValue(int maxValue) {
        return (int) (Math.random() * maxValue);
    }

    /**
     * 二分法对数器
     *
     * @param succeed 成功标识
     * @param testTimes 测试次数
     * @param maxLength 最大长度
     * @param maxValue 最大数值
     * @return boolean
     */
    private static boolean binarySearchTest(boolean succeed, int testTimes, int maxLength, int maxValue) {
        // 开始测试
        for (int i = 0; i < testTimes; i++) {
            // 生成随机数组
            int[] arr = generateRandomArray(maxLength, maxValue);
            // 生成随机数值
            int num = generateRandomValue(maxValue);
            // 升序排序
            Arrays.sort(arr);
            // 判断
            if (testBinarySearch(arr, num) != binarySearch(arr, num)) {
                succeed = false;
                printArray(arr);
                System.out.println(num);
                break;
            }
        }
        // 返回
        return succeed;
    }

    /**
     * 二分法查找有序数组中>=num最左侧的下标
     *
     * @param arr 数组
     * @param num 数值
     * @return int
     */
    public static int nearLeftIndex(int[] arr, int num) {
        // 定义变量
        int ans = -1;
        int left = 0;
        int right = arr.length - 1;
        // 开始二分
        while (left <= right) {
            // 定义中点
            int mid = (left + right) / 2;
            if (arr[mid] >= num) {
                ans = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return ans;
    }

    /**
     * 循环查找有序数组>=num最左侧的下标
     *
     * @param arr 数组
     * @param num 数值
     * @return int
     */
    public static int testNearLeftIndex(int[] arr, int num) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] >= num) {
                return i;
            }
        }
        return -1;
    }

    /**
     * 二分法查找有序数组中找到<=num最右侧的下标
     *
     * @param arr 数组
     * @param num 数值
     * @return int
     */
    public static int nearRightIndex(int[] arr, int num) {
        // 定义变量
        int ans = -1;
        int left = 0;
        int right = arr.length - 1;
        while (left <= right) {
            // 定义中点
            int mid = (left + right) / 2;
            if (arr[mid] <= num) {
                ans = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        // 返回
        return ans;
    }

    /**
     * 循环查找有序数组中<=num最右侧的下标
     *
     * @param arr 数组
     * @param num 数值
     * @return int
     */
    public static int TestNearRightIndex(int[] arr, int num) {
        for (int i = arr.length - 1; i >= 0; i--) {
            if (arr[i] <= num) {
                return i;
            }
        }
        return -1;
    }

    /**
     * 有序数组找>=num最左侧的位置
     *
     * @param succeed 成功标志
     * @param testTimes 测试次数
     * @param maxLength 最大长度
     * @param maxValue 最大值
     * @return boolean
     */
    private static boolean nearLeftIndexTest(boolean succeed, int testTimes, int maxLength, int maxValue) {
        // 开始测试
        for (int i = 0; i < testTimes; i++) {
            // 生成随机数组
            int[] arr = generateRandomArray(maxLength, maxValue);
            // 生成随机数值
            int num = generateRandomValue(maxValue);
            // 升序排序
            Arrays.sort(arr);
            // 判断
            if (testNearLeftIndex(arr, num) != nearLeftIndex(arr, num)) {
                succeed = false;
                printArray(arr);
                System.out.println(num);
                break;
            }
        }
        // 返回
        return succeed;
    }

    /**
     * 有序数组找<=num最右侧的位置
     *
     * @param succeed 成功标志
     * @param testTimes 测试次数
     * @param maxLength 最大长度
     * @param maxValue 最大值
     * @return boolean
     */
    private static boolean nearRightIndexTest(boolean succeed, int testTimes, int maxLength, int maxValue) {
        // 开始测试
        for (int i = 0; i < testTimes; i++) {
            // 生成随机数组
            int[] arr = generateRandomArray(maxLength, maxValue);
            // 生成随机数值
            int num = generateRandomValue(maxValue);
            // 升序排序
            Arrays.sort(arr);
            // 判断
            if (TestNearRightIndex(arr, num) != nearRightIndex(arr, num)) {
                succeed = false;
                printArray(arr);
                System.out.println(num);
                break;
            }
        }
        // 返回
        return succeed;
    }

    /**
     * 生成一个相邻不相等的数组
     *
     * @param maxLength 最大长度
     * @param maxValue 最大值
     * @return int[]
     */
    public static int[] generateNotEqualRandomArray(int maxLength, int maxValue) {
        // 初始化数组
        int[] arr = new int[(int) (Math.random() * maxLength) + 1];
        // 给0下标赋值
        arr[0] = (int) (Math.random() * maxValue) - (int) (Math.random() * maxValue);
        // 循环遍历
        for (int i = 1; i < arr.length; i++) {
            // 如果相邻的元素相等, 重新赋值
            do {
                arr[i] = (int) (Math.random() * maxValue) - (int) (Math.random() * maxValue);
            } while (arr[i - 1] == arr[i]);
        }
        return arr;
    }

    /**
     * 二分查找无序, 相邻不相等数组中局部最小值下标
     *
     * @param arr 数组
     */
    public static int getMinIndex(int[] arr) {
        // 边界条件
        if (arr == null || arr.length == 0) {
            return -1;
        }
        if (arr.length == 1) {
            return 0;
        }
        if (arr[0] < arr[1]) {
            return 0;
        }
        if (arr[arr.length - 1] < arr[arr.length - 2]) {
            return arr.length - 1;
        }
        // 定义变量
        int left = 0;
        int right = arr.length - 1;
        // 保证数组三个数值对比
        while (left < right - 1) {
            // 定义中点
            int mid = (left + right) / 2;
            // 如果mid小于两边返回
            if (arr[mid] < arr[mid - 1] && arr[mid] < arr[mid + 1]) {
                return mid;
            } else {
                // 如果mid大于右边, 左边不要
                if (arr[mid] > arr[mid + 1]) {
                    left = mid + 1;
                // 如果mid大于左边, 右边不要
                } else {
                    right = mid - 1;
                }
            }
        }
        // 返回
        return arr[left] < arr[right] ? left : right;
    }

    /**
     * 校验是否为局部最小
     *
     * @param arr 数组
     * @param minIndex 局部最小值下标
     * @return boolean
     */
    public static boolean check(int[] arr, int minIndex) {
        int left = minIndex - 1;
        int right = minIndex + 1;
        boolean leftBigger = left >= 0 ? arr[left] > arr[minIndex] : true;
        boolean rightBigger = right < arr.length ? arr[right] > arr[minIndex] : true;
        return leftBigger && rightBigger;
    }

    /**
     * 局部最小下标对数器
     *
     * @param succeed 成功标识
     * @param testTimes 测试次数
     * @param maxLength 最大长度
     * @param maxValue 最大值
     * @return boolean
     */
    private static boolean getMinIndexTest(boolean succeed, int testTimes, int maxLength, int maxValue) {
        // 开始测试
        for (int i = 0; i < testTimes; i++) {
            // 生成一个相邻不相等的数组
            int[] arr = generateNotEqualRandomArray(maxLength, maxValue);
            // 局部最小值下标
            int minIndex = getMinIndex(arr);
            // 判断
            if (!check(arr, minIndex)) {
                succeed = false;
                printArray(arr);
                System.out.println("最小值下标: " + minIndex + ", 最小值: " + arr[minIndex]);
                break;
            }
        }
        // 返回
        return succeed;
    }

    /**
     * 主方法
     *
     * @param args 标准参数
     */
    public static void main(String[] args) {
        // 定义测试参数
        boolean succeed = true;
        int testTimes = 100000;
        int maxLength = 1000;
        int maxValue = 1000;
        // 打印int整型二进制
//        printBinary(2);
        // 计算阶乘之和
//        System.out.println(factorialSum(10));
        // 排序对数器测试
//        succeed = sortTest(succeed, testTimes, maxLength, maxValue);
        // 前缀和数组测试
//        succeed = PreSumTest(succeed, testTimes, maxLength, maxValue);
        // 从a-b随机到c-d随机
//        equalProbability(testTimes);
        // 01不等概率到01等概率随机
//        zeroOneEqualProbability(testTimes);
        // 二分查找对数器
//        succeed = binarySearchTest(succeed, testTimes, maxLength, maxValue);
        // 二分查找>=某数最左侧的下标对数器
//        succeed = nearLeftIndexTest(succeed, testTimes, maxLength, maxValue);
        // 二分查找<=某数最右侧的下标对数器
//        succeed = nearRightIndexTest(succeed, testTimes, maxLength, maxValue);
        // 二分查找局部最小下标对数器
        succeed = getMinIndexTest(succeed, testTimes, maxLength, maxValue);
        // 打印测试结果
        System.out.print(succeed ? "测试成功" : "测试失败");
    }
}
