package org.example;

public class Main {
    public static void main(String[] args) {

        BinaryTree tree = new BinaryTree();

        tree.insert(6); // V=4 L=null P=null\
        tree.insert(7);
        tree.insert(2); // 4 L: V=2 L=null P=null
        tree.insert(5);
        tree.insert(1);
        tree.insert(14);
        tree.insert(-1);
        tree.insert(6);
        tree.insert(-2);
        tree.insert(7);



        tree.printTree();

    }
}