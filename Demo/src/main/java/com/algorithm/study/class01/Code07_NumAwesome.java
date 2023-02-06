package com.algorithm.study.class01;

/**
 * 局部最小值问题
 *
 * @author James
 */
public class Code07_NumAwesome {

    /**
     * 获取局部最小下标
     *
     * @param arr
     * */
    public static int getLessIndexV1(int[] arr) {
        if (arr == null || arr.length == 0) {
            return -1;
        }

        if (arr.length == 1 || arr[0] < arr[1]) {
            return 0;
        }

        if (arr[arr.length - 1] < arr[arr.length - 2]) {
            return arr.length - 1;
        }

        int left = 1;
        int right = arr.length - 2;
        int mid;

        while (left < right - 1) {
            mid = left + ((right - left) >> 1);
            if (arr[mid] < arr[mid - 1] && arr[mid] < arr[mid + 1]) {
                return mid;
            } else {
                if (arr[mid] > arr[mid + 1]) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
        }

        return arr[left] < arr[right] ? left : right;
    }

    public static int getLessIndexV2(int[] arr) {
        if (arr == null || arr.length == 0) {
            return -1; // no exist
        }
        if (arr.length == 1 || arr[0] < arr[1]) {
            return 0;
        }
        if (arr[arr.length - 1] < arr[arr.length - 2]) {
            return arr.length - 1;
        }

        int left = 1;
        int right = arr.length - 2;
        int mid = 0;
        while (left < right) {
            mid = left + ((right - left) >> 1);
            if (arr[mid] > arr[mid - 1]) {
                right = mid - 1;
            } else if (arr[mid] > arr[mid + 1]) {
                left = mid + 1;
            } else {
                return mid;
            }
        }
        return left;
    }

    /**
     * 生成一个随机数组(无序, 相邻不相等)
     *
     * @param maxValue  数组最大值
     * @param maxLength 数组最大长度
     * @return int[]
     */
    public static int[] generateRandomArray(int maxValue, int maxLength) {
        // 初始化数组
        int[] arr = new int[(int) ((maxLength * Math.random()) + 1)];
        // 先给第一个下标赋值
        int randomValue = (int) ((Math.random() * maxValue) + 1) - (int) (Math.random() * maxValue);
        if (randomValue != 0) {
            arr[0] = randomValue;
        }
        // 循环遍历
        for (int i = 1; i < arr.length; i++) {
            // 赋值, 相邻不相等
            do {
                arr[i] = (int) (Math.random() * maxValue);
            } while (arr[i] == arr[i - 1]);
        }
        // 返回
        return arr;
    }

    /**
     * 校验是不是局部最小值
     *
     * @param arr      数组
     * @param minIndex 最小值下标
     * @return boolean
     */
    public static boolean check(int[] arr, int minIndex) {
        // 边界条件
        if (arr == null || arr.length == 0) {
            return minIndex == -1;
        }
        // 定义最小下标的前一个位置
        int left = minIndex - 1;
        // 定义最小下标的后一个位置
        int right = minIndex + 1;
        // 如果最小下标的前一个位置>=0, 就判断是不是比最小下标的值大, 否则返回true
        boolean leftBigger = left >= 0 ? arr[left] > arr[minIndex] : true;
        // 如果最小下标的后一个位置小于数组长度, 就判断是不是比最小下标的值大, 否则返回true
        boolean rightBigger = right < arr.length ? arr[right] > arr[minIndex] : true;
        // 如果两边都大返回true
        return leftBigger && rightBigger;
    }

    /**
     * 打印数组和具备最小值
     *
     * @param arr      数组
     * @param minIndex 局部最小值下标
     */
    public static void print(int[] arr, int minIndex) {
        // 循环遍历
        for (int i = 0; i < arr.length; i++) {
            // 打印
            System.out.print(arr[i] + " ");
        }
        // 打印局部最小值
        System.out.println("***" + arr[minIndex] + "***");
    }

    public static void test() {
        // 定义变量
        int res;
        int maxValue = 1000;
        int maxLength = 1000;
        int testTimes = 20000;
        boolean succeed = true;
        // 测试开始
        for (int i = 0; i < testTimes; i++) {
            // 生成随机数组
            int[] arr = generateRandomArray(maxValue, maxLength);
            // 找到局部最小值下标
//            int res = find(arr);
            res = getLessIndex001(arr);
            //
            if (!check(arr, res)) {
                // 打印
                print(arr, res);
                // 赋值
                succeed = false;
                // 出错跳出循环
                break;
            }
        }
        // 打印
        System.out.println(succeed ? "Yes" : "No");
    }

    public static void main(String[] args) {
        // 对数器测试
        test();
    }

    public static int getLessIndex001(int[] arr) {
        if (null == arr ||
            0 == arr.length) {
            return -1;
        }

        if (1 == arr.length ||
            arr[0] < arr[1]) {
            return 0;
        }

        if (arr[arr.length - 1] < arr[arr.length - 2]) {
            return arr.length - 1;
        }

        int left = 1;
        int right = arr.length - 2;
        int mid;

        while (left < right - 1) {
            mid = left + ((right - left) >> 1);
            if (arr[mid] < arr[mid - 1] && arr[mid] < arr[mid + 1]) {
                return mid;
            } else {
                if (arr[mid] > arr[mid - 1]) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            }
        }

        return arr[left] < arr[right] ? left : right;
    }

}
