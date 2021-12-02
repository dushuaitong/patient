package com.st.algorithm.strucute.set;

/**
 * @author dushuaitong
 * @description: 集合
 * @date 2021/12/1
 */
public interface Set<E> {
    int size();
    Boolean isEmpty();
    boolean contains(E element);
    void add(E element);
    void remove(E element);
    void traversal(Visitor<E> visitor);
    void clear();

     abstract class Visitor<E> {
        boolean stop;
        protected abstract boolean visit(E element);
    }
}
