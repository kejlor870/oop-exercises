package org.example;

public class BinaryTree {
    private Node root;

    public BinaryTree(){
        this.root = null;
    }

    private Node insertRecursive(Node currentNode, int value){
        if(currentNode == null) return new Node(value);

        if(value < currentNode.value){
            currentNode.left = insertRecursive(currentNode.left, value);
        } else if (value > currentNode.value) {
            currentNode.right = insertRecursive(currentNode.right, value);
        }

        return currentNode;
    }

    public void insert(int value){
        this.root = insertRecursive(this.root, value);
    }

    public void printTree() {
        if(this.root == null){
            System.out.println("Drzewo jest puste");
            return;
        }

        printTreeRecursive(root, "", true, "Root: ");
    }

    private void printTreeRecursive(Node node, String prefix, boolean isLast, String label) {
        if (node == null) return;

        System.out.println(prefix + (isLast ? "└── " : "├── ") + label + "[ " + node.value + " ]");

        String childPrefix = prefix + (isLast ? "            " : "│           ");
        boolean hasRight = node.right != null;

        if (node.left != null) {
            printTreeRecursive(node.left, childPrefix, !hasRight, "L <" + node.value + ": ");
        }
        if (node.right != null) {
            printTreeRecursive(node.right, childPrefix, true, "P >" + node.value + ": ");
        }
    }



}
