# Worlds 24

## Project Context
An e-sport organization aims to develop a management application to organize and track video game tournaments. This application will manage players, teams, and tournaments.

## Main Features
- **Player Management**: Registration, modification, deletion, and display of one or more players.
- **Team Management**: Creation, modification, addition/removal of players, and display of one or more teams.
- **Tournament Management**: Creation, modification, addition/removal of teams, and display of one or more tournaments.

## Main Class Structure
- **Player**: Contains attributes like `nickname`, `age`, and `team`.
- **Team**: Contains attributes like `name`, `players`, `tournaments`, and `ranking`.
- **Tournament**: Contains attributes like `title`, `game`, `startDate`, `endDate`, `spectatorCount`, `teams`, `estimatedDuration`, `matchBreakTime`, `ceremonyTime`, and `status` (PLANNED, IN_PROGRESS, COMPLETED, CANCELLED).
- **Game**: Contains attributes like `name`, `difficulty`, and `averageMatchDuration`.

## Project Structure
- **Configuration Files**:
    - `applicationContext.xml` (for Spring configuration)
    - `pom.xml` (for Maven configuration)

- **Model Layer** (JPA entities)
- **Repository Layer** (using JPA/Hibernate)
- **Service Layer** (business logic)
- **Utility Layer** (validation)
- **Presentation Class** with console menu (main method to start the application and using ApplicationContext to load Spring configuration)
- **Unit Tests**

## Technologies Used
- **Java 8**: The project is developed using Java 8, leveraging its features such as Stream API, Lambda expressions, Java Time API, and Optional.
- **Maven**: Used for dependency management to streamline project configuration and build processes.
- **JUnit & Mockito**: Employed for creating unit tests to ensure the reliability and correctness of the application.
- **Design Patterns**:
    - **Repository Pattern**: Implemented for data access abstraction.
    - **Singleton Pattern**: Used to manage shared resources in the application.
- **Logging**: Integrated a logging system using SLF4J as the logging framework.
- **JPA & Hibernate**: Utilized for object-relational mapping (ORM) to interact with the database.
- **Hibernate Validations**: Implemented necessary validations using annotations like `@NotNull`, `@Size`, etc., to enforce data integrity.
- **Console Menu**: Developed the main class to provide a console menu for user interaction with the application.
- **Executable JAR**: The application is packaged as an executable JAR file for easy distribution and execution.

## Tools
- **Git**: Used for version control to manage the project, utilizing branches for feature development and collaboration.
- **Integrated Development Environment (IDE)**: Use any IDE of your choice to facilitate coding and debugging.
- **JIRA**: Employed for project management, using the Scrum methodology to plan and track progress, ensuring proper linkage with Git for issue tracking and feature development.

## Diagrams
- **Use Case Diagram**: ![Use Case Diagram](/resources/UML/classDiagram.png)
- **Class Diagram**: ![Class Diagram](/resources/UML/useCaseDiagram.png)

## Database Configuration
- The database configuration is set up in the `\worlds24_structure\src\main\resources` folder. Make sure to create a `config.properties` file based on `config.properties.example` with the following properties:

```
db.username=sa
db.password=
```

- The `applicationContext.xml` file contains the configuration for connecting to the H2 database:

```xml
<bean id="dataSource" class="org.springframework.jdbc.datasource.DriverManagerDataSource"> 
  <property name="driverClassName" value="org.h2.Driver"/> 
  <property name="url" value="jdbc:h2:file:./data/worlds24"/> 
  <property name="username" value="${db.username}"/> 
  <property name="password" value="${db.password}"/> 
</bean>
```

- Ensure that the H2 database server is running, and access the database at http://localhost:8082 if needed.

## Running the Application
- Navigate to the jar file located at `/resources/executable/` to run the application, execute the following command in your terminal:

```bash
java -jar worlds24_structure-1.0-SNAPSHOT.jar
```

## Author
- [Mostafa Meskine](https://github.com/MesVortex)
