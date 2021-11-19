package com.st.algorithm.common;

import com.st.algorithm.common.util.*;

/**
 * @author dushuaitong
 * @description: base
 * @date 2021/11/19
 */
public abstract class Base {
    private Integer[] integers;

    public void testPerformance() {
        integers = Numbers.randomIntegers(10, 1000000, 100000);
        Times.execute(getDescribtion(), () -> run());
        Assert.assert_t(Arrays.allSort(integers), getDescribtion());
    }

    public void testCorrect() {
        integers = Numbers.randomIntegers(10, 1000000, 100000);
        Times.execute(getDescribtion(), () -> run());

    }

    protected abstract void run();
    protected abstract String getDescribtion();
}
