package com.st.algorithm.strucute;

import com.st.algorithm.strucute.common.AbstractList;

/**
 * @author dushuaitong
 * @description: 单向链表+虚拟头节点
 * @date 2021/11/24
 */
public class LinkedListHeader<E> extends AbstractList<E> {
    private Node<E> first;

    public LinkedListHeader() {
        first = new Node<>(null, null);
    }

    @Override
    public E get(int index) {
        return node(index).element;
    }

    @Override
    public E set(int index, E element) {
        Node<E> node = node(index);
        E old = node.element;
        node.element = element;
        return old;
    }

    @Override
    public void add(int index, E element) {
        rangeCheckForAdd(index);
        Node<E> prev = index == 0 ? first : node(index - 1);
        prev.next = new Node<>(element, prev.next);
        size++;
    }

    @Override
    public E remove(int index) {
        rangeCheck(index);
        Node<E> prev = index == 0 ? first : node(index - 1);
        Node<E> old= prev.next;
        prev.next = prev.next.next;
        size--;
        return old.element;
    }

    @Override
    public int indexOf(E element) {
        if (element == null) {
            Node<E> node = first.next;
            for (int i = 0; i < size; i ++) {
                if (node.element == null) {
                    return i;
                }
                node = node.next;
            }
        } else {
            Node<E> node = first.next;
            for (int i = 0; i < size; i ++) {
                if (element.equals(node.element)) {
                    return i;
                }
                node = node.next;
            }
        }
        return ELEMENT_NOTFOUND;
    }

    @Override
    public void clear() {
        first = null;
        size = 0;
    }

    /**
     * 获取index 位置的节点
     * @param index
     * @return
     */
    private Node<E> node(int index) {
        rangeCheck(index);
        Node<E> node = first.next;
        for (int i = 0; i < index; i ++) {
            node = node.next;
        }
        return node;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("size=").append(size).append("; [");
        Node<E> node = first.next;
        for (int i = 0; i < size; i ++) {
            if (i != 0) {
                sb.append(", ");
            }
            sb.append(node.element);
            node = node.next;
        }
        sb.append("]");
        return sb.toString();
    }

    private static class Node<E> {
        E element;
        Node<E> next;

        public Node(E element, Node<E> next) {
            this.element = element;
            this.next = next;
        }

        @Override
        protected void finalize() throws Throwable {
            super.finalize();
            System.out.println("释放了");
        }
    }
}
