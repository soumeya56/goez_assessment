TravelSmile App - Local Setup and Access
This is the backend application for TravelSmile App. Below are the steps to run the application locally and access the necessary resources such as Swagger UI and H2 Database console.

Prerequisites
Before running the application, ensure that you have the following installed on your local machine:

Java (JDK 11 or later)

Maven (if you're building the project manually)

-------------------------------------------------------------------------------------------------------------------------------------------------------------------------
Accessing Swagger UI
Swagger UI is automatically set up for your RESTful APIs. Follow these steps to access it:

Open a browser.

Go to http://localhost:8080/swagger-ui.html.

You should see the Swagger UI displaying all the available API endpoints.
--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
Accessing H2 Database Console
To access the H2 database console:

Open a browser.

Go to http://localhost:8080/h2-console.

Login Credentials:
JDBC URL: jdbc:h2:mem:travelsmile

Username: sa

Password: (Leave empty)

This will open the H2 database console where you can view and manage your database.
-----------------------------------------------------------------------------------------------------------------------
Prerequisites
Before starting with the application, you need to ensure that roles are inserted into the database. This is necessary because roles are referenced by other entities, such as Traveler, during their creation.

Insert Roles into the Database
Insert the roles first using the following SQL queries .
INSERT INTO roles (name) VALUES ('ROLE_USER');
INSERT INTO roles (name) VALUES ('ROLE_ADMIN');


----------------------------------------------------------------------------------------------------------------------------------
Additional Information
API Documentation: All available API endpoints can be accessed via Swagger UI (http://localhost:8080/swagger-ui.html).

H2 Database: The application uses an in-memory H2 database for development purposes, and the console is available at http://localhost:8080/h2-console.



