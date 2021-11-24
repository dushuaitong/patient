package com.st.algorithm.test;

/**
 * @author dushuaitong
 * @description: 测试代码
 * @date 2021/11/23
 */
public class Person {

    @Override
    protected void finalize() throws Throwable {
        super.finalize();
        System.out.println("Person >>> finalize");
    }

    @Override
    public boolean equals(Object obj) {
        // 强制类型转换
        return super.equals(obj);
    }
}
