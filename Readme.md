**Test Automation Framework**

A scalable and modular Test Automation Framework built with **Java 11** and **TestNG**.

It supports parallel execution, data-driven testing from various sources like **CSV, Excel and JSON**

It can be executed both locally and on cloud using **LambdaTest**.

It Includes features such as headless mode, CLI test execution, screenshot capture on failure, rich reporting using **Extent Reports**, and detailed logging using **Log4j**.


## Author

- [@Zulminan](https://github.com/Zulminan)
- EmailAddress: ahmedzulminan@gmail.com


## 🔗 Links
[![portfolio](https://img.shields.io/badge/my_portfolio-000?style=for-the-badge&logo=ko-fi&logoColor=white)](https://github.com/Zulminan)

[![linkedin](https://img.shields.io/badge/linkedin-0A66C2?style=for-the-badge&logo=linkedin&logoColor=white)](https://www.linkedin.com/in/zulminanahmed786/)



## 🚀 About Me
Hi, My name is Zulminan Ahmed and I am a Test Automation Engineer with 4 years of experience in automating web and API testing processes. My core expertise lies in building robust automation frameworks using Java, with strong proficiency in Selenium WebDriver for UI testing and RestAssured for API automation.

I have hands-on experience in:

Designing scalable and modular test automation frameworks

Data-driven testing with JSON, Excel (Apache POI), and CSV (OpenCSV)

Parallel test execution using TestNG

Cloud execution with LambdaTest

Headless testing for performance optimization

Generating insightful test reports and logs using ExtentReports and Log4j

I enjoy solving real-world testing challenges and continuously strive to enhance the quality and reliability of software through automation.

## Prerequisites
Before running this framework, ensure the following software is installed on your system:

- **Java 11** - Make sure Java is installed and the JAVA HOME environment variable is set.
- **Maven** - Ensure Maven is installed and added to the system path.
- Download Link: https://maven.apache.org/download.cgi

## Features
- **Data-Driven Testing:** Using OpenCSV, Apache POI, and Gson for reading test data fron CSV and Excel files and JSON.
- **Cross-Browser Testing:** Supports running tests on different browsers.
- **Headless Mode:** Faster execution by running tests in headless mode.
- **Cloud Testing:** Integrated with LambdaTest to run tests on the cloud.
- **Logging:** Uses Log4j for detailed logs.
- **Reporting:** Generates detailed reports using Extent Reports.

## Technologies Used
- Java 11
- TestNG
- OpenCSV
- Gson
- Apache POI
- Faker
- LambdaTest
- Log4j
- Extent Reports

## Installation

**Clone the repository:**
```bash
 git clone https://github.com/Zulminan/Test-Automation-Framework-2.0.git

 cd Test-Automation-Framework-2.0
```

**Running Test On LambdaTest:**
```bash
 mvn test -X -Dbrowser=chrome -DisLambdaTest=true -DisHeadless=false
```

**Running Test on chrome browser on local machine in Headless mode :**
```bash
 mvn test -X -Dbrowser=chrome -DisLambdaTest=false -DisHeadless=true
```

## Reports
- Reports: After execution, a detailed HTML report will be generated at /report.html.

The report contains information on test cases executed,passed,failed,and skipped,along with screenshots for failed tests.

## Logs
Logs are created during the test execution and stored in the ./logs/ directory. 

## Integrated the project with Github Actions
This Automation Framework is Integrated with Github Actions. The test will be executed at 11:30PM IST every single day. 

The reports will be archived in gh-pages branch. You can view the HTML reports at :
https://zulminan.github.io/Test-Automation-Framework-2.0/report.html
    
