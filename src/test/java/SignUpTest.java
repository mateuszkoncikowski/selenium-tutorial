import builders.UserBuilder;
import objects.User;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.*;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;

/**
 * User: Mateusz Koncikowski
 * Date: 01.04.13
 * Time: 16:54
 */

public class SignUpTest {

    private BrowserDriver browser;
    private ForumPage forumPage;

    @BeforeClass
    public void initializeBrowser() {
        browser = new BrowserDriver();
        browser.openBrowser();
        forumPage = browser.navigateToForum();
    }

    @Test
    public void createUserShouldSucceed() {
        User user = new UserBuilder().withDbInsert(false).build();

        PostSignUpPage postSignUpPage = forumPage
                .navigateToCreateAccountPage()
                .fillCreateUserForm(user)
                .submit();

        String expectedMessage = "Successfully registered";
        assertThat(postSignUpPage.getPageSource(), containsString(expectedMessage));
    }

    @Test
    public void creatingTwoIdenticalUserShouldFail() {
        User user = new UserBuilder().withDbInsert(false).build();

        PostSignUpPage postSignUpPage = forumPage
                .navigateToCreateAccountPage()
                .addAccount(user)
                .navigateToCreateAccountPage()
                .addAccount(user);

        String expectedMessage = "Something went wrong while registering. Please try again later.";
        assertThat(postSignUpPage.getPageSource(), containsString(expectedMessage));
    }

    @Test
    public void creatingUserWithoutUserNameShouldFail() {
        User user = new UserBuilder().withDbInsert(false).setName("").build();

        PostSignUpPage postSignUpPage = forumPage
                .navigateToCreateAccountPage()
                .fillCreateUserForm(user)
                .submit();

        String expectedMessage = "The username can only contain letters and digits.";
        assertThat(postSignUpPage.getPageSource(), containsString(expectedMessage));
    }

    @Test
    public void enteringTwoDifferentPasswordsShouldFailSignUpProcess() {
        String invalidPassword = "InvalidPassword";
        User user = new UserBuilder().withDbInsert(false).build();

        PostSignUpPage postSignUpPage = forumPage
                .navigateToCreateAccountPage()
                .fillCreateUserForm(user)
                .setPasswordConfirmation(invalidPassword)
                .submit();

        String expectedMessage = "The two passwords did not match.";
        assertThat(postSignUpPage.getPageSource(), containsString(expectedMessage));
    }

    @AfterClass
    public void closeBrowser() {
        browser.closeBrowser();
    }
}
