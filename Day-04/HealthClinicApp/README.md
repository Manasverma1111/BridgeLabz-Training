# Health Clinic Console Application

Java + JDBC + MySQL
JDBC Core → JDBC Workflow → CRUD → Security/Performance → Transaction Management →
Connection Pooling (HikariCP) → Best Practices (try-with-resources, batch processing,
exception handling, DTO/DAO patterns) → Final Project.

## Architecture

```
Console UI (ConsoleMenu) -> Service Layer (AppointmentService, transactions)
   -> DAO Layer (PatientDAO, DoctorDAO, SpecializationDAO, AppointmentDAO,
                  BillingDAO, VisitHistoryDAO -- all PreparedStatement +
                  try-with-resources, connections from HikariCP)
      -> DTO Layer (Patient, Doctor, Specialization, Appointment, Billing, VisitHistory)
         -> MySQL (health_clinic_db)
```

## Folder Structure

```
HealthClinicApp/
├── pom.xml
├── database/
│   └── health_clinic_schema.sql
└── src/main/java/com/clinic/
    ├── Main.java
    ├── config/HikariConnectionPool.java
    ├── dto/       (Patient, Doctor, Specialization, Appointment, Billing, VisitHistory)
    ├── dao/       (interfaces + Impl classes for each entity)
    ├── service/AppointmentService.java   <- transaction coordination
    └── ui/ConsoleMenu.java
```

## Prerequisites

- Java 17+
- Maven 3.8+
- MySQL 8.x server running locally

## Setup

1. **Create the database and schema:**
   ```bash
   mysql -u root -p < database/health_clinic_schema.sql
   ```
   This creates `health_clinic_db`, all 6 module tables, an audit trigger on
   appointment status changes, sample data, and a least-privilege
   `clinic_app_user` (password: `StrongPassword123!`) with only
   SELECT/INSERT/UPDATE/DELETE — no DDL privileges.

2. **Set credentials as environment variables** (recommended over the
   schema's default password):
   ```bash
   export DB_USER=clinic_app_user
   export DB_PASSWORD=StrongPassword123!
   ```
   `HikariConnectionPool` reads these at startup and falls back to the
   schema's defaults if unset.

3. **Build and run:**
   ```bash
   mvn clean package
   java -jar target/health-clinic-console-app.jar
   ```

## Sample Session

```
===== HEALTH CLINIC MANAGEMENT SYSTEM =====
1. Patient Module
2. Doctor Module
3. Specialization Module
4. Appointment Module
5. Complete Appointment (Billing + Visit History)
6. Exit
Enter your choice: 5

-- Complete Appointment (Billing + Visit History) --
1. Complete Appointment  2. View All Billing  3. View All Visit History  4. Back
Choice: 1
Appointment ID: 1
Billing amount: 1500.00
Diagnosis: Routine Checkup
Prescription: Paracetamol
Visit notes: Patient in good health
Appointment #1 completed, billed, and recorded successfully.
```

## Best Practices Applied

- Every DAO uses `PreparedStatement` (SQL-injection immune) + try-with-resources
- HikariCP connection pooling instead of raw `DriverManager`
- Transaction management (`commit`/`rollback`) coordinated in the service layer —
  `AppointmentService` passes one shared `Connection` across the status update,
  billing insert, and visit history insert so all three commit or roll back together
- Soft delete for patients, doctors, and appointment cancellation (healthcare audit
  compliance) — hard delete reserved for genuinely disposable data
- DTO + DAO separation, DAOs coded against interfaces for testability
- Least-privilege dedicated MySQL user (`clinic_app_user`), never `root`
- Credentials read from environment variables, never hardcoded
- `Statement.RETURN_GENERATED_KEYS` used on inserts needing the new primary key
- `rewriteBatchedStatements=true` set on the JDBC URL for batch-insert performance
