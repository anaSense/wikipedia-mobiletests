package tests;

import com.codeborne.selenide.Selenide;
import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pages.ExploreTabPage;
import pages.GetStartedPage;

import static io.qameta.allure.Allure.step;

@Feature("Feature get started")
@Story("Check skipping and passing tutorial")
@Owner("egorovaa")
public class GetStartedTests extends TestBase {

    private final GetStartedPage getStartedPage = new GetStartedPage();
    private final ExploreTabPage exploreTabPage = new ExploreTabPage();

    @Test
    @Severity(SeverityLevel.TRIVIAL)
    @DisplayName("Skip the tutorial by system BACK")
    void successfullySkipBySystemBack() {
        step("Close the get started screen using the system back button", Selenide::back);
        step("Check that explore tab screen is shown", exploreTabPage::checkMainPageIsShown);
    }

    @Test
    @Severity(SeverityLevel.NORMAL)
    @DisplayName("Skip the tutorial using the screen back button")
    void successfullySkipByScreenButtonBack() {
        step("Close the get started screen using the screen back button", getStartedPage::clickOnSkipButton);
        step("Check that explore tab screen is shown", exploreTabPage::checkMainPageIsShown);
    }

    @Test
    @Severity(SeverityLevel.NORMAL)
    @DisplayName("Successful completion of tutorial")
    void successfullyCompleteTutorial() {
        step("Navigate to the second tutorial screen using the continue button", getStartedPage::clickOnContinueButton);

        step("Check the title of the second screen", () -> getStartedPage.checkThePageTitleIsShown("New ways to explore"));

        step("Navigate to the third tutorial screen using the continue button", getStartedPage::clickOnContinueButton);

        step("Check the title of the third screen", () -> getStartedPage.checkThePageTitleIsShown("Reading lists with sync"));

        step("Navigate to the fourth tutorial screen using the continue button", getStartedPage::clickOnContinueButton);

        step("Check the title of the fourth screen", () -> getStartedPage.checkThePageTitleIsShown("Data & Privacy"));

        step("Navigate to the main screen using the get started button", getStartedPage::clickOnGetStartedButton);

        step("Check that explore tab screen is shown", exploreTabPage::checkMainPageIsShown);
    }
}
