package com.st.algorithm.test;

import com.st.algorithm.common.printer.BinaryTrees;
import com.st.algorithm.strucute.tree.BinarySearchTree;

import java.util.function.Consumer;

/**
 * @author dushuaitong
 * @description: 二叉树测试类
 * @date 2021/11/27
 */
public class BinaryTreeTest {
    public static void main(String[] args) {
        BinarySearchTree<Integer> tree = new BinarySearchTree<>();
        tree.add(35);
        tree.add(33);
        tree.add(12);
        tree.add(34);
        tree.add(20);
        tree.remove(20);
        BinaryTrees.println(tree);
//        System.out.println(tree.height2());
//        System.out.println(tree.height());
//        System.out.println(tree.isComplete());
//         tree.preorderTravelsal(new Consumer<Integer>() {
//             @Override
//             public void accept(Integer integer) {
//                 System.out.println(integer);
//             }
//         });
        // tree.inorderTravelsal();
        // tree.postorderTravelsal();
        // tree.levelorderTravelsal();
    }
}
