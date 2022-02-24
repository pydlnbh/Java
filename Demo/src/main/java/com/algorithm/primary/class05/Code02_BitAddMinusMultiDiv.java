package com.algorithm.primary.class05;

public class Code02_BitAddMinusMultiDiv {

    /**
     * 初始化sum等于a,如果b等于0,直接返回sum,如果a等于0,b不等于0,跳入循环
     *
     * 第一步:  sum = a ^ b; 两个数字无尽位相加
     * 第二步:  b = (a & b) << 1; 两个数字相加进的位
     * 第三步:  a = sum;
     *
     * 如果 b != 0 循环三步
     *
     * @param a 数字
     * @param b 数字
     * @return int
     */
    public static int add(int a, int b) {
        int sum = a;
        while (b != 0) {
            sum = a ^ b;
            b = (a & b) << 1;
            a = sum;
        }
        return  sum;
    }

    /**
     * 减法 a - b 可以化作 a + (-b), b 转为 -b 可以 取反 + 1
     * @param a int整型
     * @param b int整型
     * @return int
     */
    public static int minus(int a, int b) {
        return add(a, negNum(b));
    }

    /**
     * 正数变负数 按位取反 + 1
     *
     * @param num int整型
     * @return int
     */
    public static int negNum(int num) {
        return add(~num, 1);
    }

    /**
     * 1. 初始化返回res = 0
     * 2. 如果b&1不等于0, 让a和res相加
     * 3. a向左移一位, b无符号向右移动一位
     *
     * @param a int整型
     * @param b int整型
     * @return int
     */
    public static int multi(int a, int b) {
        int res = 0;
        while (b != 0) {
            if ((b & 1) != 0) {
                res = add(res, a);
            }
            a <<= 1;
            b >>>= 1;
        }
        return res;
    }

    /**
     * 除法
     * 先转成整数再进行按位排查, 如果 x>>i >= y,(x右移几位大于y), res |= (1 << i) (把这一位存起来), x减去y向左移几位
     *
     * @param a
     * @param b
     * @return
     */
    public static int div(int a, int b) {
        int x = isNeg(a) ? negNum(a) : a;
        int y = isNeg(b) ? negNum(b) : b;
        int res = 0;
        for (int i = 30; i >= 0; i = minus(i, 1)) {
            if ((x >> i) >= y) {
                res |= (1 << i);
                x = minus(x, y << i);
            }
        }
        // true ^ true = false,  false ^ false = false, true ^ false = true, false ^ true = true;
        return isNeg(a) ^ isNeg(b) ? negNum(res) : res;
    }

    public static boolean isNeg(int num) {
        return num < 0;
    }

    /**
     * 除法(整型最小值的判断)
     * 1. 如果两个数都是整型最小值, 就返回1
     * 2. 如果除数为整型最小值, 那被除数肯定比除数小, 除不尽, 返回0
     * 3. 如果被除数是整型最小值
     *    3.1 并且除数是-1, 那就返回整型最大值
     *    3.2 被除数 + 1, 然后除以除数，得出来的值+ ((被除数-(除数*的出来的值)) / 除数)
     * 4. 如果上述条件都不满足, 就正常返回div方法
     *
     * @param a int整型
     * @param b int整型
     * @return int
     */
    public static int divide(int a, int b) {
        if (a == Integer.MIN_VALUE && b == Integer.MIN_VALUE) {
            return 1;
        } else if (b == Integer.MIN_VALUE) {
            return 0;
        } else if (a == Integer.MIN_VALUE) {
            if (b == negNum(1)) {
                return Integer.MAX_VALUE;
            } else {
                // a` = a + 1;
                // c = a` / b;
                // d = a - (b * c) ===> d = a - a`
                // e = d / b
                // res = c + e
                int c = div(add(a, 1), b);
                return add(c, div(minus(a, multi(b, c)), b));
            }
        } else if (b == 0) {
            System.out.print("Exception: 除数不能为");
            return 0;
        } else {
            return div(a, b);
        }
    }

    public static void main(String[] args) {
        System.out.println(add(3, 4));
        System.out.println(minus(2, 4));
        System.out.println(multi(0, 12));
        System.out.println(divide(12, 2));
    }

}
