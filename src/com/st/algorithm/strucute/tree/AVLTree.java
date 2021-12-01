package com.st.algorithm.strucute.tree;

import java.util.Comparator;

/**
 * @author dushuaitong
 * @description: AVL 树
 * @date 2021/11/28
 */
public class AVLTree<E> extends BinarySearchTree<E> {
    public AVLTree() {
        this(null);
    }

    public AVLTree(Comparator<E> comparator) {
        this.comparator = comparator;
    }

    @Override
    protected void afterAdd(BinaryNode<E> node) {
        while ((node = node.parent) != null) {
            if (isBanlance(node)) {
                updateHeight(node);
            } else {
                rebalance(node);
                break;
            }
        }
    }

    @Override
    protected void afterRemove(BinaryNode<E> node) {
        while ((node = node.parent) != null) {
            if (isBanlance(node)) {
                updateHeight(node);
            } else {
                rebalance(node);
            }
        }
    }

    @Override
    protected BinaryNode<E> createNode(E element, BinaryNode<E> parent) {
        return new AVLNode<>(element, parent);
    }

    private boolean isBanlance(BinaryNode<E> node) {
        AVLNode<E> avlNode = (AVLNode<E>) node;
        return Math.abs(avlNode.balanceFactory()) <= 1;
    }

    private void updateHeight(BinaryNode<E> node) {
        AVLNode<E> avlNode = (AVLNode<E>) node;
        avlNode.updateHeight();
    }

    private void rebalance(BinaryNode<E> gNode) {
        AVLNode<E> avlNode = (AVLNode<E>)gNode;
        // 取到左右子节点 比较高的那个节点
        AVLNode<E> parent = avlNode.tallerChild();
        AVLNode<E> node = parent.tallerChild();
        if (parent.isLeftChild()) {
            // L
            if (node.isLeftChild()) {
                // LL
                roteRigth((AVLNode<E>)gNode);
            } else {
                // LR
                roteLeft(parent);
                roteRigth((AVLNode<E>)gNode);
            }
        } else {
            if (node.isLeftChild()) {
                // RL
                roteRigth(parent);
                roteLeft((AVLNode<E>)gNode);
            } else {
                // RR
                roteLeft((AVLNode<E>)gNode);
            }
        }
    }

    /**
     * 左旋
     */
    private void roteLeft(AVLNode<E> node) {
        AVLNode<E> parent = (AVLNode<E>) node.right;
        // 左旋
        node.right = parent.left;
        parent.left = node;
        AVLNode<E> child = (AVLNode<E>) parent.left;
        afterRoute(node, parent, child);
    }

    /**
     * 右旋
     */
    private void roteRigth(AVLNode<E> node) {
        AVLNode<E> parent = (AVLNode<E>) node.left;
        // 右旋
        node.left = parent.right;
        parent.right = node;
        AVLNode<E> child = (AVLNode<E>) parent.right;
        afterRoute(node, parent, child);
    }

    private void afterRoute(AVLNode<E> node, AVLNode<E> parent, AVLNode<E> child) {
        parent.parent = node.parent;
        if (node.isLeftChild()) {
            node.left.parent = parent;
        } else if (node.isRightChild()) {
            node.parent.right = parent;
        } else { // 根节点
            root = parent;
        }
        if (child != null) {
            child.parent = node;
        }
        node.parent = parent;
        // 更新高度
        updateHeight(node);
        updateHeight(parent);
    }
}
