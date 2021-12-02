package com.st.algorithm.strucute.map;

/**
 * @author dushuaitong
 * @description: 映射
 * @date 2021/12/1
 */
public interface Map<Key, Value> {
    int size();
    void clear();
    Value put(Key key, Value value);
    Value get(Key key);
    Value remove(Key key);
    boolean containskey(Key key);
    boolean containsValue(Value value);
    void traversal(Visitor<Key, Value> visitor);

    public static abstract class Visitor<Key, Value> {
        boolean stop;
        abstract boolean visit(Key key, Value value);
    }
}
