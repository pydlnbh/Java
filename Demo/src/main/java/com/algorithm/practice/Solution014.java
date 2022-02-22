package com.algorithm.practice;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Solution014 {

    /**
     * 打印int整型的二进制
     *
     * @param num 数字
     */
    public static void printBinary(int num) {
        for (int i = 31; i >= 0; i--) {
            System.out.print((num & (1 << i)) == 0 ? 0 : 1);
        }
    }

    /**
     * 阶乘之和
     *
     * @param num 数字
     * @return long 长整型
     */
    public static long factorialSum(long num) {
        long res = 0;
        long ans = 1;
        for (int i = 1; i <= num; i++) {
            ans *= i;
            res += ans;
        }
        return res;
    }

    /**
     * 选择排序 O(n2)
     *
     * @param arr 数组
     */
    public static void selectionSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }

        for (int i = 0; i < arr.length; i++) {
            int index = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[index]) {
                    index = j;
                }
            }
            swap(arr, i, index);
        }
    }

    /**
     * 冒泡排序 O(n2)
     *
     * @param arr 数组
     */
    public static void bubbleSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }

        for (int i = arr.length - 1; i >= 0; i--) {
            for (int j = 0; j < i; j++) {
                if (arr[j] > arr[j + 1]) {
                    swap(arr, j, j + 1);
                }
            }
        }
    }

    /**
     * 插入排序 O(n2)
     *
     * @param arr 数组
     */
    public static void insertionSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }

        for (int i = 1; i < arr.length; i++) {
            for (int j = i - 1; j >= 0; j--) {
                if (arr[j] > arr[j + 1]) {
                    swap(arr, j, j + 1);
                }
            }
        }
    }

    /**
     * 交换函数
     *
     * @param arr 数组
     * @param i 下标i
     * @param j 下标j
     */
    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    /**
     * 生成随机数组
     *
     * @param maxSize 最大长度
     * @param maxValue 最大数值
     * @return int[]
     */
    public static int[] generateRandomArray(int maxSize, int maxValue) {
        int[] arr = new int[(int) ((maxSize * Math.random()) + 1)];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) (maxValue * Math.random()) - (int) (maxValue * Math.random());
        }
        return arr;
    }

    /**
     * 拷贝数组
     *
     * @param arr 数组
     * @return int[]
     */
    public static int[] copyArray(int[] arr) {
        int[] res = new int[arr.length];
        if (arr == null || arr.length == 0) {
            return null;
        }
        for (int i = 0; i < arr.length; i++) {
            res[i] = arr[i];
        }
        return res;
    }

    /**
     * 判断两个数组是否相等
     *
     * @param arr1 数组1
     * @param arr2 数组2
     * @return boolean
     */
    public static boolean isEqual(int[] arr1, int[] arr2) {
        if ((arr1 == null && arr2 != null) || (arr1 != null && arr2 == null)) {
            return false;
        }
        if (arr1.length != arr2.length) {
            return false;
        }
        for (int i = 0; i < arr1.length; i++) {
            if (arr1[i] != arr2[i]) {
                return false;
            }
        }
        return true;
    }

    /**
     * 打印数组
     *
     * @param args 信息
     * @param arr 数组
     */
    public static void printArray(String args, int[] arr) {
        System.out.print(args);
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    /**
     * 排序对数器
     */
    public static void testSort() {
        int testTimes = 1000;
        int maxSize = 100;
        int maxValue = 100;
        boolean succeed = true;
        for (int i = 0; i < testTimes; i++) {
            int[] arr = generateRandomArray(maxSize, maxValue);
            int[] copyArray = copyArray(arr);
            int[] sourceArray = copyArray(arr);
            // 排序
//            selectionSort(arr);
//            bubbleSort(arr);
            insertionSort(arr);
            Arrays.sort(copyArray);
            if (!isEqual(arr, copyArray)) {
                printArray("源数组:", sourceArray);
                printArray("自己排序的数组", arr);
                printArray("正确的排序", copyArray);
                succeed = false;
                break;
            }
        }
        System.out.println(succeed ? "yes" : "no");
    }

    /**
     * 前缀和数组
     */
    public static class PreSum {
        private int[] arr;

        public PreSum(int[] arr) {
            this.arr = new int[arr.length];
            this.arr[0] = arr[0];
            for (int i = 1; i < arr.length; i++) {
                this.arr[i] = this.arr[i - 1] + arr[i];
            }
        }

        public int rangeSum(int left, int right) {
            return left == 0 ? arr[right] : arr[right] - arr[left - 1];
        }
    }

    /**
     * 测试前缀和
     *
     * @param left 左侧
     * @param right 右侧
     */
    public static void testPreSum(int left, int right) {
        int[] arr = {2, 4, 3, 87, 11};
        PreSum preSum = new PreSum(arr);
        int sum = preSum.rangeSum(left, right);
        int testSum = 0;
        for (int i = left; i <= right; i++) {
            testSum += arr[i];
        }
        boolean flag = sum == testSum ? true : false;
        System.out.println(flag ? "yes" : false);
    }

    /**
     * 从 2 ~ 12 随机 变成 4 ~ 24
     */
    public static class RandomChange {

        /**
         * 2 ~ 12 随机
         *
         * @return int
         */
        public int f() {
            return (int) (Math.random() * 11) + 2;
        }

        /**
         * 等概率返回0 和 1
         *
         * @return int
         */
        public int f1() {
            int ans = 0;
            do {
                ans = f();
            } while (ans == 7);
            return ans < 7 ? 0 : 1;
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
         * 等概率返回 0 ~ 21
         *
         * @return int
         */
        public int f3() {
            int ans = 0;
            do {
                ans = f2();
            } while (ans > 21);
            return ans;
        }

        /**
         * 等概率返回4 ~ 24
         *
         * @return int
         */
        public int g() {
            return f3() + 4;
        }

        /**
         * 从0~1不等概率随机
         *
         * @return int
         */
        public int q() {
            double ans = Math.random();
            return ans < 0.33 ? 0 : 1;
        }

        /**
         * 0 ~ 1等概率随机
         *
         * @return int
         */
        public int a() {
            int ans = 0;
            do {
                ans = q();
            } while (ans == q());
            return ans;
        }

    }

    public static void testRandom(int num) {
        int testTimes = 15645614;
        int[] counts = new int[num];
        RandomChange r = new RandomChange();
        for (int i = 0; i < testTimes; i++) {
            counts[r.a()]++;
        }
        for (int i = 0; i < counts.length; i++) {
            System.out.println(i + "这个数出现了" + counts[i] + "次");
        }
    }

    /**
     * 二分查找: 有序数组中查找某个数是否存在
     *
     * @param arr 数组
     * @param num 数字
     * @return boolean
     */
    public static boolean BSExist(int[] arr, int num) {
        if (arr == null || arr.length == 0) {
            return false;
        }
        int left = 0;
        int right = arr.length - 1;
        while (left <= right) {
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
     * >= num最左侧的下标
     *
     * @param arr 数组
     * @param num 数字
     * @return int
     */
    public static int BSNearLeft(int[] arr, int num) {
        int index = -1;
        if (arr == null || arr.length == 0) {
            return index;
        }
        int left = 0;
        int right = arr.length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (arr[mid] >= num) {
                index = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return index;
    }

    /**
     * 找到<=num最右侧的位置
     *
     * @param arr 数组
     * @param num 数字
     * @return int
     */
    public static int BSNearRight(int[] arr, int num) {
        int index = -1;
        if (arr == null || arr.length == 0) {
            return index;
        }
        int left = 0;
        int right = arr.length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (arr[mid] <= num) {
                index = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return index;
    }

    /**
     * 找到局部最小值
     *
     * @param arr 数组
     * @return int
     */
    public static int miniNum(int[] arr) {
        if (arr == null || arr.length == 0) {
            return -1;
        }
        if (arr[0] < arr[1] || arr.length == 1) {
            return arr[0];
        }
        if (arr[arr.length - 1] < arr[arr.length - 2]) {
            return arr[arr.length - 1];
        }
        int left = 0;
        int right = arr.length - 1;
        while (left < right - 1) {
            int mid = (left + right) / 2;
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

    /**
     * 二分搜索
     */
    public static void testBinarySearch() {
        int[] arr = {2, 1, 24, 2, 21, 12, 44, 55};
        int[] copyArray = copyArray(arr);
        selectionSort(arr);
        System.out.println(BSExist(arr, 2));
        System.out.println(BSNearLeft(arr, 2));
        System.out.println(BSNearRight(arr, 2));
        System.out.println(miniNum(copyArray));
    }

    public static class Node {
        private int value;
        private Node next;

        public Node(int value) {
            this.value = value;
        }
    }

    public static class LinkedList01<T> {
        private T value;
        private LinkedList01 next;

        public LinkedList01(T value) {
            this.value = value;
        }
    }

    public static class DoubleNode {
        private int value;
        private DoubleNode last;
        private DoubleNode next;

        public DoubleNode(int value) {
            this.value = value;
        }
    }

    public static class DoubleLinkedList<T> {
        private T value;
        private DoubleLinkedList<T> next;
        private DoubleLinkedList<T> last;

        public DoubleLinkedList(T value) {
            this.value = value;
        }
    }

    /**
     * 反转单链表
     *
     * @param head 头结点
     * @return Node
     */
    public static Node reverseList(Node head) {
        Node pre = null;
        Node next = null;
        while (head != null) {
            next = head.next;
            head.next = pre;
            pre = head;
            head = next;
        }
        return pre;
    }

    /**
     * 反转双链表
     *
     * @param head 头结点
     * @return DoubleNode
     */
    public static DoubleNode reverseDoubleList(DoubleNode head) {
        DoubleNode pre = null;
        DoubleNode next = null;
        while (head != null) {
            next = head.next;
            head.last = next;
            head.next = pre;
            pre = head;
            head = next;
        }
        return pre;
    }

    /**
     * 打印大单表
     *
     * @param head 头结点
     */
    public static void printLinkedList(Node head) {
        while (head != null) {
            System.out.print(head.value + " ");
            head = head.next;
        }
        System.out.println();
    }

    /**
     * 打印双向链表
     *
     * @param next 头结点
     */
    public static void printDoubleLinkedList(DoubleNode next, DoubleNode last) {
        System.out.print("next 打印: ");
        while (next != null) {
            System.out.print(next.value + " ");
            next = next.next;
        }
        System.out.println();
        System.out.print("last 打印: ");
        while (last != null) {
            System.out.print(last.value + " ");
            last = last.last;
        }
        System.out.println();
    }

    /**
     * 链表实现队列
     */
    public static class MyQueue<T> {
        private int size;
        private LinkedList01<T> head;
        private LinkedList01<T> tail;

        public MyQueue() {
            size = 0;
            head = null;
            tail = null;
        }

        public boolean isEmpty() {
            return size == 0;
        }

        public int size() {
            return size;
        }

        public void push(T value) {
            LinkedList01<T> cur = new LinkedList01<>(value);
            if (head == null) {
                head = cur;
                tail = cur;
            } else {
                tail.next = cur;
                tail = cur;
            }
            size++;
        }

        public T pop() {
            T ans = null;
            if (head == null) {
                tail = null;    // 当head == null 时 tail 也等于null
                return ans;
            } else {
                ans = head.value;
                head = head.next;
            }
            size--;
            return ans;
        }

        public T peek() {
            return head == null ? null : head.value;
        }

    }

    /**
     * 链表实现栈
     */
    public static class MyStack<T> {
        private int size;
        private LinkedList01<T> head;

        public MyStack() {
            size = 0;
            head = null;
        }

        public boolean isEmpty() {
            return size == 0;
        }

        public int size() {
            return size;
        }

        public void push(T value) {
            LinkedList01<T> cur = new LinkedList01<T>(value);
            if (head == null) {
                head = cur;
            } else {
                cur.next = head;
                head = cur;
            }
            size++;
        }

        public T pop() {
            T ans = null;
            if (head == null) {
                return ans;
            } else {
                ans = head.value;
                head = head.next;
            }
            size--;
            return ans;
        }

        public T peek() {
            return head == null ? null : head.value;
        }
    }

    /**
     * 双向链表变为双端队列
     */
    public static class MyDeque<T> {
        private int size;
        private DoubleLinkedList<T> head;
        private DoubleLinkedList<T> tail;

        public MyDeque() {
            size = 0;
            head = null;
            tail = null;
        }

        public boolean isEmpty() {
            return size == 0;
        }

        public int size() {
            return size;
        }

        public void pushHead(T value) {
            DoubleLinkedList<T> cur = new DoubleLinkedList<>(value);
            if (head == null) {
                head = cur;
                tail = cur;
            } else {
                cur.next = head;
                head.last = cur;
                head = cur;
            }
            size++;
        }

        public void pushTail(T value) {
            DoubleLinkedList<T> cur = new DoubleLinkedList<>(value);
            if (head == null) {
                head = cur;
                tail = cur;
            } else {
                cur.last = tail;
                tail.next = cur;
                tail = cur;
            }
            size++;
        }

        public T popHead() {
            T ans = null;
            if (head == null) {
                return ans;
            }
            size--;
            ans = head.value;
            if (head == tail) {
                head = null;
                tail = null;
            } else {
                head = head.next;
                head.last = null;
            }
            return ans;
        }

        public T popTail() {
            T ans = null;
            if (head == null) {
                return ans;
            }
            size--;
            ans = tail.value;
            if (head == tail) {
                head = null;
                tail = null;
            } else {
                tail = tail.last;
                tail.next = null;
            }
            return ans;
        }

        public T peekHead() {
            return head != null ? head.value : null;
        }

        public T peekTail() {
            return tail != null ? tail.value : null;
        }
    }

    public static Node reverseKGroup(Node head, int k) {
        Node start = head;
        Node end = getKEnd(start, k);
        if (end == null) {
            return head;
        }
        head = end;
        reverse(start, end);
        Node lastEnd = start;
        while (lastEnd.next != null) {
            start = lastEnd.next;
            end = getKEnd(start, k);
            if (end == null) {
                return head;
            }
            reverse(start, end);
            lastEnd.next = end;
            lastEnd = start;
        }
        return head;
    }

    public static Node getKEnd(Node head, int num) {
        while (--num != 0 && head != null) {
            head = head.next;
        }
        return head;
    }

    public static void reverse(Node start, Node end) {
        end = end.next;
        Node pre = null;
        Node next = null;
        Node cur = start;
        while (cur != null) {
            next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        start.next = end;
    }

    public static Node addTwoNumbers(Node head1, Node head2) {
        int len1 = getNodeLength(head1);
        int len2 = getNodeLength(head2);
        Node l = len1 >= len2 ? head1 : head2;
        Node s = l == head1 ? head2 : head1;
        Node curL = l;
        Node curS = s;
        Node last = curL;
        int carry = 0;
        int num = 0;
        while (curS != null) {
            num = curS.value + curL.value + carry;
            curL.value = num % 10;
            carry = num / 10;
            last = curL;
            curS = curS.next;
            curL = curL.next;
        }
        while (curL != null) {
            num = curL.value + carry;
            curL.value = num % 10;
            carry = num / 10;
            last = curL;
            curL = curL.next;
        }
        if (carry != 0) {
            last.next = new Node(1); // 写成last = new Node(1);
        }
        return l;
    }

    public static Node mergeTwoList(Node head1, Node head2) {
//        if ((head1 == null && head2 != null) || (head1 != null && head2 == null)) { 全等于null 会报错
        if (head1 == null || head2 == null) {
            return head1 == null ? head2 : head1;
        }
        Node head = head1.value <= head2.value ? head1 : head2;
        Node cur1 = head.next;
        Node cur2 = head == head1 ? head2 : head1;
        Node pre = head;
        while (cur1 != null && cur2 != null) {
            if (cur1.value <= cur2.value) {
                pre.next = cur1;
                cur1 = cur1.next;
            } else {
                pre.next = cur2;
                cur2 = cur2.next;
            }
            pre = pre.next;
        }
        pre.next = cur1 != null ? cur1 : cur2;
        return head;
    }

    public static int getNodeLength(Node head) {
        int length = 0;
        while (head != null) {
            length++;
            head = head.next;
        }
        return length;
    }

    /**
     * 链表测试
     */
    public static void testLinkedList() {
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        node1.next = node2;
        node2.next = node3;
        printLinkedList(node1);
        Node reverseNode1 = reverseList(node1);
        printLinkedList(reverseNode1);

        System.out.println("================");

        DoubleNode doubleNode = new DoubleNode(0);
        DoubleNode doubleNode1 = new DoubleNode(1);
        DoubleNode doubleNode2 = new DoubleNode(2);
        doubleNode.next = doubleNode1;
        doubleNode1.last = doubleNode;
        doubleNode1.next = doubleNode2;
        doubleNode2.last = doubleNode1;
        printDoubleLinkedList(doubleNode, doubleNode);
        DoubleNode reverseDoubleList = reverseDoubleList(doubleNode);
        printDoubleLinkedList(reverseDoubleList, reverseDoubleList);

        System.out.println("=================");

        MyQueue<Integer> queue = new MyQueue<>();
        queue.push(0);
        System.out.println(queue.peek());
        queue.push(1);
        queue.pop();
        System.out.println(queue.peek());
        System.out.println(queue.size());

        System.out.println("=================");

        MyStack<Integer> stack = new MyStack<>();
        stack.push(0);
        System.out.println(stack.peek());
        stack.push(1);
        stack.pop();
        System.out.println(stack.peek());
        System.out.println(stack.size());

        System.out.println("=================");

        MyDeque<Integer> deque = new MyDeque<>();
        deque.pushHead(1);
        deque.pushTail(2);
        deque.pushHead(3);
        deque.pushTail(3);
        System.out.println(deque.popHead());
        System.out.println(deque.peekHead());
        System.out.println(deque.peekTail());
    }

    public static void testQueue() {
        MyQueue<Integer> myQueue = new MyQueue<>();
        Queue<Integer> test = new LinkedList<>();
        int testTime = 5000000;
        int maxValue = 200000000;
        System.out.println("测试开始！");
        for (int i = 0; i < testTime; i++) {
            if (myQueue.isEmpty() != test.isEmpty()) {
                System.out.println("Oops!");
            }
            if (myQueue.size() != test.size()) {
                System.out.println("Oops!");
            }
            double decide = Math.random();
            if (decide < 0.33) {
                int num = (int) (Math.random() * maxValue);
                myQueue.push(num);
                test.offer(num);
            } else if (decide < 0.66) {
                if (!myQueue.isEmpty()) {
                    int num1 = myQueue.pop();
                    int num2 = test.poll();
                    if (num1 != num2) {
                        System.out.println("Oops!");
                    }
                }
            } else {
                if (!myQueue.isEmpty()) {
                    int num1 = myQueue.peek();
                    int num2 = test.peek();
                    if (num1 != num2) {
                        System.out.println("Oops!");
                    }
                }
            }
        }
        if (myQueue.size() != test.size()) {
            System.out.println("Oops!");
        }
        while (!myQueue.isEmpty()) {
            int num1 = myQueue.pop();
            int num2 = test.poll();
            if (num1 != num2) {
                System.out.println("Oops!");
            }
        }
        System.out.println("测试结束！");
    }

    public static void testStack() {
        MyStack<Integer> myStack = new MyStack<>();
        Stack<Integer> test = new Stack<>();
        int testTime = 5000000;
        int maxValue = 200000000;
        System.out.println("测试开始！");
        for (int i = 0; i < testTime; i++) {
            if (myStack.isEmpty() != test.isEmpty()) {
                System.out.println("Oops!");
            }
            if (myStack.size() != test.size()) {
                System.out.println("Oops!");
            }
            double decide = Math.random();
            if (decide < 0.33) {
                int num = (int) (Math.random() * maxValue);
                myStack.push(num);
                test.push(num);
            } else if (decide < 0.66) {
                if (!myStack.isEmpty()) {
                    int num1 = myStack.pop();
                    int num2 = test.pop();
                    if (num1 != num2) {
                        System.out.println("Oops!");
                    }
                }
            } else {
                if (!myStack.isEmpty()) {
                    int num1 = myStack.peek();
                    int num2 = test.peek();
                    if (num1 != num2) {
                        System.out.println("Oops!");
                    }
                }
            }
        }
        if (myStack.size() != test.size()) {
            System.out.println("Oops!");
        }
        while (!myStack.isEmpty()) {
            int num1 = myStack.pop();
            int num2 = test.pop();
            if (num1 != num2) {
                System.out.println("Oops!");
            }
        }
        System.out.println("测试结束！");
    }

    public static void main(String[] args) {
        // simple Test to save time
//        printBinary(4);
//        System.out.println(factorialSum(3));
//        testSort();
//        testPreSum(2, 4);
//        testRandom(33);
//        testBinarySearch();
//        testLinkedList();
        testQueue();
    }

}
