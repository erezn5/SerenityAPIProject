# Serenity API Automation Project

## Getting Started

Those instructions will guide you through the project and understand the different components which construct the project as a whole.

The project is divided into 2 main parts:

	1. Steps (src/test/java/steps/APISteps.java):
	This class defines all the steps being used in the project.
	
	2. Tests (src/test/java/testcases/*):
	This package defines all the actual tests.
	
The project is using the following csv file to inject parametes into the project:

	users.csv (src/test/resources/users.csv)
	
pom.xml defines the project dependencies and managing the project in order to create rich HTML report (serenity reporting system is being used). 

For each test java class there is a use of the APISteps java class:

For example let's look at the test class ``GetUserTest``:
We use the decorator `@Steps` to indicate we are using `APISteps` as our test steps use-case.
We use the decorator `@Title` to indicate the title of the test step (and this is how it will appear in the HTML test report). 
We use the decorator `@Test` to indicate the method is a test case (use case). 
Then inside the method `getUserTest` we can mention the steps we want to use using the steps from the `APISteps` class that we declared earlier. 

### For additional information please refer to the official Serenity Website documentation:
	http://www.thucydides.info/#/
