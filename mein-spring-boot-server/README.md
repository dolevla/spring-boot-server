# Mein Spring Boot Server

This is a Spring Boot server project that consumes HTTP requests, retrieves additional data from an Oracle database, and puts the incoming request data into a specific queue in RabbitMQ.

## Project Structure

The project has the following structure:

```
mein-spring-boot-server
├── src
│   ├── main
│   │   ├── java
│   │   │   ├── com
│   │   │   │   ├── meinprojekt
│   │   │   │   │   ├── Application.java
│   │   │   │   │   ├── controller
│   │   │   │   │   │   └── MeinController.java
│   │   │   │   │   ├── service
│   │   │   │   │   │   └── MeinService.java
│   │   │   │   │   ├── repository
│   │   │   │   │   │   └── MeinRepository.java
│   │   │   │   │   └── model
│   │   │   │   │       └── MeinModel.java
│   │   ├── resources
│   │   │   ├── application.properties
│   │   │   └── logback.xml
│   ├── test
│   │   ├── java
│   │   │   └── com
│   │   │       └── meinprojekt
│   │   │           └── ApplicationTests.java
├── .mvn
│   └── wrapper
│       ├── MavenWrapperDownloader.java
│       ├── maven-wrapper.jar
│       └── maven-wrapper.properties
├── mvnw
├── mvnw.cmd
├── pom.xml
└── README.md
```

## Files

- `src/main/java/com/meinprojekt/Application.java`: This file is the entry point of the Spring Boot application. It contains the main method to start the server.

- `src/main/java/com/meinprojekt/controller/MeinController.java`: This file exports a class `MeinController` which handles the HTTP requests. It contains methods to consume the incoming requests and interact with the Oracle database and RabbitMQ.

- `src/main/java/com/meinprojekt/service/MeinService.java`: This file exports a class `MeinService` which provides the business logic for interacting with the Oracle database. It contains methods to retrieve additional data from the database.

- `src/main/java/com/meinprojekt/repository/MeinRepository.java`: This file exports a class `MeinRepository` which handles the database operations. It contains methods to query the Oracle database.

- `src/main/java/com/meinprojekt/model/MeinModel.java`: This file exports a class `MeinModel` which represents the data model for the application. It contains the necessary properties and methods to store and retrieve data.

- `src/main/resources/application.properties`: This file contains the configuration properties for the Spring Boot application, such as the database connection details and RabbitMQ configuration.

- `src/main/resources/logback.xml`: This file contains the configuration for logging in the application.

- `src/test/java/com/meinprojekt/ApplicationTests.java`: This file contains the test cases for the application.

- `.mvn/wrapper/MavenWrapperDownloader.java`: This file is used by the Maven Wrapper to download the specified version of Maven.

- `.mvn/wrapper/maven-wrapper.jar`: This file is the Maven Wrapper JAR file.

- `.mvn/wrapper/maven-wrapper.properties`: This file contains the configuration for the Maven Wrapper.

- `mvnw`: This file is the Maven Wrapper script for Unix-based systems.

- `mvnw.cmd`: This file is the Maven Wrapper script for Windows systems.

- `pom.xml`: This file is the Maven project object model (POM) file. It contains the project configuration, dependencies, and build settings.

- `README.md`: This file contains the documentation for the project.

Please refer to the individual files for more information on their contents and functionality.