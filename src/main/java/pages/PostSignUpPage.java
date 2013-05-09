package pages;

import org.openqa.selenium.WebDriver;

/**
 * User: Mateusz Koncikowski
 * Date: 4/26/13
 * Time: 3:22 PM
 */

public class PostSignUpPage extends ForumPage {

    public PostSignUpPage(WebDriver driver) {
        super(driver);
        logPageOpening(this.getClass());

    }
}
