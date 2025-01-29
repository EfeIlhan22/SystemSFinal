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
- **Doctor Service**: Manages prescription creation.
- **Pharmacy Service**: Handles prescription submission.
- **Medicine Service**: Provides medicine search and autocomplete.
- **Notification Service**: Sends notifications for prescriptions with empty medicines.
- **Queue Service**: Manages asynchronous messaging.
- **Cache Service**: Implements MongoCache caching for medicines.
- **API Gateway**: Routes requests to relevant services.

## Technologies
- **Backend**: SpringBoot
- **Queue**: RabbitMQ
- **Cache**: MongoCache
- **Database**: PostgreSQL & MongoDB
- **Containerization**: Docker

## API Endpoints

### Authentication:
- `POST /api/v1/auth/login`: Puts JWT in header
- `POST /api/v1/auth/create`: Create a new doctor or pharmacy.

### Doctor:
- `POST /doctor/v1/create`: Creates a prescription.

### Pharmacy:
- `POST /pharmacy/v1/update`: Submits a prescription.
### Prescription
- `GET /prescription/v1/prescription`:Gets the prescription with the id given

### Medicine:
- `GET /api/v1/medicines/search`: Search medicines with autocomplete.
