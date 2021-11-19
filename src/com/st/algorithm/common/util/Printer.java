package com.st.algorithm.common.util;

/**
 * @author dushuaitong
 * @description: 打印器
 * @date 2021/11/19
 */
public class Printer {
    public static void printInter(Integer[] integers, Executor executor) {
        System.out.print("[");
        for (int i = 0; i < integers.length; ++i) {
            Integer integer = integers[i];
            if (executor != null) {
                executor.execute();
            }
            if (i != 0) {
                System.out.print(" ,");
            }
            System.out.print(integer);
        }
        System.out.print("]");
        System.out.println("");
    }
}
