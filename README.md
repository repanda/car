# car

We have a need to create a backend API to store and retrieve the data about the cars of our fleet. A “Car” model would
have the following

```
{
    “id”: 12345,
    “brand”: “Flexa”,
    “licensePlate”: “L-CS8877E”,
    “status”: “available”,
    “createdAt”: “2017-09-01T10:23:47.000Z",
    “lastUpdatedAt”: “2022-04-15T13:23:11.000Z"
}
```

# Requirements

- Maven 3 (using mvn 3.8.1 version)
- Java 17 (using jdk-17.0.1)

# Build

mvn clean install

## How to Run

After building the project you run it using the ```java -jar``` command or in your favorite IDE.

* Clone this repository
* You can build the project and run the tests by running ```mvn clean package```
* Once successfully built, you can run the service by one of these two methods:

```
        java -jar target/car-0.0.1-SNAPSHOT.jar
or
        mvn spring-boot:run
```

## About the App

This app is just a simple car REST service. It uses an in-memory database (H2) to store the data.

Here are some endpoints you can call:

### Create a car resource

```
POST /cars
Accept: application/json
Content-Type: application/json
{
  "brand": "Flexa",
  "licensePlate": "L-CS8877E",
  "status": "AVAILABLE"
}
RESPONSE: HTTP 200
```

### Retrieve all cars (for demo purpose only!)

```
http://localhost:8080/cars

RESPONSE: HTTP 200
[
  {
    "id": 1,
    "brand": "Flexa",
    "licensePlate": "L-CS8877E",
    "status": "available",
    "createdAt": "2022-09-25T21:28:14.939Z",
    "lastUpdatedAt": "2022-09-25T21:28:14.939Z"
  }
]
```

### Retrieve a car by ID

```
http://localhost:8080/cars/1

RESPONSE: HTTP 200
{
    "id": 1,
    "brand": "Flexa",
    "licensePlate": "L-CS8877E",
    "status": "available",
    "createdAt": "2022-09-25T21:28:14.939Z",
    "lastUpdatedAt": "2022-09-25T21:28:14.939Z"
}
```