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
        test(new ArrayList<>());
        test(new ArrayListTrim<>());
        test(new SingleLinkedList<>());
        test(new SingleLinkedListHeader<>());
        test(new LinkedList<>());
        test(new SingleCircleLinkedList<>());
        test(new LinkedCircleList<>());
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
