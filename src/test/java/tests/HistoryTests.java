package tests;

import com.codeborne.selenide.Selenide;
import io.qameta.allure.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pages.SearchTabPage;
import pages.components.BottomNavigationBarComponent;
import pages.components.ToolbarComponent;

import static helpers.PropertyReader.constantsProperties;
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
        step("Skip tutorial flow", () -> Selenide.back());
        step("Click on the search tab", () -> bottomBarComponent.clickTabByText(constantsProperties.getProperty("searchTab")));
    }

    @Test
    @Severity(SeverityLevel.CRITICAL)
    @DisplayName("Successful saving of the article to the history list after opening the article page")
    void successfullySaveArticleToHistoryTest() {
        String validTextForSearch = constantsProperties.getProperty("validTextForSearch");

        step(format("Enter \"%s\" into search text field", validTextForSearch), () -> searchTabPage.enterTextToSearchField(validTextForSearch));
        String choseResultText = step("Click on the first article in the search results", () -> {
            searchTabPage.checkListOfTitlesIsNotNull();
            String str = searchTabPage.getTextFromFirstResultElement();
            searchTabPage.clickToFirstElement();
            return str;
        });
        step("Return to search result page", toolbarComponent::clickBackButton);
        step("Return to the search tab and check the page title", () -> {
            toolbarComponent.clickBackButton();
            searchTabPage.checkTitleOfSearchTabIsShown();
        });
        step("Check that the previously opened article was saved first " + "in the history list ", () ->
                searchTabPage.checkListOfTitlesIsNotNull().checkIsOpenArticleSaveToHistory(choseResultText));
    }

    @Test
    @Severity(SeverityLevel.CRITICAL)
    @DisplayName("The article isn't saved to the history list if article's page wasn't opened")
    void emptyHistoryIfArticleWasNotOpenedTest() {
        String validTextForSearch = constantsProperties.getProperty("validTextForSearch");

        step(format("Enter \"%s\" into search text field", validTextForSearch), () ->
                searchTabPage.enterTextToSearchField(validTextForSearch));
        step("Return to the search tab and check the page title", () -> {
            toolbarComponent.clickBackButton();
            searchTabPage.checkTitleOfSearchTabIsShown();
        });
        step("Check that there isn't any article in the search history", () ->
                searchTabPage.checkHistoryIsEmpty());
    }
}
