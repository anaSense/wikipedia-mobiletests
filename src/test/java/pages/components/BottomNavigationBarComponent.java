package pages.components;

import io.appium.java_client.AppiumBy;

import static com.codeborne.selenide.Selenide.$;
import static java.lang.String.format;

public class BottomNavigationBarComponent {
    String searchTabByDesc = "UiSelector().description(\"%s\")";

    public void clickTabByText(String tab) {
        $(AppiumBy.androidUIAutomator(format(searchTabByDesc, tab))).click();
    }
}
