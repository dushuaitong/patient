package com.st.algorithm.strucute.tree;

import java.util.Comparator;

/**
 * @author dushuaitong
 * @description: 二叉搜索树
 * @date 2021/11/27
 */
public class BinarySearchTree<E> extends BinaryTree<E> {
    protected Comparator<E> comparator;

    public BinarySearchTree() {
        this(null);
    }

    public BinarySearchTree(Comparator<E> comparator) {
        this.comparator = comparator;
    }

    public void add(E element) {
        elementNoNullCheck(element);
        if (root == null) {
            // 第一个节点
            root = createNode(element, null);
            size++;
            afterAdd(root);
            return;
        }

        BinaryNode<E> parentNode = root;
        BinaryNode<E> cmpNode = root;
        int cmp = 0;
        while (cmpNode != null) {
            cmp = cmp(element, cmpNode.element);
            parentNode = cmpNode;
            if (cmp > 0) {
                cmpNode = cmpNode.right;
            } else if (cmp < 0) {
                cmpNode = cmpNode.left;
            } else {
                cmpNode.element = element;
                return;
            }
        }
        BinaryNode<E> newNode = createNode(element, parentNode);;
        if (cmp > 0) {
            parentNode.right = newNode;
        } else if (cmp < 0) {
            parentNode.left = newNode;
        }
        afterAdd(newNode);
        size ++;
    }

    public void remove(E element) {
        if (element == null) {
            return;
        }
        remove(node(element));
    }

    public boolean contains(E element) {
        return node(element) != null;
    }

    private void remove(BinaryNode<E> node) {
        if (node == null) {
            return;
        }
        size--;
        if (node.hasTowChileren()) {
            // 后继节点
            BinaryNode<E> sNode = succsor(node);
            node.element = sNode.element;
            // 删除后继节点
            node = sNode;
        }
        BinaryNode<E> replacement = node.left != null ? node.left : node.right;
        if (replacement != null) {
            // 度为一的节点
            replacement.parent = node.parent;
            if (node.parent == null) {
                root = replacement;
            } else if (node == node.parent.left) {
                node.parent.left = replacement;
            } else if (node == node.parent.right) {
                node.parent.right = replacement;
            }
            afterRemove(node);
        } else if (node.parent == null) {
            root = null;
            afterRemove(root);
        } else {
            // 叶子节点非根节点
            if (node == node.parent.left) {
                node.parent.left = null;
            } else {
                node.parent.right = null;
            }
            afterRemove(node);
        }
    }

    private BinaryNode<E> node(E elemment) {
        BinaryNode<E> node = root;
        while (node != null) {
            int cmp = cmp(elemment, node.element);
            if (cmp == 0) {
                return node;
            }
            if (cmp > 0) {
                node = node.right;
            } else if (cmp < 0) {
                node = node.left;
            }
        }
        return null;
    }

    private int cmp(E v1, E v2) {
        if (comparator != null) {
            comparator.compare(v1, v2);
        }
        return ((Comparable) v1).compareTo(v2);
    }
}
