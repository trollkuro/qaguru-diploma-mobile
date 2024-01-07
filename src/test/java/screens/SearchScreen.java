package screens;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.CollectionCondition.sizeGreaterThan;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;
import static io.appium.java_client.AppiumBy.id;

public class SearchScreen {
    private ElementsCollection searchResult = $$(id("org.wikipedia.alpha:id/page_list_item_title"));
    private SelenideElement articleDescription = $(id("org.wikipedia.alpha:id/page_list_item_description"));

    public void searchResultIsGreaterThan(int result){
        searchResult.shouldHave(sizeGreaterThan(result));
    }

    public ArticleScreen selectArticleByDescription(String description){
        articleDescription.shouldHave(text(description)).click();
        return Selenide.page(ArticleScreen.class);
    }


}
