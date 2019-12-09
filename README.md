# AutomationPractice

This is Serenity Cucumber test automation framework to automate Automation Practice application. This project is built on maven in Java, with tools Serenity and Cucumber.  
 
**To setup the project, follow below steps:**

1. Clone the Git repository to your local machine.
2. Ensure you have Java 8 and IDE (Eclipse or IntelliJ) installed.
3. Import the project as maven project in IDE and wait until all dependancies downloaded.

**To run the test:**

Open command prompt or terminal window in IDE, then in the project root path run the below command:

_mvn clean verify serenity:check -Dcucumber.options="--tags @Demo" -Denv=test_

