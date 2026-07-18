# Indian States Census Analyzer

A Java-based application to analyze **Indian State Census** and **Indian State Code** data from CSV files. The project is built using **Java**, **Maven**, **OpenCSV**, and **JUnit 5**, following Object-Oriented Programming principles and Test-Driven Development (TDD).

## Features

### UC1 - Indian State Census Analyzer

- Load Indian State Census data from a CSV file
- Map CSV records to Java objects using OpenCSV
- Read data using an Iterator
- Validate the number of records loaded
- Handle invalid file path using a custom exception
- Handle invalid file type using a custom exception
- Handle incorrect CSV delimiter using a custom exception
- Handle incorrect CSV header using a custom exception

### UC2 - Indian State Code Analyzer

- Load Indian State Code data from a CSV file
- Map CSV records to Java objects using OpenCSV
- Read data using an Iterator
- Validate the number of records loaded
- Handle invalid file path using a custom exception
- Handle invalid file type using a custom exception
- Handle incorrect CSV delimiter using a custom exception
- Handle incorrect CSV header using a custom exception

## Technologies Used

- Java 8+
- Maven
- OpenCSV
- JUnit 5

## Project Structure

```text
IndianStatesCensusAnalyzer
│── pom.xml
│── README.md
│
└── src
    ├── main
    │   └── java
    │       └── com
    │           └── bridgelabz
    │               └── iscap
    │                   ├── CSVStateCensus.java
    │                   ├── CSVStateCode.java
    │                   ├── StateCensusAnalyser.java
    │                   └── StateCensusAnalyserException.java
    │
    └── test
        ├── java
        │   └── com
        │       └── bridgelabz
        │           └── iscap
        │               └── StateCensusAnalyserTest.java
        │
        └── resources
            ├── IndiaStateCensusData.csv
            ├── IndiaStateCensusWrongDelimiter.csv
            ├── IndiaStateCensusWrongHeader.csv
            ├── IndiaStateCode.csv
            ├── IndiaStateCodeWrongDelimiter.csv
            └── IndiaStateCodeWrongHeader.csv
```

## Exception Handling

The application uses a custom exception (`StateCensusAnalyserException`) to handle validation failures.

Supported exception types include:

- Invalid file path
- Invalid file type
- Incorrect CSV delimiter
- Incorrect CSV header

## Testing

The project includes JUnit 5 test cases covering both positive and negative scenarios.

### State Census Test Cases

- Verify correct record count
- Invalid file path
- Invalid file type
- Incorrect delimiter
- Incorrect header

### State Code Test Cases

- Verify correct record count
- Invalid file path
- Invalid file type
- Incorrect delimiter
- Incorrect header

## Dependencies

```xml
<dependency>
    <groupId>com.opencsv</groupId>
    <artifactId>opencsv</artifactId>
    <version>5.9</version>
</dependency>

<dependency>
    <groupId>org.junit.jupiter</groupId>
    <artifactId>junit-jupiter</artifactId>
    <version>5.10.2</version>
    <scope>test</scope>
</dependency>
```

## Learning Outcomes

- Object-Oriented Programming (OOP)
- Java Collections
- Java File I/O
- CSV Processing using OpenCSV
- Exception Handling
- Custom Exceptions
- Iterator
- Maven Project Structure
- Test-Driven Development (TDD)
- JUnit 5 Testing
- Code Reusability
- Clean Code Practices