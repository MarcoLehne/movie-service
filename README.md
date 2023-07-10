# Movie App

## Introduction

This is a Kotlin back-end movie app that provides JSON responses. It consists of two main aspects: a user database and a movie database.

## Features

- User Management:
    - Create a profile
    - Delete a profile
    - User authentication

- Movie Management:
    - Create movies
    - Rate movies
    - Favorite movies

## Technology Stack

- Spring Boot
- Kotlin
- JUnit 5

## Usage

### Prerequisites

- Install Java
- Install Kotlin
- Set up a local development environment

### Getting Started

1. Clone the repository: `git clone https://github.com/your-username/movie-app.git`
2. Install dependencies: `mvn install`
3. Run the application: `mvn spring-boot:run`
4. Access the application at [http://localhost:8080](http://localhost:8080)

## API Endpoints

- `GET /movies`: Retrieve all movies
- `POST /createMovie`: Create a new movie
- `POST /rateMovie`: Rate a movie
- `POST /favoriteMovie`: Favorite a movie
- `POST /createUser`: Create a user
- `POST /deleteUser`: Delete a user
- `POST /loginUser`: Login a user
- `POST /logoutUser`: Logout a user

## Mock Implementation

This project uses a mock implementation and does not connect to real database.

## Testing

Run the unit tests and integration tests using the following command:

```shell
mvn test
