# User Management REST API

A REST API for managing users, built with Java 17, Spring Boot, Spring Data JPA and MySQL.

## Features
- Create, read, update and delete users
- Controller, Service and Repository layers
- DTO records for requests and responses
- Bean Validation on incoming data
- Global exception handling with consistent error responses
- Demo data seeded on first run

## Tech stack
Java 17, Spring Boot, Spring Data JPA, MySQL, Maven

## Run locally
1. Create a MySQL database named `crud`.
2. Set environment variables `DB_USERNAME` and `DB_PASSWORD`.
3. Run `./mvnw spring-boot:run`.

The app starts on `http://localhost:8080`.

## Endpoints

| Method | URL | Description | Success |
|---|---|---|---|
| GET | `/api/users` | List all users | 200 |
| GET | `/api/users/{id}` | Get one user | 200 |
| POST | `/api/users` | Create a user | 201 |
| PUT | `/api/users/{id}` | Update a user | 200 |
| DELETE | `/api/users/{id}` | Delete a user | 204 |

### Example request
`POST /api/users`
```json
{ "name": "Test", "email": "test@gmail.com" }
```

### Example response
```json
{ "id": 5, "name": "Test", "email": "test@gmail.com" }
```

### Error responses
- `400` for validation errors, for example `name: Name is required`
- `404` when a user doesn't exist
- `500` for unexpected errors

```json
{ "status": 404, "message": "User not found with id 999", "timestamp": "2026-10-18T19:10:00" }
```
