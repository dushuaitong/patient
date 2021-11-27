package com.st.algorithm.test;

import com.st.algorithm.common.util.Assert;
import com.st.algorithm.strucute.*;
import com.st.algorithm.strucute.common.List;

/**
 * @author dushuaitong
 * @description: 测试接口
 * @date 2021/11/23
 */
public class Main {
    public static void main(String[] args) {
//        test(new ArrayList<>());
//        test(new ArrayListTrim<>());
//        test(new SingleLinkedList<>());
//        test(new SingleLinkedListHeader<>());
//        test(new LinkedList<>());
//        test(new SingleCircleLinkedList<>());
//        test(new LinkedCircleList<>());
//        testStack();
//        testQueue();
//        testDoubleQueue();
//        testCycleQueue();
        testCycleDoubleQueue();
    }
    public static void testCycleDoubleQueue() {
        CycleDoubleQueue<Integer> cycleQueue = new CycleDoubleQueue<>();
        for (int i = 0; i < 10; i ++) {
            cycleQueue.enQueueFront(i + 1);
            cycleQueue.enQueueRear(i + 100);
        }
        System.out.println(cycleQueue);

        while (!cycleQueue.isEmpty()) {
            System.out.println(cycleQueue.deQueueRear());
        }

    }

    public static void testCycleQueue() {
        CycleQueue<Integer> cycleQueue = new CycleQueue<>();
        for (int i = 0; i < 15; i ++) {
            cycleQueue.enQueue(i);
        }
        System.out.println(cycleQueue);
        for (int i = 0; i < 7; i ++) {
            cycleQueue.deQueue();
        }
        for (int i = 0; i < 9; i ++) {
            cycleQueue.enQueue(i);
        }
        System.out.println(cycleQueue);
    }

    public static void testDoubleQueue() {
        DoubleQueue<Integer> queue = new DoubleQueue<>();
        queue.enQueueFront(11);
        queue.enQueueFront(12);
        queue.enQueueFront(13);
        queue.enQueueFront(14);

        while (!queue.isEmpty()) {
            System.out.println(queue.deQueueFront());
        }

        queue.enQueueRear(11);
        queue.enQueueRear(12);
        queue.enQueueRear(13);
        queue.enQueueRear(14);

        while (!queue.isEmpty()) {
            System.out.println(queue.deQueueRear());
        }
    }

    public static void testQueue() {
        Queue<Integer> queue = new Queue<>();
        queue.enQueue(11);
        queue.enQueue(12);
        queue.enQueue(13);
        queue.enQueue(14);

        while (!queue.isEmpty()) {
            System.out.println(queue.deQueue());
        }
    }

    public static void testStack() {
        Stack<Integer> stack = new Stack<>();
        stack.push(11);
        stack.push(12);
        stack.push(13);
        stack.push(14);

        while (!stack.isEmpty()) {
            System.out.println(stack.pop());
        }
    }

    public static void testDDLinkList() {
        List<Integer> arrayList = new LinkedList<>();
        arrayList.add(13);
        arrayList.add(14);
        arrayList.add(15);
        // arrayList.add(0, 12);
        arrayList.add(arrayList.size(), 15);
        arrayList.add(16);
        arrayList.set(arrayList.size()-1, 99);
         arrayList.remove(0);
         arrayList.remove(arrayList.size() - 1);
        System.out.println(arrayList);
        System.gc();
    }

    public static void testLinkList() {
        List<Integer> arrayList = new SingleLinkedList<>();
        arrayList.add(13);
        arrayList.add(14);
        arrayList.add(15);
        // arrayList.add(0, 12);
        arrayList.add(arrayList.size(), 15);
        arrayList.add(16);
        arrayList.set(arrayList.size()-1, 99);
        // arrayList.remove(0);
        // arrayList.remove(arrayList.size() - 1);
        System.out.println(arrayList);
        System.gc();
    }

    public static void testLinkedHeaderList() {
        List<Integer> arrayList = new SingleLinkedListHeader<>();
        arrayList.add(13);
        arrayList.add(14);
        arrayList.add(15);
        // arrayList.add(0, 12);
        arrayList.add(arrayList.size(), 15);
        arrayList.add(16);
        arrayList.set(arrayList.size()-1, 99);
         arrayList.remove(0);
        // arrayList.remove(arrayList.size() - 1);
        System.out.println(arrayList);
        System.out.println(arrayList.indexOf(13));
        System.gc();
    }

    public static void testArrayList() {
        ArrayList<Integer> arrayList = new ArrayList<>();
        arrayList.add(13);
        arrayList.add(14);
        arrayList.add(15);
        // arrayList.add(0, 12);
        arrayList.add(arrayList.size(), 15);
        arrayList.add(16);
        arrayList.set(arrayList.size()-1, 99);
        // arrayList.remove(0);
        // arrayList.remove(arrayList.size() - 1);
        System.out.println(arrayList);
        System.gc();
    }

    public static void test(List<Integer> list) {
        list.add(10);
        list.add(11);
        list.add(12);
        list.add(13);

        list.add(0, 22);
        list.add(2, 33);
        list.add(list.size(), 44);

        list.remove(0);
        list.remove(2);
        list.toString();
        list.remove(list.size() - 1);
        System.out.println(list);

        Assert.assert_t(list.indexOf(13) == 3, null);
        Assert.assert_t(list.indexOf(11) == List.ELEMENT_NOTFOUND, null);
        Assert.assert_t(list.get(0) == 10, null);
        Assert.assert_t(list.get(1) == 33, null);
        Assert.assert_t(list.contains(10), null);
        Assert.assert_t(list.get(list.size() - 1) == 13, null);
    }
}
