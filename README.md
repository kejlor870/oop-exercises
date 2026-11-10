# OOP Exercises (Java)

Repository containing Object-Oriented Programming exercises completed as part of university coursework.

Each folder represents a separate project focused on practicing Java OOP concepts, JavaFX applications, web development, and fundamental data structures and algorithms.

---

## 📁 Projects

### 📁 01 - [kalkulatorMZerowychFunkcjiObiektowo](https://github.com/kejlor870/oop-exercises/tree/main/kalkulatorMZerowychFunkcjiObiektowo) (JavaFX)

JavaFX application that calculates roots of a quadratic function based on coefficients `a`, `b`, and `c`.

**Folder:** `kalkulatorMZerowychFunkcjiObiektowo/`

#### Technologies

- Java
- JavaFX
- FXML
- Maven
- OOP principles

---

### 📁 02 - [FabrykaUrzadzenWeb](https://github.com/kejlor870/oop-exercises/tree/main/FabrykaUrzadzenWeb-SpringBoot) (Spring Boot)

A web application built with Spring Boot that simulates an electrical device factory and registry (handling light bulbs, engines, and heaters).

The application uses the **Factory Design Pattern** to handle dynamic object creation via HTTP GET requests, automatically calculates power consumption, and exposes a registry of created devices in JSON format.

**Folder:** `FabrykaUrzadzenWeb/`

#### Technologies

- Java
- Spring Boot (Spring Web)
- Jackson (JSON serialization)
- Maven
- OOP principles
- Factory Design Pattern

---

### 📁 03 - [KalkulatorElektryczny](https://github.com/kejlor870/oop-exercises/tree/main/KalkulatorElektryczny) (JavaFX)

A JavaFX desktop application designed to perform various electrical calculations based on Ohm's Law and electrical power formulas (computing Voltage, Current, Resistance, and Power).

**Folder:** `KalkulatorElektryczny/`

#### Technologies

- Java
- JavaFX
- FXML
- Maven
- OOP principles

---

### 📁 04 - [CityVehicleRentalSystem](https://github.com/kejlor870/oop-exercises/tree/main/CityVehicleRentalSystem) (Java)

A console-based vehicle rental application that simulates a city vehicle rental service for bicycles, electric scooters, and cars.

The application allows users to create vehicles using the **Factory Design Pattern**, display available vehicles, rent and return vehicles, and calculate rental costs based on vehicle type. It also includes vehicle data validation, duplicate ID prevention, and exception handling.

**Folder:** `CityVehicleRentalSystem/`

#### Technologies

- Java
- Maven
- OOP principles
- Encapsulation, Inheritance, and Polymorphism
- Abstract Classes and Interfaces
- Factory Design Pattern
- Enums and Java Collections
- Exception handling and input validation

---

### 📁 05 - [SimpleBankingSystem](https://github.com/kejlor870/oop-exercises/tree/main/SimpleBankingSystem) (Java)

A console-based banking application that simulates basic banking operations, including bank account creation, deposits, withdrawals, money transfers, interest calculations, and transaction history management.

The application supports three types of bank accounts: **Basic**, **Savings**, and **Premium**, each with its own balance restrictions and functionality.

It uses the **Factory Design Pattern** to create bank accounts and a **Service Layer** to manage accounts, retrieve accounts by their unique IDs, and validate transfers between accounts. The application also includes transaction history tracking, input validation, exception handling, and unit tests with JUnit 5.

**Folder:** `SimpleBankingSystem/`

#### Technologies

- Java
- Object-Oriented Programming (OOP)
- Encapsulation, Inheritance, Polymorphism, and Abstraction
- Abstract Classes and Interfaces
- Factory Design Pattern
- Service Layer architecture
- Java Collections (`List`, `ArrayList`)
- Enums
- UUID for unique account identification
- Transaction history management
- Input validation and exception handling
- JUnit 5 unit testing

---

### 📁 06 - [BinaryTree](https://github.com/kejlor870/oop-exercises/tree/main/binaryTree) (Java)

A console-based Java application that implements a **Binary Search Tree (BST)**. The program reads integer values entered by the user, inserts them into the tree, and displays the resulting tree structure in the console.

The tree is built dynamically using objects of the `Node` class. Each node stores an integer value and references to its left and right child nodes. Values smaller than the current node are inserted into the left subtree, while values greater than or equal to the current node are inserted into the right subtree. Insertion is implemented recursively.

The application provides two ways to display the data: a tree-like console representation and an **in-order traversal**, which prints the values in non-decreasing order. Invalid input tokens that cannot be parsed as integers are skipped and reported to the user.

**Folder:** `BinaryTree/`

#### Technologies

- Java
- Object-Oriented Programming (OOP)
- Binary Search Tree (BST)
- Binary tree nodes and object references
- Recursion
- Tree traversal (in-order)
- Console input and output (`Scanner`)
- Input validation and exception handling (`NumberFormatException`)

---

## 🛠 Technologies Used in This Repository

- Java
- JavaFX
- FXML
- Spring Boot
- Jackson
- Maven
- JUnit 5
- Object-Oriented Programming (OOP)
- Encapsulation, Inheritance, Polymorphism, and Abstraction
- Abstract Classes and Interfaces
- Factory Design Pattern
- Service Layer architecture
- Java Collections
- Enums and UUID
- Exception handling and input validation
- Transaction and account management
- Binary Search Trees (BST)
- Recursion and tree traversal
- IntelliJ IDEA
- Git and GitHub

---

## 🎯 Purpose of the Repository

The goal of this repository is to:

- Practice object-oriented programming concepts:
  - Encapsulation
  - Inheritance
  - Polymorphism
  - Abstraction
  - Interfaces
- Build Java desktop applications using JavaFX
- Build Java web applications and REST APIs using Spring Boot
- Implement creational design patterns (Factory Pattern)
- Practice separation of responsibilities using a Service Layer
- Practice Java Collections and enum types
- Implement account, vehicle, and device management systems
- Implement and manipulate fundamental data structures, including binary search trees
- Practice recursive algorithms and tree traversal
- Learn exception handling and input validation
- Practice transaction management and transaction history tracking
- Learn unit testing with JUnit 5
- Learn proper project structure and separation of responsibilities
- Practice data serialization and JSON handling
- Use Git and GitHub in practical software development workflows
