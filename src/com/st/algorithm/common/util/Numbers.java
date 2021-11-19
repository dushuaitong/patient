package com.st.algorithm.common.util;

import java.util.Random;

/**
 * @author dushuaitong
 * @description: 随机数生成以
 * @date 2021/11/19
 */
public class Numbers {

    public static Integer[] randomIntegers(Integer min, Integer max, Integer count) {
        Random random = new Random();
        Integer[] integers = new Integer[count];
        for (int i = 0; i < count; i ++) {
           int number = random.nextInt(max)%(max-min+1) + min;
           integers[i] = number;
        }
        return integers;
    }
}
