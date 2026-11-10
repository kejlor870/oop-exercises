# Binary Tree 🌳

---

## 📖 Description

A simple Java program that implements a **Binary Search Tree (BST)**. The project is intended for practising fundamental data structures, recursion, creating node objects, and linking them through references.

The application reads integers from the console, builds a BST from the supplied values, displays its structure as text, and prints the values using inorder traversal.

---

## 📌 Project Overview

The main goal of this project is to practise:

- implementing a Binary Search Tree (BST),
- representing tree nodes as objects,
- linking nodes through references,
- inserting elements recursively,
- traversing a tree recursively,
- reading and validating user input,
- handling invalid input,
- displaying a data structure in the console.

---

## 🚀 Features

- Read multiple integers from a single console line.
- Split input using whitespace characters, such as spaces or tabs.
- Skip elements that cannot be converted to the Java `int` type.
- Build a BST using objects of the `Node` class.
- Insert new values recursively.
- Place values smaller than a node's value in its left subtree.
- Place values greater than or equal to a node's value in its right subtree.
- Display the tree structure in the console using the `├──`, `└──`, and `│` characters.
- Print tree elements using inorder traversal.
- Handle empty input and an empty tree.

---

## 🌳 Binary Search Tree (BST)

The program implements a Binary Search Tree. Each node stores one integer value and references to its left and right children.

The following rule applies to every node:

- values smaller than the node's value are placed in its left subtree,
- values greater than or equal to the node's value are placed in its right subtree.

Duplicate values are therefore allowed and are inserted into the right subtree of a node with the same value.

### Example

Given the following input:

```text
8 3 10 1 6 14 4 7 13
```

The tree has the following structure:

```text
          8
        /   \
       3     10
      / \      \
     1   6      14
        / \    /
       4   7  13
```

---

## ➕ Inserting Elements

Elements are inserted by the `insert(int value)` method in the `BinaryTree` class. This method calls the private recursive method `insertRecursive()`.

The algorithm works as follows:

1. If the current node is empty (`null`), a new `Node` object is created with the supplied value.
2. If the value being inserted is smaller than the current node's value, the algorithm moves to the left child.
3. Otherwise, the algorithm moves to the right child.
4. When the recursive calls finish, the current node is returned to preserve the links in the tree.

Implementation excerpt:

```java
private Node insertRecursive(Node currentNode, int value) {
    if (currentNode == null) return new Node(value);

    if (value < currentNode.value) {
        currentNode.left = insertRecursive(currentNode.left, value);
    } else {
        currentNode.right = insertRecursive(currentNode.right, value);
    }

    return currentNode;
}
```

---

## 🖨️ Displaying the Tree

The project provides two ways to display the contents of the tree.

### 1. Graphical Tree Display

The `printTree()` method checks whether the tree has a root. If the tree is empty, it displays the message `Drzewo jest puste` ("The tree is empty").

Otherwise, it calls the recursive `printTreeRecursive()` method, which prints the nodes using text characters to represent connections between tree levels. The displayed node labels are:

- `Root` – the root of the tree,
- `L` – the left child (from Polish *lewy*),
- `P` – the right child (from Polish *prawy*).

### 2. Inorder Traversal

The `printInOrder()` method calls `printInOrderRecursive()`. The traversal follows this order:

1. left subtree,
2. current node,
3. right subtree.

For a BST, this traversal prints the values in non-decreasing order.

For the example input:

```text
8 3 10 1 6 14 4 7 13
```

the inorder output is:

```text
Wypisanie in-order: 1 3 4 6 7 8 10 13 14
```

The output label is kept in Polish because that is the string used in the supplied Java code.

---

## 🧩 Project Structure

The project consists of three Java classes in the `org.example` package:

```text
BinaryTree/
└── src/
    └── main/
        └── java/
            └── org/
                └── example/
                    ├── Main.java
                    ├── BinaryTree.java
                    └── Node.java
```

### Main Components

| Class | Responsibility |
|---|---|
| `Main` | Starts the program, reads console input, converts valid values to `int`, handles invalid elements, and calls the tree display methods. |
| `BinaryTree` | Stores the root node, implements recursive insertion, and provides methods for displaying the tree structure and performing inorder traversal. |
| `Node` | Represents a single tree node. It stores an `int` value and the `left` and `right` references to its children. |

---

## 🧠 Object-Oriented Programming and Data Structures

### 1. The `Node` Class

The `Node` class represents a single element of the tree. Each object stores:

- `value` – the integer value of the node,
- `left` – a reference to the left child,
- `right` – a reference to the right child.

The constructor accepts the node value and initializes both child references to `null`.

### 2. The `BinaryTree` Class

The `BinaryTree` class manages the entire tree structure. Its `root` field stores a reference to the root node and is declared as `private`.

The class contains methods for:

- inserting elements (`insert`),
- recursive insertion (`insertRecursive`),
- graphical tree display (`printTree` and `printTreeRecursive`),
- inorder traversal (`printInOrder` and `printInOrderRecursive`).

### 3. Recursion

Recursion is used both when inserting elements and when displaying the tree. This allows the algorithms to process successive levels of the structure by calling the same methods for left and right children.

### 4. References in Java

The tree is built from `Node` objects that store references to other objects of the same class. Java does not provide direct pointer arithmetic like C++, but references make it possible to link nodes and build a dynamic tree structure.

---

## ⚙️ Requirements

- Java Development Kit (JDK).
- A Java-compatible development environment, such as IntelliJ IDEA, Eclipse, or Visual Studio Code.
- A console or terminal for running the program.

The project uses only basic features of the Java standard library, including `java.util.Scanner`. It does not require external libraries or frameworks.

---

## ▶️ How to Run

### Option 1: Run in IntelliJ IDEA

1. Open the project in IntelliJ IDEA.
2. Make sure the source files are located in the `org.example` package.
3. Open `Main.java`.
4. Run the `main()` method.
5. Enter integers separated by spaces and press Enter.

### Option 2: Compile and Run from the Terminal

From the project root directory, use the following commands with the directory structure shown in the Project Structure section.

**1. Compile:**

```bash
javac -d out src/main/java/org/example/*.java
```

**2. Run:**

```bash
java -cp out org.example.Main
```

The program prompts the user to enter integers separated by spaces. It then displays the tree structure and the result of inorder traversal.

---

## 💻 Example Usage

Example input:

```text
8 3 10 1 6 14 4 7 13
```

The program builds a BST according to the order of the supplied values. It then displays the tree structure in the console and prints the values using inorder traversal.

Expected inorder output:

```text
Wypisanie in-order: 1 3 4 6 7 8 10 13 14
```

### Handling Invalid Input

Example input:

```text
8 3 abc 10 5 xyz 12
```

The values `abc` and `xyz` cannot be converted to integers. The program displays a message indicating that each invalid element is skipped and continues processing the remaining values.

If the user provides no input, the program reports that the input is empty. The tree display methods then report that the tree is empty.

---

## ⏱️ Algorithm Complexity

Let `n` be the number of nodes in the tree and `h` be its height.

- **Insertion of one element:** `O(h)`, because the algorithm follows one path from the root to the insertion position.
- **Inorder traversal:** `O(n)`, because every node is visited exactly once.
- **Graphical tree display:** `O(n)`, because every node is printed once.
- **Storage for the tree structure:** `O(n)` for `n` `Node` objects.

The tree is not automatically balanced. In the worst case, for example when values are inserted in ascending order, its height can be `n`. A single insertion can then take `O(n)` time, and recursion may require a large number of stack frames.

---

## 🧪 Suggested Tests

The following cases can be used to check the program manually:

| Test | Input | Expected behavior |
|---|---|---|
| Empty input | empty line | A message indicating that no data was entered, followed by a message that the tree is empty. |
| Single element | `5` | The tree contains one node with the value 5. |
| Several elements | `8 3 10 1 6` | Elements are placed according to the BST rules. |
| Negative numbers | `0 -5 7 -10` | Negative values are handled as `int` values. |
| Duplicate values | `5 3 5 5` | Duplicate values are inserted into the right subtree of a node with the same value. |
| Invalid values | `5 abc 3 xyz` | Text elements are skipped, while the remaining numbers are inserted into the tree. |
| Ascending input | `1 2 3 4 5` | The tree becomes one-sided; inorder traversal prints the values in ascending order. |

The supplied code does not include separate JUnit unit tests. The cases above are suggestions for manual testing.

---

## ⚠️ Limitations

- **No tree balancing:** the implementation does not use AVL trees or red-black trees. The shape of the tree depends on the order in which values are inserted.
- **No element deletion:** the program does not provide a method for removing nodes.
- **No value search method:** apart from insertion and traversal, a separate search method has not been implemented.
- **Integer values only:** nodes store values of type `int`.
- **Recursion:** a very deep, unbalanced tree may cause a `StackOverflowError`.
- **No persistent storage:** the tree exists only while the program is running and is not saved to a file or database.
- **Console interface:** input and output are handled in the terminal.

---

## 🎯 Learning Objectives

This project provides practice with:

- creating and managing dynamic data structures,
- implementing a Binary Search Tree,
- creating objects that represent tree nodes,
- using references to establish relationships between objects,
- implementing recursive insertion and tree traversal algorithms,
- validating input and handling exceptions,
- analysing the basic time and space complexity of algorithms.

The project provides a foundation for further study of other tree-based data structures, such as AVL trees, red-black trees, and binary heaps.
