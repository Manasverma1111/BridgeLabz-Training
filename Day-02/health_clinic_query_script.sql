-- 1. DATABASE OPERATIONS - DDL

CREATE DATABASE health_clinic;


USE health_clinic;

-- Show current database
SELECT DATABASE();

-- 2. CREATE TABLES - DDL

CREATE TABLE departments (
                             department_id INT AUTO_INCREMENT PRIMARY KEY,
                             department_name VARCHAR(100) NOT NULL UNIQUE,
                             location VARCHAR(100)
);


CREATE TABLE doctors (
                         doctor_id INT AUTO_INCREMENT PRIMARY KEY,
                         doctor_name VARCHAR(100) NOT NULL,
                         specialization VARCHAR(100),
                         salary DECIMAL(10,2) CHECK (salary >= 0),
                         department_id INT,
                         phone VARCHAR(15) UNIQUE,
                         email VARCHAR(100) UNIQUE,
                         hire_date DATE DEFAULT (CURRENT_DATE),

                         CONSTRAINT fk_doctor_department
                             FOREIGN KEY (department_id)
                                 REFERENCES departments(department_id)
                                 ON DELETE SET NULL
                                 ON UPDATE CASCADE
);


CREATE TABLE patients (
                          patient_id INT AUTO_INCREMENT PRIMARY KEY,
                          patient_name VARCHAR(100) NOT NULL,
                          age INT CHECK (age >= 0),
                          gender ENUM('Male', 'Female', 'Other'),
                          phone VARCHAR(15),
                          city VARCHAR(100),
                          blood_group VARCHAR(5),
                          admission_date DATE DEFAULT (CURRENT_DATE)
);


CREATE TABLE appointments (
                              appointment_id INT AUTO_INCREMENT PRIMARY KEY,
                              patient_id INT NOT NULL,
                              doctor_id INT NOT NULL,
                              appointment_date DATETIME NOT NULL,
                              status VARCHAR(20) DEFAULT 'Scheduled',

                              CONSTRAINT fk_appointment_patient
                                  FOREIGN KEY (patient_id)
                                      REFERENCES patients(patient_id)
                                      ON DELETE CASCADE,

                              CONSTRAINT fk_appointment_doctor
                                  FOREIGN KEY (doctor_id)
                                      REFERENCES doctors(doctor_id)
                                      ON DELETE CASCADE
);


CREATE TABLE medicines (
                           medicine_id INT AUTO_INCREMENT PRIMARY KEY,
                           medicine_name VARCHAR(100) NOT NULL,
                           price DECIMAL(10,2) NOT NULL,
                           stock INT DEFAULT 0
);


CREATE TABLE prescriptions (
                               prescription_id INT AUTO_INCREMENT PRIMARY KEY,
                               appointment_id INT NOT NULL,
                               medicine_id INT NOT NULL,
                               dosage VARCHAR(100),

                               FOREIGN KEY (appointment_id)
                                   REFERENCES appointments(appointment_id)
                                   ON DELETE CASCADE,

                               FOREIGN KEY (medicine_id)
                                   REFERENCES medicines(medicine_id)
                                   ON DELETE CASCADE
);


-- Create Rooms table
CREATE TABLE rooms (
                       room_id INT AUTO_INCREMENT PRIMARY KEY,
                       room_number VARCHAR(10) NOT NULL UNIQUE,
                       room_type VARCHAR(50) NOT NULL,
                       floor INT NOT NULL,
                       capacity INT DEFAULT 1,
                       status ENUM('Available', 'Occupied', 'Maintenance')
                           DEFAULT 'Available'
);

-- Create Doctor-Room relationship table
CREATE TABLE doctor_room (
                             doctor_id INT NOT NULL,
                             room_id INT NOT NULL,
                             assigned_from DATE DEFAULT (CURRENT_DATE),
                             assigned_to DATE NULL,

                             PRIMARY KEY (doctor_id, room_id),

                             CONSTRAINT fk_doctor_room_doctor
                                 FOREIGN KEY (doctor_id)
                                     REFERENCES doctors(doctor_id)
                                     ON DELETE CASCADE
                                     ON UPDATE CASCADE,

                             CONSTRAINT fk_doctor_room_room
                                 FOREIGN KEY (room_id)
                                     REFERENCES rooms(room_id)
                                     ON DELETE CASCADE
                                     ON UPDATE CASCADE
);

SELECT
    d.doctor_name,
    d.specialization,
    r.room_number,
    r.room_type,
    r.floor
FROM doctor_room dr
         JOIN doctors d
              ON dr.doctor_id = d.doctor_id
         JOIN rooms r
              ON dr.room_id = r.room_id
ORDER BY d.doctor_name;

--
INSERT INTO rooms
(room_number, room_type, floor, capacity, status)
VALUES
    ('C101', 'Consultation', 1, 1, 'Available'),
    ('C102', 'Consultation', 1, 1, 'Available'),
    ('N201', 'Consultation', 2, 1, 'Available'),
    ('O301', 'Consultation', 3, 1, 'Available'),
    ('P401', 'Consultation', 4, 1, 'Available');

INSERT INTO doctor_room
(doctor_id, room_id)
VALUES
    (1, 1),
    (2, 3),
    (3, 4),
    (4, 5),
    (5, 2);

-- 3. VIEW TABLE STRUCTURE

SHOW TABLES;

DESC departments;
DESC doctors;
DESC patients;
DESC appointments;

SHOW CREATE TABLE doctors;


INSERT INTO departments (department_name, location)
VALUES ('Cardiology', 'Floor 1');

INSERT INTO departments (department_name, location)
VALUES
    ('Neurology', 'Floor 2'),
    ('Orthopedics', 'Floor 3'),
    ('Pediatrics', 'Floor 4'),
    ('Dermatology', 'Floor 5');


INSERT INTO doctors
(doctor_name, specialization, salary, department_id, phone, email)
VALUES
    ('Amit Sharma', 'Cardiologist', 90000, 1, '9876543210',
     'amit@hospital.com'),

    ('Priya Singh', 'Neurologist', 95000, 2, '9876543211',
     'priya@hospital.com'),

    ('Rahul Verma', 'Orthopedic', 80000, 3, '9876543212',
     'rahul@hospital.com'),

    ('Neha Gupta', 'Pediatrician', 85000, 4, '9876543213',
     'neha@hospital.com'),

    ('Ankit Kumar', 'Dermatologist', 75000, 5, '9876543214',
     'ankit@hospital.com');


INSERT INTO patients
(patient_name, age, gender, phone, city, blood_group)
VALUES
    ('Rohan', 25, 'Male', '9000000001', 'Lucknow', 'O+'),
    ('Sneha', 30, 'Female', '9000000002', 'Delhi', 'A+'),
    ('Arjun', 45, 'Male', '9000000003', 'Lucknow', 'B+'),
    ('Pooja', 28, 'Female', '9000000004', 'Noida', 'AB+'),
    ('Karan', 55, 'Male', '9000000005', 'Delhi', 'O-');


INSERT INTO appointments
(patient_id, doctor_id, appointment_date, status)
VALUES
    (1, 1, '2026-08-01 10:00:00', 'Scheduled'),
    (2, 2, '2026-08-01 11:00:00', 'Completed'),
    (3, 1, '2026-08-02 09:30:00', 'Scheduled'),
    (4, 3, '2026-08-02 12:00:00', 'Cancelled'),
    (5, 2, '2026-08-03 14:00:00', 'Scheduled');


INSERT INTO medicines (medicine_name, price, stock)
VALUES
    ('Paracetamol', 20, 100),
    ('Amoxicillin', 80, 50),
    ('Ibuprofen', 40, 70);


-- All columns
SELECT * FROM patients;

-- Specific columns
SELECT patient_name, age, city
FROM patients;

-- Column aliases
SELECT
    patient_name AS Name,
    age AS Age
FROM patients;

-- Unique values
SELECT DISTINCT city
FROM patients;


--
SELECT *
FROM patients
WHERE city = 'Lucknow';

SELECT *
FROM patients
WHERE age > 30;

SELECT *
FROM doctors
WHERE salary >= 80000;


--
SELECT *
FROM patients
WHERE city = 'Lucknow'
  AND age > 30;


SELECT *
FROM patients
WHERE city = 'Lucknow'
   OR city = 'Delhi';


SELECT *
FROM patients
WHERE NOT city = 'Delhi';


--
SELECT * FROM patients WHERE age = 30;

SELECT * FROM patients WHERE age != 30;

SELECT * FROM patients WHERE age <> 30;

SELECT * FROM patients WHERE age > 30;

SELECT * FROM patients WHERE age < 30;

SELECT * FROM patients WHERE age >= 30;

SELECT * FROM patients WHERE age <= 30;


--
SELECT *
FROM patients
WHERE age BETWEEN 25 AND 40;


SELECT *
FROM doctors
WHERE salary BETWEEN 80000 AND 95000;


--
SELECT *
FROM patients
WHERE city IN ('Lucknow', 'Delhi', 'Noida');


SELECT *
FROM patients
WHERE city NOT IN ('Lucknow', 'Delhi');


-- Starts with R
SELECT *
FROM patients
WHERE patient_name LIKE 'R%';

-- Ends with a
SELECT *
FROM patients
WHERE patient_name LIKE '%a';

-- Contains "ha"
SELECT *
FROM patients
WHERE patient_name LIKE '%ha%';

-- Second character is 'o'
SELECT *
FROM patients
WHERE patient_name LIKE '_o%';


--
SELECT *
FROM doctors
WHERE department_id IS NULL;


SELECT *
FROM doctors
WHERE department_id IS NOT NULL;


--
SELECT *
FROM patients
ORDER BY age ASC;


SELECT *
FROM patients
ORDER BY age DESC;


SELECT *
FROM patients
ORDER BY city ASC, age DESC;


--
SELECT *
FROM patients
         LIMIT 3;


-- Skip first 2 and return next 3
SELECT *
FROM patients
         LIMIT 3 OFFSET 2;


--
UPDATE patients
SET city = 'Greater Noida'
WHERE patient_id = 4;


UPDATE doctors
SET salary = salary + 5000
WHERE department_id = 1;


--
DELETE FROM patients
WHERE patient_id = 5;

-- WARNING: Deletes every row
-- DELETE FROM patients;


--
SELECT COUNT(*) AS total_patients
FROM patients;


SELECT COUNT(DISTINCT city) AS total_cities
FROM patients;


SELECT SUM(salary) AS total_salary
FROM doctors;


SELECT AVG(salary) AS average_salary
FROM doctors;


SELECT MAX(salary) AS highest_salary
FROM doctors;


SELECT MIN(salary) AS lowest_salary
FROM doctors;


--
SELECT city, COUNT(*) AS total_patients
FROM patients
GROUP BY city;


SELECT department_id, AVG(salary) AS average_salary
FROM doctors
GROUP BY department_id;


--
SELECT department_id,
       COUNT(*) AS total_doctors
FROM doctors
GROUP BY department_id
HAVING COUNT(*) >= 1;


SELECT department_id,
       AVG(salary) AS avg_salary
FROM doctors
GROUP BY department_id
HAVING AVG(salary) > 80000;


--
SELECT department_id,
       AVG(salary) AS avg_salary
FROM doctors
WHERE salary > 70000
GROUP BY department_id
HAVING AVG(salary) > 80000;


--
SELECT
    d.doctor_id,
    d.doctor_name,
    d.specialization,
    dep.department_name
FROM doctors d
         INNER JOIN departments dep
                    ON d.department_id = dep.department_id;


--
SELECT
    p.patient_name,
    a.appointment_date,
    a.status
FROM patients p
         LEFT JOIN appointments a
                   ON p.patient_id = a.patient_id;


--
SELECT
    p.patient_name,
    a.appointment_date
FROM appointments a
         RIGHT JOIN patients p
                    ON a.patient_id = p.patient_id;


--
SELECT
    p.patient_name,
    d.doctor_name
FROM patients p
         CROSS JOIN doctors d;


--
SELECT
    p.patient_name,
    d.doctor_name,
    d.specialization,
    dep.department_name,
    a.appointment_date,
    a.status
FROM appointments a

         INNER JOIN patients p
                    ON a.patient_id = p.patient_id

         INNER JOIN doctors d
                    ON a.doctor_id = d.doctor_id

         INNER JOIN departments dep
                    ON d.department_id = dep.department_id;


--
SELECT
    d1.doctor_name AS doctor1,
    d2.doctor_name AS doctor2,
    d1.department_id
FROM doctors d1
         JOIN doctors d2
              ON d1.department_id = d2.department_id
                  AND d1.doctor_id < d2.doctor_id;


-- remove duplicates
SELECT patient_name AS name
FROM patients

UNION

SELECT doctor_name AS name
FROM doctors;


--
SELECT city
FROM patients

UNION ALL

SELECT location
FROM departments;


-- Doctors earning above average salary

SELECT *
FROM doctors
WHERE salary > (
    SELECT AVG(salary)
    FROM doctors
);


--
SELECT *
FROM patients
WHERE patient_id IN (
    SELECT patient_id
    FROM appointments
);


--
SELECT *
FROM patients p
WHERE EXISTS (
    SELECT 1
    FROM appointments a
    WHERE a.patient_id = p.patient_id
);


--
SELECT *
FROM patients p
WHERE NOT EXISTS (
    SELECT 1
    FROM appointments a
    WHERE a.patient_id = p.patient_id
);


--
SELECT
    patient_name,
    age,

    CASE
        WHEN age < 18 THEN 'Child'
        WHEN age BETWEEN 18 AND 60 THEN 'Adult'
        ELSE 'Senior Citizen'
        END AS age_category

FROM patients;


--
SELECT UPPER(patient_name)
FROM patients;

SELECT LOWER(patient_name)
FROM patients;

SELECT LENGTH(patient_name)
FROM patients;

SELECT CONCAT(patient_name, ' - ', city)
FROM patients;

SELECT TRIM('   Hospital   ');

SELECT SUBSTRING(patient_name, 1, 3)
FROM patients;


--
SELECT CURRENT_DATE();

SELECT CURRENT_TIME();

SELECT NOW();

SELECT YEAR(admission_date)
FROM patients;

SELECT MONTH(admission_date)
FROM patients;

SELECT DAY(admission_date)
FROM patients;

SELECT DATEDIFF(CURRENT_DATE(), admission_date)
FROM patients;


--
-- Add column
ALTER TABLE patients
    ADD COLUMN email VARCHAR(100);


-- Modify column
ALTER TABLE patients
    MODIFY COLUMN email VARCHAR(150);


-- Rename column
ALTER TABLE patients
    RENAME COLUMN patient_name TO full_name;


-- Rename it back
ALTER TABLE patients
    RENAME COLUMN full_name TO patient_name;


-- Drop column
ALTER TABLE patients
DROP COLUMN email;


--
ALTER TABLE patients
    ADD CONSTRAINT unique_patient_phone
        UNIQUE (phone);


ALTER TABLE patients
DROP INDEX unique_patient_phone;


--
CREATE INDEX idx_patient_city
    ON patients(city);


CREATE INDEX idx_doctor_specialization
    ON doctors(specialization);


-- Show indexes
SHOW INDEX FROM patients;


-- Delete index
DROP INDEX idx_patient_city
    ON patients;


--
CREATE VIEW doctor_department_view AS

SELECT
    d.doctor_id,
    d.doctor_name,
    d.specialization,
    dep.department_name
FROM doctors d
         JOIN departments dep
              ON d.department_id = dep.department_id;


-- Query view
SELECT *
FROM doctor_department_view;


-- Delete view
DROP VIEW doctor_department_view;

--
START TRANSACTION;

UPDATE doctors
SET salary = salary + 5000
WHERE doctor_id = 1;

COMMIT;


START TRANSACTION;

UPDATE doctors
SET salary = salary + 50000
WHERE doctor_id = 1;

ROLLBACK;


START TRANSACTION;

UPDATE doctors
SET salary = salary + 1000
WHERE doctor_id = 1;

SAVEPOINT salary_updated;

UPDATE doctors
SET salary = salary + 50000
WHERE doctor_id = 2;

ROLLBACK TO salary_updated;

COMMIT;


CREATE USER IF NOT EXISTS 'hospital_user'@'localhost'
IDENTIFIED BY 'Hospital@123';


GRANT SELECT
      ON hospital_management.*
          TO 'hospital_user'@'localhost';


-- Give INSERT and UPDATE permission
GRANT INSERT, UPDATE
                  ON hospital_management.*
                  TO 'hospital_user'@'localhost';


-- Give all permissions
GRANT ALL PRIVILEGES
ON hospital_management.*
TO 'hospital_user'@'localhost';


-- Show permissions
SHOW GRANTS FOR 'hospital_user'@'localhost';


-- Remove UPDATE permission
REVOKE UPDATE
    ON hospital_management.*
    FROM 'hospital_user'@'localhost';


-- Remove all privileges
REVOKE ALL PRIVILEGES, GRANT OPTION
    FROM 'hospital_user'@'localhost';


/* ============================================================
   45. COMMON INTERVIEW QUERIES
   ============================================================ */


-- Second highest salary
SELECT MAX(salary) AS second_highest_salary
FROM doctors
WHERE salary < (
    SELECT MAX(salary)
    FROM doctors
);


-- Second highest DISTINCT salary
SELECT DISTINCT salary
FROM doctors
ORDER BY salary DESC
    LIMIT 1 OFFSET 1;


-- Nth highest salary (example: 3rd)
SELECT DISTINCT salary
FROM doctors
ORDER BY salary DESC
    LIMIT 1 OFFSET 2;


-- Doctors earning above average salary
SELECT *
FROM doctors
WHERE salary > (
    SELECT AVG(salary)
    FROM doctors
);


-- Highest paid doctor
SELECT *
FROM doctors
ORDER BY salary DESC
    LIMIT 1;


-- Highest salary in each department
SELECT
    department_id,
    MAX(salary) AS highest_salary
FROM doctors
GROUP BY department_id;


-- Doctors with highest salary in each department
SELECT d.*
FROM doctors d
         JOIN (
    SELECT
        department_id,
        MAX(salary) AS max_salary
    FROM doctors
    GROUP BY department_id
) x
              ON d.department_id = x.department_id
                  AND d.salary = x.max_salary;


-- Count doctors in each department
SELECT
    dep.department_name,
    COUNT(d.doctor_id) AS total_doctors
FROM departments dep
         LEFT JOIN doctors d
                   ON dep.department_id = d.department_id
GROUP BY dep.department_id, dep.department_name;


-- Departments having more than one doctor
SELECT
    dep.department_name,
    COUNT(d.doctor_id) AS total_doctors
FROM departments dep
         JOIN doctors d
              ON dep.department_id = d.department_id
GROUP BY dep.department_id, dep.department_name
HAVING COUNT(d.doctor_id) > 1;


-- Patients without appointments
SELECT p.*
FROM patients p
         LEFT JOIN appointments a
                   ON p.patient_id = a.patient_id
WHERE a.appointment_id IS NULL;


-- Doctors without appointments
SELECT d.*
FROM doctors d
         LEFT JOIN appointments a
                   ON d.doctor_id = a.doctor_id
WHERE a.appointment_id IS NULL;


-- Number of appointments handled by each doctor
SELECT
    d.doctor_name,
    COUNT(a.appointment_id) AS total_appointments
FROM doctors d
         LEFT JOIN appointments a
                   ON d.doctor_id = a.doctor_id
GROUP BY d.doctor_id, d.doctor_name;


/* ============================================================
   46. DUPLICATE RECORD QUERIES
   ============================================================ */

-- Find duplicate patient phone numbers
SELECT
    phone,
    COUNT(*) AS occurrences
FROM patients
GROUP BY phone
HAVING COUNT(*) > 1;


/* ============================================================
   47. RANKING - WINDOW FUNCTIONS (MySQL 8+)
   ============================================================ */

SELECT
    doctor_name,
    salary,

    ROW_NUMBER() OVER (
        ORDER BY salary DESC
    ) AS row_num,

        RANK() OVER (
        ORDER BY salary DESC
    ) AS salary_rank,

        DENSE_RANK() OVER (
        ORDER BY salary DESC
    ) AS dense_rank_value

FROM doctors;


/* ============================================================
   48. RANK WITHIN EACH DEPARTMENT
   ============================================================ */

SELECT
    doctor_name,
    department_id,
    salary,

    DENSE_RANK() OVER (
        PARTITION BY department_id
        ORDER BY salary DESC
    ) AS salary_rank

FROM doctors;


/* ============================================================
   49. CTE - COMMON TABLE EXPRESSION (MySQL 8+)
   ============================================================ */

WITH high_salary_doctors AS (

    SELECT *
    FROM doctors
    WHERE salary > 80000

)

SELECT *
FROM high_salary_doctors;


/* ============================================================
   50. FINAL JOIN EXAMPLE
   ============================================================ */

SELECT
    p.patient_name        AS patient,
    p.age,
    p.city,

    d.doctor_name         AS doctor,
    d.specialization,

    dep.department_name   AS department,

    a.appointment_date,
    a.status

FROM appointments a

         JOIN patients p
              ON a.patient_id = p.patient_id

         JOIN doctors d
              ON a.doctor_id = d.doctor_id

         JOIN departments dep
              ON d.department_id = dep.department_id

WHERE a.status = 'Scheduled'

ORDER BY a.appointment_date;


-- Single-column index
CREATE INDEX idx_appointment_date
    ON appointments(appointment_date);

-- Composite index
CREATE INDEX idx_doctor_date
    ON appointments(doctor_id, appointment_date);

-- without using an index
EXPLAIN
SELECT *
FROM appointments
WHERE status = 'Scheduled';

-- using a single-column index
EXPLAIN
SELECT *
FROM appointments
WHERE appointment_date = '2026-08-01 10:00:00';

-- using the composite index
EXPLAIN
SELECT *
FROM appointments
WHERE doctor_id = 1
  AND appointment_date = '2026-08-02 09:30:00';

--
CREATE TABLE patient_phones (
                                phone_id INT AUTO_INCREMENT PRIMARY KEY,
                                patient_id INT NOT NULL,
                                phone_number VARCHAR(15) NOT NULL UNIQUE,
                                phone_type ENUM('Home', 'Mobile', 'Work', 'Emergency') DEFAULT 'Mobile',

                                CONSTRAINT fk_patient_phone
                                    FOREIGN KEY (patient_id)
                                        REFERENCES patients(patient_id)
                                        ON DELETE CASCADE
                                        ON UPDATE CASCADE
);

--
INSERT INTO patient_phones (patient_id, phone_number, phone_type)
VALUES
    (1, '9000000001', 'Mobile'),
    (1, '9000001001', 'Home'),
    (2, '9000000002', 'Mobile'),
    (3, '9000000003', 'Mobile'),
    (3, '9000001003', 'Emergency'),
    (4, '9000000004', 'Mobile'),
    (5, '9000000005', 'Mobile');

SELECT *
FROM patient_phones;

/*
Justification:
The table satisfies 1NF because every field stores a single value,
and each patient-phone combination is stored as a separate row.
*/

/*
Justification:
The table satisfies 2NF because it contains only key attributes.
There are no partial dependencies on either patient_id or phone_number.
*/

/*
Justification:
The table satisfies 3NF because it has no non-key attributes.
The only data stored is the relationship between a patient and a phone number,
so there are no transitive dependencies.
*/

SELECT
    p.patient_id,
    p.patient_name,
    pp.phone_number,
    pp.phone_type
FROM patients p
         JOIN patient_phones pp
              ON p.patient_id = pp.patient_id
ORDER BY p.patient_id;

-- create the covering index
CREATE INDEX idx_covering_appointments
    ON appointments (doctor_id, appointment_date, status);

-- EXPLAIN
EXPLAIN
SELECT
    doctor_id,
    appointment_date,
    status
FROM appointments
WHERE doctor_id = 1;