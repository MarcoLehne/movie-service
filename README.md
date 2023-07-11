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

1. Clone the repository: `git clone https://github.com/MarcoLehne/movie-service.git`
2. Install dependencies: `gradle build`
3. Run the application: `gradle bootRun`
4. Access the application at [http://localhost:8080](http://localhost:8080)

## API Endpoints

- `GET /movies`: Retrieve all movies
- `POST /createMovie`: Create a new movie
- `POST /rateMovie`: Rate a movie
- `POST /favoriteMovie`: Favorite a movie
- `POST /createUser`: Create a user
- `POST /deleteUser`: Delete a user
- `POST /login`: Login a user
- `POST /logout`: Logout a user

## Get Requests

### Get Movies

Endpoint: `/movies`

Response Body:
```json
[
  {
    "title": "Raiders of the Lost Ark",
    "date": "06-12-81",
    "director": "Steven Spielberg",
    "rating": null,
    "amountOfRatings": 0
  },
  {
    "title": "Harry Potter and the Philosopher's Stone",
    "date": "11-22-2001",
    "director": "Chris Columbus",
    "rating": null,
    "amountOfRatings": 0
  },
  {
    "title": "2001: A Space Odyssey",
    "date": "04-02-1968",
    "director": "Stanley Kubrick",
    "rating": null,
    "amountOfRatings": 0
  }
]
```

## Request Payloads

### Create User Request

Endpoint: `/createUser`

Request Body:
```json
{
  "userName": "musiccc",
  "password": "huhugaj23",
  "ratedMovies": [],
  "favoriteMovies": []
}
```
Response Body:
```json
{
  "userName": "musiccc",
  "password": "huhugaj23",
  "ratedMovies": [],
  "favoriteMovies": []
}
```

### Delete User Request

Endpoint: `/deleteUser`

Request Body:
```json
{
  "userName": "stargazer74",
  "password": "jju23"
}
```
Response Body:
```json 
{
  "message": "userWasDeleted"
}
```

### Login User Request

Endpoint: `/login`

Request Body:
```json
{
  "userName": "twistingShadow1",
  "password": "555ju5"
}
```
Response Body:
```json
{
  "userName": "twistingShadow",
  "token": "1"
}
```
### Logout User Request

Endpoint: `/logout`

Request Body:
```json
{
  "userName": "stargazer74",
  "token": "1"
}
```
Response Body:
```json
{
  "message": "userIsLoggedOut"
}
```

### Create Movie Request

Endpoint: `/createMovie`

Request Body:
```json
{
  "movie": {
    "title": "Iron Man",
    "releaseDate": "05-01-08",
    "director": "Jon Favreau",
    "rating": null,
    "amountOfRatings": 0
  },
  "userToken": {
    "userName": "stargazer74",
    "token": "1"
  }
}

```
Response Body:
```json 
{
  "title": "Iron Man",
  "releaseDate": "05-01-08",
  "director": "Jon Favreau",
  "rating": null,
  "amountOfRatings": 0
}
```

### Rate Movie Request

Endpoint: `/rateMovie`

Request Body:
```json
{
  "movie": {
    "title": "Raiders of the Lost Ark",
    "releaseDate": "06-12-81",
    "director": "Steven Spielberg",
    "rating": null,
    "amountOfRatings": 0
  },
  "userToken": {
    "userName": "stargazer74",
    "token": "1"
  },
  "rating": 4
}

```
Response Body:
```json
{
  "title": "Raiders of the Lost Ark",
  "releaseDate": "06-12-81",
  "director": "Steven Spielberg",
  "rating": null,
  "amountOfRatings": 0
}
```
### Favorite Movie Request

Endpoint: `/favoriteMovie`

Request Body:
```json
{
  "movie": {
    "title": "Raiders of the Lost Ark",
    "releaseDate": "06-12-81",
    "director": "Steven Spielberg",
    "rating": null,
    "amountOfRatings": 0
  },
  "userToken": {
    "userName": "stargazer74",
    "token": "1"
  }
}

```
Response Body:
```json
{
    "title": "Raiders of the Lost Ark",
    "releaseDate": "06-12-81",
    "director": "Steven Spielberg",
    "rating": null,
    "amountOfRatings": 0
}
```

## Mock Implementation

This project uses a mock implementation and does not connect to real database.
Some data is pre-defined in the mock implementation. 

### Movies

```json
[
  {
    "title": "Raiders of the Lost Ark",
    "releaseDate": "06-12-81",
    "director": "Steven Spielberg",
    "cast": null,
    "rating": 0
  },
  {
    "title": "Harry Potter and the Philosopher's Stone",
    "releaseDate": "11-22-2001",
    "director": "Chris Columbus",
    "cast": null,
    "rating": 0
  },
  {
    "title": "2001: A Space Odyssey",
    "releaseDate": "04-02-1968",
    "director": "Stanley Kubrick",
    "cast": null,
    "rating": 0
  }
]

```

### Users

```json
[
  {
    "userName": "stargazer74",
    "password": "jju23",
    "ratedMovies": [],
    "favoriteMovies": []
  },
  {
    "userName": "fluffypuff69",
    "password": "wwuwu999",
    "ratedMovies": [],
    "favoriteMovies": []
  },
  {
    "userName": "twistingShadow1",
    "password": "555ju5",
    "ratedMovies": [],
    "favoriteMovies": []
  }
]

```

### Logged In Users

```json
[
  {
    "userName": "stargazer74",
    "token": "1"
  },
  {
    "userName": "fluffypuff69",
    "token": "1"
  }
]

```

## Testing

Run the unit tests and integration tests using the following command:

```shell
gradle test
