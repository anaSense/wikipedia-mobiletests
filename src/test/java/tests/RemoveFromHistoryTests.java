package tests;

import com.codeborne.selenide.Selenide;
import helpers.SwipeHelper;
import io.qameta.allure.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pages.SearchTabPage;
import pages.components.BottomNavigationBarComponent;
import pages.components.ToolbarComponent;
import pages.components.DialogWidgetComponent;

import static helpers.ConstantsHelper.SEARCH_TAB;
import static helpers.ConstantsHelper.VALID_TEXT_FOR_SEARCH;
import static io.qameta.allure.Allure.step;
import static org.assertj.core.api.Assertions.assertThat;

@Feature("History feature")
@Story("Check removing items from history")
@Owner("egorovaa")
public class RemoveFromHistoryTests extends TestBase {
    private final BottomNavigationBarComponent bottomBarComponent = new BottomNavigationBarComponent();
    private final ToolbarComponent toolbarComponent = new ToolbarComponent();
    private final DialogWidgetComponent widgetComponent = new DialogWidgetComponent();
    private final SearchTabPage searchTabPage = new SearchTabPage();

    @BeforeEach
    void setUp() {
        step("Skip tutorial flow", () -> Selenide.back());
        step("Click on the search tab", () -> bottomBarComponent.clickToTabByText(SEARCH_TAB));
        step("Add article element to history", () -> {
            searchTabPage.enterTextToSearchField(VALID_TEXT_FOR_SEARCH).checkListOfTitlesIsNotNull().clickToTheFirstElement();
            toolbarComponent.clickBackButton().clickBackButton();
        });
    }

    @Test
    @Severity(SeverityLevel.NORMAL)
    @DisplayName("Successfully remove article from history by swipe")
    void successfullyRemoveItemFromHistoryBySwipeTest() {
        int countOfItem = step("Get size of history list before removing item", () -> {
            searchTabPage.checkListOfTitlesIsNotNull();
            return searchTabPage.getSizeOfHistoryList();
        });
        step("Delete item by swipe", () ->
                SwipeHelper.horizontalSwipeByItemCoordinates(searchTabPage.getCoordinatedOfFirstItemInHistoryList()));
        step("Check that the history list size decreased by 1 item", () ->
                assertThat(searchTabPage.getSizeOfHistoryList()).isEqualTo(countOfItem - 1));
    }

    @Test
    @Severity(SeverityLevel.CRITICAL)
    @DisplayName("Successfully clear all history")
    void successfullyClearHistory() {
        step("Check that history list is not empty", () -> searchTabPage.checkListOfTitlesIsNotNull());
        step("Click on the clear all history button", () -> searchTabPage.clickToClearAllHistoryButton());
        step("Click YES button in widget", () -> widgetComponent.clickYesButton());
        step("Check that history list is empty", () -> searchTabPage.checkTheHistoryIsEmpty());
    }

    @Test
    @Severity(SeverityLevel.CRITICAL)
    @DisplayName("The history wasn't cleaned if the user didn't agree in the dialog")
    void historyNotCleanIfDeclineDialog() {
        int countOfItem = step("Check that history list is not empty", () -> {
            searchTabPage.checkListOfTitlesIsNotNull();
            return searchTabPage.getSizeOfHistoryList();
        });
        step("Click on the clear all history button", () -> searchTabPage.clickToClearAllHistoryButton());
        step("Click NO button in widget", () -> widgetComponent.clickNoButton());
        step("Check that the size of the history list hasn't changed", () ->
                assertThat(searchTabPage.getSizeOfHistoryList()).isEqualTo(countOfItem));
    }
}
