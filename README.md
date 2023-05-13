<br />
<p align="center">

 <h1> Washing Machine Management Backend </h1>
<!-- ABOUT THE PROJECT -->
<h3>About The Project</h3>

This is a Backend of web app which allows users to do CRUD actions on various entities. 
It is developed using Spring Boot, Java, JWT, Spring Security and Postgres.

**How to use?:**
* You can Clone this repo : https://github.com/airbus-aerothon-5-0/washing-machine-backend.git.
* Set-up the local environment and then we can test with postman and posgresql.
* Add application.properties file in project_path/src/main/resources with following parameters.

server.port = 8080 <br />
spring.datasource.url= <br />
spring.datasource.username=<br />
spring.datasource.password=<br />
spring.datasource.driver-class-name=org.postgresql.Driver<br />
spring.jpa.database-platform=org.hibernate.dialect.PostgreSQLDialect<br />
spring.jpa.hibernate.ddl-auto=<br />
spring.jpa.show-sql=<br />
spring.jpa.properties.hibernate.format_sql=<br />
jwt.token.validity=<br />
jwt.token.secret=<br />
public.urls =   /api/v1/auth/login,/api/v1/auth/register<br />

### :hammer:Built With
* This is written in Java using Spring BOOT.
* It has implementation of spring secutity for authentication using JWT.

</p>


### ER Diagram

![Untitled](https://github.com/airbus-aerothon-5-0/washing-machine-backend/assets/64781854/f7f6719c-a896-445e-99b3-2e138c9deff9)
