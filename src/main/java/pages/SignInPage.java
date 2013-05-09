package pages;

import objects.User;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import webElements.Button;
import webElements.InputField;

/**
 * User: Mateusz Koncikowski
 * Date: 22.04.13
 * Time: 21:17
 */

public class SignInPage extends ForumPage {

    public SignInPage(WebDriver driver) {
        super(driver);
        logPageOpening(this.getClass());

    }

    public SignInPage setUsername(String username) {
        new InputField(getDriver(), By.name("user_name")).type(username);
        return this;
    }

    public SignInPage setPassword(String password) {
        new InputField(getDriver(), By.name("user_pass")).type(password);
        return this;
    }

    public PostSignInPage submit() {
        return new Button<PostSignInPage>(getDriver(), By.xpath("//input[@value='Sign in']"), PostSignInPage.class).click();
    }

    public PostSignInPage logIn(User user) {
        setUsername(user.getName());
        setPassword(user.getPass());
        return submit();
    }

}
