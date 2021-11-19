package com.st.algorithm.common.util;

/**
 * @author dushuaitong
 * @description: 断言
 * @date 2021/11/19
 */
public class Assert {
    public static void assert_t(Boolean result, String message) {
        if (!result) {
            throw new RuntimeException(message);
        }
    }
}
