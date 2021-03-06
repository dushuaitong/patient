package com.st.algorithm.practice;
/**
 * @author dushuaitong
 * @description: 链表练习题
 * @date 2021/11/24
 */
public class LinkPractice {
    private static class Node<E> {
        E element;
        Node<E> next;

        public Node(E element, Node<E> next) {
            this.element = element;
            this.next = next;
        }
    }

    /**
     * 镜像一个链表
     */
    public static Node<Integer> recerseLinkList_01(Node<Integer> node) {
        if (node == null || node.next == null) {
            return node;
        }
        Node<Integer> newHead = recerseLinkList_01(node.next);
        node.next.next = node;
        node.next = null;
        return newHead;
    }

    public static Node<Integer> recerseLinkList_02(Node<Integer> node) {
        if (node == null || node.next == null) {
            return node;
        }
        Node<Integer> newHeader = null;
        while (node != null) {
            Node<Integer> temp = node.next;
            node.next = newHeader;
            newHeader = node;
            node = temp;
        }
        return newHeader;
    }

    /**
     * 证明一个链表有环 快慢指针
     */
    public static Boolean hasCycle(Node<Integer> node) {
        if (node == null || node.next == null) {
            return false;
        }
        Node<Integer> slow = node;
        Node<Integer> fast = node.next;
        while (fast == null || fast.next == null) {
            slow = slow.next;
            fast = fast.next.next;
            if (fast == slow) {
                return true;
            }
        }
        return false;
    }
}
