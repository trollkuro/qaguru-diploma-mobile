package tests;

import io.qameta.allure.Feature;
import io.qameta.allure.Owner;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import screens.ExploreScreen;
import screens.OnboardingScreen;

import static io.qameta.allure.Allure.step;

@DisplayName("Onboarding")
@Disabled
public class OnboardingScreenTests extends BaseTest{

    private OnboardingScreen onboardingScreen = new OnboardingScreen();
    private ExploreScreen exploreScreen = new ExploreScreen();

    private static final String FIRST_ONBOARDING_HEADER = "The Free Encyclopedia\n" + "…in over 300 languages";
    private static final String SECOND_ONBOARDING_HEADER = "New ways to explore";
    private static final String THIRD_ONBOARDING_HEADER = "Reading lists with sync";
    private static final String FOURTH_ONBOARDING_HEADER = "Send anonymous data";

    @Test
    @Tag("Onboarding")
    @Feature("Onboarding")
    @Owner("kegorova")
    @DisplayName("Check all banner in the app onboarding")
    void onboardingAllBannersTest(){
        step("Verify the first onboarding banner", () -> {
           onboardingScreen.checkHeaderText(FIRST_ONBOARDING_HEADER);
        });
        step("Click \"Continue\" button", () -> {
            onboardingScreen.clickContinueButton();
        });
        step("Verify the second onboarding banner", () -> {
            onboardingScreen.checkHeaderText(SECOND_ONBOARDING_HEADER);
        });
        step("Click \"Continue\" button", () -> {
            onboardingScreen.clickContinueButton();
        });
        step("Verify the third onboarding banner", () -> {
            onboardingScreen.checkHeaderText(THIRD_ONBOARDING_HEADER);
        });
        step("Click \"Continue\" button", () -> {
            onboardingScreen.clickContinueButton();
        });
        step("Verify the fourth onboarding banner", () -> {
            onboardingScreen.checkHeaderText(FOURTH_ONBOARDING_HEADER);
        });
        step("Verify accept and reject buttons", () -> {
            onboardingScreen.acceptButtonIsVisible();
            onboardingScreen.rejectButtonIsVisible();
        });
    }

    @Test
    @Tag("Onboarding")
    @Feature("Onboarding")
    @Owner("kegorova")
    @DisplayName("Check the first onboarding banner")
    void onboardingInitialBannerDisplayTest() {
        step("Verify the first onboarding banner header", () -> {
            onboardingScreen.checkHeaderText(FIRST_ONBOARDING_HEADER);
        });
        step("Verify language button", () -> {
            onboardingScreen.languageButtonIsDisplayed();
        });
        step("Verify buttons: Skip and Continue", () -> {
            onboardingScreen.scipButtonIsDisplayed();
            onboardingScreen.continueButtonIsDisplayed();
        });
    }

    @Test
    @Tag("Onboarding")
    @Feature("Onboarding")
    @Owner("kegorova")
    @DisplayName("Redirect to \"Explore\" section")
    void redirectToExporeAfterScipTest() {
        step("Verify the first onboarding banner header", () -> {
            onboardingScreen.checkHeaderText(FIRST_ONBOARDING_HEADER);
        });
        step("Click \"Skip\" button", () -> {
            onboardingScreen.clickScipButton();
        });
        step("Verify that \"Explore\" tab is displayed ", () -> {
            exploreScreen.wordMarkIsDisplayed();
        });
    }

}
