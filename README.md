# Android Test Automation Project for [Wikipedia](https://www.wikipedia.org/)
<p align="center">
  <img src="images/logo/wikipedia.png" width="480" height="270"/>
</p>

## **Contents:** ##

* <a href="#tools">Technologies and tools</a>

* <a href="#cases">Examples of automated test cases</a>

* <a href="#jenkins">Build in Jenkins</a>

* <a href="#console">Run from Terminal</a>

* <a href="#allure">Allure report</a>

* <a href="#testops">Integration with Allure TestOps</a>

* <a href="#jira">Integration with Jira</a>

* <a href="#telegram">Telegram notification with bot</a>

* <a href="#video">Test execution video examples</a>


---------
<a id="tools"></a>
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

- The mobile autotests were written in **Java** for **Android** application.
- **Gradle** was used as the builder.
- **JUnit 5**, **Appium** and **Selenide** frameworks were used as test frameworks.
- **UIAutomator2** was used as an Android driver.
- Tests could run on a real device, emulator and had integration with the **Browserstack** cloud mobile testing platform.
- **Rest-assured** was used for interaction with the Browserstack API.
- For remote run, a job in **Jenkins** with **Allure report** generation and result sending to **Telegram** using a bot has been implemented.
- Integration with **Allure TestOps** and **Jira** has been established.

------
<a id="cases"></a>
## **Examples of automated test cases:**
**Get started tutorial**
- ✅ Skip the tutorial by system BACK  
- ✅ Skip the tutorial by screen button BACK  
- ✅ Successfully passed tutorial

**History feature**
- ✅ Successfully save article to history list after opening the article page 
- ✅ Checking that the article isn't saved to the history list if the article's page wasn't opened
- ✅ Successfully remove article from history by swipe
- ✅ Successfully clear all history
- ✅ Checking that the history wasn't cleared, if the user didn't agree in the dialog

----
<a id="jenkins"></a>
## Build in Jenkins ([link](https://jenkins.autotests.cloud/job/C24-egorovaa-mobiletests/))
<p align="center">  
<a href="https://jenkins.autotests.cloud/job/C24-egorovaa-mobiletests//"><img src="images/screen/jenkins.png" alt="Jenkins" width="950"/></a>  
</p>

### **Jenkins build options:**

- `USER_NAME` 
- `ACCESS_KEY`
- `COMMENT` (default - Android wiki api test results)

----
<a id="console"></a>
## Run from Terminal

**Local launch with Browserstack**
```bash
clean test
-DdeviceHost=browserstack
-DuserName={userName from you browserstack account}
-DaccessKey={accessKey from you browserstack account}
-DdeviceName=Samsung Galaxy M52
-DplatformVersion=11.0
```
more information about Browserstack account and credentials [here](https://app-automate.browserstack.com/dashboard/v2/quick-start/setup-browserstack-sdk)

**Local launch on emulator or real(local) device**
```bash
clean test
-DdeviceHost=emulator/local
-Dudid=emulator-5554/EFJNFDC3S22
```
Appium Server and Uiautomator2 must be installed and configred before launching tests.
After that, run the Appium Server with the command:

`appium server --base-path /wd/hub`   

**Remote launch via Jenkins (only with Browserstack)**
```bash
clean test
-DuserName=${USER_NAME}
-DaccessKey=${ACCESS_KEY}
-Dcomment=${COMMENT}
```

----
<a id="allure"></a>
## Allure report ([link](https://jenkins.autotests.cloud/job/C24-egorovaa-mobiletests/allure/))

**Main report page**
<p align="center">  
<a href="https://jenkins.autotests.cloud/job/C24-egorovaa-mobiletests/allure/"><img src="images/screen/allure_report_main.png" alt="Allure Report main" width="950"/></a>  
</p>

**Test cases**
<p align="center">  
<a href="https://jenkins.autotests.cloud/job/C24-egorovaa-mobiletests/allure/"><img src="images/screen/allure_report_cases.png" alt="Allure Report testcases" width="950"/></a>  
</p>


----
<a id="testops"></a>
## Integration with Allure TestOps ([link](https://allure.autotests.cloud/project/4222/dashboards))
<p align="center">  
<a href="https://allure.autotests.cloud/project/4222/dashboards"><img src="images/screen/allure_testops_main.png" alt="Allure TestOps" width="950"/></a>  
</p>

**Automation test cases**
<p align="center">  
<a href="https://allure.autotests.cloud/project/4222/dashboards"><img src="images/screen/allure_testops_auto.png" alt="Allure TestOps" width="950"/></a>  
</p>

----
<a id="jira"></a>
## Integration with Jira ([link](https://jira.autotests.cloud/browse/HOMEWORK-1217))
<p align="center">  
<a href="https://jira.autotests.cloud/browse/HOMEWORK-1217"><img src="images/screen/jira_task.png" alt="Jira" width="950"/></a>  
</p>

----
<a id="telegram"></a>
## Telegram notification with bot
<p align="center">  
<img src="images/screen/tg_bot_report.png" width="350"/> 
</p>

----
<a id="video"></a>
## Test execution video examples
<p align="center">
<img title="Browserstack Video" src="images/video/video_report.gif" width="600" height="600"  alt="video">   
</p>
