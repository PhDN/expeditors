# Expeditors Technical Assignment
**Applicant: Phuong Nguyen**

## About:
This repository contain a design solution to a challenge of taking a series of CSV-format household data containing a person's first and last name, their address, and age, as input, and output each household and the number of occupants, followed by: each person's first name, last name, address and age, sorted by last name then first name where the occupant(s) is older than 18.

## Approach
Using an Object-Oriented Programming approach, we can create a Person and Address object to differentiate between each "person" and each "address". 

To differeniate between each person, we assume that one person is the same as another person if they share the same first and last name, address, and age. To differentiate between each address, we assume that one address is the same as another address if they share the same 'address' (building number and street name), city, and state.

We first process the CSV-format input line by line, cleaning each line by spliting and trimming and normalizing to individual strings, to correspond to first name, last name, address, city, state, and age fields that can be used to construct each Person and their associated address.

We store each household information by mapping each address with people associated with that address, and operate on that mapping to sort each person by their last name, then first name, and filtering to include only people older than 18 years of age before outputing the results to an output file (or print out to terminal).

The results are stored in ['app/src/main/resources/output.txt'](app/src/main/resources/output.txt).

## Run the Code
To build (assemble and test) the project, execute: ```gradlew build```

To run the project as a JVM app, execute:  ```gradlew run```

To run the test suites, execute: ```gradlew test```

## Directory Structure

**Code**
- [./app/src/main/java/expeditors/](./app/src/main/java/expeditors/)
    - [Address.java](./app/src/main/java/expeditors/Address.java)
    - [App.java (main)](./app/src/main/java/expeditors/App.java)
    - [Person.java](./app/src/main/java/expeditors/Person.java)

**Test Suite**
- [./app/src/main/java/expeditors/](./app/src/test/java/expeditors/)
    - [Address.java](./app/src/test/java/expeditors/AddressTest.java)
    - [Person.java](./app/src/test/java/expeditors/PersonTest.java)