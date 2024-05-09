# Android Test Automation Project for [Wikipedia](https://www.wikipedia.org/)
<p align="center">
  <img src="images/logo/wikipedia.png" width="480" height="270"/>
</p>

## **Contents:** ##

* Technologies and tools

* Examples of automated test cases

* Build in Jenkins

* Run from Terminal

* Allure report

* Integration with Allure TestOps

* Integration with Jira

* Telegram notification with bot

* Test execution video examples


---------
## <a name="Technologies and tools">**Technologies and tools:**</a>

<p align="center">
<a href="https://www.w3schools.com/java/"> <img src="https://cdn.jsdelivr.net/gh/devicons/devicon@latest/icons/java/java-original.svg" title="Java" alt="Java" width="40" height="40"/> </a> 
<a href="https://www.jetbrains.com/idea/"> <img src="https://cdn.jsdelivr.net/gh/devicons/devicon@latest/icons/intellij/intellij-original.svg" title="IntelliJ Idea" alt="IntelliJ Idea" width="40" height="40"/> </a> 
<a href="https://www.android.com/"> <img src="https://cdn.jsdelivr.net/gh/devicons/devicon@latest/icons/android/android-original.svg" title="Android" alt="Android" width="40" height="40"/> </a> 
<a href="https://developer.android.com/studio"> <img src="https://cdn.jsdelivr.net/gh/devicons/devicon@latest/icons/androidstudio/androidstudio-original.svg" title="Android Studio" alt="Android Studio" width="40" height="40"/> </a> 
<a href="https://git-scm.com/"> <img src="https://cdn.jsdelivr.net/gh/devicons/devicon@latest/icons/git/git-original.svg" title="Git" alt="Git" width="40" height="40"/> </a> 
<a href="https://junit.org/junit5"> <img src="https://cdn.jsdelivr.net/gh/devicons/devicon@latest/icons/junit/junit-original.svg" title="JUnit5" alt="JUnit5" width="40" height="40"/> </a>
<a href="https://rest-assured.io/"> <img src="images/logo/rest_assured.png" title="REST-assured" alt="REST-assured" width="40" height="40"/> </a>
<a href="https://selenide.org"> <img src="images/logo/selenide.png" title="Selenide" alt="Selenide" width="40" height="40"/> </a>
<a href="https://www.browserstack.com/"> <img src="https://cdn.jsdelivr.net/gh/devicons/devicon@latest/icons/browserstack/browserstack-original.svg" title="Browserstack" alt="Browserstack" width="40" height="40"/> </a>
<a href="https://appium.io/"> <img src="images/logo/appium.png" title="Appium" alt="Appium" width="40" height="40"/> </a>
<a href="https://gradle.org"> <img src="https://cdn.jsdelivr.net/gh/devicons/devicon@latest/icons/gradle/gradle-original.svg" title="Gradle" alt="Gradle" width="40" height="40"/> </a>
<a href="https://allurereport.org/"> <img src="images/logo/allure_report.png" title="Allure report" alt="Allure report" width="40" height="40"/> </a>
<a href="https://qameta.io/"> <img src="images/logo/allure_testops.png" title="Allure TestOps" alt="Allure TestOps" width="40" height="40"/> </a>
<a href="https://www.jenkins.io"> <img src="https://cdn.jsdelivr.net/gh/devicons/devicon@latest/icons/jenkins/jenkins-original.svg" title="Jenkins" alt="Jenkins" width="40" height="40"/> </a>
<a href="https://www.atlassian.com/software/jira"> <img src="https://cdn.jsdelivr.net/gh/devicons/devicon@latest/icons/jira/jira-original.svg" title="Jira" alt="Jira" width="40" height="40"/> </a>
</p>

- The mobile autotests was written in **Java** for **Android** application.
- **Gradle** was used as a builder.
- **JUnit 5**, **Appium** and **Selenide** frameworks were used as test frameworks.
- **UIAutomator2** was used as an Android driver.
- Tests could run on real device, emulator and has integration with **Browserstack** cloud mobile testing platform.
- **Rest-assured** was used for interaction with Browserstack API.
- For remote run, a job in **Jenkins** with **Allure report** generation and sending the results to **Telegram** using a bot is implemented.
- Integration with **Allure TestOps** and **Jira** is implemented
