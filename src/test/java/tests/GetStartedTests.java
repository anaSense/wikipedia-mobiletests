package tests;

import com.codeborne.selenide.Selenide;
import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pages.ExploreTabPage;
import pages.GetStartedPage;

import static io.qameta.allure.Allure.step;

@Feature("Get started feature")
@Story("Check skip and pass tutorial")
@Owner("egorovaa")
public class GetStartedTests extends TestBase {

    private final GetStartedPage getStartedPage = new GetStartedPage();
    private final ExploreTabPage exploreTabPage = new ExploreTabPage();

    @Test
    @Severity(SeverityLevel.TRIVIAL)
    @DisplayName("Skip the tutorial by system BACK")
    void successfullySkipBySystemBack() {
        step("Close get started screen by system button back", Selenide::back);
        step("Check that explore tab screen is shown", exploreTabPage::checkMainPageIsShown);
    }

    @Test
    @Severity(SeverityLevel.NORMAL)
    @DisplayName("Skip the tutorial by screen button BACK")
    void successfullySkipByScreenButtonBack() {
        step("Close get started screen by screen button back",
                getStartedPage::clickOnSkipButton);
        step("Check that explore tab screen is shown", exploreTabPage::checkMainPageIsShown);
    }

    @Test
    @Severity(SeverityLevel.NORMAL)
    @DisplayName("Successfully passed tutorial")
    void successfullyCompleteTutorial() {
        step("Go to the second tutorial screen by continue button",
                getStartedPage::clickOnContinueButton);

        step("Check the title of the second screen", () ->
            getStartedPage.checkThePageTitleIsShown("New ways to explore"));

        step("Go to the third tutorial screen by continue button",
                getStartedPage::clickOnContinueButton);

        step("Check the title of the third screen", () ->
                getStartedPage.checkThePageTitleIsShown("Reading lists with sync"));

        step("Go to the fourth tutorial screen by continue button",
                getStartedPage::clickOnContinueButton);

        step("Check the title of the fourth screen", () ->
                getStartedPage.checkThePageTitleIsShown("Data & Privacy"));

        step("Go to the main screen by get started button",
                getStartedPage::clickOnGetStartedButton);

        step("Check that explore tab screen is shown",
                exploreTabPage::checkMainPageIsShown);
    }
}
