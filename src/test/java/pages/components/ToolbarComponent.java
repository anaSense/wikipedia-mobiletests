package pages.components;

import io.appium.java_client.AppiumBy;

import static com.codeborne.selenide.Selenide.$;
import static java.lang.String.format;

public class ToolbarComponent {
    String backButtonByDesc = "UiSelector().description(\"%s\")";

    public ToolbarComponent clickBackButton() {
        $(AppiumBy.androidUIAutomator(format(backButtonByDesc, "Navigate up"))).click();
        return this;
    }
}
