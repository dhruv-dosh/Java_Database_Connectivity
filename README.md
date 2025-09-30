# 🐘 Java Database Connectivity (JDBC) Reference

This repository serves as a focused collection of Java code examples and essential notes covering the fundamentals of Java Database Connectivity (JDBC). It is designed as a quick-reference guide for connecting to a database, executing queries, and managing resources effectively.

## ✨ Core Concepts

JDBC is the Java API that standardizes database-independent connectivity between Java and a wide range of databases (MySQL, Oracle, PostgreSQL, etc.).

| Component | Interface/Class | Role |
| :--- | :--- | :--- |
| **Driver** | `Driver` (Interface) | The vendor-specific software that translates JDBC calls into the database's native protocol. |
| **Connection** | `Connection` (Interface) | Represents a secure session between the Java application and the database. |
| **Statement** | `Statement`, `PreparedStatement` | Objects used to execute SQL queries. |
| **Result** | `ResultSet` (Interface) | Represents the results table returned by a `SELECT` query. |
| **Manager** | `DriverManager` (Class) | Manages the available JDBC drivers and handles connection requests. |

## 🚀 The 5 Steps of JDBC

All JDBC operations fundamentally follow these steps:

| Step | Action | Key Java Code |
| :--- | :--- | :--- |
| **1. Load Driver** | Load the specific JDBC driver class into memory. | `Class.forName("com.mysql.cj.jdbc.Driver");` (Often optional since JDBC 4.0) |
| **2. Establish Connection** | Create a connection to the database using its URL and credentials. | `DriverManager.getConnection(url, user, password);` |
| **3. Create Statement** | Create a container to hold and execute the SQL query. | `conn.createStatement();` or `conn.prepareStatement(sql);` |
| **4. Execute Query** | Run the SQL command. | `stmt.executeQuery(select_query)` (for SELECT) or `stmt.executeUpdate(DML_query)` |
| **5. Close Resources** | Close the open `Connection`, `Statement`, and `ResultSet` objects. | `conn.close();` (Best done using **try-with-resources**) |

## 🔗 Connection Setup Notes

| Detail | Note/Syntax |
| :--- | :--- |
| **JDBC URL Structure** | `jdbc:drivername://hostname:port/databaseName` |
| **Example (MySQL)** | `jdbc:mysql://localhost:3306/my_database` |
| **Dependencies** | The specific **JDBC Driver JAR file** (e.g., MySQL Connector/J) must be included in the project's **classpath**. |
| **Modern Practice**| Always use the **`try-with-resources`** statement to ensure connections and statements are automatically closed, preventing resource leaks. |

## 📝 Statement vs. PreparedStatement

The choice of statement interface impacts performance, reusability, and security.

| Feature | `Statement` | `PreparedStatement` |
| :--- | :--- | :--- |
| **SQL Handling** | Executes static SQL. | **Pre-compiled** SQL with placeholders (`?`). |
| **Parameters** | Does not support parameters; values are concatenated into the SQL string. | Supports dynamic parameters set via `setXxx()` methods. |
| **Security** | **Vulnerable to SQL Injection.** | **Prevents SQL Injection** by separating SQL command from user data. |
| **Performance** | Slower, as the query is compiled every time it runs. | **Faster** for repeated execution, as it is compiled only once. |
| **Use Case** | Single execution of a static SQL query (e.g., `CREATE TABLE`). | All queries involving **user input** or repeated execution (preferred standard). |

## 📂 Repository Contents

This repository contains organized code examples for the following operations:

* Basic steps for establishing a database connection.
* Demonstrates using `Statement` and `ResultSet` to fetch data.
* Example of using `PreparedStatement` for DML operations (`INSERT`, `UPDATE`, `DELETE`).
* Best practice example demonstrating automatic resource closing.

---
**To Use the Code:** Ensure your database (e.g., MySQL) is running and you have included the correct vendor-specific JDBC driver JAR in your project build path.
***
