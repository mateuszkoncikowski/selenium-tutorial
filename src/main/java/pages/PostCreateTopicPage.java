package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import webElements.InputField;
import webElements.Link;

/**
 * User: Mateusz Koncikowski
 * Date: 4/30/13
 * Time: 12:34 PM
 */

public class PostCreateTopicPage extends ForumPage {

    public PostCreateTopicPage(WebDriver driver) {
        super(driver);
        logPageOpening(this.getClass());

    }
}
