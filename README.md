# Address directory 📇

## Introduction

Thank you for applying for a developer position at onstructive. This repository contains a simple Micronaut project that contains a directory of Swiss postal codes. We would like you to continue the development and add support a street and house number directory.

The main goal of this assignment is to understand how you are solving problems.

## Requirements

Make sure you have installed the following tools:

- JDK 14 (You can use sdkman to easily switch between JDK installations (see https://sdkman.io/jdks)).
- Your favourite Java IDE. We recommend using IntelliJ IDEA.
- Gradle (the project provides a Gradlew wrapper, so no installation is required)

## Your assigments 📃

### Assignment 1 - Analyze the existing code 👓

Walkthrough the existing code and try to run and understand it. We would like you to explain how the application works. Feel free to ask questions on parts you don't understand.

#### Explanation of the modules

Within this project you find the following modules.

##### Domain

The domain module represents the persistence layer and holds JPA entities and their repositories (see https://micronaut-projects.github.io/micronaut-data/latest/guide/).

##### Services API

A service api module for interacting with backend services.

##### Services

This is the business service layer that implements specific business logic. It is responsible for defining the transactional boundries.

##### REST API

The rest api consumes the business service layer and 

##### Server

This module represents the applications itself. It will result in an executable fat jar. 


### Assignment 2 - Add support for street & house numbers 🛠

The application holds a list of postal codes and city names. Your task is to add streets and house numbers to it such as _Untermoosstrasse 36, 8047 Zurich_ contains information such as

- Street name
- House number

Make sure a street & house number always is assigned to a postal code. Expose a list of streets with their postal code on the REST API at `/api/v1/streets`.

### Assignment 3 - Prepare a brief presentation 💡

In the 2nd interview you present your solution and explain your design decisions. Be prepared for a brief Q&A.

## Once you are done 🎓

When you are done with your work please raise a pull request. In order to match the PR with your application please provide your full name as a PR comment. Thank you.

## Questions ❔

If you have any questions please do not hesiate to contact me at silvio@onstructive.ch