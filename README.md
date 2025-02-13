# Spring JDBC CRUD Operations

This is a simple **CRUD (Create, Read, Update, Delete)** application using **Spring JDBC** and **MySQL**.

## 🛠 Technologies Used
- **Spring Framework (Spring JDBC)**
- **Java**
- **MySQL**
- **Maven**

## 📌 Features
- **Insert** a new student record  
- **Update** an existing student record  
- **Delete** a student record  
- **Retrieve** all student records  

## ⚙️ Project Structure
- `com.resources.Springconfig` → Spring configuration (JDBC, DataSource)  
- `com.rowmapper.StudentRowMapper` → Maps database rows to Java objects  
- `com.student.Student` → POJO class for Student entity  
- `CRUD_Oparaions_Using_SPring.SPring_JDBC.App` → Main class for CRUD operations  

## 🚀 How to Run
1. **Setup MySQL Database**
   ```sql
   CREATE DATABASE springjdbc;
   USE springjdbc;
   CREATE TABLE student (
       s_id INT PRIMARY KEY,
       s_name VARCHAR(100),
       s_marks FLOAT
   );
