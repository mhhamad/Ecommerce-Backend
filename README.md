## E commerce Backend Spring Boot Project : <br>


## Project descreption
=> This Spring Boot backend application is designed to manage users and products for and e commerce application
It provides a RESTful API to handle CRUD operations and user authentication, making it easy to integrate with any frontend.

---

## EndPoints

![workflow](https://github.com/mhhamad/ECOMMERCE-BACKEND/assets/workflow.png)

## Features

- **User Management**: Create, read, update, and delete users.
- **Login Authentication**: Users can login securely with email and password.  
- **Product Management**: Create, read, update, and delete products.  
- **Password Security**: Passwords are stored securely using hashing.  
- **OpenAPI Documentation**: API documentation available via `/v3/api-docs`.  
- **Database Integration**: Integrated with PostgreSQL for persistent storage.  
- **RESTful API Endpoints**: Easy integration with frontend applications.  
- **Testing using JUnit 5 (Jupiter)** : for automate testing 

---

## Technologies Used

- **Spring Boot**: Backend framework for building Java-based web applications.  
- **PostgreSQL**: Relational database for storing user and product data.  
- **OpenAPI 3.1**: API documentation and testing.  
- **IDE/Tool**: VSCode for development.  

---

## Installation :

1. Clone the repository : $ git clone https://github.com/SuhasKamate/Business_Management_Project.git <br>

2. Open the file in VSCode <br>
     
3. Make sure you are in the Ecommerce-Backend directory. <br>

//dir image 
![packageExplorer](https://github.com/SuhasKamate/Business_Management_Project/assets/126138738/3ea1eb7f-8e49-4b76-96e4-798b6b8e8715)


4.Configure the database connection is application.properties (check the Database section for more information). <br>

5.Run the project (by running main method is SpringBoot.java) OR `mvn spring-boot : run` in the terminal . <br>

6.Open http://localhost:8080/swagger.ui/index.html in any browser. <br>

7.Now your tables will be created in the database. <br>
   

## Database :

Postgre is used as the database for this project. 
The database connection can be configured in the application.properties file, with the appropriate values for the following properties: <br>

spring.datasource.name=[Your Database Name] <br>
spring.datasource.url=jdbc:mysql://localhost:3306/[Your Database Name] <br>
spring.datasource.password=[Your password] <br>
spring.datasource.username=[Your username] <br>
spring.jpa.hibernate.ddl-auto=update <br>


## WorkFlow :

![workflow](https://github.com/mhhamad/ECOMMERCE-BACKEND/assets/workflow.png)


