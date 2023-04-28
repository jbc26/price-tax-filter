# Price filter service

## Prerequisites
- JDK 11 or 17
- Maven

## Introduction
Service retrieves the priceTax applied at a requested date for a brand and a product.

If there are many matches for the same product and brand, the service will return the greatest record with the priority value.

## How to

- Compile
```bash
mvn clean install
```


- Compile without tests
```bash
mvn clean install -DskipTests
```


- Run (path to pom.xml file)
```bash
mvn spring-boot:run
```

## Code considerations
- Using hexagonal architecture (also known as ports and adapters).

- Creation of input and output DTOs in controller, instead of using domain entity. This fact allow to customize input and output values (in this example, can customize the data format).

- Test constants are declared in the test file to prevent changes in code that could break the functionality. For example, if the URL path changes by mistake in the controller code, the test will notify that change.

- Using a PriceFilter entity domain instead of passing the params directly to the method to encapsulate the request. In the future, we can add or remove fields from the class with no need to change all params in the code.

## Swagger
[http://localhost:8080/swagger-ui/index.htm](http://localhost:8080/swagger-ui/index.htm)