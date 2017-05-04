# Demo SpringBoot Web Service With an embedded Database

* perform a ./gradlew clean build bootRun 
* Open a browser and got to URL http://localhost:8080/findCustomers/DAN

You will notice the two files schema.sql and data.sql in the resources directory.  This is how the tables and initialized data are handled.  SpringBoot looks for these in the resources dir.

Note the property management.security.enabled: false in the application.properties.  This allows full access to the actuator endpoints.

