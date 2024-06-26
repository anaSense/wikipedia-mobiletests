package tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.logevents.SelenideLogger;
import drivers.BrowserstackDriverProvider;
import drivers.DeviceDriverProvider;
import helpers.AttachHelper;
import helpers.PropertyReader;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;

import static com.codeborne.selenide.Selenide.closeWebDriver;
import static com.codeborne.selenide.Selenide.open;

public class TestBase {
    private static final String BROWSERSTACK_DRIVER = "browserstack",
            LOCAL_DRIVER = "local",
            EMULATOR_DRIVER = "emulator";

    @BeforeAll
    static void beforeAll() {
        switch (System.getProperty("deviceHost", BROWSERSTACK_DRIVER)) {
            case BROWSERSTACK_DRIVER -> Configuration.browser = BrowserstackDriverProvider.class.getName();
            case EMULATOR_DRIVER, LOCAL_DRIVER -> Configuration.browser = DeviceDriverProvider.class.getName();
        }
        Configuration.browserSize = null;
        Configuration.timeout = 30000;

        PropertyReader.readPropertyFile("test_data/testData.properties");
    }

    @BeforeEach
    void beforeEach() {
        open();
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide());
    }

    @AfterEach
    void addAttachments() {
        String sessionId = Selenide.sessionId().toString();
        AttachHelper.screenshotAs("Last screenshot");
        AttachHelper.pageSource();
        closeWebDriver();
        if (System.getProperty("deviceHost", BROWSERSTACK_DRIVER).equals(BROWSERSTACK_DRIVER))
            AttachHelper.addVideo(sessionId);
    }

}
