package com.st.algorithm.strucute;

import com.st.algorithm.strucute.common.List;

/**
 * @author dushuaitong
 * @description: 队列
 * @date 2021/11/26
 */
public class Queue<E> {
    private List<E> list;

    public Queue() {
        list = new LinkedList<>();
    }

    public int size() {
        return list.size();
    }

    public boolean isEmpty() {
        return list.isEmpty();
    }

    public void enQueue(E element) {
        list.add(element);
    }

    public E deQueue() {
        return list.remove(0);
    }

    public E front() {
        return list.get(0);
    }

    public void clear() {
        list.clear();
    }
}
