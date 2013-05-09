package pages;

import org.openqa.selenium.WebDriver;

/**
 * User: Mateusz Koncikowski
 * Date: 4/30/13
 * Time: 8:08 AM
 */

public class PostCreateCategoryPage extends ForumPage {
    public PostCreateCategoryPage(WebDriver driver) {
        super(driver);
        logPageOpening(this.getClass());

    }
}
