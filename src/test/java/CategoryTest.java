import builders.CategoryBuilder;
import builders.TopicBuilder;
import builders.UserBuilder;
import enums.Level;
import objects.Category;
import objects.Topic;
import objects.User;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.*;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasItem;

/**
 * User: Mateusz Koncikowski
 * Date: 4/30/13
 * Time: 7:58 AM
 */

public class CategoryTest {

    private BrowserDriver browser;
    private ForumPage forumPage;

    @BeforeClass
    public void initializeBrowser() {
        browser = new BrowserDriver();
        browser.openBrowser();
        forumPage = browser.navigateToForum();
    }

    @Test
    public void creatingCategoryShouldSucceed() {
        User user = new UserBuilder().setLevel(Level.ADMIN_USER).build();
        Category category = new CategoryBuilder().withDbInsert(false).build();

        PostCreateCategoryPage postCreateCategoryPage = forumPage
                .signOutIfAlreadyLoggedIn()
                .navigateToSignInPage()
                .logIn(user)
                .navigateToCreateCategoryPage()
                .addCategory(category);

        String expectedMessage = "New category successfully added.";
        assertThat(postCreateCategoryPage.getPageSource(), containsString(expectedMessage));
    }

    @Test
    public void creatingCategoryWithRegularUserShouldFail() {
        User user = new UserBuilder().setLevel(Level.REGULAR_USER).build();

        CreateCategoryPage createCategoryPage = forumPage
                .signOutIfAlreadyLoggedIn()
                .navigateToSignInPage()
                .logIn(user)
                .navigateToCreateCategoryPage();

        String expectedMessage = "Sorry, you do not have sufficient rights to access this page.";
        assertThat(createCategoryPage.getPageSource(), containsString(expectedMessage));
    }

    @Test
    public void displayingCreatedCategoryOnTheIndexShouldSucceed() {
        Category category = new CategoryBuilder().build();

        List<String> existingCategories = forumPage
                .navigateToIndex()
                .getCategories();

        assertThat(existingCategories, hasItem(category.getName()));
    }

    @Test
    public void openingNewlyCreatedCategoryShouldSucceed() {
        Category category = new CategoryBuilder().build();

        CategoryPage categoryPage = forumPage
                .navigateToIndex()
                .navigateToCategoryPage(category);

        String expectedMessage = String.format("Topics in ′%s′ category", category.getName());
        assertThat(categoryPage.getPageSource(), containsString(expectedMessage));
    }

    @Test
    public void categoryListOnIndexPageShouldDisplayLinkToLastTopic() {
        User user = new UserBuilder().build();
        Category category = new CategoryBuilder().build();
        Topic topic = new TopicBuilder(category, user).build();

        Index index = forumPage.navigateToIndex();

        assertThat(index.getLinkToLastTopic(category), equalTo(topic.getSubject()));
    }

    @AfterClass
    public void closeBrowser() {
        browser.closeBrowser();
    }
}
