package com.st.algorithm.strucute;

import com.st.algorithm.strucute.common.List;

/**
 * @author dushuaitong
 * @description: 栈
 * @date 2021/11/26
 */
public class Stack<E> {
    private List<E> elements;

    public Stack() {
        elements = new ArrayList<>();
    }

    public int size() {
        return elements.size();
    }

    public boolean isEmpty() {
        return elements.isEmpty();
    }

    public void push(E element) {
        elements.add(element);
    }

    public E pop() {
        return elements.remove(size() - 1);
    }

    public E top() {
        return elements.get(size() - 1);
    }

    public void clear() {
        elements.clear();
    }
}
