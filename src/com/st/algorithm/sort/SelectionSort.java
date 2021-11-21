package com.st.algorithm.sort;

import com.st.algorithm.common.Base;

/**
 * @author dushuaitong
 * @description: 选择排序
 * @date 2021/11/21
 */
public class SelectionSort extends Base {

    @Override
    protected void run() {
        selecttionSort();
    }

    public void selecttionSort() {
        for (int i = 0; i < integers.length; i ++) {
            int maxIndex = 0;
            for (int j = 0; j < integers.length - i; j ++) {
                if (integers[j] >= integers[maxIndex]) {
                    maxIndex = j;
                }
            }
            int temp = integers[maxIndex];
            integers[maxIndex] = integers[integers.length - i - 1];
            integers[integers.length - i - 1] = temp;
        }
    }



    @Override
    protected String getDescribtion() {
        return "选择排序";
    }
}
