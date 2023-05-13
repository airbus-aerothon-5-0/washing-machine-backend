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

*server.port = 8080
*spring.datasource.url=
*spring.datasource.username=
*spring.datasource.password=
*spring.datasource.driver-class-name=org.postgresql.Driver
*spring.jpa.database-platform=org.hibernate.dialect.PostgreSQLDialect
*spring.jpa.hibernate.ddl-auto=
*spring.jpa.show-sql=
*spring.jpa.properties.hibernate.format_sql=
*jwt.token.validity=
*jwt.token.secret=
*public.urls =   /api/v1/auth/login,/api/v1/auth/register

### :hammer:Built With
* This is written in Java using Spring BOOT.
* It has implementation of spring secutity for authentication using JWT.

</p>


### ER Diagram

![Untitled](https://github.com/airbus-aerothon-5-0/washing-machine-backend/assets/64781854/f7f6719c-a896-445e-99b3-2e138c9deff9)
