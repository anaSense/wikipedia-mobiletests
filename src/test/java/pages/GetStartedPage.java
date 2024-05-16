package pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;
import static io.appium.java_client.AppiumBy.id;
import static org.assertj.core.api.Assertions.assertThat;

public class GetStartedPage {

    SelenideElement continueButton = $(id("org.wikipedia.alpha:id/fragment_onboarding_forward_button")), getStartedButton = $(id("org.wikipedia.alpha:id/fragment_onboarding_done_button")), skipButton = $(id("org.wikipedia.alpha:id/fragment_onboarding_skip_button")), titleTextView = $(id("org.wikipedia.alpha:id/primaryTextView"));

    public void clickOnContinueButton() {
        continueButton.click();
    }

    public void clickOnGetStartedButton() {
        getStartedButton.click();
    }

    public void clickOnSkipButton() {
        skipButton.click();
    }

    public void checkThePageTitleIsShown(String errorText) {
        String titleText = titleTextView.text();
        assertThat(titleText).isEqualTo(errorText);
    }
}
