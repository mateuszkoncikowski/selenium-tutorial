import builders.CategoryBuilder;
import builders.TopicBuilder;
import builders.UserBuilder;
import objects.Category;
import objects.Topic;
import objects.User;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.*;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;

/**
 * User: Mateusz Koncikowski
 * Date: 4/30/13
 * Time: 10:46 AM
 */

public class TopicTest {

    private BrowserDriver browser;
    private ForumPage forumPage;

    @BeforeClass
    public void initializeBrowser() {
        browser = new BrowserDriver();
        browser.openBrowser();
        forumPage = browser.navigateToForum();
    }

    @Test
    public void creatingTopicShouldShouldSucceed() {
        User user = new UserBuilder().build();
        Category category = new CategoryBuilder().build();
        Topic topic = new TopicBuilder(category, user).withDbInsert(false).build();

        PostCreateTopicPage postCreateTopicPage = forumPage
                .navigateToSignInPage()
                .logIn(user)
                .navigateToCreateTopicPage()
                .addTopic(topic);

        String expectedMessage = "You have successfully created your new topic";
        assertThat(postCreateTopicPage.getPageSourceWithoutTags(), containsString(expectedMessage));
    }

    @Test
    public void openingNewlyCreatedTopicShouldSucceed() {
        User user = new UserBuilder().build();
        Category category = new CategoryBuilder().build();
        Topic topic = new TopicBuilder(category, user).build();

        TopicPage topicPage = forumPage
                .navigateToIndex()
                .navigateToCategoryPage(category)
                .navigateToTopicPage(topic);

        assertThat(topicPage.getPageSource(), containsString(topic.getSubject()));
        assertThat(topicPage.getPageSource(), containsString(topic.getFirstPost()));
    }

    @AfterClass
    public void closeBrowser() {
        browser.closeBrowser();
    }
}
