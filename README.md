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

- H2 Database integration with JPA/Hibernate
- DTO, Service, Repository and Controller layers
- Lombok and Builder Pattern
- Bean Validation and Exception Handling
- H2 Console and Actuator integration

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
- Tested REST APIs using Postman.

# Day-09: Spring Boot Contacts App – Complete CRUD, Custom Query

## 📚 Topics Covered

- Auto Configuration
- Starter Dependencies
  - spring-boot-starter-web
  - spring-boot-starter-data-jpa
  - spring-boot-starter-security
  - spring-boot-starter-validation
  - spring-boot-starter-actuator
  - spring-boot-starter-test
- Embedded Servers (tomcat, jetty, netty)
- Spring Controller

## Project

- Built a Contacts REST API using Spring Boot
- H2 Database integration with JPA/Hibernate
- DTO, Service, Repository and Controller layers
- Lombok and Builder Pattern
- Bean Validation and Exception Handling
- H2 Console and Actuator integration
- Tested REST APIs using Postman
- Implemented custom JPA queries for:
  - Maximum salary from each department.
  - Faculty earning more than their department's average salary.

# Day-10: Spring Boot Employee Payroll App

## 📚 Topics Covered

- Dependency Injection
- Spring Boot key Features
- H2 Database Integration and Configuration
- Circular Dependency

# Day-11: Spring Boot Employee Payroll App

- Spring JPA Configuration
- Spring JDBC Configuration
- Created Create & Read REST end points
- Create Employee by POST Request
- Get All Employee Details by GET Request
- Get Employee by Id

## 📚 Topics Covered

- Spring REST API — service-layer design
- Spring JPA — repositories and entity mapping
- Spring JDBC — template-based data access
- Comparison of hand-written JDBC, JdbcTemplate, and Spring Data JPA
- Rebuilding the Employee Payroll App using Spring Data JPA

# Day-12: Spring Boot Employee Payroll App - Complete CRUD Operations

- Complete CRUD Operations end-to-end
- Global Exception Handling
- dto layer with request and response
- REST end points testing with Postman

## 📚 Topics Covered

- Spring Bean Scopes — singleton, prototype, request, session
- Logging in Spring Boot applications
- Maven — dependency resolution and build lifecycle
- Postman — collections, environments, variables, chaining and assertions

# Day-13: Spring Boot Fundoo Notes App

## Spring Security & JWT Authentication

- `SecurityConfig`, `JwtUtil`, `User` entity/repository, `UserService`
  (register/login with `BCryptPasswordEncoder`), `AuthController` — matches
  the original Day 13 document.
- **Added (missing from the source material):**
  - `JwtAuthenticationFilter` — the document defines `JwtUtil` and a
    `SecurityFilterChain` requiring authentication, but never wires the two
    together. Without this filter, every protected request would 401 even
    with a valid token.
  - Password recovery (`PasswordResetToken`, `PasswordResetService`,
    `/auth/forgot-password`, `/auth/reset-password`) — the document
    describes this pattern in prose and explicitly marks it out of scope.
  - Global exception handling (`GlobalExceptionHandler`) and bean validation
    on all request DTOs.

## 📚 Topics Covered

- Spring Boot recap; Spring Security fundamentals
- Authentication vs Authorization
- SecurityFilterChain and endpoint protection
- JWT structure, generation and validation
- BCrypt password hashing
- Fundoo Notes App User Management

# Day-14: Spring Boot Fundoo Notes App - Authorization Module

## Authorization & JPA for Notes Management

- **Authorization module:** `Role` enum (`USER`/`ADMIN`) on `User`, embedded
  as a `role` claim in the JWT. `JwtAuthenticationFilter` turns that claim
  into a `ROLE_*` Spring Security authority. `@EnableMethodSecurity` is on,
  and `AdminController` (`GET /admin/users`) demonstrates
  `@PreAuthorize("hasRole('ADMIN')")` on top of plain authentication.
- **JPA deep-dive:** `Note` now has a real `@ManyToOne User user` (was a raw
  `userId` int), and `User` has the matching `@OneToMany` back-reference
  with `cascade`/`orphanRemoval`.
- **Notes Management:** create/read/update/delete on `NoteController`.

## 📚 Topics Covered

- Authentication vs Authorization — secure token-based verification
- OncePerRequestFilter and JWT validation
- SecurityContextHolder and authenticated identity
- IDOR and why client-supplied user IDs must not determine ownership
- @ManyToOne and @OneToMany entity relationships
- mappedBy and ownership of the foreign key
- LAZY vs EAGER fetching and LazyInitializationException
- Ownership-scoped Notes Management

# Day-15: Spring Boot Fundoo Notes App - Organisation Module

## Organisation Modules: Pin/Archive/Trash, Search & Tags
- **Pin/Archive:** `PATCH /notes/{id}/pin`, `PATCH /notes/{id}/archive`.
- **Trash module:** `DELETE /notes/{id}` now soft-deletes (moves to trash)
  instead of removing the row; `GET /notes/trash`, `PATCH
  /notes/{id}/restore`, and `DELETE /notes/{id}/permanent` (empty trash for
  one note) round out the flow.
- **Search & Filter module:** `GET /notes/search?keyword=&pinned=&archived=`
  — a single `@Query` with optional keyword/pinned/archived filters.
- **Tags/Labels module:** `Tag` entity, `TagController` (`/tags`
  create/list/delete), many-to-many `Note`↔`Tag` relationship; attach tags
  to a note via `tagIds` on `NoteRequest`.

## 📚 Topics Covered

- Designing organisation-oriented REST endpoints
- Pin, Archive and Trash state management
- State transitions and Service-layer business rules
- State-based filtering with query parameters
- Search using multiple optional filters
- Spring Data JPA Specification
- @ManyToMany relationship between Notes and Tags
- Tag management and relationship-based derived queries

# Day-16: Spring Boot Fundoo Notes App - Reminder & Notification Module

## JMS & Redis Caching
- **Reminder & Notification module (via JMS):** `Reminder` entity,
  `ReminderController` (`POST /notes/{noteId}/reminders`, `GET
  /reminders`). `ReminderService` polls due reminders every minute
  (`@Scheduled`) and hands them to `ReminderProducer`, which publishes onto
  a JMS queue; `ReminderListener` consumes the queue asynchronously and
  marks the reminder sent — the actual "send" happens off the request
  thread. Runs on an **embedded Artemis broker** so no external JMS server
  is required locally.
- **Token/user caching via Redis:** `CacheConfig` enables Spring's cache
  abstraction backed by Redis; `UserService.getById` is `@Cacheable`
  (`@CacheEvict` helper included) so repeated user lookups skip the
  database. **Requires a running Redis server.**

## 📚 Topics Covered

- JMS and asynchronous, non-blocking background processing
- Producer / Queue / Consumer model
- JmsTemplate and @JmsListener
- When JMS is appropriate and when synchronous processing is required
- Redis as a shared in-memory key-value store
- JWT validation caching
- Cache expiration and token expiration
- Fundoo Notes Reminder / Notification module

# Day-17: Spring Boot Fundoo Notes App - File Attachment Module

## RabbitMQ & Spring Batch (Excel)
- **File Attachment module (optional):** `Attachment` entity,
  `AttachmentController` — multipart upload (`POST
  /notes/{noteId}/attachments`), listing, download, and delete. Files are
  stored on local disk under `app.upload-dir`.
- **RabbitMQ:** `RabbitConfig` declares a topic exchange/queue/binding;
  `NoteEventPublisher` fires a `note.created` event on every note creation,
  consumed asynchronously by `NoteEventListener` — demonstrates
  non-blocking background processing outside the request thread.
  **Requires a running RabbitMQ server.**
- **Excel import/export:** `NoteExcelService` (Apache POI) backs `GET
  /notes/export` (download an `.xlsx` of active notes) and `POST
  /notes/import` (upload an `.xlsx`, one note created per row). A full
  Spring Batch `Job`/`Step` was skipped as overkill for a per-request,
  single-user dataset — swap this in if bulk/offline batch processing with
  checkpointing is needed later.

## 📚 Topics Covered

- RabbitMQ and AMQP fundamentals
- JMS specification vs RabbitMQ broker/protocol
- Exchange, Binding and Queue routing
- Direct, Topic and Fanout exchanges
- RabbitTemplate and @RabbitListener
- Spring Batch Job, Step and Chunk
- ItemReader, ItemProcessor and ItemWriter
- Excel import using Apache POI and Spring Batch
- Excel export using Apache POI
- Optional File Attachment Module

# Day-18: Spring Boot Fundoo Notes App

## REST API Patterns, Global Exception Handling, AOP & Spring Cloud
- **Global exception handling:** `GlobalExceptionHandler` (added under Day
  13, listed here since the roadmap calls it out again) — clean JSON for
  validation errors, `IllegalArgumentException`, `ResourceNotFoundException`,
  and unexpected errors.
- **DTO ↔ Entity mapping:** every entity has a matching request/response DTO
  (`NoteRequest`/`NoteResponse`, `TagRequest`/`TagResponse`, etc.) —
  controllers never leak JPA entities directly.
- **AOP:** `LoggingAspect` wraps every controller and service method with
  `@Around` advice, logging method signature, duration, and any thrown
  exception — a cross-cutting concern applied uniformly instead of
  hand-added log lines.
- **Spring Cloud (introductory):** the Spring Cloud BOM
  (`spring-cloud-dependencies`) is imported in `pom.xml` for dependency
  management, matching the roadmap's "Introduction to Spring Cloud." No
  Spring Cloud starter is pulled in yet — add one (e.g.
  `spring-cloud-starter-config`) when centralized configuration or service
  discovery is actually needed.
- **Consolidate and harden:** logging (AOP), error handling, and
  authorization now apply across every module added in Days 14–17, not just
  the original Day 13 auth endpoints.

## 📚 Topics Covered

- REST API design patterns and Spring scopes revisited
- DTO to Entity and Entity to DTO mapping
- Global exception handling
- Custom exceptions and consistent error responses
- Logging best practices
- AOP and pointcut expressions
- Spring proxy mechanism
- @Transactional as an AOP example
- Introduction to Spring Cloud
- Full Fundoo Notes hardening pass

# Day-19: Spring Boot Fundoo Notes App - Monolith vs Microservices & Spring Boot Microservices

## 📚 Topics Covered

- Monolith vs Microservices trade-offs
- Identifying service boundaries in the Fundoo Notes App
- Spring Boot microservice project structure
- Separate applications, ports and databases
- Inter-service communication with RestTemplate
- Replacing JPA relationships across service boundaries
- API Gateway and request routing
- Beginning the User Management + Auth service decomposition

# Day-20: Spring Boot Fundoo Notes App - Monolith vs Microservices & Spring Boot Microservices

## 📚 Topics Covered

- Why hardcoded service addresses fail
- Eureka as a Service Registry
- Registering Spring Boot services with Eureka
- Service lookup by logical name
- @LoadBalanced RestTemplate
- Multiple service instances and load balancing
- Completing the microservices decomposition
- Eureka-aware API Gateway
- Reminder Service as an independent service
- Tracing the complete 20-day architecture
- Final end-to-end microservices demo

