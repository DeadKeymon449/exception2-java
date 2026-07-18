# exception2-java
Java exception handling exercise completed as part of the Java Programming Course by Nélio Alves.

## About
This project is a Java exercise from the **Java Programming Course** by Nélio Alves.

The application simulates a simple bank account system where users can perform withdrawals while respecting business rules. Invalid operations are handled through custom exceptions.

## Features
- Create a bank account.
- Deposit money.
- Withdraw money.
- Validate the account balance.
- Enforce a withdrawal limit.
- Throw custom exceptions when business rules are violated.

## Class Design

### Account
| Attribute | Type |
|-----------|------|
| number | Integer |
| holder | String |
| balance | Double |
| withdrawLimit | Double |

### Methods
- `deposit(double amount)`
- `withdraw(double amount)`

## Business Rules
- A withdrawal cannot exceed the account balance.
- A withdrawal cannot exceed the account's withdrawal limit.
- Invalid operations throw a `DomainException`.

## Technologies
- Java
- Eclipse IDE

## Author
**Matheus Bittencourt Tavares**
GitHub: github.com/DeadKeymon449
