# City Vehicle Rental System 🚗

---

## 📖 Description

A console-based vehicle rental application written in Java. This project was created to practice object-oriented programming (OOP), software design principles, and common design patterns.

The application simulates a city vehicle rental service where users can manage vehicles, check availability, rent vehicles, return them, and calculate rental costs.

---

## 📌 Project Overview

The main goal of this project is to practice:

- Encapsulation
- Inheritance
- Polymorphism
- Abstraction
- Interfaces
- Factory Design Pattern
- Java Collections
- Exception handling and input validation
- Project organization and separation of responsibilities

---

## 🚀 Features

- Create vehicles using the Vehicle Factory.
- Support three types of vehicles: bicycles, electric scooters, and cars.
- Display all available vehicles.
- Rent a vehicle using its unique ID.
- Return a previously rented vehicle.
- Calculate rental costs according to the vehicle type.
- Prevent renting a vehicle that is already rented.
- Prevent returning a vehicle that is already available.
- Prevent adding vehicles with duplicate IDs.
- Validate vehicle data during object construction.
- Handle invalid IDs, rental durations, and other invalid operations.

---

## 🚘 Supported Vehicle Types

The application supports three vehicle types:

| Vehicle Type | Hourly Rate | Additional Fee |
|---|---:|---:|
| Bicycle | 10.00 PLN | None |
| Electric Scooter | 15.00 PLN | 4.00 PLN start fee |
| Car | 50.00 PLN | 25.00 PLN reservation fee |

All prices are expressed in PLN (Polish złoty).

### Rental Cost Examples

- Bicycle for 3 hours: 10 × 3 = **30 PLN**
- Electric scooter for 2 hours: 15 × 2 + 4 = **34 PLN**
- Car for 4 hours: 50 × 4 + 25 = **225 PLN**

The rental duration must be a positive number of hours.

---

## 🧠 Object-Oriented Programming Concepts

### 1. Encapsulation

The `Vehicle` class encapsulates its fields using the `private` access modifier.

Vehicle information is accessed through getters, while availability is controlled through dedicated methods:

- `rent()`
- `returnVehicle()`
- `isAvailable()`

This prevents other classes from directly modifying the vehicle's availability.

The constructor also validates the provided vehicle data to prevent objects from being created with invalid values.

### 2. Inheritance

`Vehicle` is an abstract base class shared by all vehicle types.

The following classes inherit from it:

- `Bicycle`
- `ElectricScooter`
- `Car`

Common properties and behavior are defined once in `Vehicle`, reducing code duplication.

### 3. Abstraction

`Vehicle` is an abstract class that defines the common structure of a vehicle without providing a single rental-cost formula for every type.

The abstract method `calculateCost(int hours)` must be implemented by each concrete vehicle class.

### 4. Polymorphism

The application uses references of type `Vehicle` to work with different vehicle objects.

Each subclass provides its own implementation of `calculateCost()`. The correct implementation is selected automatically at runtime.

This allows `RentalService` to calculate rental costs without checking the concrete type of every vehicle.

### 5. Interfaces

The `Rentable` interface defines the operations required for a rentable object:

- `rent()`
- `returnVehicle()`
- `isAvailable()`

The abstract `Vehicle` class implements this interface, providing the behavior inherited by all concrete vehicle types.

### 6. Factory Design Pattern

`VehicleFactory` is responsible for creating the correct vehicle object.

The `createVehicle()` method accepts a `VehicleType` value, an ID, a brand, and a model, and returns the corresponding `Vehicle` object.

This separates object creation from the rest of the application and centralizes the creation logic in one place.

### 7. Enum

The `VehicleType` enum defines the supported vehicle types:

- `BICYCLE`
- `SCOOTER`
- `CAR`

Using an enum instead of arbitrary text values makes vehicle creation more type-safe and easier to maintain.

### 8. Collections and Exception Handling

The `RentalService` class manages vehicles using Java collections, including `List` and `ArrayList`.

The application uses exceptions such as `IllegalArgumentException` and `IllegalStateException` to handle invalid data and operations.

Examples include:

- Duplicate vehicle IDs.
- Attempts to rent an unavailable vehicle.
- Attempts to return a vehicle that is already available.
- Non-existent vehicle IDs.
- Invalid rental durations.
- Invalid vehicle data.

----

## 🏗️ Project Structure

```text
CityVehicleRentalSystem/
├── pom.xml
└── src/
    └── main/
        └── java/
            └── org/
                └── example/
                    ├── Main.java
                    ├── factory/
                    │   ├── VehicleFactory.java
                    │   └── VehicleType.java
                    ├── interfaces/
                    │   └── Rentable.java
                    ├── model/
                    │   ├── Vehicle.java
                    │   ├── Bicycle.java
                    │   ├── ElectricScooter.java
                    │   └── Car.java
                    └── service/
                        └── RentalService.java
```

### Main Components

| Class / Interface | Responsibility |
|---|---|
| `Main` | Runs the application and demonstrates its functionality. |
| `Vehicle` | Abstract base class containing common vehicle properties, validation, and behavior. |
| `Bicycle` | Represents a bicycle and calculates its rental cost. |
| `ElectricScooter` | Represents an electric scooter and includes a start fee. |
| `Car` | Represents a car and includes a reservation fee. |
| `Rentable` | Defines the contract for rentable objects. |
| `VehicleFactory` | Creates vehicle objects based on their type. |
| `VehicleType` | Defines the supported vehicle types. |
| `RentalService` | Manages the vehicle collection, availability, rentals, returns, and ID lookup. |

---

## ⚙️ Requirements

- Java Development Kit (JDK) 17 or newer is recommended.
- An IDE such as IntelliJ IDEA is recommended.
- Maven is used for project configuration.

---

## ▶️ How to Run

1. Clone or download the repository.
2. Open the `CityVehicleRentalSystem` project in IntelliJ IDEA.
3. Make sure the project is configured to use JDK 17 or newer.
4. Open `src/main/java/org/example/Main.java`.
5. Run the `main()` method.

The application demonstrates its functionality by displaying available vehicles, performing rental and return operations, and handling selected error scenarios in the console.

---

## 🧪 Manual Testing Scenarios

The application can be checked using the following scenarios:

- Add vehicles of all three types.
- Display the list of available vehicles.
- Rent a bicycle for 3 hours and verify the cost of 30 PLN.
- Rent an electric scooter for 2 hours and verify the cost of 34 PLN.
- Rent a car for 4 hours and verify the cost of 225 PLN.
- Try to add another vehicle with an existing ID.
- Try to rent a vehicle that is already rented.
- Try to return a vehicle that is already available.
- Try to rent a vehicle using a non-existent ID.
- Try to rent a vehicle for zero or a negative number of hours.
- Try to create a vehicle with invalid data.
- Return a rented vehicle and verify that it becomes available again.

These scenarios can be executed through the application's `Main` class.

Automated unit tests have not been added yet.

---

## 🔮 Possible Future Improvements

- Add an interactive console menu.
- Introduce automated unit tests using JUnit.
- Store vehicle data in a database.
- Add rental history and customer management.
- Improve monetary calculations by using `BigDecimal`.
- Create a graphical user interface using JavaFX.
- Extend the project with a Spring Boot REST API.
- Add data persistence and JSON serialization.

---

## 🎯 Learning Objectives

This project is part of a Java programming exercise repository. It focuses on understanding object-oriented programming, writing maintainable code, applying the Factory Design Pattern, handling invalid data, and separating business logic from application startup code.

The project is intended for educational purposes and can be extended with additional features as new Java concepts are learned.