package com.st.algorithm.strucute.set;

import com.st.algorithm.strucute.LinkedList;
import com.st.algorithm.strucute.common.List;

/**
 * @author dushuaitong
 * @description: 链表实现集合
 * @date 2021/12/1
 */
public class ListSet<E> implements Set<E> {
    private List<E> list = new LinkedList<>();

    @Override
    public int size() {
        return list.size();
    }

    @Override
    public Boolean isEmpty() {
        return list.isEmpty();
    }

    @Override
    public boolean contains(E element) {
        return list.contains(element);
    }

    @Override
    public void add(E element) {
//        if (list.contains(element)) {
//            return;
//        }
        int index = list.indexOf(element);
        if (index != List.ELEMENT_NOTFOUND) {
            list.set(index, element);
        } else {
            list.add(element);
        }
    }

    @Override
    public void remove(E element) {
        list.remove(element);
    }

    @Override
    public void traversal(Visitor<E> visitor) {
        if (visitor == null) {
            return;
        }
        int size = list.size();
        for (int i = 0; i < size; i ++) {
            visitor.visit(list.get(i));
        }
    }

    @Override
    public void clear() {
        list.clear();
    }
}
