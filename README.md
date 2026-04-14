# 🚀 Employee Management System

A **Spring Boot REST API project** to manage employee data with CRUD operations, DTO pattern, exception handling, and advanced Java Collections logic.

---

## 📌 Features

* ✅ Create, Read, Update, Delete (CRUD) operations
* ✅ DTO Pattern (clean API design)
* ✅ Global Exception Handling
* ✅ Java Streams & Collections (business logic)
* ✅ Layered Architecture (Controller → Service → Repository)

---

## 🛠 Tech Stack

* Java 8
* Spring Boot
* Spring Data JPA
* MySQL
* Maven

---

## 📂 Project Structure

employee-management-system
│── src
│   ├── main
│   │   ├── java
│   │   │   └── com.jsp.employee
│   │   │       ├── controller
│   │   │       │     └── EmployeeController.java
│   │   │       ├── service
│   │   │       │     └── EmployeeService.java
│   │   │       ├── repository
│   │   │       │     └── EmployeeRepository.java
│   │   │       ├── entity
│   │   │       │     └── Employee.java
│   │   │       ├── dto
│   │   │       │     └── EmployeeDto.java
│   │   │       ├── util
│   │   │       │     └── EmployeeMapper.java
│   │   │       ├── exception
│   │   │       │     ├── ResourceNotFoundException.java
│   │   │       │     ├── GlobalExceptionHandler.java
│   │   │       │     └── ErrorResponse.java
│   │   │       │
│   │   │       └── EmployeeApplication.java
│   │   │
│   │   └── resources
│   │         └── application.properties
│   │
│   └── test (optional)
│
│── screenshots
│   ├── save-api.png
│   ├── getall-api.png
│   ├── highest.png
│   └── database.png
│
│── README.md
│── pom.xml
│── .gitignore

---

## 🌐 API Endpoints

### CRUD APIs
- POST /employees
- GET /employees
- GET /employees/{id}
- PUT /employees/{id}
- DELETE /employees/{id}

### Business Logic APIs
- GET /employees/highest-salary
- GET /employees/average-salary
- GET /employees/total-salary
- GET /employees/role/{role}
- GET /employees/sort-salary
- GET /employees/group-by-role
- GET /employees/count-gender

---

## 📸 Screenshots

### 🔹 Save Employee API

![Save API]([Screenshots/saveEmployee-api.png](https://github.com/MURUGESAN007/employee-management-system/blob/main/Screenshots/saveEmployee.png))

### 🔹 Get All Employees API

### 🔹 Database Table

---

## 📊 Sample API Response

### 🔹 GET /employees

```json
[
  {
    "name": "Murugesan",
    "age": 22,
    "email": "murugesan@gmail.com",
    "role": "Developer",
    "salary": 50000,
    "gender": "Male"
  }
]
```

---

## ▶️ How to Run

1. Clone the repository
2. Open project in Eclipse
3. Configure MySQL database in `application.properties`
4. Run the Spring Boot application
5. Test APIs using Postman

---

## ⚙️ Database Configuration

```properties
spring.application.name=employee

spring.application.name=product

spring.datasource.url= jdbc:mysql://localhost:3306/springboot_employee_app?createDatabaseIfNotExist=true
spring.datasource.username=root
spring.datasource.password=root

spring.jpa.hibernate.ddl-auto=update
spring.jpa.properties.hibernate.format_sql=true
spring.jpa.show-sql=true
```

---

## 💡 Future Enhancements

* 🔐 JWT Authentication
* 📄 Swagger API Documentation
* 📊 Pagination & Sorting
* ☁️ Cloud Deployment

---

## 👨‍💻 Author

**Murugesan S**

---

## ⭐ If you like this project

Give it a ⭐ on GitHub!
