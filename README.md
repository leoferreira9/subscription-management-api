# Subscription Management API

A RESTful API built with Spring Boot to manage recurring subscriptions for streaming services, including users, subscriptions, and payment history.

This project was developed as a **portfolio project** with a focus on clean architecture, business rules modeling, and proper API design.

---

## 📌 Overview

The Subscription Management API allows users to subscribe to streaming services with monthly or yearly plans.  
Each subscription generates a billing record (`PaymentHistory`) that represents a charge attempt linked to the subscription.

The system is intentionally simplified and **does not integrate with real payment gateways**.  
Its main goal is to demonstrate backend design, data modeling, and RESTful API practices.

---

## 🚀 Features

- User management (create, update, list, delete)
- Streaming service management
- Subscription management:
  - Monthly or yearly billing
  - Automatic calculation of `startDate` and `nextBillingDate`
- Payment history:
  - Automatically created when a subscription is created
  - Linked to a specific subscription
  - Tracks payment status (`PENDING`, `PAID`, `FAILED`, `CANCELED`)
- DTO separation (Create / Update / Response)
- MapStruct for entity-to-DTO mapping
- Swagger/OpenAPI documentation

---

## 🧩 Main Business Rules

- A subscription belongs to a user and a streaming service
- Billing can be **MONTHLY** or **YEARLY**
- When a subscription is created:
  - A `PaymentHistory` record is automatically generated with status `PENDING`
- Payment history represents **billing attempts**, not real financial transactions
- Payment methods (PIX, gift card, etc.) are treated as informational only

---

## 📄 API Documentation

The API is documented using **Swagger (OpenAPI)**.

After running the application, access:
```bash
http://localhost:8080/swagger-ui/index.html
```
---

## ⚙️ Technologies Used

- Java 21
- Spring Boot 3.2.5
- Spring Web
- Spring Data JPA
- Bean Validation
- MapStruct
- MySQL
- Maven
- Swagger / OpenAPI (springdoc)

---

## 🛠️ How to Run the Project

### Prerequisites
- Java 21
- Maven
- MySQL

### Steps

1. Clone the repository:
   ```bash
   git clone https://github.com/your-username/subscription-management-api.git
   ```
   
2. Rename the configuration file:
   ```bash
   application-example.properties → application.properties
   ```
   
3. Update your database credentials in application.properties:
   ```bash
   spring.datasource.username=USERNAME_HERE
   spring.datasource.password=PASSWORD_HERE
   ```
   
4. Run the project:
   ```bash
   mvn spring-boot:run -> The application will start on port 8080.
   ```
