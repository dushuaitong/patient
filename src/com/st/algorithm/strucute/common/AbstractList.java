package com.st.algorithm.strucute.common;

/**
 * @author dushuaitong
 * @description: 抽象父类
 * @date 2021/11/24
 */
public abstract class AbstractList<E> implements List<E> {
    /**
     * 大小
     */
    protected int size;

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public boolean contains(E element) {
        return indexOf(element) != ELEMENT_NOTFOUND;
    }

    @Override
    public void add(E element) {
        add(size, element);
    }

    @Override
    public void remove(E element) {
        remove(indexOf(element));
    }

    protected void rangeCheck(int index) {
        if (index < 0 || index >= size) {
            outOfBounds(index);
        }
    }

    protected void rangeCheckForAdd(int index) {
        if (index < 0 || index > size) {
            outOfBounds(index);
        }
    }

    protected void outOfBounds(int index) {
        throw new IndexOutOfBoundsException("Index: " + index + "Size: " + size);
    }

}
