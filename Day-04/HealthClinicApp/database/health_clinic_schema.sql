-- Health Clinic Console Application - Database Schema
-- Modules: Patient, Doctor, Specialization, Appointment, Visit History, Billing

DROP DATABASE IF EXISTS health_clinic_db;
CREATE DATABASE health_clinic_db CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci;
USE health_clinic_db;

-- MODULE: Specialization
CREATE TABLE specializations (
    specialization_id INT AUTO_INCREMENT PRIMARY KEY,
    name               VARCHAR(100) NOT NULL UNIQUE,
    description         VARCHAR(255),
    created_at         TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

-- MODULE: Doctor
CREATE TABLE doctors (
    doctor_id           INT AUTO_INCREMENT PRIMARY KEY,
    first_name           VARCHAR(50) NOT NULL,
    last_name            VARCHAR(50) NOT NULL,
    specialization_id   INT,
    email                VARCHAR(100) UNIQUE,
    phone                VARCHAR(20),
    is_active            BOOLEAN DEFAULT TRUE,
    created_at           TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    CONSTRAINT fk_doctor_specialization
        FOREIGN KEY (specialization_id) REFERENCES specializations(specialization_id)
        ON DELETE SET NULL
);

-- MODULE: Patient
CREATE TABLE patients (
    patient_id       INT AUTO_INCREMENT PRIMARY KEY,
    first_name        VARCHAR(50) NOT NULL,
    last_name         VARCHAR(50) NOT NULL,
    date_of_birth     DATE,
    gender            ENUM('Male', 'Female', 'Other') NOT NULL,
    email             VARCHAR(100) UNIQUE,
    phone             VARCHAR(20),
    is_active         BOOLEAN DEFAULT TRUE,
    created_at        TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

-- MODULE: Appointment
CREATE TABLE appointments (
    appointment_id     INT AUTO_INCREMENT PRIMARY KEY,
    patient_id         INT NOT NULL,
    doctor_id          INT NOT NULL,
    appointment_date   DATETIME NOT NULL,
    status             ENUM('Scheduled', 'Completed', 'Cancelled') NOT NULL DEFAULT 'Scheduled',
    created_at         TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    CONSTRAINT fk_appointment_patient
        FOREIGN KEY (patient_id) REFERENCES patients(patient_id)
        ON DELETE CASCADE,
    CONSTRAINT fk_appointment_doctor
        FOREIGN KEY (doctor_id) REFERENCES doctors(doctor_id)
        ON DELETE RESTRICT
);

-- MODULE: Visit History
CREATE TABLE visit_history (
    visit_id          INT AUTO_INCREMENT PRIMARY KEY,
    appointment_id    INT NOT NULL,
    diagnosis         VARCHAR(255),
    prescription       VARCHAR(255),
    visit_notes        TEXT,
    created_at         TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    CONSTRAINT fk_visit_appointment
        FOREIGN KEY (appointment_id) REFERENCES appointments(appointment_id)
        ON DELETE CASCADE
);

-- MODULE: Billing
CREATE TABLE billing (
    billing_id        INT AUTO_INCREMENT PRIMARY KEY,
    appointment_id    INT NOT NULL,
    amount            DECIMAL(10, 2) NOT NULL,
    payment_status    ENUM('Pending', 'Paid', 'Cancelled') NOT NULL DEFAULT 'Pending',
    billed_at         TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    CONSTRAINT fk_billing_appointment
        FOREIGN KEY (appointment_id) REFERENCES appointments(appointment_id)
        ON DELETE CASCADE,
    CONSTRAINT chk_billing_amount_non_negative CHECK (amount >= 0)
);

-- AUDIT TABLE + TRIGGER (reusing Day 3 audit trigger concept)
-- Tracks status changes on appointments for compliance/audit purposes
CREATE TABLE appointment_status_audit (
    audit_id          INT AUTO_INCREMENT PRIMARY KEY,
    appointment_id    INT NOT NULL,
    old_status         VARCHAR(20),
    new_status         VARCHAR(20),
    changed_at         TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

DELIMITER //
CREATE TRIGGER trg_appointment_status_audit
AFTER UPDATE ON appointments
FOR EACH ROW
BEGIN
    IF OLD.status <> NEW.status THEN
        INSERT INTO appointment_status_audit (appointment_id, old_status, new_status)
        VALUES (NEW.appointment_id, OLD.status, NEW.status);
    END IF;
END //
DELIMITER ;

-- INDEXES for common lookup patterns
CREATE INDEX idx_appointments_patient ON appointments(patient_id);
CREATE INDEX idx_appointments_doctor ON appointments(doctor_id);
CREATE INDEX idx_appointments_date ON appointments(appointment_date);
CREATE INDEX idx_billing_appointment ON billing(appointment_id);
CREATE INDEX idx_visit_history_appointment ON visit_history(appointment_id);

-- LEAST-PRIVILEGE APPLICATION USER (never use root in application code)
DROP USER IF EXISTS 'clinic_app_user'@'localhost';
CREATE USER 'clinic_app_user'@'localhost' IDENTIFIED BY 'StrongPassword123!';

-- Grant only what the application needs -- no DROP/ALTER/CREATE privileges
GRANT SELECT, INSERT, UPDATE, DELETE ON health_clinic_db.* TO 'clinic_app_user'@'localhost';
FLUSH PRIVILEGES;

-- SAMPLE DATA
INSERT INTO specializations (name, description) VALUES
    ('Cardiology', 'Heart and cardiovascular system'),
    ('Pediatrics', 'Medical care for infants, children, and adolescents'),
    ('Orthopedics', 'Musculoskeletal system'),
    ('General Medicine', 'General physician / internal medicine');

INSERT INTO doctors (first_name, last_name, specialization_id, email, phone) VALUES
    ('Anjali', 'Rao', 1, 'anjali.rao@clinic.com', '9876500001'),
    ('Vikram', 'Iyer', 3, 'vikram.iyer@clinic.com', '9876500002'),
    ('Priya', 'Nair', 2, 'priya.nair@clinic.com', '9876500003'),
    ('Suresh', 'Menon', 4, 'suresh.menon@clinic.com', '9876500004');

INSERT INTO patients (first_name, last_name, date_of_birth, gender, email, phone) VALUES
    ('Ramesh', 'Kumar', '1985-03-14', 'Male', 'ramesh.kumar@example.com', '9123400001'),
    ('Sita', 'Sharma', '1990-07-22', 'Female', 'sita.sharma@example.com', '9123400002'),
    ('Arjun', 'Verma', '2001-11-05', 'Male', 'arjun.verma@example.com', '9123400003');

INSERT INTO appointments (patient_id, doctor_id, appointment_date, status) VALUES
    (1, 1, '2026-08-10 10:00:00', 'Scheduled'),
    (2, 2, '2026-08-11 11:30:00', 'Scheduled'),
    (3, 3, '2026-08-12 09:15:00', 'Scheduled');
