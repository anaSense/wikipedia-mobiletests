package tests;

import com.codeborne.selenide.Selenide;
import io.qameta.allure.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pages.SearchTabPage;
import pages.components.BottomNavigationBarComponent;
import pages.components.ToolbarComponent;

import static helpers.ConstantsHelper.SEARCH_TAB;
import static helpers.ConstantsHelper.VALID_TEXT_FOR_SEARCH;
import static io.qameta.allure.Allure.step;
import static java.lang.String.format;

@Feature("History feature")
@Story("Check saving article to history list")
@Owner("egorovaa")
public class HistoryTests extends TestBase {

    private final BottomNavigationBarComponent bottomBarComponent = new BottomNavigationBarComponent();
    private final ToolbarComponent toolbarComponent = new ToolbarComponent();
    private final SearchTabPage searchTabPage = new SearchTabPage();

    @BeforeEach
    void setUp() {
        step("Skip tutorial flow",
                Selenide::back);
        step("Click to search tab", () ->
                bottomBarComponent.clickToTabByText(SEARCH_TAB));
    }

    @Test
    @Severity(SeverityLevel.CRITICAL)
    @DisplayName("Successfully save article to history list after open article page")
    void successfullySaveArticleToHistoryTest() {
        step(format("Enter \"%s\" into search text field", VALID_TEXT_FOR_SEARCH), () ->
                searchTabPage.enterTextToSearchField(VALID_TEXT_FOR_SEARCH));
        String choseResultText = step("Click to the first article in the search result", () -> {
            searchTabPage.checkListOfTitlesIsNotNull();
            String str = searchTabPage.getTextFromFirstResultElement();
            searchTabPage.clickToTheFirstElement();
            return str;
        });
        step("Return to search result page",
                toolbarComponent::clickBackButton);
        step("Return to search tab and check the page title", () -> {
            toolbarComponent.clickBackButton();
            searchTabPage.checkTheTitleOfSearchTabIsShown();
        });
        step("Check that the previously opened article was saved first " +
                "in the history list ", () -> searchTabPage.checkListOfTitlesIsNotNull()
                .checkIsOpenArticleSaveToHistory(choseResultText));
    }

    @Test
    @Severity(SeverityLevel.CRITICAL)
    @DisplayName("The article isn't saved to history list if article's page wasn't opened")
    void emptyHistoryIfArticleWasNotOpenedTest() {
        step(format("Enter \"%s\" into search text field", VALID_TEXT_FOR_SEARCH), () ->
                searchTabPage.enterTextToSearchField(VALID_TEXT_FOR_SEARCH));
        step("Return to search tab and check the page title", () -> {
            toolbarComponent.clickBackButton();
            searchTabPage.checkTheTitleOfSearchTabIsShown();
        });
        step("Check that isn't any article in search history",
                searchTabPage::checkTheHistoryIsEmpty);
    }
}
