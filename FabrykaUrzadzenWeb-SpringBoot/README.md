# FabrykaUrzadzenWeb (Spring Boot)

## 📌 Description

This is a web application built with the Spring Boot framework that simulates an electrical device factory and registry (light bulbs, engines, and heaters).

The application allows dynamic creation of device objects through HTTP requests, automatically calculates their power consumption based on current and voltage values, and stores them in a shared registry that can be viewed in JSON format.

---

## 🧠 Architecture (OOP)

The project is divided into logical classes with a clear application of object-oriented programming principles and design patterns.

### Application

Main entry-point class responsible for starting the Spring Boot application.

### BasicController

REST controller (`@RestController`) that manages API endpoints. It handles request parameters, invokes the factory, and returns data in JSON format.

### IndexController

Traditional MVC controller (`@Controller`) responsible for mapping and displaying the home page (`index.html`).

### DevicesFactory

Class implementing the **Factory Design Pattern**. It contains the logic for creating appropriate device objects (`Zarowka`, `Silnik`, `Grzejnik`) based on a provided text parameter.

### DevicesList

A container (registry) class responsible for storing all created devices in the application's memory.

### Urzadzenie

An interface defining a common contract for all electrical devices, including a method for power calculation.

### Zarowka, Silnik, Grzejnik

Concrete classes implementing the `Urzadzenie` interface. Each class contains its own properties (`name`, `current`, `voltage`) and implements the specific power calculation logic. Jackson annotations are used to structure JSON responses.

---

## 🖥 Features

- Dedicated endpoints for each device type (`/zarowka`, `/silnik`, `/grzejnik`).
- Support for request parameters (`@RequestParam`) allowing dynamic configuration of current and voltage values with safe default values.
- Automatic power calculation using the formula:

  **Power = Voltage × Current**

- Device registry available under `/lista`, returning the complete list of devices serialized into JSON with a predefined property order (`@JsonPropertyOrder`).
- Home page mapping available at `/`.

---

## 🛠 Technologies

- Java
- Spring Boot (Spring Web)
- Jackson (JSON serialization annotations)
- Maven

---

## ▶️ How to Run

1. Run the application by executing the `Application.java` class in your IDE (e.g., IntelliJ IDEA).
2. The application starts by default on port `8080`.
3. You can test the application using a web browser, Postman, or cURL with the following example URLs:

### Add a light bulb

```text
http://localhost:8080/zarowka?prad=2.5&napiecie=230
```

### Add an engine (default values)

```text
http://localhost:8080/silnik
```

### View the device registry

```text
http://localhost:8080/lista
```

---

## 🎯 Learning Goals

- Using the **Factory Design Pattern** to isolate object creation logic.
- Applying **polymorphism** through operations on the `Urzadzenie` interface.
- Building web applications and REST APIs with Spring Boot.
- Controlling Java object serialization to JSON using Jackson.
- Working with HTTP request parameters (`@RequestParam`).
