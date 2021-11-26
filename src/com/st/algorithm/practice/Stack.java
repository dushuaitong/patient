package com.st.algorithm.practice;

/**
 * @author dushuaitong
 * @description: 栈
 * @date 2021/11/26
 */
public class Stack {
    /**
     * 是否是合法的字符 [()]
     * @param s
     * @return
     */
    public boolean isValid(String  s) {
        while (s.contains("{}")
                || s.contains("[]")
                || s.contains("()")) {
            s = s.replace("{}", "");
            s = s.replace("[]", "");
            s = s.replace("()", "");
        }
        return s.isEmpty();
    }

    /**
     * 是否是合法的字符 [()]
     * @param s
     * @return
     */
    public boolean isValid2(String  s) {
        com.st.algorithm.strucute.Stack<Character> cStack = new com.st.algorithm.strucute.Stack<>();
        for (int i = 0; i < s.length(); i ++) {
            char c = s.charAt(i);
            if (c == '[' || c == '(' || c == '{') {
                cStack.push(c);
            } else {
                if (cStack.isEmpty()) {
                    return false;
                }
                char left = cStack.pop();
                if (left == '[' && c != ']') { return false; }
                if (left == '{' && c != '}') { return false; }
                if (left == '(' && c != ')') { return false; }
            }
        }
        return cStack.isEmpty();
    }
}
