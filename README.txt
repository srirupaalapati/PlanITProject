Instructions for executing the tests.
Download the project from GitHub and Import it into Eclipse IDE.
Add the dependant JAR files for execution(Selenium 3.141.59 and Apache POI 4.0.1)
Add the TestNG library to the project
OPTIONAl step to modify test data: Go to testdata/FacebookSignUpData spreadsheet and modify the data as per your requirement. 
Go to src/tests/FacebookSignUpTest. java and Run as TestNG Test
The test will enter details on the Facebook sign up page and click Sign Up button so it moves the Enter code from Email screen. 
Asserting whether the Continue button is available to see that the test moved to next screen.
Please look at the execution report from test-output folder emailable-report.html
