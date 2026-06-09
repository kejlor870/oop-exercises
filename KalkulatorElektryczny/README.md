# KalkulatorElektryczny (JavaFX)

## 📌 Description
This is a JavaFX desktop application designed to perform various electrical calculations based on Ohm's Law and electrical power formulas. 

The application computes key electrical parameters such as:
- Voltage (U)
- Current (I)
- Resistance (R)
- Electric Power (P)

It ensures reliable results by validating inputs and handling edge cases, making it a practical tool for basic electrical engineering calculations.

---

## 🧠 Architecture (OOP)

The project is divided into clear classes following Object-Oriented Programming and MVC principles:

- **HelloApplication**
  - Launches the JavaFX application and loads the FXML interface.

- **KalkulatorController**
  - Handles user input, validation, and UI interaction.
  - Processes button click events and dynamically updates the interface based on selected calculation modes.
  - Displays results in the graphical interface.

- **ObliczeniaElektryczne**
  - Contains business logic for electrical engineering equations.
  - Implements Ohm's law and power formulas to compute missing variables based on provided inputs.

- **WynikElektryczny**
  - Data class storing the results of the calculations (calculated value, unit, and status messages).

---

## 🖥 Features

- Interactive UI for selecting known electrical parameters.
- Calculation of Voltage, Current, Resistance, and Power.
- Real-time input validation (prevents division by zero, non-numeric input handling).
- Clear representation of electrical units (V, A, Ω, W).
- JavaFX GUI using FXML layout.

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

- Separation of logic and UI (MVC-like structure).
- Encapsulation of electrical formulas into reusable business logic classes.
- Handling multi-conditional user input in GUI applications.
- JavaFX application structure and event handling.
- Object-oriented design principles.
