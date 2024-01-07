# Mobile UI test automation project for [Wikipedia Android App](https://github.com/wikimedia/apps-android-wikipedia/)

## Summary
+ [About the project](#about)
+ [Tools and Technologies](#tools)
+ [How to run](#launch)
    + [Launch tests on emulator](#local)
    + [Launch tests on browserstack](#remote)

<a id="about"></a>
## About the project
The project consists of UI Mobile tests. A brief list of interesting facts:
- [x] `Page object` pattern for app screens
- [x] Config with `Owner` library
- [x] Different configuration files for test running depending on build parameters
- [x] Autotests as test documentation
- [x] Run tests by `Tags` or all at once

<a id="tools"></a>
## Tools and Technologies
<a href="https://www.java.com/en/"><img src="media/logo/Java_logo.png" width="90"/></a>
<a href="https://gradle.org/"><img src="media/logo/Gradle.png" width="90"/></a>
<a href="https://github.com/"><img src="media/logo/GitHub.png" width="90"/></a>
<a href="https://appium.io/"><img src="media/logo/Appium.svg" width="90"/></a>
<a href="https://developer.android.com/"><img src="media/logo/AndroidStudio.svg" width="90"/></a>
<a href="https://www.browserstack.com/"><img src="media/logo/Browserstack.svg" width="90"/></a>
<a href="https://www.jetbrains.com/idea/"><img src="media/logo/IntelliJ_IDEA.png" width="90"></a>
<a href="https://junit.org/junit5/"><img src="media/logo/JUnit5.png" width="90"/></a>
<a href="https://www.jenkins.io/"><img src="media/logo/Jenkins.png" width="90"/></a>
<a href="https://github.com/allure-framework/"><img src="media/logo/AllureReports.png" width="90"/></a>
<a href="https://qameta.io/"><img src="media/logo/AllureTestOps.svg" width="90"/></a>
<a href="https://telegram.org/"><img src="media/logo/Telegram.png" width="90"/></a>

The project is written in `Java` using `Selenide` framework.
- `Gradle` - is used as a build automation tool.
- `JUnit5` - to execute tests.
- `Appium, Android Studio` - for running tests locally on machine
- `Browserstack` - for running tests remotely.
- `Jenkins` - is CI/CD for running tests remotely.
- `Telegram Bot` - for test results notifications.
- `Allure Report` - for test results visualisation.
- `Allure TestOps` - as Test Management System.

<a id="launch"></a>
## How to run
<a id="local"></a>
### Launch tests on emulator
> [!IMPORTANT]
> Be sure you have installed: Java, Gradle and Node.js. It is also important to set up Appium server, Appium UIAutomator2, Android Studio.

Tests are divided by different features, it is possible to run not only all tests but also by feature tags.  
Available feature test runs are:
- onboarding_tests
- search_tests

Use the following command to run all tests:
```
gradle clean test -Denv_test_run=emulator
```
<a id="remote"></a>
### Launch tests on browserstack
> [!IMPORTANT]
> Browserstack requires unique user credentials. Also, before running tests, download the latest version of app and upload to the browserstack. Get unique app id and set in the configuration file. 

Use following command to run all tests in the browser stack
```
gradle clean test -Denv_test_run=browserstack
```
All configurations are described in the `browserstack.properties` and `emulator.properties` files.  
If needed configurations could be changed in those files.

<a id="jenkins"></a>
## Run in Jenkins

<a id="telegram"></a>
## Telegram Notifications

<a id="allure-report"></a>
## Report in Allure Report

<a id="allureTO"></a>
## Allure TestOps Integration

<a id="video"></a>
## Video example of test pass