# kalkulatorMZerowychFunkcjiObiektowo (JavaFX)

## 📌 Description
This is a JavaFX desktop application that calculates the roots of a quadratic function based on user input coefficients **a**, **b**, and **c**.

The application computes:
- discriminant (delta)
- number of real roots
- values of x1 and x2 (if they exist)

It handles all cases:
- two real roots
- one double root
- no real roots

---

## 🧠 Architecture (OOP)

The project is divided into clear classes:

- **HelloApplication**
  - Launches the JavaFX application and loads the FXML interface.

- **KalkulatorController**
  - Handles user input and UI interaction.
  - Processes button click events.
  - Displays results in the interface.

- **WielomianKwadratowy**
  - Contains business logic for quadratic equation calculations.
  - Computes delta and roots.

- **Wynik**
  - Data class storing results (delta, roots, message).

---

## 🖥 Features

- Input fields for coefficients a, b, c
- Calculation of quadratic equation roots
- Display of:
  - discriminant (delta)
  - number of solutions
  - x1 and x2 values (if applicable)
- Input validation (non-numeric input, a = 0 case)
- JavaFX GUI using FXML

---

## 🛠 Technologies

- Java
- JavaFX
- FXML
- Maven
- Object-Oriented Programming

---

## ▶️ How to run

Run the application by executing: `HelloApplication.java`

in IntelliJ IDEA with JavaFX configured.

---

## 🎯 Learning goals

- Separation of logic and UI (MVC-like structure)
- Encapsulation of business logic
- Handling user input in GUI applications
- JavaFX application structure
- Object-oriented design principles
