Designed based on Miroservice Architecture but not compeletely.

Instructions for running the Application services: 

* Download each project and open it with the IntelliJ IDEA community edition, you can find it in the below link. 
https://www.jetbrains.com/idea/download/
 
* After the opening projects in IntelliJ run the Maven install command in Maven section. If in your local machine Maven configured properly you can create a Jar file from the command line too via the following commands:

 mvn clean install 

The mentioned instruction will create a Jar file that you can find it in the target folder. 

* Running a Jar file via command line:

 java -jar jarfilename.jar

* For testing make sure both applications running properly. 

### Application API URL Addresses:

# employee service:
http://localhost:9005/api/v1/employees

# company-service 
http://localhost:9002/api/v1/companies/





