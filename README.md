# camelrestjdbcexample
Example web application provides REST API that make available to execute CRUD operations with an "User" entities, that are persisted in the in-memory Derby database. 
REST API is configured in com.peterservice.example.camel.restjdbc.ExampleUsersRouteConfiguration class. 

U can to start that app by typing **mvn jetty:run** at your console (be sure that 28080 port is free).
After that U can to get some list of users by executing the GET method: http://localhost:28080/rs/users

App is similar to [camel-example-restlet-jdbc](http://mvnrepository.com/artifact/org.apache.camel/camel-example-restlet-jdbc) (and is based on its code)

# Allure 2 Example
1. Install Allure with Scoop [installation instrictions](https://docs.qameta.io/allure/)
scoop install allure
2. Type "mvn test" to run tests. This command generates the allure results into .\allure-results\ folder
3. Type "allure serve .\allure-results" command in project root directory. Which generates a report in temporary folder from the data found in the provided path and then creates a local Jetty server instance, serves generated report and opens it in the default browser