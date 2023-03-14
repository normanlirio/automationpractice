# Automation Practice

## Objectives
- To demonstrate skills in Automation using Java, TestNG and Selenium Framework
- To demonstrate skills in Object Oriented Programming
- To demonstrate skills in Version control using Git
- To demonstrate skills in setting up Environment Variables and CICD Integration using Github actions

## URL
In order to reach the objectives, this website is used for implementation. https://automationexercise.com/

## Tech Stack
- Java
- Selenium WebDriver
- TestNG
- Git (Github Actions)
- node.js

## Libraries/ 3rd party
- commitizen => https://github.com/commitizen/cz-cli
- Monte Screen Recorder => https://mvnrepository.com/artifact/com.github.stephenc.monte/monte-screen-recorder/0.7.7.0

## Pre-requisite
1. Install JDK 19

## How to use
1. Clone this repository
2. Open the project
3. Open a new terminal inside the IDE you are using
4.  Run mvn dependency:resolve to install maven dependencies
5. Run this command
```mvn -f pom.xml -DtestEnvVariables='env.dev.properties' -DtestUsername='yourusername@username.com' -DtestPassword='yourpassword' -DwebDriver='chrome' -DloginSpec='test-suite/testsuite.xml' clean test```
