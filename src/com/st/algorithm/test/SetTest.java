package com.st.algorithm.test;

import com.st.algorithm.strucute.set.ListSet;
import com.st.algorithm.strucute.set.Set;

/**
 * @author dushuaitong
 * @description: 结合测试
 * @date 2021/12/1
 */
public class SetTest {
    public static void main(String[] args) {
        ListSet<Integer> set = new ListSet<>();
        set.add(11);
        set.add(11);
        set.add(11);
        set.add(12);
        set.add(13);

        set.traversal(new Set.Visitor<Integer>() {
            @Override
            protected boolean visit(Integer element) {
                System.out.println(element);
                return false;
            }
        });
    }
}
