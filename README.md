# Price filter service

## Prerequisites
- JDK 11 or 17
- Maven

## Introduction
Service retrieves the priceTax applied at a requested date for a brand and a product.

If there are many matches for the same product and brand, the service will return the greatest record with the priority value.
