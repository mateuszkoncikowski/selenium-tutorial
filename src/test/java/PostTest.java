import builders.CategoryBuilder;
import builders.PostBuilder;
import builders.TopicBuilder;
import builders.UserBuilder;
import enums.Level;
import objects.Category;
import objects.Post;
import objects.Topic;
import objects.User;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.BrowserDriver;
import pages.ForumPage;
import pages.PostCreatePostPage;
import pages.TopicPage;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.equalTo;

/**
 * User: Mateusz Koncikowski
 * Date: 5/4/13
 * Time: 10:46 AM
 */

public class PostTest {

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
        Topic topic = new TopicBuilder(category, user).build();
        Post post = new PostBuilder(topic, user).withDbInsert(false).build();

        PostCreatePostPage postCreatePostPage = forumPage
                .signOutIfAlreadyLoggedIn()
                .navigateToSignInPage()
                .logIn(user)
                .navigateToIndex()
                .navigateToCategoryPage(category)
                .navigateToTopicPage(topic)
                .addPost(post);

        String expectedMessage = "Your reply has been saved, check out the topic.";
        assertThat(postCreatePostPage.getPageSourceWithoutTags(), containsString(expectedMessage));
    }

    @Test
    public void openingTopicWithNewlyCreatedPostShouldSucceed() {
        User user = new UserBuilder().build();
        Category category = new CategoryBuilder().build();
        Topic topic = new TopicBuilder(category, user).build();
        Post post = new PostBuilder(topic, user).build();

        TopicPage topicPage = forumPage
                .navigateToIndex()
                .navigateToCategoryPage(category)
                .navigateToTopicPage(topic);

        assertThat(topicPage.getPageSource(), containsString(topic.getSubject()));
        assertThat(topicPage.getPageSource(), containsString(topic.getFirstPost()));
        assertThat(topicPage.getPageSource(), containsString(post.getContent()));
        assertThat(topicPage.getPageSource(), containsString(post.getUser().getName()));
    }

    @Test
    public void addingNewPostWhenNotLoggedShouldFail() {
        User user = new UserBuilder().build();
        Category category = new CategoryBuilder().build();
        Topic topic = new TopicBuilder(category, user).build();

        TopicPage topicPage = forumPage
                .signOutIfAlreadyLoggedIn()
                .navigateToSignInPage()
                .navigateToIndex()
                .navigateToCategoryPage(category)
                .navigateToTopicPage(topic);

        String expectedMessage = "You must be signed in to reply. You can also sign up for an account.";
        assertThat(topicPage.getPageSourceWithoutTags(), containsString(expectedMessage));
    }

    @Test
    public void numberOfPostsInNewlyCreatedTopicShouldBeCorrect() {
        User user = new UserBuilder().build();
        Category category = new CategoryBuilder().build();
        Topic topic = new TopicBuilder(category, user).build();
        Post post = new PostBuilder(topic, user).withDbInsert(false).build();

        TopicPage topicPage = forumPage
                .signOutIfAlreadyLoggedIn()
                .navigateToSignInPage()
                .logIn(user)
                .navigateToIndex()
                .navigateToCategoryPage(category)
                .navigateToTopicPage(topic)
                .addPost(post)
                .backToTopic();

        assertThat(topicPage.getPosts().size(), equalTo(2));
    }

    @Test
    public void creatingPostWithNewlyCreatedUserShouldSucceed() {
        User user = new UserBuilder().setLevel(Level.ADMIN_USER).build();
        Category category = new CategoryBuilder().withDbInsert(false).build();
        Topic topic = new TopicBuilder(category, user).withDbInsert(false).build();
        Post post = new PostBuilder(topic, user).withDbInsert(false).build();

        TopicPage topicPage = forumPage
                .signOutIfAlreadyLoggedIn()
                .navigateToSignInPage()
                .logIn(user)
                .navigateToCreateCategoryPage()
                .addCategory(category)
                .navigateToCreateTopicPage()
                .addTopic(topic)
                .navigateToIndex()
                .navigateToCategoryPage(category)
                .navigateToTopicPage(topic)
                .addPost(post)
                .backToTopic();

        assertThat(topicPage.getPageSource(), containsString(topic.getSubject()));
        assertThat(topicPage.getPageSource(), containsString(topic.getFirstPost()));
        assertThat(topicPage.getPageSource(), containsString(post.getContent()));
        assertThat(topicPage.getPageSource(), containsString(post.getUser().getName()));
    }

    @Test
    public void postingToTopicCreatedByAnotherUserShouldSucceed() {
        User firstUser = new UserBuilder().build();
        Category category = new CategoryBuilder().build();
        Topic topic = new TopicBuilder(category, firstUser).build();

        User secondUser = new UserBuilder().build();
        Post post = new PostBuilder(topic,secondUser).withDbInsert(false).build();

        PostCreatePostPage postCreatePostPage = forumPage
                .signOutIfAlreadyLoggedIn()
                .navigateToSignInPage()
                .logIn(secondUser)
                .navigateToIndex()
                .navigateToCategoryPage(category)
                .navigateToTopicPage(topic)
                .addPost(post);

        String expectedMessage = "Your reply has been saved, check out the topic.";
        assertThat(postCreatePostPage.getPageSourceWithoutTags(), containsString(expectedMessage));
    }

    @AfterClass
    public void closeBrowser() {
        browser.closeBrowser();
    }
}
