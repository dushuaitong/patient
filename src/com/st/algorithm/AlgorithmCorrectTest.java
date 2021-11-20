package com.st.algorithm;

import com.st.algorithm.common.Base;
import com.st.algorithm.sort.Bubble;

/**
 * @author dushuaitong
 * @description: 正确性测试
 * @date 2021/11/20
 */
public class AlgorithmCorrectTest {
    public static void main(String[] args) {
        Base[] bases = new Base[] { new Bubble() };
        for (Base basis : bases) {
            basis.testCorrect();
        }
    }
}
