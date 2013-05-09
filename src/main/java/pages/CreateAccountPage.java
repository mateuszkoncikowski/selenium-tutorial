package pages;

import objects.User;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import webElements.Button;
import webElements.InputField;

/**
 * User: Mateusz Koncikowski
 * Date: 22.04.13
 * Time: 21:20
 */

public class CreateAccountPage extends ForumPage {

    public CreateAccountPage(WebDriver driver) {
        super(driver);
        logPageOpening(this.getClass());
    }

    public CreateAccountPage setUsername(String username) {
        new InputField(getDriver(), By.name("user_name")).type(username);
        return this;
    }

    public CreateAccountPage setPassword(String password) {
        new InputField(getDriver(), By.name("user_pass")).type(password);
        return this;
    }

    public CreateAccountPage setPasswordConfirmation(String passwordConfirmation) {
        new InputField(getDriver(), By.name("user_pass_check")).type(passwordConfirmation);
        return this;
    }

    public CreateAccountPage setEmail(String email) {
        new InputField(getDriver(), By.name("user_email")).type(email);
        return this;
    }

    public PostSignUpPage submit() {
        return new Button<PostSignUpPage>(getDriver(), By.xpath("//input[@value='Add user']"), PostSignUpPage.class).click();
    }

    public CreateAccountPage fillCreateUserForm(User user) {
        setUsername(user.getName());
        setPassword(user.getPass());
        setPasswordConfirmation(user.getPass());
        setEmail(user.getEmail());
        return this;
    }

    public PostSignUpPage addAccount(User user) {
        return fillCreateUserForm(user).submit();
    }
}
