package com.st.algorithm.strucute.tree;

/**
 * @author dushuaitong
 * @description: 二叉树节点
 * @date 2021/11/28
 */
public class BinaryNode<E> {
    public E element;
    public BinaryNode<E> left ;
    public BinaryNode<E> right;
    public BinaryNode<E> parent;

    public BinaryNode(E element,BinaryNode<E> parent) {
        this.element = element;
        this.parent = parent;
    }

    public boolean isLeaf() {
        return left == null && right == null;
    }

    public boolean hasTowChileren() {
        return left != null && right != null;
    }
}
