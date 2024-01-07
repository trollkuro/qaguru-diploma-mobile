package screens;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.page;
import static io.appium.java_client.AppiumBy.*;

public class ExploreScreen {
    private SelenideElement wordMark = $(id("org.wikipedia.alpha:id/main_toolbar_wordmark")),
                            falseSearch = $(accessibilityId("Search Wikipedia")),
                            trueSearch = $(id("org.wikipedia.alpha:id/search_src_text"));



    public ExploreScreen wordMarkIsDisplayed(){
        wordMark.shouldBe(visible);
        return this;
    }
    public ExploreScreen tapOnFalseSearch(){
        falseSearch.click();
        return this;
    }

    public SearchScreen setSearchQuery(String query){
        trueSearch.sendKeys(query);
        return page(SearchScreen.class);
    }


}
