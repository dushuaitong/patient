package com.st.algorithm.strucute.tree;

/**
 * @author dushuaitong
 * @description: AVL node
 * @date 2021/11/28
 */
public class AVLNode<E> extends BinaryNode<E> {
    public int height = 1;

    public AVLNode(E element,BinaryNode<E> parent) {
        this.element = element;
        this.parent = parent;
    }

    public int balanceFactory() {
        int letftHeight = left == null ? 0 : ((AVLNode<E>) left).height;
        int rightHeight = right == null ? 0 : ((AVLNode<E>) right).height;
        return letftHeight - rightHeight;
    }

    public void updateHeight() {
        int letftHeight = left == null ? 0 : ((AVLNode<E>) left).height;
        int rightHeight = right == null ? 0 : ((AVLNode<E>) right).height;
        height = 1 + Math.max(letftHeight, rightHeight);
    }

    /**
     * 返回左右子树比较高的那个树
     * @return
     */
    public AVLNode<E> tallerChild() {
        int letftHeight = left == null ? 0 : ((AVLNode<E>) left).height;
        int rightHeight = right == null ? 0 : ((AVLNode<E>) right).height;
        if (letftHeight > rightHeight) {
            return (AVLNode<E>) left;
        } else if (rightHeight > letftHeight) {
            return (AVLNode<E>) right;
        } else {
            // 左右子树高度相等  返回父树的方向
            if (isLeftChild()) {
                return (AVLNode<E>) left;
            } else {
                return (AVLNode<E>) right;
            }
        }
    }
}
