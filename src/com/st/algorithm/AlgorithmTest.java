package com.st.algorithm;

import com.st.algorithm.common.Base;
import com.st.algorithm.sort.Bubble;
import com.st.algorithm.sort.SelectionSort;

/**
 * @author dushuaitong
 * @description: 算法测试类
 * @date 2021/11/19
 */
public class AlgorithmTest {
    public static void main(String[] args) {
        Base[] bases = new Base[] { /*new Bubble(),*/ new SelectionSort() };
        for (Base basis : bases) {
            basis.testPerformance();
        }
    }
}
