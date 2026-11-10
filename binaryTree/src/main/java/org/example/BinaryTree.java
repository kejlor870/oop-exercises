package org.example;

public class BinaryTree {
    private Node root;

    public BinaryTree(){
        this.root = null;
    }

    // Method to insert new value to its place on up-to-date node
    private Node insertRecursive(Node currentNode, int value){
        if(currentNode == null) return new Node(value);

        if(value < currentNode.value){
            currentNode.left = insertRecursive(currentNode.left, value);
        } else {
            currentNode.right = insertRecursive(currentNode.right, value);
        }

        return currentNode;
    }

    // Method to call inserting new value to node and returning newest node to the root variable
    public void insert(int value){
        this.root = insertRecursive(this.root, value);
    }

    // Method to call printing tree
    public void printTree() {
        if(this.root == null){
            System.out.println("Drzewo jest puste");
            return;
        }

        printTreeRecursive(root, "", true, "Root: ");
    }

    // Recurrent Printing tree with styling
    private void printTreeRecursive(Node node, String prefix, boolean isLast, String label) {
        if (node == null) return;

        System.out.println(prefix + (isLast ? "└── " : "├── ") + label + "[ " + node.value + " ]");

        String childPrefix = prefix + (isLast ? "            " : "│           ");
        boolean hasRight = node.right != null;

        if (node.left != null) {
            printTreeRecursive(node.left, childPrefix, !hasRight, "L (<" + node.value + "): ");
        }
        if (node.right != null) {
            printTreeRecursive(node.right, childPrefix, true, "P (>=" + node.value + "): ");
        }
    }

    // Recurrent Method to print values from nodes in order recurisve - only values
    private void printInOrderRecursive(Node node){
        if(node.left != null) printInOrderRecursive(node.left);
        System.out.print(node.value + " ");
        if(node.right != null) printInOrderRecursive(node.right);
    }

    public void printInOrder(){
        if(root != null){
            System.out.print("Wypisanie in-order: ");
            printInOrderRecursive(this.root);

        } else {
            System.out.println("Drzewo jest puste.");
        }
    }

}
