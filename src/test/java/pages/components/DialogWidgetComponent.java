package pages.components;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;
import static io.appium.java_client.AppiumBy.id;

public class DialogWidgetComponent {
    SelenideElement yesButton = $(id("android:id/button1")), noButton = $(id("android:id/button2"));

    public void clickYesButton() {
        yesButton.click();
    }

    public void clickNoButton() {
        noButton.click();
    }
}
