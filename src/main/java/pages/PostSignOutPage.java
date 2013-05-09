package pages;

import org.openqa.selenium.WebDriver;

/**
 * User: Mateusz Koncikowski
 * Date: 4/29/13
 * Time: 11:29 AM
 */

public class PostSignOutPage extends ForumPage {

    public PostSignOutPage(WebDriver driver) {
        super(driver);
        logPageOpening(this.getClass());

    }
}
