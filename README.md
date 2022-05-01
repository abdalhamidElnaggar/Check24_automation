# check24 QA Automation Task
RestAPIs test automation and Web UI Test Automation

## Technologies

A list of technologies used within the project:
* [Maven](https://maven.apache.org/)
* [selenium](https://www.selenium.dev/): Version 4.1.4
* [TestNG](https://testng.org/doc/)
* [RestAssured](https://rest-assured.io/)
* [JAVA](https://www.java.com/en/)


## run the tests

* Download or clone the project
* load all maven dependencies 
* run testng.xml file 

## Web UI  tests
* validate on specific cookie existence 
* validate on error messages existence when users leave the form empty
* validate that the user is redirected to a new form with no error after adding all required data
* all tests are in one flow as requested but can be broke down to multiple atmoic tests if needed


## RestAPIs endpoints tests
* https://finanzen.check24.de/accounts/r/frs/productInfo/kreditkarte/abcd -> resource is not found validate on response code and body message and header content type 
* https://finanzen.check24.de/accounts/r/frs/productInfo/kreditkarte/20007 -> found resource validate on response code 200 and product id and header content type ( can be extended for other body data)
* https://finanzen.check24.de/accounts/r/frs/productInfo/kreditkarte/5456 -> no content is returned , validate on status code 204 

## Reporting
* allure reports found at allure-results folder -> run allure serve [allure-result] path to generate
* testng reports found at test-reports directory -> open emailable-report.html or index.html
