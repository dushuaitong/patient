package com.st.algorithm.strucute.common;

/**
 * @author dushuaitong
 * @description: 集合
 * @date 2021/11/23
 */
public interface List<E> {
    static final int ELEMENT_NOTFOUND = -1;
    /**
     * 大小
     */
    int size();

    /**
     * 是否为空
     */
    boolean isEmpty();

    /**
     * 是否包含
     */
    boolean contains(E element);

    /**
     * 在结尾添加
     */
    void add(E element);

    /**
     * 获取index的元素
     */
    E get(int index);

    /**
     * 设置index的元素
     */
    E set(int index, E element);

    /**
     * 在index处插入
     */
    void add(int index, E element);

    /**
     * 删除
     */
    E remove(int index);

    /**
     * 删除元素
     */
    void remove(E element);

    /**
     * 某个元素的位置
     */
    int indexOf(E element);

    /**
     * 清空
     */
    void clear();
}
