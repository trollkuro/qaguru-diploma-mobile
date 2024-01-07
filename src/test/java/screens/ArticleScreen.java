package screens;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static io.appium.java_client.AppiumBy.id;

public class ArticleScreen {
    private SelenideElement articleTitleDescription = $(id("pcs-edit-section-title-description"));

    public ArticleScreen checkArticleTitleDescription(String titleDescription){
        articleTitleDescription.shouldHave(text(titleDescription));
        return this;
    }
}