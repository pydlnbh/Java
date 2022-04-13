package com.algorithm.primary.practice;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

public class Solution024 {

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
            swap(arr, index, i);
        }
    }

    public static void bubbleSort(int[] arr) {
        if (arr.length < 2 || arr == null) {
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

    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static int[] generateRandomArray(int maxSize, int maxValue) {
        int[] res = new int[(int) (Math.random() * maxSize) + 1];
        for (int i = 0; i < res.length; i++) {
            res[i] = (int) (Math.random() * maxValue) - (int) (Math.random() * maxValue);
        }
        return res;
    }

    public static int[] copyArray(int[] arr) {
        int[] res = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            res[i] = arr[i];
        }
        return res;
    }

    public static boolean isEqual(int[] arr1, int[] arr2) {
        if ((arr1 == null && arr2 != null) || (arr1 != null && arr2 == null)) {
            return false;
        }
        if (arr1 == null && arr2 == null) {
            return true;
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

    public static void testSort() {
        int maxSize = 1000;
        int maxValue = 10000;
        int testTimes = 100000;
        boolean succeed = true;
        for (int i = 0; i < testTimes; i++) {
            int[] arr = generateRandomArray(maxSize, maxValue);
            int[] copy = copyArray(arr);
//            selectionSort(arr);
//            bubbleSort(arr);
            insertionSort(arr);
            Arrays.sort(copy);
            if (!isEqual(arr, copy)) {
                succeed = false;
                break;
            }
        }
        System.out.println(succeed ? "yes" : "Oops");
    }

    public static class Node<E> {
        private E val;
        private Node<E> next;

        public Node(E val) {
            this.val = val;
        }
    }

    public static class MyQueue<E> {
        private int size;
        private Node<E> head;
        private Node<E> tail;

        public MyQueue() {
            size = 0;
        }

        public void offer(E val) {
            Node<E> cur = new Node<>(val);
            if (head == null) {
                head = cur;
                tail = cur;
            } else {
                tail.next = cur;
                tail = cur;
            }
            size++;
        }

        public E poll() {
            E ans = null;
            if (head == null) {
                tail = null;
                return ans;
            } else {
                ans = head.val;
                head = head.next;
            }
            size--;
            return ans;
        }

        public E peek() {
            return head.val != null ? head.val : null;
        }

        public boolean isEmpty() {
            return size == 0;
        }

        public int size() {
            return size;
        }
    }

    public static void testMyQueue() {
        int maxValue = 1000;
        int testTimes = 10000;
        MyQueue<Integer> queue = new MyQueue<>();
        Queue<Integer> test = new LinkedList<>();
        System.out.println("begin");
        for (int i = 0; i < testTimes; i++) {
            if (queue.isEmpty() != test.isEmpty()) {
                System.out.println("Oops1");
                break;
            }
            if (queue.size() != test.size()) {
                System.out.println("Oops2");
                break;
            }
            double decide = Math.random();
            int num = (int) (Math.random() * maxValue);
            if (decide < 0.33) {
                queue.offer(num);
                test.offer(num);
                if (queue.size() != test.size()) {
                    System.out.println("Oops3");
                    break;
                }
            } else if (decide < 0.66) {
                if (!queue.isEmpty()) {
                    int num1 = queue.poll();
                    int num2 = test.poll();
                    if (num1 != num2) {
                        System.out.println("Oops4");
                        break;
                    }
                }
            } else {
                if (!queue.isEmpty()) {
                    int num1 = queue.peek();
                    int num2 = test.peek();
                    if (num1 != num2) {
                        System.out.println("Oops5");
                        break;
                    }
                }
            }
        }
        if (queue.isEmpty() != test.isEmpty()) {
            System.out.println("Oops6");
        }
        if (queue.size() != test.size()) {
            System.out.println("Oops7");
        }
        while (queue.isEmpty()) {
            int num1 = queue.poll();
            int num2 = test.poll();
            if (num1 != num2) {
                System.out.println("Oops8");
                break;
            }
        }
        System.out.println("end");
    }

    public static class DoubleNode<E> {
        private E val;
        private DoubleNode<E> pre;
        private DoubleNode<E> next;

        public DoubleNode(E value) {
            val = value;
        }
    }

    public static class MyDeque<E> {
        private int size;
        private DoubleNode<E> head;
        private DoubleNode<E> tail;

        public MyDeque() {
            size = 0;
        }

        public boolean isEmpty() {
            return size == 0;
        }

        public int size() {
            return size;
        }

        public void offerHead(E val) {
            DoubleNode<E> cur = new DoubleNode<>(val);
            if (head == null) {
                head = cur;
                tail = cur;
            } else {
                cur.next = head;
                head.pre = cur;
                head = cur;
            }
            size++;
        }

        public void offerTail(E val) {
            DoubleNode<E> cur = new DoubleNode<>(val);
            if (tail == null) {
                head = cur;
                tail = cur;
            } else {
                tail.next = cur;
                cur.pre = tail;
                tail = cur;
            }
            size++;
        }

        public E pollHead() {
            E ans = null;
            if (head == null) {
                return ans;
            }
            ans = head.val;
            size--;
            if (head == tail) {
                head = null;
                tail = null;
            } else {
                head = head.next;
                head.pre = null;
            }
            return ans;
        }

        public E pollTail() {
            E ans = null;
            if (tail == null) {
                return ans;
            }
            ans = tail.val;
            size--;
            if (head == tail) {
                head = null;
                tail = null;
            } else {
                tail = tail.pre;
                tail.next = null;
            }
            return ans;
        }

        public E peekHead() {
            return head.val != null ? head.val : null;
        }

        public E peekTail() {
            return tail.val != null ? tail.val : null;
        }
    }

    public static void testMyDeque() {
        int maxValue = 1000;
        int testTimes = 10000;
        MyDeque<Integer> deque = new MyDeque<>();
        Deque<Integer> test = new LinkedList<>();
        System.out.println("测试开始");
        for (int i = 0; i < testTimes; i++) {
            if (deque.isEmpty() != test.isEmpty()) {
                System.out.println("Oops1");
                break;
            }
            if (deque.size() != test.size()) {
                System.out.println("Oops2");
                break;
            }
            double decide = Math.random();
            int num = (int) (Math.random() * maxValue);
            if (decide < 0.33) {
                if (Math.random() < 0.5) {
                    deque.offerHead(num);
                    test.offerFirst(num);
                } else {
                    deque.offerTail(num);
                    test.offerLast(num);
                }
                if (deque.size() != test.size()) {
                    System.out.println("Oops3");
                    break;
                }
            } else if (decide < 0.66) {
                if (!deque.isEmpty()) {
                    int num1, num2;
                    if (Math.random() < 0.5) {
                        num1 = deque.pollHead();
                        num2 = test.pollFirst();
                    } else {
                        num1 = deque.pollTail();
                        num2 = test.pollLast();
                    }
                    if (num1 != num2) {
                        System.out.println("Oops4");
                        break;
                    }
                }
            } else {
                if (!deque.isEmpty()) {
                    int num1, num2;
                    if (Math.random() < 0.5) {
                        num1 = deque.peekHead();
                        num2 = test.peekFirst();
                    } else {
                        num1 = deque.peekTail();
                        num2 = test.peekLast();
                    }
                    if (num1 != num2) {
                        System.out.println("Oops5");
                        break;
                    }
                }
            }
        }
        if (deque.isEmpty() != test.isEmpty()) {
            System.out.println("Oops6");
        }
        if (deque.size() != test.size()) {
            System.out.println("Oops7");
        }
        while (deque.isEmpty()) {
            int num1 = deque.pollTail();
            int num2 = test.pollLast();
            if (num1 != num2) {
                System.out.println("Oops8");
                break;
            }
        }
        System.out.println("测试结束");
    }

    private static class ListNode {
        private int val;
        private ListNode next;

        public ListNode(int val) {
            this.val = val;
        }
    }

    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode start = head;
        ListNode end = getKGroupEnd(start, k);
        if (end == null) {
            return head;
        }
        head = end;
        reverse(start, end);
        ListNode lastEnd = start;
        while (lastEnd.next != null) {
            start = lastEnd.next;
            end = getKGroupEnd(start, k);
            if (end == null) {
                return head;
            }
            reverse(start, end);
            lastEnd.next = end;
            lastEnd = start;
        }
        return head;
    }

    public ListNode getKGroupEnd(ListNode head, int k) {
        while (--k != 0 && head != null) {
            head = head.next;
        }
        return head;
    }

    public void reverse(ListNode start, ListNode end) {
        end = end.next;
        ListNode cur = start;
        ListNode pre = null;
        ListNode next;
        while (cur != end) {
            next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        start.next = end;
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int len1 = getListNodeLength(l1);
        int len2 = getListNodeLength(l2);
        ListNode longer = len1 >= len2 ? l1 : l2;
        ListNode shorter = longer == l1 ? l2 : l1;
        ListNode curL = longer;
        ListNode curS = shorter;
        ListNode last = curL;
        int carry = 0;
        int curSum;
        while (curS != null) {
            curSum = curS.val + curL.val + carry;
            curL.val = curSum % 10;
            carry = curSum / 10;
            last = curL;
            curL = curL.next;
            curS = curS.next;
        }
        while (curL != null) {
            curSum = curL.val + carry;
            curL.val = curSum % 10;
            carry = curSum / 10;
            last = curL;
            curL = curL.next;
        }
        if (carry != 0) {
            last.next = new ListNode(1);
        }
        return longer;
    }

    public int getListNodeLength(ListNode head) {
        int length = 0;
        while (head != null) {
            length++;
            head = head.next;
        }
        return length;
    }

    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if (list1 == null || list2 == null) {
            return list1 == null ? list2 : list1;
        }
        ListNode head = list1.val <= list2.val ? list1 : list2;
        ListNode cur1 = head.next;
        ListNode cur2 = head == list1 ? list2 : list1;
        ListNode pre = head;
        while (cur1 != null && cur2 != null) {
            if (cur1.val <= cur2.val) {
                pre.next = cur1;
                cur1 = cur1.next;
            } else {
                pre.next = cur2;
                cur2 = cur2.next;
            }
            pre = pre.next;
        }
        pre.next = cur1 == null ? cur2 : cur1;
        return head;
    }

    public int removeDuplicates(int[] nums) {
//        return test01(nums);
        return test02(nums);
    }

    public static int test01(int[] nums) {
        int count = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i - 1] == nums[i]) {
                count++;
            } else {
                nums[i - count] = nums[i];
            }
        }
        return nums.length - count;
    }

    public static int test02(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int left = 0;
        for (int right = 1; right < nums.length; right++) {
            if (nums[left] != nums[right]) {
                nums[++left] = nums[right];
            }
        }
        return ++left;
    }

    public static void main(String[] args) {
//        testSort();
//        testMyQueue();
//        testMyDeque();
        int i = test02(new int[]{});
        System.out.println(i);
    }
}
