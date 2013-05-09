package pages;

import org.openqa.selenium.WebDriver;

/**
 * User: Mateusz Koncikowski
 * Date: 4/29/13
 * Time: 9:37 AM
 */

public class PostSignInPage extends ForumPage {

    public PostSignInPage(WebDriver driver) {
        super(driver);
        logPageOpening(this.getClass());

    }
}
