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


## Key Concepts Practice

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