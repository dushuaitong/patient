package com.st.algorithm.strucute;

/**
 * @author dushuaitong
 * @description: 循环队列
 * @date 2021/11/27
 */
public class CycleQueue<E> {
    private int front;
    private int size;
    private E[] list;
    private static final int DELFULT_CAPACITY = 10;

    public CycleQueue() {
        list = (E[]) new Object[DELFULT_CAPACITY];
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void enQueue(E element) {
        ensureCapacity(size + 1);
        list[getIndex(size)] = element;
        size++;
    }

    public E deQueue() {
        E element = list[front];
        list[front] = null;
        front = getIndex(1);
        size--;
        return element;
    }

    public E front() {
        return list[front];
    }

    public void clear() {
        for (int i = 0; i < size; i++) {
            list[getIndex(i)] = null;
        }
        size = 0;
        front = 0;
    }

    private int getIndex(int index) {
         return (front + index) % list.length;
    }

    private void ensureCapacity(int size) {
        int oldCapacity = list.length;
        if (oldCapacity >= size) {
            return;
        }
        int newCapacity = oldCapacity + (oldCapacity >> 1);
        E[] newElements = (E[]) new Object[newCapacity];
        for (int i = 0; i < size; i++) {
            newElements[i] = list[getIndex(i)];
        }
        list = newElements;
        front = 0;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("size=");
        sb.append(size);
        sb.append("; front=");
        sb.append(front);
        sb.append("; [");
        for (int i = 0; i < list.length; i ++) {
            if (i != 0) {
                sb.append(", ");
            }
            E e = list[i];
            if (e != null) {
                sb.append(e);
            } else {
                sb.append("null");
            }
        }
        sb.append("]");
        return sb.toString();
    }
}
