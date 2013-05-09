import builders.UserBuilder;
import objects.User;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.*;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.equalTo;

/**
 * User: Mateusz Koncikowski
 * Date: 4/29/13
 * Time: 9:30 AM
 */

public class SignInTest {

    private BrowserDriver browser;
    private ForumPage forumPage;

    @BeforeClass
    public void initializeBrowser() {
        browser = new BrowserDriver();
        browser.openBrowser();
        forumPage = browser.navigateToForum();
    }

    @Test
    public void logInShouldSucceed() {
        User user = new UserBuilder().build();

        PostSignInPage postSignInPage = forumPage
                .signOutIfAlreadyLoggedIn()
                .navigateToSignInPage()
                .logIn(user);

        String expectedMessage = String.format("Welcome, %s.", user.getName());
        assertThat(postSignInPage.getPageSource(), containsString(expectedMessage));

        forumPage = postSignInPage.navigateToIndex();
        assertThat(forumPage.isLoggedIn(), equalTo(true));
    }

    @Test
    public void logInWithInvalidUserShouldFail() {
        User user = new UserBuilder().build();

        PostSignInPage postSignInPage = forumPage
                .signOutIfAlreadyLoggedIn()
                .navigateToSignInPage()
                .setUsername("InvalidUsername")
                .setPassword(user.getPass())
                .submit();

        String expectedMessage = "You have supplied a wrong user/password combination. Please try again.";
        assertThat(postSignInPage.getPageSource(), containsString(expectedMessage));
    }

    @Test
    public void logInWithInvalidPasswordShouldFail() {
        User user = new UserBuilder().build();

        PostSignInPage postSignInPage = forumPage
                .signOutIfAlreadyLoggedIn()
                .navigateToSignInPage()
                .setUsername(user.getName())
                .setPassword("InvalidPassword")
                .submit();

        String expectedMessage = "You have supplied a wrong user/password combination. Please try again.";
        assertThat(postSignInPage.getPageSource(), containsString(expectedMessage));
    }

    @AfterClass
    public void closeBrowser() {
        browser.closeBrowser();
    }
}
