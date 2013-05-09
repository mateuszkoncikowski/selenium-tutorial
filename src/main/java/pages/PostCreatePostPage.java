package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import webElements.Link;

/**
 * User: Mateusz Koncikowski
 * Date: 5/6/13
 * Time: 10:16 AM
 */

public class PostCreatePostPage extends ForumPage {

    public PostCreatePostPage(WebDriver driver) {
        super(driver);
        logPageOpening(this.getClass());

    }

    public TopicPage backToTopic() {
        return new Link<TopicPage>(getDriver(), By.linkText("the topic"), TopicPage.class).click();
    }
}
