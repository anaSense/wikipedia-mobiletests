package drivers;

import com.codeborne.selenide.WebDriverProvider;
import config.BrowserstackAuthConfig;
import config.BrowserstackConfig;
import helpers.BrowserstackHelper;
import io.appium.java_client.android.AndroidDriver;
import org.aeonbits.owner.ConfigFactory;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import javax.annotation.Nonnull;
import java.net.MalformedURLException;
import java.net.URL;

import static org.assertj.core.api.Assertions.assertThat;

public class BrowserstackDriverProvider implements WebDriverProvider {

    static BrowserstackConfig browserstackConfig = ConfigFactory.create(BrowserstackConfig.class, System.getProperties());
    static BrowserstackAuthConfig browserstackAuthConfig = ConfigFactory.create(BrowserstackAuthConfig.class, System.getProperties());

    @Nonnull
    @Override
    public WebDriver createDriver(@Nonnull Capabilities capabilities) {
        DesiredCapabilities caps = new DesiredCapabilities();

        String appUrl = BrowserstackHelper.uploadApp();
        assertThat(appUrl).isNotNull();

        caps.setCapability("app", appUrl);
        caps.setCapability("appium:deviceName", browserstackConfig.deviceName());
        caps.setCapability("appium:platformVersion", browserstackConfig.platformVersion());
        caps.setCapability("appium:projectName", "Wiki test project");
        caps.setCapability("appium:buildName", "browserstack-build-1");
        caps.setCapability("appium:name", "mobile_tests_wiki");

        try {
            return new AndroidDriver(new URL(String.format("https://%s:%s@hub.browserstack.com/wd/hub",
                    browserstackAuthConfig.userName(), browserstackAuthConfig.accessKey())), caps);
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
    }

}
