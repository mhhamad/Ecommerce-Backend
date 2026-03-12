## E commerce Backend Spring Boot Project : <br>

## Project descreption
This Spring Boot backend application is designed to manage users and products for and e commerce application
It provides a RESTful API to handle CRUD operations and user authentication, making it easy to integrate with any frontend.

## EndPoints

![workflow](https://github.com/mhhamad/Ecommerce-Backend/blob/main/assets/swaggerUI.png)

## Features

- **User Management**: Create, read, update, and delete users.
- **Login Authentication**: Users can login securely with email and password.  
- **Product Management**: Create, read, update, and delete products.  
- **Password Security**: Passwords are stored securely using hashing.  
- **OpenAPI Documentation**: API documentation available via `/v3/api-docs`.  
- **Database Integration**: Integrated with PostgreSQL for persistent storage.  
- **RESTful API Endpoints**: Easy integration with frontend applications.  
- **Automated Testing with JUnit 5 (Jupiter)**: Ensures reliable and maintainable tests for application functionality.

## Technologies Used

- **Spring Boot**: Backend framework for building Java-based web applications.  
- **PostgreSQL**: Relational database for storing user and product data.  
- **OpenAPI 3.1**: API documentation and testing.  
- **IDE/Tool**: VSCode for development.  

## Installation :

1. Clone the repository : $ git clone https://github.com/mhhamad/Ecommerce-Backend.git <br>

2. Open the file in VSCode <br>
     
3. Make sure you are in the Ecommerce-Backend directory. <br>

4. Configure the database connection is application.properties (check the Database section for more information). <br>

5. Run the project (by running main method which is SpringBoot.java) OR `mvn spring-boot : run` in the terminal . <br>

6. Open http://localhost:8080/swagger.ui/index.html in any browser. <br>

  

## Database :

Postgre is used as the database for this project. 
The database connection can be configured in the application.properties file, with the appropriate values for the following properties: <br>

spring.datasource.url = jdbc:postgresql://localhost:5432/[Your Database Name]
spring.datasource.username = [Your username] 
spring.datasource.password = [Your password] 
spring.jpa.hibernate.ddl-auto = update


## WorkFlow :

![workflow](https://github.com/mhhamad/Ecommerce-Backend/blob/main/assets/workFlow.png)


