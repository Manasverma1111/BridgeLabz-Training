# Refresher Training

## Day-01: DBMS Basics & SQL Command Categories (MySQL)

### 📚 Topics Covered

- Introduction to DBMS (Database Management System)
- Basic concepts:
    - Database
    - Table
    - Schema
    - Records
    - Fields
- Overview of SQL command categories:
    - **DDL** – Data Definition Language
    - **DML** – Data Manipulation Language
    - **DCL** – Data Control Language
    - **TCL** – Transaction Control Language
- Hands-on practice using MySQL

## DBMS Basics

A **Database Management System (DBMS)** is software used to create, manage, and interact with databases. It allows storing, retrieving, and manipulating data efficiently while maintaining data integrity, security, and consistency.

### Key Concepts Practiced

- Creating a database and selecting it for use
- Understanding tables, rows (records), and columns (fields)
- Data types (`INT`, `VARCHAR`, `DATE`, etc.)
- Constraints (`PRIMARY KEY`, `NOT NULL`, etc.)

# Day-02: Database Design, Normalization & Query Optimization

### 📚 Topics Covered

- Database schema design and extension
- Entity relationships and foreign keys
- One-to-Many and Many-to-Many relationships
- Database normalization (1NF, 2NF, 3NF)
- Creating additional tables
- Indexing in MySQL
  - Single-column indexes
  - Composite indexes
  - Covering indexes
- Query execution plans using `EXPLAIN`
- SQL query optimization

### Key Concepts Practiced

- Extended the **Health Clinic** database schema by adding:
  - `rooms` table
  - `doctor_room` relationship table
- Designed the `patient_phones` table to support multiple phone numbers per patient.
- Verified that the `patient_phones` design satisfies:
  - First Normal Form (1NF)
  - Second Normal Form (2NF)
  - Third Normal Form (3NF)
- Created and tested:
  - Single-column indexes
  - Composite indexes
  - Covering indexes
- Compared query execution plans using `EXPLAIN`.

# Day-03: Stored Procedures, Triggers & Joins

### 📚 Topics Covered

- Stored Procedures
- Types of Stored Procedures
- Triggers
- Types of Joins in MySQL
- Hands-on implementation and execution using MySQL

### Types of Joins

- **INNER JOIN** – Returns only the matching records from both tables.
- **LEFT JOIN (LEFT OUTER JOIN)** – Returns all records from the left table and matching records from the right table.
- **RIGHT JOIN (RIGHT OUTER JOIN)** – Returns all records from the right table and matching records from the left table.
- **FULL OUTER JOIN** – Returns all matching and non-matching records from both tables (not directly supported in MySQL; can be achieved using `UNION`).
- **CROSS JOIN** – Returns the Cartesian product of two tables.
- **SELF JOIN** – Joins a table with itself to compare or relate rows within the same table.

### Types of Stored Procedures

- **Procedure Without Parameters** – Executes predefined SQL statements without accepting any input.
- **Procedure With IN Parameter** – Accepts input values from the caller.
- **Procedure With OUT Parameter** – Returns values back to the caller through output parameters.
- **Procedure With INOUT Parameter** – Accepts input values, modifies them, and returns the updated values.

### Triggers

- **BEFORE INSERT Trigger** – Executes before a new record is inserted.
- **AFTER INSERT Trigger** – Executes after a new record is inserted.
- **BEFORE UPDATE Trigger** – Executes before an existing record is updated.
- **AFTER UPDATE Trigger** – Executes after an existing record is updated.
- **BEFORE DELETE Trigger** – Executes before a record is deleted.
- **AFTER DELETE Trigger** – Executes after a record is deleted.

### Key Concepts Practiced

- Created and executed stored procedures with different parameter types.
- Used stored procedures to encapsulate reusable SQL logic.
- Created triggers for `INSERT`, `UPDATE`, and `DELETE` events.
- Automated database actions using `BEFORE` and `AFTER` triggers.
- Practiced SQL joins to retrieve related data from multiple tables.
- Compared different join types and understood their use cases.

# Day-04: JDBC Core & Database Connectivity

### 📚 Topics Covered

#### JDBC Core
- JDBC Architecture – Structure for Java–database communication.
- JDBC Drivers – Enable communication with specific databases.
- DriverManager – Manages JDBC drivers and connections.
- Connection – Represents a database connection.
- Statement – Executes static SQL queries.
- PreparedStatement – Executes parameterized SQL queries securely.
- CallableStatement – Executes stored procedures.
- ResultSet – Holds query results.

#### JDBC Workflow
- Database Connection
- Driver Loading
- Connection URL
- Properties
- Singleton Connection – Single shared database connection.

#### CRUD Operations
- INSERT – Add records.
- SELECT – Retrieve records.
- UPDATE – Modify records.
- DELETE – Remove records.

#### Security & Transactions
- PreparedStatement vs Statement
- SQL Injection Prevention
- Performance Comparison
- ACID Properties
- Commit
- Rollback
- Savepoints

#### Connection Pooling
- HikariCP – High-performance JDBC connection pool.

#### Best Practices
- Try-with-Resources
- Batch Processing
- Exception Handling
- DTO Pattern – Transfers data between layers.
- DAO Pattern – Encapsulates database operations.

### Key Concepts Practiced

Learned JDBC fundamentals, database connectivity, CRUD operations, transaction management, connection pooling, and best practices for building secure and efficient Java database applications.

# Day-05: Spring MVC Fundamentals

### 📚 Topics Covered

- Spring MVC Architecture
- Tomcat Servlet
- Spring IOC
- Dependency Injection
- Spring vs Spring Boot
- Model
- View
- Controller

### 🚀 Project: My Greetings App

Built a simple Spring Boot MVC application that accepts a user's name and displays a personalized greeting using Thymeleaf.

### 🔹 Key Concepts Practiced

- **Spring MVC Architecture** – Follows the Model-View-Controller pattern to separate application logic.
- **DispatcherServlet** – Front controller that receives requests and routes them to the appropriate controller.
- **Controller (`@Controller`)** – Handles HTTP requests and prepares data for the view.
- **Views (Thymeleaf)** – Dynamic HTML templates used to render responses.
- **`@GetMapping`** – Maps HTTP GET requests to controller methods.
- **`@RequestParam`** – Retrieves query parameters from the request URL.
- **Model** – Passes data from the controller to the view.
- **Request Lifecycle** – Client Request → DispatcherServlet → Controller → Model → View → Response.

### 💻 My Greetings App

- Created a Spring Boot MVC application (`my-greetings-app`).
- Configured the application using `@SpringBootApplication`.
- Implemented a `GreetingController` with:
  - `GET /` – Displays a form (`index.html`) to enter a name.
  - `GET /greeting` – Reads the `name` parameter and displays a personalized greeting (`greeting.html`).
- Used Thymeleaf templates to render dynamic content.
- Gained hands-on experience with the complete Spring MVC request flow.