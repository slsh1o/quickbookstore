# quickBookstore - Simple and light bookstore
## Set up
First of all you should create a new PostgreSQL database with name 'quickbookstore'
### Set up application.properties file
Then set username for user you have chosen in previous step and type password.
```bash
#Db connection
spring.datasource.url=jdbc:postgresql://localhost/quickbookstore
spring.datasource.username=
spring.datasource.password=
```
## Usage
Now generate a WAR file and deploy it or just run application in your preferred IDE
### Try it
The application can now be accessed at http://localhost:8080/
