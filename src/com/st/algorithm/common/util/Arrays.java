package com.st.algorithm.common.util;

/**
 * @author dushuaitong
 * @description: 数组工具类
 * @date 2021/11/19
 */
public class Arrays {
    public static Boolean allSort(Integer[] integers) {
        Boolean isAces = false;
        for (int i = 0; i < integers.length - 1; ++i) {
            if (integers[i] < integers[i + 1]) {
                isAces = true;
                continue;
            }
            if (isAces && integers[i] > integers[i + 1]) {
                return false;
            }
            if (!isAces && integers[i] < integers[i + 1]) {
                return false;
            }
        }
        return true;
    }
}
