package screens;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.page;
import static io.appium.java_client.AppiumBy.*;

public class OnboardingScreen {
    private SelenideElement header = $(id("org.wikipedia.alpha:id/primaryTextView")),
                            languageButton = $(id("org.wikipedia.alpha:id/addLanguageButton")),
                            continueButton = $(id("org.wikipedia.alpha:id/fragment_onboarding_forward_button")),

                            skipButton = $(id("org.wikipedia.alpha:id/fragment_onboarding_skip_button")),
                            acceptSendDataButton = $(id("org.wikipedia.alpha:id/acceptButton")),
                            rejectSendDataButton = $(id("org.wikipedia.alpha:id/rejectButton"));

    public OnboardingScreen checkHeaderText(String expectedHeader){
        header.shouldHave(text(expectedHeader));
        return this;
    }

    public OnboardingScreen clickContinueButton(){
        continueButton.click();
        return this;
    }

    public ExploreScreen clickScipButton(){
        skipButton.click();
        return page(ExploreScreen.class);
    }

    public OnboardingScreen continueButtonIsDisplayed(){
        continueButton.shouldBe(visible);
        return this;
    }

    public OnboardingScreen scipButtonIsDisplayed(){
        skipButton.shouldBe(visible);
        return this;
    }

    public OnboardingScreen languageButtonIsDisplayed(){
        languageButton.shouldBe(visible);
        return this;
    }


    public OnboardingScreen acceptButtonIsVisible(){
        acceptSendDataButton.shouldBe(visible);
        return this;
    }

    public OnboardingScreen rejectButtonIsVisible(){
        rejectSendDataButton.shouldBe(visible);
        return this;
    }
}
