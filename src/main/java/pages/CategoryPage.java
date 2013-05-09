package pages;

import objects.Topic;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import webElements.Link;

/**
 * User: Mateusz Koncikowski
 * Date: 4/30/13
 * Time: 9:54 AM
 */

public class CategoryPage extends ForumPage {

    public CategoryPage(WebDriver driver) {
        super(driver);
        logPageOpening(this.getClass());
    }

    public TopicPage navigateToTopicPage(String topicSubject) {
        return new Link<TopicPage>(getDriver(), By.partialLinkText(topicSubject), TopicPage.class).click();
    }

    public TopicPage navigateToTopicPage(Topic topic) {
        return new Link<TopicPage>(getDriver(), By.partialLinkText(topic.getSubject()), TopicPage.class).click();
    }
}
