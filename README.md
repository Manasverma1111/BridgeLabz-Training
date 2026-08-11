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

### Key Concepts Practiced

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
- Gained hands-on experience with the complete Spring MVC request flow

## Day-06: Spring MVC CRUD Operations

### 📚 Topics Covered

- Spring MVC Architecture
  - DispatcherServlet
  - Controllers
  - Views
- Request Mapping and Handling in Spring MVC
- CRUD Operations in Spring MVC
  - Create
  - Read
  - Update
  - Delete
- Form Handling using Spring MVC
- Request Parameters and Path Variables
- Model and View Data Handling
- Thymeleaf Templates
- Database Integration with Spring MVC

### 🚀 Project: My Greetings App – Complete CRUD

Enhanced the **My Greetings App** to support complete **CRUD (Create, Read, Update, Delete)** functionality for managing greetings.

### Key Concepts Practiced

- **DispatcherServlet** – Front controller that receives incoming requests and routes them to the appropriate controller.
- **Controllers** – Handle HTTP requests and coordinate application logic.
- **Views (Thymeleaf)** – Render dynamic HTML pages and display application data.
- **Request Mapping** – Maps HTTP requests to specific controller methods.
- **`@GetMapping`** – Handles HTTP GET requests.
- **`@PostMapping`** – Handles HTTP POST requests.
- **`@PathVariable`** – Extracts values from the URL path.
- **`@RequestParam`** – Retrieves parameters from the request.
- **Model** – Transfers data from the controller to the view.
- **CRUD** – Implemented Create, Read, Update, and Delete operations.

### 💻 My Greetings App

Completed the **My Greetings App** with all four CRUD operations:

- **Create** – Add a new greeting.
- **Read** – Display all saved greetings.
- **Update** – Edit and update an existing greeting.
- **Delete** – Remove a greeting from the application.

### 🔄 Request Flow

**Client Request → DispatcherServlet → Controller → Service/Repository → Database → Controller → Model → Thymeleaf View → Response**

### Key Concepts Practiced

- Completed the **My Greetings App** using Spring MVC.
- Implemented all four CRUD operations.
- Created request mappings for different application actions.
- Used Thymeleaf forms for creating and updating greetings.
- Used `@PathVariable` and `@RequestParam` for handling request data.
- Connected the Spring MVC application with the database for persistent data management.

# Day-07: Spring Boot REST API with JPA & H2

### 📚 Topics Covered

- Spring Boot REST API
- RESTful CRUD Operations
- Spring Data JPA & Hibernate
- Entity, Repository, Service & Controller layers
- DTO Pattern
- Bean Validation
- Custom & Global Exception Handling
- H2 In-Memory Database
- H2 Database Console
- Database Indexing & Unique Constraints
- Spring Boot Actuator
- HikariCP Connection Pool

### 🚀 Project: Contacts Management REST API

Built a **Contacts Management REST API** using Spring Boot, Spring Data JPA, Hibernate, and H2 Database.

### Key Concepts Practiced

- Implemented complete **CREATE and READ operations** using `GET`, `POST`.
- Followed layered architecture: **Controller → Service → Repository → Database**.
- Used **DTOs** for request and response data.
- Applied **Bean Validation** for input validation.
- Implemented **custom exceptions** and centralized exception handling.
- Configured **H2 Database** with H2 Console for database management.
- Added **indexes and unique constraints** for better performance and data integrity.
- Integrated **Spring Boot Actuator** for application monitoring.
- Implemented **Global Exception Handling**.

### Project Structure
```
contacts_app/
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   ├── org/
│   │   │       ├── example/
│   │   │           ├── contacts_app/
│   │   │               ├── controller/
│   │   │               │   └── ContactController.java
│   │   │               ├── dto/
│   │   │               │   ├── ContactRequestDTO.java
│   │   │               │   └── ContactResponseDTO.java
│   │   │               ├── entity/
│   │   │               │   └── Contact.java
│   │   │               ├── exception/
│   │   │               │   ├── ContactAlreadyExistsException.java
│   │   │               │   ├── ContactNotFoundException.java
│   │   │               │   ├── ErrorResponse.java
│   │   │               │   └── GlobalExceptionHandler.java
│   │   │               ├── repository/
│   │   │               │   └── ContactRepository.java
│   │   │               ├── service/
│   │   │               │   ├── ContactService.java
│   │   │               │   └── ContactServiceImpl.java
│   │   │               └── ContactsAppApplication.java
│   │   ├── resources/
│   │       ├── static/
│   │       ├── templates/
│   │       └── application.properties
│   ├── test/
│       ├── java/
│           ├── org/
│               ├── example/
│                   ├── contacts_app/
│                       └── ContactsAppApplicationTests.java
├── mvnw
├── mvnw.cmd
└── pom.xml
```

# Day-08: Spring Boot Contacts App – Complete CRUD

### 📚 Topics Covered

- Built a Contacts REST API using Spring Boot
- H2 Database integration with JPA/Hibernate
- DTO, Service, Repository and Controller layers
- Lombok and Builder Pattern
- Bean Validation and Exception Handling
- H2 Console and Actuator integration
- Tested REST APIs using Postman

### 🔄 CRUD Operations

- **Create** – Add a new contact with name, phone number and email.
- **Read** – Fetch all contacts or fetch a specific contact by ID.
- **Update** – Modify the details of an existing contact using its ID.
- **Delete** – Remove an existing contact using its ID.

# Spring Boot College Management App - Complete CRUD

### 📚 Topics Covered

- Created a Spring Boot REST API for **Student** and **Faculty** management.
- Implemented complete **CRUD operations**:
  - Create
  - Read
  - Update
  - Delete
- Connected Spring Boot with **MySQL** using Spring Data JPA.
- Created Entity, Repository, Service, and Controller layers.
- Implemented custom JPA queries for:
  - Maximum salary from each department.
  - Faculty earning more than their department's average salary.
- Tested REST APIs using Postman.