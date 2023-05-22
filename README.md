# Sample REST project for hospital-management-system:
This project consist of 20 APIs that are for the four core elements(Patent, Doctor, Department, Medicinne) in any hospital-management-system  
you can see the uml class diagram for the elements in system bellow:  
![Untitled](https://github.com/MohamadAlwan/hospital-management-system/assets/91935195/fc1cdb4a-27c5-484c-9f33-619c05b40604)

For each element in the Class Diagram attached above, five APIs are provided for each of these elements as follows:
- view all records 
- view exact record
- add(or create) new record
- maintain(or update) any existing record
- remove(or delete) any record

explain the APIs for each element(or resource) bellow:
# Department
| HTTP Method | URL Path | Status Code | Description | Request | Response |
| --- | --- | --- | --- | --- | --- |
| GET | /hms/department | 200(OK) | Get all Departments | | [ { "id": 1, "name": "mohamad elwan", "address": "Ramallah", "phoneNumber": 5978755, "specialization": "brain surgery" },
{ "id": 2, "name": "mohamad elwan", "address": "Ramallah", "phoneNumber": 15, "specialization": "sss" } ] | 
| GET | /hms/department/{id} | 200(OK) | Get Department by id | | | 
| POST | /hms/department | 201(Created) | Create new Department | {depName} | | 
| PUT | /hms/department/{id} | 200(OK) | update existing Department with id | {depName} | |
| DELETE | /hms/department/{id} | 200(OK) | Delete Department by id | | Deleted successfully | 

# Doctor
| HTTP Method | URL Path | Status Code | Description | Request | Response |
| --- | --- | --- | --- | --- | --- |
| GET | /hms/doctor | 200(OK) | Get all Doctors | | | 
| GET | /hms/doctor/{id} | 200(OK) | Get Doctor by id | | | 
| POST | /hms/doctor | 201(Created) | Create new Doctor | {name} {address} {phoneNumber} {specialization} | | 
| PUT | /hms/doctor/{id} | 200(OK) | update existing Doctor with id | {name} {address} {phoneNumber} {specialization} | |
| DELETE | /hms/doctor/{id} | 200(OK) | Delete Doctor by id | | Deleted successfully |

# Patent
| HTTP Method | URL Path | Status Code | Description | Request | Response |
| --- | --- | --- | --- | --- | --- |
| GET | /hms/patent | 200(OK) | Get all Patents | | | 
| GET | /hms/patent/{id} | 200(OK) | Get Patent by id | | | 
| POST | /hms/patent | 201(Created) | Create new Patent | {name} {address} {phoneNumber} {age} | | 
| PUT | /hms/patent/{id} | 200(OK) | update existing Patent with id | {name} {address} {phoneNumber} {age} | |
| DELETE | /hms/patent/{id} | 200(OK) | Delete Patent by id | | Deleted successfully |

# Medicine
| HTTP Method | URL Path | Status Code | Description | Request | Response |
| --- | --- | --- | --- | --- | --- |
| GET | /hms/medicine | 200(OK) | Get all Medicine | | | 
| GET | /hms/medicine/{id} | 200(OK) | Get Medicine by id | | | 
| POST | /hms/medicine | 201(Created) | Create new Medicine | {name} {quantity} {price} {description} | | 
| PUT | /hms/medicine/{id} | 200(OK) | update existing Medicine with id | {name} {quantity} {price} {description} | |
| DELETE | /hms/medicine/{id} | 200(OK) | Delete Medicine by id | | Deleted successfully |

# Testing:
Postman/SOAPUI will be good option to use.  
also you can find a file name [Postman test collections](https://github.com/MohamadAlwan/hospital-management-system/tree/master/Postman_test_colectionss) contain some testing for this project for all elements

# package the project:
```ruby
.\mvnw clean package -DskipTests
```
# To run the project:
```ruby
.\mvnw spring-boot:run
```
# License:
[MIT](https://choosealicense.com/licenses/mit/)
