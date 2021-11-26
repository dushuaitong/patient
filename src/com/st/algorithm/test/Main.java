package com.st.algorithm.test;

import com.st.algorithm.strucute.ArrayList;
import com.st.algorithm.strucute.LinkedList;
import com.st.algorithm.strucute.LinkedListHeader;
import com.st.algorithm.strucute.common.List;

/**
 * @author dushuaitong
 * @description: 测试接口
 * @date 2021/11/23
 */
public class Main {
    public static void main(String[] args) {
        testLinkedHeaderList();
    }

    public static void testLinkList() {
        List<Integer> arrayList = new LinkedList<>();
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
        List<Integer> arrayList = new LinkedListHeader<>();
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
}
