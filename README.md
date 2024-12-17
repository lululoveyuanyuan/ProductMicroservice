# Product Microservice

This project is a simple microservice for managing products, built with Spring Boot. It demonstrates a layered architecture with clear separation of concerns, integration with Kafka for event publishing, and the use of JSON-based REST endpoints.

## Overview

### Key Features

- **REST Endpoints:**  
  Provides HTTP endpoints to create and manage products.

- **Service Layer:**  
  Encapsulates business logic separately from the REST layer.

- **DTO Mappings:**  
  Uses data transfer objects (DTOs) like `CreateProductRestModel` to map incoming JSON requests into Java objects.

- **Kafka Integration:**  
  Publishes product-related events (e.g., when a product is created) to a Kafka topic configured in `KafkaConfig`.

### Packages

- **`products.service`**  
  - `ProductService` / `ProductServiceImpl`: Contains business logic for product operations.

- **`products.rest`**  
  - `ProductController`: Handles HTTP requests for product-related operations.  
  - `CreateProductController`: Focuses on handling product creation requests.  
  - `CreateProductRestModel`: DTO that represents the JSON structure of product creation requests.

- **`KafkaConfig`**  
  Configures Kafka topics and related properties.

- **`ProductMicroserviceApplication`**  
  The main entry point of the Spring Boot application.

## Prerequisites

- Java 17+ (or any compatible version specified by your project)
- Maven or Gradle (depending on your build tool)
- Kafka Broker running locally (if you want to test Kafka integration)
- Zookeeper (if required by your Kafka version)
- Postman or curl (optional, for testing endpoints)

## Getting Started

### Clone the Repository

```bash
git clone <repository-url>
cd product-microservice
Build the Project
With Maven:

bash
Copy code
mvn clean install
With Gradle:

bash
Copy code
./gradlew build
Run the Application
bash
Copy code
mvn spring-boot:run

Using the REST Endpoints
Create a Product
POST http://localhost:8080/products

Request Body (JSON):

json
Copy code
{
  "title": "Sample Product",
  "price": 19.99,
  "quantity": 10
}
Response:

201 CREATED if successfully created.
