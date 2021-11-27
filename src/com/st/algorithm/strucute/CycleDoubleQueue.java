package com.st.algorithm.strucute;

/**
 * @author dushuaitong
 * @description: 双端循环队列
 * @date 2021/11/27
 */
public class CycleDoubleQueue<E> {
    private int front;
    private int size;
    public E[] list;
    private static final int DEFAULT_CAPACITY = 10;

    public CycleDoubleQueue() {
        list = (E[]) new Object[DEFAULT_CAPACITY];
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void enQueueRear(E element) {
        ensureCapacity(size + 1);
        list[getIndex(size)] = element;
        size++;
    }

    public E deQueueRear() {
        int reIndex = getIndex(size - 1);
        E element = list[reIndex];
        list[reIndex] = null;
        size--;
        return element;
    }

    public void enQueueFront(E element) {
        ensureCapacity(size + 1);
        front = getIndex(-1);
        list[front] = element;
        size++;
    }

    public E deQueueFront() {
        E element = list[front];
        list[front] = null;
        front = getIndex(1);
        size--;
        return element;
    }

    public E front() {
        return list[front];
    }

    public E rear() {
        return list[getIndex(size - 1)];
    }

    private int getIndex(int index) {
        index += front;
        if (index < 0) {
            return (index + list.length);
        }
        // index % list.length 取模运算
        return index - (index >= list.length ? list.length : 0);
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

    public void clear() {
        for (int i = 0; i < size; i++) {
            list[getIndex(i)] = null;
        }
        size = 0;
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
