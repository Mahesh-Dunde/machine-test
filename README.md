
# Java Spring Boot Machine Test

## 📌 Overview
This project is a Java Spring Boot application implementing **Category and Product CRUD operations** with a **one-to-many relationship**, **pagination**, and **Hibernate ORM**.

## 🛠️ Tech Stack
- **Java 17**
- **Spring Boot 3.4.2**
- **Spring Data JPA & Hibernate**
- **MySQL** (Relational Database)
- **Maven** (Build Tool)
- **Postman** (API Testing)

## ⚙️ Features
✅ Category CRUD Operations (Create, Read, Update, Delete)  
✅ Product CRUD Operations (Create, Read, Update, Delete)  
✅ One-to-Many relationship between **Category** & **Products**  
✅ Pagination for efficient data retrieval  
✅ Sorting by product attributes (e.g., price, name)  
✅ Fetching product details along with category name  
✅ REST API following best practices  

---
## 🚀 Getting Started

### 1️⃣ Clone the Repository
```sh
 git clone https://github.com/Mahesh-Dunde/machine-test
 cd machinetest
```

### 2️⃣ Configure Database
Update `src/main/resources/application.properties` with your MySQL credentials:
```properties
spring.datasource.url=jdbc:mysql://localhost:3306/machinetest
spring.datasource.username=root
spring.datasource.password=yourpassword
spring.jpa.hibernate.ddl-auto=update
```

### 3️⃣ Run the Application
```sh
mvn spring-boot:run
```
The application will start on **http://localhost:8080**.

---
## 📝 API Endpoints

### 📌 Category APIs
| Method | Endpoint | Description |
|---|---|---|
| GET | `/api/categories?page=0&size=5` | Get all categories (paginated) |
| POST | `/api/categories` | Create a new category |
| GET | `/api/categories/{id}` | Get category by ID |
| PUT | `/api/categories/{id}` | Update category by ID |
| DELETE | `/api/categories/{id}` | Delete category by ID |

### 📌 Product APIs
| Method | Endpoint | Description |
|---|---|---|
| GET | `/api/products?page=0&size=5` | Get all products (paginated) |
| POST | `/api/products` | Create a new product |
| GET | `/api/products/{id}` | Get product by ID (includes category name) |
| PUT | `/api/products/{id}` | Update product by ID |
| DELETE | `/api/products/{id}` | Delete product by ID |

---
## 🗄️ Database Schema
**Category Table:**
| id | name |
|---|---|
| 1 | Electronics |
| 2 | Furniture |

**Product Table:**
| id | name | price | category_id |
|---|---|---|---|
| 1 | Laptop | 800 | 1 |
| 2 | Table | 200 | 2 |

---
## 🛠️ How to Run the Machine Test?
1. **Start MySQL Server** and ensure the database is running.
2. **Run the Spring Boot application** using `mvn spring-boot:run`.
3. **Use Postman or cURL** to test the API endpoints.
4. **Verify pagination & sorting** by testing `/api/products?page=0&size=5&sortBy=price&ascending=true`.

---
## 📌 Submission Details
- **GitHub Repository:** [https://github.com/Mahesh-Dunde/machine-test]
- **How I ran the code?** Using `mvn spring-boot:run`
- **How I ran the machine test?** Using Postman API testing
- **DB Design:** MySQL, with `Category` and `Product` tables (one-to-many relationship)
