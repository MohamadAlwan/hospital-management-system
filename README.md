# Sample REST project for hospital-management-system:
This project consist of 20 APIs that are for the four core elements(Patent, Doctor, Department, Medicinne) in any hospital-management-system
you can see the uml class diagram for the elements in system bellow:
![Untitled](https://github.com/MohamadAlwan/hospital-management-system/assets/91935195/fc1cdb4a-27c5-484c-9f33-619c05b40604)

For each element in the Class Diagram attached above, five APIs are provided for each of these elements as follows:
- view all records 
- view exact record
- add(or create) new record
- maintain any existing record
- remove(or delete) any record

# Testing:
Postman/SOAPUI will be good option to use.
also you can find a file name Postman test collections contain some testing for this project for all elements

# package the project:
.\mvnw clean package -DskipTests

# To run the project:
.\mvnw spring-boot:run

# License:
https://choosealicense.com/licenses/mit/
