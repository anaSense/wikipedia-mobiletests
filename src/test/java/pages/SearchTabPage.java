package pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Coordinates;

import java.time.Duration;

import static com.codeborne.selenide.CollectionCondition.sizeGreaterThan;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static helpers.PropertyReader.constantsProperties;
import static io.appium.java_client.AppiumBy.accessibilityId;
import static io.appium.java_client.AppiumBy.id;
import static org.assertj.core.api.Assertions.assertThat;


public class SearchTabPage {
    SelenideElement searchCard = $(accessibilityId("Search Wikipedia")),
            searchTextField = $(id("org.wikipedia.alpha:id/search_src_text")),
            historyEmptyTitle = $(id("org.wikipedia.alpha:id/history_empty_title")),
            firstItemFromList = $(id("org.wikipedia.alpha:id/page_list_item_container")),
            clearAllHistoryButton = $(id("org.wikipedia.alpha:id/history_delete"));
    ElementsCollection listOfTitles = $$(By.id("org.wikipedia.alpha:id/page_list_item_title"));

    public SearchTabPage enterTextToSearchField(String text) {
        searchCard.click();
        searchTextField.sendKeys(text);
        return this;
    }

    public SearchTabPage checkListOfTitlesIsNotNull() {
        listOfTitles.shouldHave(sizeGreaterThan(0));
        return this;
    }

    public String getTextFromFirstResultElement() {
        return listOfTitles.get(0).text();
    }

    public void clickToFirstElement() {
        listOfTitles.get(0).click();
    }

    public void checkTitleOfSearchTabIsShown() {
        $(accessibilityId(constantsProperties.getProperty("searchTab"))).shouldBe(visible, Duration.ofSeconds(3));
    }


    public void checkIsOpenArticleSaveToHistory(String titleOpenedArticle) {
        assertThat(listOfTitles.get(0).text()).isEqualTo(titleOpenedArticle);
    }

    public void checkHistoryIsEmpty() {
        historyEmptyTitle.click();
    }

    public Coordinates getCoordinatesFirstItemInHistoryList() {
        return firstItemFromList.getCoordinates();
    }

    public int getSizeOfHistoryList() {
        return listOfTitles.size();
    }

    public void clickClearAllHistoryButton() {
        clearAllHistoryButton.click();
    }
}