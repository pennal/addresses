# Address directory

## Your tasks

Implement a simple address lookup by using a three tier layer application

 - persistence
 - business services
 - presentation layer (rest api)

An address such as _Untermoosstrasse 36, 8047 Zurich, Switzerland_ contains information such as

- Country
- City
- Postal code
- Street name
- House number

### Assignment 1

Design your persistence layer by defining one or more JPA entities that reflect the domain model _Address_.

### Assignment 2

Implement a rest api to read all addresses.

### Assignment 3

Implement a rest api to search for specific addresses by street, house number, postal code or city.

### Assignment 4

Present your solution and explain your design decisions. Be prepared for a brief Q&A.
  
## Requirements

Make sure you have installed the following things:

- JDK 14

You can use sdkman to easily switch between JDK installations (see https://sdkman.io/jdks).


## Explanation of the modules

Within this project you find the following modules.

### Domain

The domain module represents the persistence layer and holds JPA entities and their repositories (see https://micronaut-projects.github.io/micronaut-data/latest/guide/).

### Services

This is the business service layer that implements specific business logic. It is responsible for defining the transactional boundries.

### REST API

The rest api consumes the business service layer and 

### Server

This module represents the applications itself. It will result in an executable fat jar. 
