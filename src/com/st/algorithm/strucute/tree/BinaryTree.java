package com.st.algorithm.strucute.tree;

import com.st.algorithm.common.printer.BinaryTreeInfo;

import java.util.LinkedList;
import java.util.Queue;
import java.util.function.Consumer;

/**
 * @author dushuaitong
 * @description: 二叉树
 * @date 2021/11/28
 */
public class BinaryTree<E> implements BinaryTreeInfo {
    protected int size = 0;
    protected BinaryNode<E> root;

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void clear() {
        root = null;
        size = 0;
    }

    public void  preorderTravelsal(Consumer<E> consumer) {
        if (consumer == null) {
            return;
        }
        preorderTravelsal(root, consumer);
    }

    private void preorderTravelsal(BinaryNode<E> node, Consumer<E> consumer) {
        if (node == null) {
            return;
        }
        consumer.accept(node.element);
        preorderTravelsal(node.left, consumer);
        preorderTravelsal(node.right, consumer);
    }

    public void  inorderTravelsal(Consumer<E> consumer) {
        if (consumer == null) {
            return;
        }
        inorderTravelsal(root, consumer);
    }

    private void inorderTravelsal(BinaryNode<E> node, Consumer<E> consumer) {
        if (node == null) {
            return;
        }
        inorderTravelsal(node.left, consumer);
        consumer.accept(node.element);
        inorderTravelsal(node.right, consumer);
    }

    public void  postorderTravelsal(Consumer<E> consumer) {
        if (consumer == null) {
            return;
        }
        postorderTravelsal(root, consumer);
    }

    public void levelorderTravelsal(Consumer<E> consumer) {
        if (root == null) {
            return;
        }
        Queue<BinaryNode<E>> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            BinaryNode<E> node = queue.poll();
            consumer.accept(node.element);
            if (node.left != null) {
                queue.offer(node.left);
            }
            if (node.right != null) {
                queue.offer(node.right);
            }
        }
    }

    /**
     * 前驱节点
     * @param node
     * @return
     */
    public BinaryNode<E> predecessor(BinaryNode<E> node) {
        if (node == null) return null;
        BinaryNode<E> p = node.left;
        if (p != null) {
            while (p.right != null) {
                p = p.right;
            }
            return p;
        }
        while (p.parent != null && node == node.parent.left) {
            node = node.parent;
        }
        return node.parent;
    }

    /**
     * 后继节点
     * @param node
     * @return
     */
    public BinaryNode<E> succsor(BinaryNode<E> node) {
        if (node == null) return null;
        BinaryNode<E> p = node.right;
        if (p != null) {
            while (p.left != null) {
                p = p.left;
            }
            return p;
        }
        while (p.parent != null && node == node.parent.right) {
            node = node.parent;
        }
        return node.parent;
    }


    private void postorderTravelsal(BinaryNode<E> node, Consumer<E> consumer) {
        if (node == null) {
            return;
        }
        postorderTravelsal(node.left, consumer);
        postorderTravelsal(node.right, consumer);
        consumer.accept(node.element);
        System.out.println(node.element);
    }

    public static <E> void invertTree(BinaryNode<E> node) {
        if (node == null) return;
        BinaryNode<E> temp = node.left;
        node.left = node.right;
        node.right = temp;
        invertTree(node.left);
        invertTree(node.right);
    }

    public static <E> void invertTree2(BinaryNode<E> node) {
        if (node == null) return;
        invertTree(node.left);
        BinaryNode<E> temp = node.left;
        node.left = node.right;
        node.right = temp;
        invertTree(node.left);
    }

    public void invertTree3() {
        if (root == null) {
            return;
        }
        Queue<BinaryNode<E>> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            BinaryNode<E> node = queue.poll();
            BinaryNode<E> temp = node.left;
            node.left = node.right;
            node.right = temp;
            if (node.left != null) {
                queue.offer(node.left);
            }
            if (node.right != null) {
                queue.offer(node.right);
            }
        }
    }

    // 是不是一颗完全二叉树
    public boolean isComplete() {
        if (root == null) {
            return false;
        }
        Queue<BinaryNode<E>> queue = new LinkedList<>();
        queue.offer(root);
        Boolean isLefe = false;
        while (!queue.isEmpty()) {
            BinaryNode<E> node = queue.poll();
            if (isLefe && !node.isLeaf()) {
                return false;
            }
            if (node.left != null && node.right != null) {
                queue.offer(node.left);
                queue.offer(node.right);
            } else if (node.left == null && node.right != null) {
                return false;
            } else {
                if (node.left != null) {
                    queue.offer(node.left);
                }
                isLefe = true;
            }
        }
        return true;
    }

    public int height() {
        return height(root);
    }

    public int height(BinaryNode<E> node) {
        if (node == null) {
            return 0;
        }
        return 1 + Math.max(height(node.left), height(node.right));
    }

    public int height2() {
        if (root == null) {
            return 0;
        }
        int height = 0;
        int levelSize = 1;
        Queue<BinaryNode<E>> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            BinaryNode<E> node = queue.poll();

            if (node.left != null) {
                queue.offer(node.left);
            }
            if (node.right != null) {
                queue.offer(node.right);
            }
            levelSize--;
            if (levelSize == 0) {
                levelSize = queue.size();
                height++;
            }
        }
        return height;
    }

    protected void elementNoNullCheck(E element) {
        if (element == null) {
            throw new IllegalArgumentException("【element】参数不能为空");
        }
    }

    protected void afterAdd(BinaryNode<E> node) {}
    protected void afterRemove(BinaryNode<E> node) {}

    protected BinaryNode<E> createNode(E element,BinaryNode<E> parent) {
        return new BinaryNode(element, parent);
    }

    @Override
    public Object root() {
        return root;
    }

    @Override
    public Object left(Object node) {
        return ((BinaryNode<E>) node).left;
    }

    @Override
    public Object right(Object node) {
        return ((BinaryNode<E>) node).right;
    }

    @Override
    public Object string(Object node) {
        return ((BinaryNode<E>) node).element;
    }
}
