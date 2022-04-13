package com.algorithm.primary.practice;

import java.util.*;

public class Solution021 {

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

    public static void bubbleSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        for (int i = arr.length - 1; i >= 0; i--) {
            for (int j = 0; j < i; j++) {
                if (arr[j + 1] < arr[j]) {
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
        int[] arr = new int[(int) (maxSize * Math.random()) + 1];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) (Math.random() * maxValue) - (int) (Math.random() * maxValue);
        }
        return arr;
    }

    public static int[] copyArray(int[] arr) {
        int[] res = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            res[i] = arr[i];
        }
        return res;
    }

    public static boolean isEqual(int[] arr1, int[] arr2) {
        if ((arr1 != null && arr2 == null) || (arr1 == null && arr2 != null)) {
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
        int testTimes = 10000;
        int maxSize = 100;
        int maxValue = 1000;
        boolean succeed = true;
        for (int i = 0; i < testTimes; i++) {
            int[] arr = generateRandomArray(maxSize, maxValue);
            int[] copyArray = copyArray(arr);
//            selectionSort(arr);
//            bubbleSort(arr);
//            insertionSort(arr);
            Arrays.sort(copyArray);
            if (!isEqual(arr, copyArray)) {
                succeed = false;
                break;
            }
        }
        System.out.println(succeed ? "yes" : "no");
    }

    public static class Linked<T> {
        private T val;
        private Linked<T> next;

        public Linked(T val) {
            this.val = val;
        }
    }

    public static class MyQueue<T> {
        private int size;
        private Linked<T> head;
        private Linked<T> tail;

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

        public void offer(T val) {
            Linked<T> cur = new Linked<>(val);
            if (head == null) {
                head = cur;
                tail = cur;
            } else {
                tail.next = cur;
                tail = cur;
            }
            size++;
        }

        public T poll() {
            T ans = null;
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

        public T peek() {
            return head.val != null ? head.val : null;
        }
    }

    public static void testQueue() {
        MyQueue<Integer> myQueue = new MyQueue<>();
        Queue<Integer> test = new LinkedList<>();
        int testTimes = 100000;
        int maxValue = 1000000;
        System.out.println("测试开始");
        for (int i = 0; i < testTimes; i++) {
            if (myQueue.isEmpty() != test.isEmpty()) {
                System.out.println("Oops");
            }
            if (myQueue.size() != test.size()) {
                System.out.println("Oops");
            }
            double decide = Math.random();
            if (decide < 0.33) {
                int num = (int) (Math.random() * maxValue);
                myQueue.offer(num);
                test.offer(num);
            } else if (decide < 0.66) {
                if (!myQueue.isEmpty()) {
                    int num1 = myQueue.poll();
                    int num2 = test.poll();
                    if (num1 != num2) {
                        System.out.println("Oops");
                    }
                }
            } else {
                if (!myQueue.isEmpty()) {
                    int num1 = myQueue.peek();
                    int num2 = test.peek();
                    if (num1 != num2) {
                        System.out.println("Oops");
                    }
                }
            }
        }
        if (myQueue.size() != test.size()) {
            System.out.println("Oops");
        }
        while (!myQueue.isEmpty()) {
            int num1 = myQueue.poll();
            int num2 = test.poll();
            if (num1 != num2) {
                System.out.println("Oops");
            }
        }
        System.out.println("测试结束");
    }

    public static class DoubleLinked<T> {
        private T val;
        private DoubleLinked<T> pre;
        private DoubleLinked<T> next;

        public DoubleLinked(T value) {
            val = value;
        }
    }

    public static class MyDeque<T> {
        private int size;
        private DoubleLinked<T> head;
        private DoubleLinked<T> tail;

        public MyDeque() {
            size = 0;
        }

        public boolean isEmpty() {
            return size == 0;
        }

        public int size() {
            return size;
        }

        public void offerHead(T val) {
            DoubleLinked<T> cur = new DoubleLinked<>(val);
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

        public void offerTail(T val) {
            DoubleLinked<T> cur = new DoubleLinked<>(val);
            if (tail == null) {
                head = cur;
                tail = cur;
            } else {
                cur.pre = tail;
                tail.next = cur;
                tail = cur;
            }
            size++;
        }

        public T pollHead() {
            T ans = null;
            if (head == null) {
                return ans;
            }
            ans = head.val;
            size--;
            if (head == tail) {
                head = null;
                tail = null;
            } else {
                ans = head.val;
                head = head.next;
                head.pre = null;
            }
            return ans;
        }

        public T pollTail() {
            T ans = null;
            if (tail == null) {
                return ans;
            }
            ans = tail.val;
            size--;
            if (head == tail) {
                head = null;
                tail = null;
            } else {
                ans = tail.val;
                tail = tail.pre;
                tail.next = null;
            }
            return ans;
        }

        public T peekHead() {
            return head.val != null ? head.val : null;
        }

        public T peekTail() {
            return tail.val != null ? tail.val : null;
        }
    }

    public static void testDeque() {
        MyDeque<Integer> myDeque = new MyDeque<>();
        Deque<Integer> test = new LinkedList<>();
        int testTimes = 1000011;
        int maxValue = 10000;
        System.out.println("测试开始");
        for (int i = 0; i < testTimes; i++) {
            if (myDeque.isEmpty() != test.isEmpty()) {
                System.out.println("Oops1");
                break;
            }
            if (myDeque.size() != test.size()) {
                System.out.println("Oops2");
                break;
            }
            double decide = Math.random();
            int num = (int) (Math.random() * maxValue);
            if (decide < 0.33) {
                if (Math.random() < 0.5) {
                    myDeque.offerHead(num);
                    test.offerFirst(num);
                } else {
                    myDeque.offerTail(num);
                    test.offerLast(num);
                }
                if (myDeque.size() != test.size()) {
                    System.out.println("Oops3");
                    break;
                }
            } else if (decide < 0.66) {
                if (!myDeque.isEmpty()) {
                    int num1, num2;
                    if (Math.random() < 0.5) {
                        num1 = myDeque.pollHead();
                        num2 = test.pollFirst();
                    } else {
                        num1 = myDeque.pollTail();
                        num2 = test.pollLast();
                    }
                    if (num1 != num2) {
                        System.out.println("Oops4");
                        break;
                    }
                }
            } else {
                if (!myDeque.isEmpty()) {
                    int num1, num2;
                    if (Math.random() < 0.5) {
                        num1 = myDeque.peekHead();
                        num2 = test.peekFirst();
                    } else {
                        num1 = myDeque.peekTail();
                        num2 = test.peekLast();
                    }
                    if (num1 != num2) {
                        System.out.println("Oops5");
                        break;
                    }
                }
            }
        }
        if (myDeque.size() != test.size()) {
            System.out.println("Oops6");
        }
        while (!myDeque.isEmpty()) {
            int num1 = myDeque.pollTail();
            int num2 = test.pollLast();
            if (num1 != num2) {
                System.out.println("Oops7");
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
        ListNode end = getKGroupEnd(head, k);
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
        ListNode pre = null;
        ListNode next = null;
        ListNode cur = start;
        while (cur != end) {
            next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        start.next = end;
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int len1 = getlength(l1);
        int len2 = getlength(l2);
        ListNode longer = len1 >= len2 ? l1 : l2;
        ListNode shorter = longer == l1 ? l2 : l1;
        ListNode curL = longer;
        ListNode curS = shorter;
        ListNode last = curL;
        int carry = 0;
        int curNum;
        while (curS != null) {
            curNum = curS.val + curL.val + carry;
            curL.val = curNum % 10;
            carry = curNum / 10;
            last = curL;
            curL = curL.next;
            curS = curS.next;
        }
        while (curL != null) {
            curNum = curL.val + carry;
            curL.val = curNum % 10;
            carry = curNum / 10;
            last = curL;
            curL = curL.next;
        }
        if (carry != 0) {
            last.next = new ListNode(1);
        }
        return longer;
    }

    public int getlength(ListNode head) {
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

    public static void main(String[] args) {
        testSort();
//        testQueue();
//        testDeque();
    }
}
