# Kafka PoC (Proof of Concept)

This project demonstrates a simple setup for using Apache Kafka with Spring Boot applications.

## Overview

The project consists of the following modules:

- **kafka-poc**: Parent POM project that manages common configuration and dependencies.
- **kafka-message-consumer**: Spring Boot application responsible for consuming messages from Kafka.
- **kafka-message-producer**: Spring Boot application responsible for producing messages to Kafka.
- **kafdrop**: Dockerized Kafka UI for monitoring Kafka topics and messages.

## Prerequisites

Before running the applications, ensure you have the following installed:

- Java 17
- Apache Maven
- Docker

## Setup

1. Clone the repository:

    ```bash
    git clone https://github.com/mehdiz/kafka-poc.git
    ```

2. Navigate to the project directory:

    ```bash
    cd kafka-poc
    ```

3. Build the project using Maven:

    ```bash
    mvn clean install
    ```

4. Start Kafka and Kafdrop using Docker Compose:

    ```bash
    docker-compose up -d
    ```
5. Open your browser and navigate to [http://localhost:3000](http://localhost:3000) to access the React app.

6. To send a greeting message, use curl:

    ```bash
    curl http://localhost:8081/send/greeting/[name]
    ```

   Replace `[name]` with the desired name for the greeting message.

That's it! Kafka, Kafdrop, and the React app are now running, and you can send greeting messages to the Kafka message consumer using curl.
![](/Users/mehdi/projects/Kafka-poc/kafka.png)