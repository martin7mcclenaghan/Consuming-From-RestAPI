# Spring Boot Demo Application

This application experiments with data from public APIs, using Java 11 and Spring 2.1.6.

This project is mostly to demonstrate my understanding of Spring Boot, including Web and Data JPA modules.
It also consumes data from a public API (JSON Placeholder) as I am aware this is often used as an interview challenge
so I was keen to experiment with this.

Complete list of technologies:

- Use of Java
- Use of Spring Boot
- Use of Spring Boot Web
- Use of Spring Boot Data JPA
- Use of Thymeleaf
- Use of Bootstrap

My current task is to replace the hard coded Strings used to name Model
Attributes and Get/Post mappings with constants. This will make the application 
easier to maintain moving forward as changes can be made in one place.
This will be done in the mappings package which I am still working on.

I could also decouple the thymeleaf logic from the html but I am dubious as 
to the usefulness of this as I find it can make the templates more difficult to
follow and maintain.
