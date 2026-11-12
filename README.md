# Equipment Maintenance Management System API

## Project Overview

The **Equipment Maintenance Management System API** is a RESTful web application developed using Spring Boot. It helps organizations manage equipment records and maintenance activities.

The system allows users to register equipment, retrieve equipment information, update records, and manage maintenance activities.

## Technologies Used

- Java
- Spring Boot
- Spring Data JPA
- Hibernate
- MySQL
- Maven
- REST API
- IntelliJ IDEA

## Main Features

### Equipment Management
- Register new equipment.
- View all registered equipment.
- Retrieve equipment by ID.
- Update equipment information.
- Delete equipment records.
- Search equipment by name.
- Filter equipment by category, status, and location.

### Maintenance Management
- Create maintenance records.
- View all maintenance records.
- Retrieve maintenance records by ID.
- Update maintenance information.
- Delete maintenance records.
- Retrieve maintenance history for specific equipment.
- Filter maintenance records by status, priority, and type.
- Mark maintenance activities as completed.

## Database Configuration

The application uses MySQL.

Create a database named:

```sql
CREATE DATABASE maintenance_db;
```

Configure your database connection in `src/main/resources/application.properties`:

```properties
spring.datasource.url=jdbc:mysql://localhost:3307/maintenance_db
spring.datasource.username=root
spring.datasource.password=${DB_PASSWORD}

spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
spring.jpa.properties.hibernate.format_sql=true
```

Set the `DB_PASSWORD` environment variable to your actual MySQL password before running the application.

**Important:** Never upload your actual database password to GitHub.

## Running the Application

1. Clone the repository:

```bash
git clone https://github.com/YOUR_USERNAME/equipment-maintenance-api.git
```

2. Open the project in IntelliJ IDEA.

3. Configure your MySQL database and `DB_PASSWORD` environment variable.

4. Allow Maven to download the required dependencies.

5. Run the main Spring Boot application.

The application will start at:

```text
http://localhost:8080
```

## API Endpoints

### Equipment Endpoints

| Method | Endpoint | Description |
|---|---|---|
| POST | `/api/equipment` | Register equipment |
| GET | `/api/equipment` | Get all equipment |
| GET | `/api/equipment/{id}` | Get equipment by ID |
| PUT | `/api/equipment/{id}` | Update equipment |
| DELETE | `/api/equipment/{id}` | Delete equipment |
| GET | `/api/equipment/search?keyword=Pump` | Search equipment |
| GET | `/api/equipment/category/{category}` | Filter by category |
| GET | `/api/equipment/status/{status}` | Filter by status |
| GET | `/api/equipment/location/{location}` | Filter by location |

### Maintenance Endpoints

| Method | Endpoint | Description |
|---|---|---|
| POST | `/api/maintenance` | Create maintenance record |
| GET | `/api/maintenance` | Get all maintenance records |
| GET | `/api/maintenance/{id}` | Get maintenance by ID |
| PUT | `/api/maintenance/{id}` | Update maintenance |
| DELETE | `/api/maintenance/{id}` | Delete maintenance |
| GET | `/api/maintenance/equipment/{equipmentId}` | Get equipment maintenance history |
| GET | `/api/maintenance/status/{status}` | Filter by status |
| GET | `/api/maintenance/priority/{priority}` | Filter by priority |
| GET | `/api/maintenance/type/{type}` | Filter by maintenance type |
| PATCH | `/api/maintenance/{id}/complete` | Complete maintenance |

## Testing

The API can be tested using the IntelliJ IDEA HTTP Client through the `equipment-api.http` file.

## Author

**TUYISHIME Kevine**

GitHub: https://github.com/YOUR_USERNAME

## Project Purpose

This project was developed for academic and practical learning purposes to demonstrate the development of REST APIs using Java and Spring Boot, database integration, and equipment maintenance management.