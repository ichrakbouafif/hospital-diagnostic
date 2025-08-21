## Project Overview
This project is part of a hospital information system developed for the Diagnostic squad. The system features an automated self-diagnosis cabin that analyzes patient health data and directs patients to the appropriate medical units based on detected conditions.

## Context
Our development team operates using Agile SCRUM methodology with a full team comprising developers, a tester, Tech Lead, Scrum Master, and Product Owner. This functionality represents the core focus area for our squad moving forward. All code produced undergoes thorough review and testing before production deployment.

## Functional Requirements
The automated diagnosis cabin processes a "health index" value from sensors to determine patient pathologies:

- A health index multiple of 3 indicates cardiac issues

- A health index multiple of 5 indicates fractures

- A health index multiple of both 3 and 5 indicates both conditions simultaneously

Based on the detected pathologies, the system directs patients to the appropriate medical units:

- Cardiac problems are treated in cardiology

- Fractures are treated in traumatology

- Patients with multiple conditions are directed to all relevant medical units (order is not important)

## Examples
- Health index 33 returns: "Cardiologie"

- Health index 55 returns: "Traumatologie"

- Health index 15 returns: "Cardiologie, Traumatologie"

# Technical Implementation
- The interoperability squad has already developed the communication infrastructure with the cabin's sensors and display screen. Our responsibility focuses on processing the numerical data from the sensor and returning appropriate string responses for display.

- The solution is implemented exclusively in Java without GUI frameworks, emphasizing clean code principles, maintainability, readability, and testability while adhering to object-oriented and SOLID principles.

## How to Run
* Prerequisites
- Java 11 or higher

- Maven 3.6 or higher

* Building the Project
bash
```
mvn clean compile
```
Running Tests
bash
```
mvn test
```
Packaging the Application
bash
```
mvn package
```
Executing the Application
bash
```
java -cp target/hospital-diagnostic-1.0-SNAPSHOT.jar com.hospital.diagnostic.HealthIndexProcessor <health_index>
```
Examples
bash
```
java -jar target/hospital-diagnostic-1.0-SNAPSHOT.jar 15
java -jar target/hospital-diagnostic-1.0-SNAPSHOT.jar 33
java -jar target/hospital-diagnostic-1.0-SNAPSHOT.jar 55
```


## Technical Notes
- The project uses JUnit 5 for comprehensive unit testing

- External dependencies are minimized for simplicity and maintainability

- The architecture follows clean code principles and SOLID design patterns

- All code is thoroughly tested before deployment
