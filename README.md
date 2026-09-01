# Inventory Management Dashboard

## Overview
Industry-level inventory management backend for an e-commerce store, built with Java & Spring Boot. This system manages products, categories, suppliers, stock levels, and orders with secure, role-based access control.

## Status
🚧 In Progress — Phase 1 (Foundation)

## Tech Stack
- Java 25
- Spring Boot 4.1.1
- Spring Data JPA
- MySQL
- Lombok
- Maven

## Features (Planned)
- [x] Project setup
- [ ] Product/Category/Supplier CRUD
- [ ] JWT Authentication & Role-based Access
- [ ] Stock tracking & low-stock alerts
- [ ] Reporting & analytics
- [ ] Docker & CI/CD

## Getting Started

### Prerequisites
- Java 21 or higher
- MySQL Server
- Maven (or use included Maven wrapper)

### Local Setup
1. Clone the repository
2. Create a MySQL database named `inventory_db`
3. Update `src/main/resources/application.properties` with your MySQL credentials
4. Run the application:./mvnw spring-boot:run
5. Application will start on `http://localhost:8080`

## Roadmap
This project follows a phased development approach:
- Phase 1: MVP Foundation (CRUD, validation, basic auth)
- Phase 2: Security, Transactions & Testing
- Phase 3: Production Readiness (Docker, CI/CD, caching)
- Phase 4: Advanced Features (reporting, async events)