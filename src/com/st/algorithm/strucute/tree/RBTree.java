package com.st.algorithm.strucute.tree;

import java.util.Comparator;

/**
 * @author dushuaitong
 * @description: 红黑树
 * @date 2021/12/1
 */
public class RBTree<E> extends BinarySearchTree<E> {
    public RBTree() {
        this(null);
    }

    public RBTree(Comparator<E> comparator) {
        this.comparator = comparator;
    }
}
