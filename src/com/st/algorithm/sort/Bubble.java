package com.st.algorithm.sort;

import com.st.algorithm.common.Base;

/**
 * @author dushuaitong
 * @description: 冒泡排序
 * @date 2021/11/19
 */
public class Bubble extends Base {

    public void bubbleSortVersion_1() {
        for (int j = 0; j < integers.length; j++) {
            for (int i = 0; i < integers.length-j-1; ++i) {
                if (integers[i] > integers[i + 1]) {
                    Integer temp = integers[i + 1];
                    integers[i + 1] = integers[i];
                    integers[i] = temp;
                }
            }
        }
    }

    public void bubbleSortVersion_1_1() {
        for (int end = integers.length-1; end > 0; --end) {
            for (int begin = 1; begin <= end; begin++) {
                if (integers[begin] <= integers[begin - 1]) {
                    Integer temp = integers[begin - 1];
                    integers[begin - 1] = integers[begin];
                    integers[begin] = temp;
                }
            }
        }
    }

    public void bubbleSortVersion_2() {
        for (int i = 0; i < integers.length; i ++) {
            Boolean isSort = true;
            for (int j = 0; j < integers.length-i-1 ; j ++) {
                if (integers[j] > integers[j + 1]) {
                    Integer temp = integers[j + 1];
                    integers[j + 1] = integers[j];
                    integers[j] = temp;
                    isSort = false;
                }
            }
            if (isSort) {
                break;
            }
        }
    }

    public void bubbleSortVersion_3() {
        int sortIndex = 1;
        int times = -1;
        for (int i = 0; i < sortIndex; i ++) {
            times++;
            for (int j = 0; j < integers.length-times-1 ; j ++) {
                if (integers[j] > integers[j + 1]) {
                    Integer temp = integers[j + 1];
                    integers[j + 1] = integers[j];
                    integers[j] = temp;
                    sortIndex = j;
                    i = sortIndex - 2;
                }
            }
        }
    }

    @Override
    protected void run() {
        bubbleSortVersion_3();
        // bubbleSortVersion_2();
        // bubbleSortVersion_1_1();
        // bubbleSortVersion_1();
    }

    @Override
    protected String getDescribtion() {
        return "冒泡排序";
    }
}
