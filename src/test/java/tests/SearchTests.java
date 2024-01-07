package tests;

import io.qameta.allure.Owner;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import screens.ArticleScreen;
import screens.ExploreScreen;
import screens.OnboardingScreen;
import screens.SearchScreen;

import static io.qameta.allure.Allure.step;

@DisplayName("Search")
@Disabled
public class SearchTests extends BaseTest {

    private ExploreScreen exploreScreen = new ExploreScreen();
    private SearchScreen searchScreen = new SearchScreen();
    private ArticleScreen articleScreen = new ArticleScreen();
    private OnboardingScreen onboardingScreen = new OnboardingScreen();
    private final static String SEARCH_QUERY = "Appium";
    private final static int RESULT_SIZE = 0;
    private final static String SEARCH_QUERY_ARTICLE = "Selenide";
    private final static String ARTICLE_TITLE_DESCRIPTION = "Chemical compound containing selenium";



    @Test
    @Disabled
    @Tag("Search")
    @Owner("kegorova")
    @DisplayName("Successful search: results are returned in the list")
    void successfulSearchTest(){
        step("Click \"Skip\" button", () -> {
            onboardingScreen.clickScipButton();
        });
        step("Type search", () -> {
            exploreScreen.tapOnFalseSearch()
                    .setSearchQuery(SEARCH_QUERY);
        });
        step("Verify content found", () -> {
            searchScreen.searchResultIsGreaterThan(RESULT_SIZE);
        });
    }


    @Test
    @Disabled
    @Tag("Search")
    @Owner("kegorova")
    @DisplayName("Search: open article by description")
    void openArticleAndGetErrorTest(){
        step("Click \"Skip\" button", () -> {
            onboardingScreen.clickScipButton();
        });
        step("Type search", () -> {
            exploreScreen.tapOnFalseSearch()
                    .setSearchQuery(SEARCH_QUERY_ARTICLE);
        });
        step("Select article by title description", () -> {
            searchScreen.selectArticleByDescription(ARTICLE_TITLE_DESCRIPTION);
        });
        step("Check title description in the oped article", () -> {
            articleScreen.checkArticleTitleDescription(ARTICLE_TITLE_DESCRIPTION);
        });
    }

}