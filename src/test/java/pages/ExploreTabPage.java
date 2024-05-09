package pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static io.appium.java_client.AppiumBy.id;

public class ExploreTabPage {
    SelenideElement feedView = $(id("org.wikipedia.alpha:id/feed_view"));

    public void checkMainPageIsShown() {
        feedView.shouldBe(visible);
    }
}
