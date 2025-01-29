# Healthcare Management System

## Overview
A microservice-based application for managing doctors, patients, prescriptions, pharmacies, and medicines. It includes authentication, caching, messaging queues, and API versioning. The system is cloud-ready and containerized using Docker.

## Key Features
- Doctor & Patient Management
- Prescription Creation & Management
- Medicine Search with Autocomplete
- Prescription Notifications
- Asynchronous Queue System
- Redis Caching for Medicines
- API Gateway for Routing

## Services
- **Authentication Service**: Manages user authentication and JWT.
- **Doctor Service**: Manages doctor info and prescription creation.
- **Pharmacy Service**: Handles prescription submission.
- **Medicine Service**: Provides medicine search and autocomplete.
- **Notification Service**: Sends notifications for missing prescriptions.
- **Queue Service**: Manages asynchronous messaging.
- **Cache Service**: Implements Redis caching for medicines.
- **API Gateway**: Routes requests to relevant services.

## Technologies
- **Backend**: Spring Boot
- **Queue**: RabbitMQ
- **Cache**: Redis
- **Database**: PostgreSQL & MongoDB
- **Containerization**: Docker

## API Endpoints

### Authentication:
- `POST /api/v1/auth/login`: Authenticate user and issue JWT.
- `POST /api/v1/auth/register`: Register a new user.

### Doctor:
- `POST /api/v1/doctor/register`: Register a doctor.
- `POST /api/v1/doctor/createPrescription`: Create a prescription.

### Pharmacy:
- `POST /api/v1/pharmacy/submitPrescription`: Submit a prescription.
- `GET /api/v1/pharmacy/searchMedicine`: Search medicines.

### Medicine:
- `POST /api/v1/medicines`: Add a new medicine.
- `GET /api/v1/medicines/search`: Search medicines with autocomplete.
