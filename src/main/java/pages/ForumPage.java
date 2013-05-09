package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import webElements.Button;

/**
 * User: Mateusz Koncikowski
 * Date: 04.04.13
 * Time: 20:11
 */

public class ForumPage extends Page {

    private Button<PostSignOutPage> signOutButton =
            new Button<PostSignOutPage>(getDriver(), By.id("sign_out"), PostSignOutPage.class);

    public ForumPage(WebDriver driver) {
        super(driver);
    }

    public Index navigateToIndex() {
        return new Button<Index>(getDriver(), By.id("home"), Index.class).click();
    }

    public CreateTopicPage navigateToCreateTopicPage() {
        return new Button<CreateTopicPage>(getDriver(), By.id("create_topic"), CreateTopicPage.class).click();
    }

    public CreateCategoryPage navigateToCreateCategoryPage() {
        return new Button<CreateCategoryPage>(getDriver(), By.id("create_category"), CreateCategoryPage.class).click();
    }

    public SignInPage navigateToSignInPage() {
        if (!isLoggedIn()) {
            return new Button<SignInPage>(getDriver(), By.id("sign_in"), SignInPage.class).click();
        } else {
            throw new IllegalStateException("You cannot sign in, when already logged in");
        }
    }

    public CreateAccountPage navigateToCreateAccountPage() {
        return new Button<CreateAccountPage>(getDriver(), By.id("sign_up"), CreateAccountPage.class).click();
    }

    public PostSignOutPage signOut() {
        if (isLoggedIn()) {
            PostSignOutPage postSignOutPage = signOutButton.click();
            refresh();
            return postSignOutPage;
        } else {
            throw new IllegalStateException("You cannot sign out, when not logged id");
        }
    }

    public boolean isLoggedIn() {
        return signOutButton.isPresent();
    }

    public ForumPage signOutIfAlreadyLoggedIn() {
        if (isLoggedIn()) {
            return signOut();
        }
        return this;
    }

}
