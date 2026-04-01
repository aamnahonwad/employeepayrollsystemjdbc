Employee Payroll System (JDBC)
Overview

The Employee Payroll System is a Java-based application developed using JDBC (Java Database Connectivity) to manage employee records, salaries, and payroll processing.

This project is designed for learning and practicing Java, JDBC, and database operations in a real-world business scenario.

Features

Add new employee records
View all employees
Calculate employee salary
Update employee details
Delete employee records
Generate payroll details
Search employee by ID or name
Simple console-based interface

Technologies Used

Java
JDBC (Java Database Connectivity)
MySQL Database
IDE (Eclipse / IntelliJ IDEA / VS Code)
Project Structure
Employee-Payroll-System/
│
├── src/
│   ├── Main.java
│   ├── Employee.java
│   ├── Payroll.java
│   ├── PayrollDAO.java
│   └── DBConnection.java
│
├── lib/
│   └── mysql-connector-j.jar
│
└── README.md
Database Setup
Install MySQL and open MySQL Workbench or terminal.
Create database:
CREATE DATABASE payroll_db;
USE payroll_db;
Create tables:
CREATE TABLE employees (
    id INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(100),
    position VARCHAR(100),
    salary DOUBLE
);
CREATE TABLE payroll (
    id INT PRIMARY KEY AUTO_INCREMENT,
    employee_id INT,
    basic_salary DOUBLE,
    bonus DOUBLE,
    deductions DOUBLE,
    net_salary DOUBLE,
    pay_date DATE,
    FOREIGN KEY (employee_id) REFERENCES employees(id)
);
JDBC Configuration

Update your database credentials inside DBConnection.java:

String url = "jdbc:mysql://localhost:3306/payroll_db";
String user = "root";
String password = "your_password";
How to Run
Clone the repository:
git clone https://github.com/your-username/employee-payroll-system.git
Open the project in your IDE.
Add MySQL Connector JAR file to the project.
Run Main.java.

Sample Operations

Add Employee
View Employees
Calculate Salary
Generate Payroll
Update Employee
Delete Employee
Learning Outcomes
Understanding JDBC connectivity
Performing CRUD operations
Payroll calculation logic
Database relationships and management
