# people-registry

This is the initial phase of the POC of a people registry. 

## What's used in this project
- Java 17
- JUnit 4

## Functionalities available in the service
1) Register a person.
2) Retrieve a specific person by the social security number.
3) Retrieve the elder child's name of a person.

## Assumptions
1) Validations will be added in the REST endpoints or controllers. 
2) The service method ```getElderChild``` only returns the name. Social security number of the parent could be attached in this result finally at the REST endpoint.

Assumptions are commented in detail in the code.

## Integration tests
Run the ```PersonServiceImplTest``` test class.
