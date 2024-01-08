package screens;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static io.appium.java_client.AppiumBy.id;

public class ArticleScreen {
    private SelenideElement articleTitleDescription = $(id("pcs-edit-section-title-description")),
            articleNavigationBar = $(id("org.wikipedia.alpha:id/page_actions_tab_layout"));

    public ArticleScreen checkArticleTitleDescription(String titleDescription){
        articleTitleDescription.shouldHave(text(titleDescription));
        return this;
    }

    public ArticleScreen articleNavigationBarIsDisplayed(){
        articleNavigationBar.shouldBe(visible);
        return this;
    }
}