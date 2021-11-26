package com.st.algorithm.strucute;

import com.st.algorithm.strucute.common.AbstractList;

/**
 * @author dushuaitong
 * @description: 动态数组 + 缩容 扩容 或者缩容 系数时机问题 选择不好容易导致复杂度震荡
 * @date 2021/11/23
 */
public class ArrayListTrim<E> extends AbstractList<E> {
    /**
     * 元素
     */
    private E[] elements;
    /**
     * 默认容量
     */
    private static final int DEFAULT_CAPACITY = 10;

    public ArrayListTrim(int capacity) {
        capacity = Math.max(capacity, DEFAULT_CAPACITY);
        elements = (E[]) new Object[capacity];
    }

    public ArrayListTrim() {
        this(DEFAULT_CAPACITY);
    }

    @Override
    public E get(int index) {
        rangeCheck(index);
        return elements[index];
    }

    @Override
    public E set(int index, E element) {
        rangeCheck(index);
        E old = elements[index];
        elements[index] = element;
        return old;
    }

    @Override
    public void add(int index, E element) {
        rangeCheckForAdd(index);
        ensureCapacity(size + 1);
        for (int i = size; i > index; i --) {
            elements[i] = elements[i - 1];
        }
        elements[index] = element;
        size++;
    }

    @Override
    public E remove(int index) {
        rangeCheck(index);
        E old = elements[index];
        for (int i = index; i < size - 1; i ++) {
            elements[i] = elements[i + 1];
        }
        elements[--size] = null;
        trim();
        return old;
    }

    @Override
    public int indexOf(E element) {
        if (element == null) {
            for (int i = 0; i < size; i ++) {
                if (elements[i] == null) {
                    return i;
                }
            }
        } else {
            for (int i = 0; i < size; i ++) {
                if (element.equals(elements[i])) {
                    return i;
                }
            }
        }
        return ELEMENT_NOTFOUND;
    }

    @Override
    public void clear() {
        for (int i = 0; i < size; i ++) {
            elements[i] = null;
        }
        size = 0;
        if (elements != null && elements.length > DEFAULT_CAPACITY) {
            elements = (E[]) new Object[DEFAULT_CAPACITY];
        }
    }

    private void ensureCapacity(int size) {
        int oldCapacity = elements.length;
        if (oldCapacity > size) {
            return;
        }
        int newCapacity = oldCapacity + (oldCapacity >> 1);
        E[] newElements = (E[]) new Object[newCapacity];
        for (int i = 0; i < size; i ++) {
            newElements[i] = elements[i];
        }
        elements = newElements;
    }

    /**
     * 缩容
     */
    private void trim() {
        int capacity = elements.length;
        if (size >= (capacity << 1) || size <= DEFAULT_CAPACITY) {
            return;
        }
        int newCapacity = (capacity >> 1);
        E[] newElements = (E[]) new Object[newCapacity];
        for (int i = 0; i < size; i ++) {
            newElements[i] = elements[i];
        }
        elements = newElements;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("size=").append(size).append("; [");
        for (int i = 0; i < size; i ++) {
            if (i != 0) {
                sb.append(", ");
            }
            sb.append(elements[i]);
        }
        sb.append("]");
        return sb.toString();
    }
}
