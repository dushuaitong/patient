package com.st.algorithm.other;

/**
 * @author dushuaitong
 * @description: 斐波那契数 事后统计法(算法)
 * @date 2021/11/23
 */
public class FibNumber {
    public static int fib(int n) {
        if (n <= 1) {
            return n;
        }
        return fib(n - 1) + fib(n - 2);
    }

    public static int fib2(int n) {
        if (n <= 1) {
            return n;
        }
        int first = 0;
        int second = 1;
        for (int i = 0; i < n -1; i ++) {
            int sum = first + second;
            first = second;
            second = sum;
        }
        return second;
    }

    public int fib3(int n) {
        if (n <= 1) {
            return n;
        }
        int first = 0;
        int second = 1;
        while (n -- > 1) {
            second = first + second;
            first = second - first;
        }
        return second;
    }
}
