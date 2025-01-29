Healthcare Management System
Overview
A microservice-based application designed to manage doctors, patients, prescriptions, pharmacies, and medicines. It features authentication, caching, messaging queues, and API versioning. The system is cloud-ready and containerized using Docker.

Key Features
Doctor & Patient Management
Prescription Creation & Management
Medicine Search with Autocomplete
Prescription Notifications
Asynchronous Queue System
Redis Caching for Medicines
API Gateway for Routing
Services
Authentication Service: Manages user authentication and JWT.
Doctor Service: Handles doctor info and prescription creation.
Pharmacy Service: Manages prescription submission.
Medicine Service: Provides medicine search and autocomplete.
Notification Service: Sends notifications for missing prescriptions.
Queue Service: Manages asynchronous messaging.
Cache Service: Implements Redis caching for medicine data.
API Gateway: Routes API requests to relevant services.
Technologies
Backend: Spring Boot
Queue: RabbitMQ
Cache: Redis
Database: PostgreSQL & MongoDB
Containerization: Docker
API Endpoints
Authentication:

POST /api/v1/auth/login
POST /api/v1/auth/register
Doctor:

POST /api/v1/doctor/register
POST /api/v1/doctor/createPrescription
Pharmacy:

POST /api/v1/pharmacy/submitPrescription
GET /api/v1/pharmacy/searchMedicine
Medicine:

POST /api/v1/medicines
GET /api/v1/medicines/search
