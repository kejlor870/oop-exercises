# Simple Banking System 🏦

---

## 📖 Description

A simple banking system implemented in Java. This project was created to practice Object-Oriented Programming (OOP), software design principles, and common design patterns.

The application simulates basic banking operations, including account creation, deposits, withdrawals, money transfers, interest calculations, and transaction history management.

It supports three different types of bank accounts, each with its own balance restrictions and functionality.

---

## 📌 Project Overview

The main goal of this project is to practice:

- Encapsulation
- Inheritance
- Polymorphism
- Abstraction
- Factory Design Pattern
- Service Layer architecture
- Java Collections
- Enums
- Input validation and exception handling
- Transaction history management
- Unit testing with JUnit 5
- Project organization and separation of responsibilities

---

## 🚀 Features

- Create bank accounts using the Account Factory.
- Support three account types: Basic, Savings, and Premium.
- Generate a unique UUID for every bank account.
- Deposit money into an account.
- Withdraw money while respecting account-specific balance restrictions.
- Transfer money between accounts.
- Apply interest to savings accounts.
- Store transaction history, including transaction types, amounts, and timestamps.
- Retrieve an account by its unique ID.
- Display and retrieve all accounts managed by the banking service.
- Prevent basic and savings accounts from having a negative balance.
- Enforce a predefined overdraft limit for premium accounts.
- Validate account owners, account types, transaction amounts, and interest rates.
- Reject invalid operations without modifying account balances.
- Return an unmodifiable snapshot of account and transaction lists.
- Test account creation, balance restrictions, interest calculations, and transfers using JUnit 5.

---

## 💳 Supported Account Types

The application supports three types of bank accounts:

| Account Type | Negative Balance | Special Feature |
|---|:---:|---|
| `BasicAccount` | ❌ Not allowed | Standard banking operations |
| `SavingsAccount` | ❌ Not allowed | Interest calculation |
| `PremiumAccount` | ✅ Up to -1000.00 | Overdraft facility |

All monetary values are represented using Java `double`. No specific currency is enforced by the application.

### 1. Basic Account 💵

A standard bank account designed for everyday banking operations.

**Features:**

- Supports deposits and withdrawals.
- Supports incoming and outgoing transfers.
- Does not allow a negative balance.
- Rejects withdrawals and transfers that would exceed the available balance.

**Example:**

```java
BankAccount account = new BasicAccount("Jan");

account.deposit(100.00);
account.withdraw(40.00);

System.out.println(account.getBalance()); // 60.0
```

Attempting to withdraw more money than the available balance returns `false` and leaves the balance unchanged.

### 2. Savings Account 📈

A bank account that allows interest to be applied to the current balance.

**Features:**

- Supports deposits, withdrawals, and transfers.
- Does not allow a negative balance.
- Stores an interest rate provided during account creation.
- Provides the `applyInterest()` method.
- Records successfully applied interest in the transaction history.

The interest rate is expressed as a decimal fraction. For example, `0.05` represents 5% interest.

The implementation accepts finite interest rates greater than or equal to `0.01` (1%).

**Example:**

```java
SavingsAccount account = new SavingsAccount("Jan", 0.05);

account.deposit(1000.00);
account.applyInterest();

System.out.println(account.getBalance()); // 1050.0
```

The interest is calculated using the current account balance:

**Interest = Balance × Interest Rate**

### 3. Premium Account 💎

A bank account that allows its owner to spend more money than the current balance, within a predefined overdraft limit.

**Features:**

- Supports deposits, withdrawals, and transfers.
- Allows the balance to fall as low as `-1000.00`.
- Rejects operations that would exceed the overdraft limit.
- Uses the same transaction history mechanism as other account types.

**Example:**

```java
BankAccount account = new PremiumAccount("Ola");

account.deposit(500.00);
account.withdraw(1200.00);

System.out.println(account.getBalance()); // -700.0
```

A withdrawal that would bring the balance below `-1000.00` is rejected.

---

## 💸 Banking Operations

### Deposits

The `deposit(double amount)` method adds money to an account.

- The amount must be positive and finite.
- The resulting balance must be valid for the account type.
- A successful deposit creates a `DEPOSIT` transaction.
- Invalid operations return `false`.

### Withdrawals

The `withdraw(double amount)` method removes money from an account.

- The amount must be positive.
- The resulting balance must satisfy the account's balance restrictions.
- A successful withdrawal creates a `WITHDRAW` transaction.
- An unsuccessful withdrawal does not change the balance or transaction history.

### Money Transfers

The `transferTo(BankAccount target, double amount)` method transfers money between two accounts.

The `BankingService` also provides a `transfer()` method that checks whether both accounts belong to the service before performing the transfer.

**Transfer validation includes:**

- Both accounts must be valid.
- The target account cannot be the source account.
- The transfer amount must be positive and finite.
- Both resulting balances must be valid for their respective account types.

A successful transfer creates two transaction records:

- `TRANSFER_OUT` — recorded by the source account.
- `TRANSFER_IN` — recorded by the target account.

If validation fails, neither balance is modified.

---

## 🧾 Transaction History

Each bank account maintains its own transaction history.

Every successful deposit, withdrawal, transfer, and interest application records a transaction containing:

- **Transaction type** — the type of financial operation.
- **Amount** — the amount involved in the transaction.
- **Timestamp** — the date and time when the transaction was created.

The `TransactionType` enum defines the supported transaction types:

| Transaction Type | Description |
|---|---|
| `DEPOSIT` | Money deposited into an account |
| `WITHDRAW` | Money withdrawn from an account |
| `TRANSFER_OUT` | Money transferred out of an account |
| `TRANSFER_IN` | Money transferred into an account |
| `INTEREST` | Interest added to a savings account |

Transaction history can be retrieved using `getTransactionHistory()`.

**Example:**

```java
BankAccount account = new BasicAccount("Jan");

account.deposit(200.00);
account.withdraw(50.00);

for (Transaction transaction : account.getTransactionHistory()) {
    System.out.println(
        transaction.getType() + " - " +
        transaction.getAmount() + " - " +
        transaction.getTime()
    );
}
```

The method returns an unmodifiable snapshot of the history, preventing callers from directly modifying the account's internal transaction list.

---

## 🧠 Object-Oriented Programming Concepts

### 1. Encapsulation

The `BankAccount` class encapsulates its fields using the `private` access modifier.

Account information is accessed through methods such as:

- `getUniqueID()`
- `getOwner()`
- `getBalance()`
- `getTransactionHistory()`

The account balance cannot be modified directly from outside the class. Instead, changes are made through dedicated operations such as `deposit()`, `withdraw()`, and `transferTo()`.

This helps protect the internal state of each account and ensures that balance restrictions are checked before money is added or removed.

### 2. Inheritance

`BankAccount` is an abstract base class shared by all account types.

The following classes inherit from it:

- `BasicAccount`
- `SavingsAccount`
- `PremiumAccount`

Common properties and operations are implemented once in `BankAccount`, reducing code duplication and allowing the subclasses to share the same basic interface.

### 3. Abstraction

`BankAccount` is an abstract class that defines the common structure and behavior of a bank account.

It declares the abstract method:

```java
protected abstract boolean isBalanceAllowed(double proposedBalance);
```

Each concrete account type implements its own balance validation rules without requiring the base class to know the details of every account type.

### 4. Polymorphism

The application uses references of type `BankAccount` to work with different account implementations.

Each subclass overrides `isBalanceAllowed()` with its own rules.

This allows methods such as `deposit()`, `withdraw()`, and `transferTo()` to validate balances automatically based on the actual account type.

For example, the same withdrawal operation behaves differently for a `BasicAccount` and a `PremiumAccount` because their balance restrictions differ.

### 5. Factory Design Pattern

`AccountFactory` is responsible for creating the appropriate bank account object.

It provides overloaded `createAccount()` methods for standard accounts and savings accounts.

The factory uses the `AccountType` enum to determine which account implementation to create.

This separates object creation from the rest of the application and centralizes account creation logic in one place.

### 6. Enums

The project uses two enums to define supported values.

**`AccountType`:**

- `BASIC`
- `SAVINGS`
- `PREMIUM`

**`TransactionType`:**

- `DEPOSIT`
- `WITHDRAW`
- `TRANSFER_OUT`
- `TRANSFER_IN`
- `INTEREST`

Using enums instead of arbitrary text values makes the code more type-safe and easier to maintain.

### 7. Service Layer

The `BankingService` class separates account management from the account models.

It is responsible for:

- Creating accounts through `AccountFactory`.
- Storing accounts in a collection.
- Returning the list of managed accounts.
- Validating account membership before transfers.
- Finding accounts by their unique IDs.

This keeps account management logic separate from the implementation of individual banking operations.

### 8. Collections and Exception Handling

The application uses Java collections such as `List` and `ArrayList` to store accounts and transaction records.

It also uses validation and exceptions to handle invalid data and operations.

Examples include:

- Invalid or blank account owner names.
- Null or unsupported account types.
- Invalid savings account interest rates.
- Non-positive or non-finite transaction amounts.
- Withdrawals that violate account balance restrictions.
- Transfers involving invalid accounts or amounts.

Most unsuccessful banking operations return `false`, while invalid construction parameters and unsupported account creation requests can result in an `IllegalArgumentException`.

### 9. Unit Testing

The project includes JUnit 5 tests in `AccountTypesTest.java`.

The tests verify account creation, overdraft limits, savings interest, transaction history, account management, and money transfers.

This helps confirm that the core banking rules work as expected.

---

## 🏗️ Project Structure

```text
SimpleBankingSystem/
├── src/
│   ├── main/
│   │   └── java/
│   │      └── org/
│   │          └── example/
│   │              ├── factory/
│   │              │   ├── AccountFactory.java
│   │              │   └── AccountType.java
│   │              ├── model/
│   │              │   ├── BankAccount.java
│   │              │   ├── BasicAccount.java
│   │              │   ├── PremiumAccount.java
│   │              │   ├── SavingsAccount.java
│   │              │   ├── Transaction.java
│   │              │   └── TransactionType.java
│   │              ├── service/
│   │              │   └── BankingService.java
│   │              └── Main.java
│   │   
│   └── test/
│       └── java/
│           └── org/
│               └── example/
│                   ├── AccountTypesTest.java
│                   ├── BankAccountTest.java
│                   └── BankingServiceTest.java
├── .gitignore
├── pom.xml
└── README.md
```

### Main Components

| Class / Enum | Responsibility |
|---|---|
| `Main` | Runs the application and demonstrates basic banking operations. |
| `BankAccount` | Abstract base class containing common account properties, balance management, deposits, withdrawals, transfers, and transaction history. |
| `BasicAccount` | Implements standard account balance restrictions. |
| `SavingsAccount` | Adds an interest rate and interest application functionality. |
| `PremiumAccount` | Implements an overdraft limit of `-1000.00`. |
| `Transaction` | Represents a financial transaction, including its type, amount, and timestamp. |
| `TransactionType` | Defines the supported transaction types. |
| `AccountFactory` | Creates account objects based on the selected account type. |
| `AccountType` | Defines the supported bank account types. |
| `BankingService` | Manages accounts, account lookup, and transfers between managed accounts. |
| `AccountTypesTest` | Contains unit tests for account types and core banking functionality. |

---

## ⚙️ Requirements

- Java Development Kit (JDK) 14 or newer.
- JDK 17 or newer is recommended.
- An IDE such as IntelliJ IDEA, Eclipse, or Visual Studio Code with Java support.
- JUnit 5 to execute the automated unit tests.

The supplied project structure does not include a `pom.xml` or `build.gradle` file. The main application can be compiled using the JDK, while running the tests requires JUnit 5 to be configured in the IDE or another build environment.

---

## ▶️ How to Run

### Option 1: Run in IntelliJ IDEA

1. Clone or download the repository.
2. Open the `SimpleBankingSystem` directory in IntelliJ IDEA.
3. Configure the project to use JDK 17 or newer.
4. Open `src/main/java/org/example/Main.java`.
5. Run the `main()` method.

### Option 2: Compile and Run from the Terminal

**1. Clone the repository:**

```bash
git clone https://github.com/kejlor870/oop-exercises.git
```

**2. Navigate to the project directory:**

```bash
cd oop-exercises/SimpleBankingSystem
```

**3. Compile the application:**

```bash
javac -d out $(find src/main/java -name "*.java")
```

**4. Run the application:**

```bash
java -cp out org.example.Main
```

The example in `Main.java` creates a basic account, deposits money, performs a valid withdrawal, and then attempts an invalid withdrawal and an invalid deposit.

**Expected output:**

```text
Account balance: 153.30
Account balance: 153.30
```

The balance remains unchanged after the rejected operations.

---

## 🧪 Automated Tests

The project contains a JUnit 5 test class named `AccountTypesTest.java`.

The tests cover the following scenarios:

- Creating Basic, Savings, and Premium accounts.
- Preventing negative balances in basic accounts.
- Applying interest to savings accounts.
- Recording interest payments in transaction history.
- Enforcing Premium account overdraft limits.
- Managing and retrieving bank accounts.
- Validating transfers between managed accounts.
- Rejecting a null account type.

The tests can be run using the JUnit 5 test runner in IntelliJ IDEA or another configured Java development environment.

Since no Maven or Gradle configuration was included in the supplied project structure, the test dependencies must be configured separately before running the tests.

---

## 💻 Example Usage

The following example demonstrates creating accounts, depositing money, transferring funds, and applying savings interest.

```java
import org.example.factory.AccountType;
import org.example.model.BankAccount;
import org.example.model.SavingsAccount;
import org.example.service.BankingService;

public class BankingExample {
    public static void main(String[] args) {
        BankingService bankingService = new BankingService();

        BankAccount basicAccount =
                bankingService.createAccount(AccountType.BASIC, "Jan");

        BankAccount premiumAccount =
                bankingService.createAccount(AccountType.PREMIUM, "Ola");

        basicAccount.deposit(500.00);

        bankingService.transfer(basicAccount, premiumAccount, 100.00);

        SavingsAccount savingsAccount = (SavingsAccount)
                bankingService.createAccount(
                        AccountType.SAVINGS, "Jan", 0.05
                );

        savingsAccount.deposit(1000.00);
        savingsAccount.applyInterest();

        System.out.printf("Basic balance: %.2f%n",
                basicAccount.getBalance());

        System.out.printf("Premium balance: %.2f%n",
                premiumAccount.getBalance());

        System.out.printf("Savings balance: %.2f%n",
                savingsAccount.getBalance());
    }
}
```

**Expected output:**

```text
Basic balance: 400.00
Premium balance: 100.00
Savings balance: 1050.00
```

The example shows how `BankingService` manages different account types through the common `BankAccount` abstraction.

---

## ⚠️ Limitations

- **In-memory storage:** Account information is not persisted between application runs.
- **No user interface:** The current application demonstrates functionality through Java code and console output.
- **No database integration:** Accounts and transactions are not stored in a database.
- **No authentication or authorization:** User identity and access permissions are not implemented.
- **Floating-point money representation:** The application uses Java `double` for monetary values, which can introduce precision issues in financial calculations.
- **Basic error reporting:** Most unsuccessful operations return `false` rather than providing detailed failure information.

This project is intended for educational purposes and is not designed for real banking transactions.

---

## 🎯 Learning Objectives

This project is part of a Java programming exercise repository.

Its main purpose is to develop practical skills in:

- Designing class hierarchies using inheritance and abstraction.
- Applying polymorphism to implement different account rules.
- Protecting object state through encapsulation.
- Using the Factory Design Pattern to create objects.
- Separating account logic from service-level responsibilities.
- Managing collections and immutable snapshots.
- Validating financial operations and handling invalid data.
- Writing unit tests with JUnit 5.

The project can be extended as new Java concepts and software design principles are learned.

