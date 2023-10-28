# ✴️ Selenium Java Framework

Test Automation Framework built with Selenium and Java for browser testing.
    
## Installation Steps:
* Clone this repo
* mvn install
* mvn test

## Steps To Follow:
* Create a maven project, download basic dependencies, selenium-java and testng. Other dependencies will be added later
* Create Base class, Global Env properties file.
* Create Base Test
* Implement PageObject model - create com.pageObjects and add pageObject classes to store objects of that page
* Parameterizing test data with help of TestNG DataProvider
* Assertions
* Create testng.xml file and create a testng suite containing all the tests.
* Add @BeforeTest and @AfterTest methods
* Integrate testng.xml into maven pom.xml. So that when use maven test to all test cases.
* Adding logs using log4j
* Modify testng.xml to create individual tests instead of all tests wrapped into a single test tag
* Initialize a local web-driver instance to support parallel execution
* Add parallel='tests' attribute in testng.xml to run tests parallel
* Add screenshots on failures using TestNG Listeners
* Add TestNG listener information to testng.xml file
* Add extent reports to TestNG listener
* Making f/w and extent reports thread safe using ThreadLocal<ExtentTest> class



