package pages;

import objects.Category;
import objects.Topic;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import webElements.Button;
import webElements.Dropdown;
import webElements.InputField;

/**
 * User: Mateusz Koncikowski
 * Date: 22.04.13
 * Time: 21:14
 */

public class CreateTopicPage extends ForumPage {

    public CreateTopicPage(WebDriver driver) {
        super(driver);
        logPageOpening(this.getClass());

    }

    public CreateTopicPage setTopicSubject(String name) {
        new InputField(getDriver(), By.name("topic_subject")).type(name);
        return this;
    }

    public CreateTopicPage setTopicCategory(Category category) {
        new Dropdown(getDriver(), By.name("topic_cat")).setValue(category.getName());
        return this;
    }

    public CreateTopicPage setTopicMessage(String message) {
        new InputField(getDriver(), By.name("post_content")).type(message);
        return this;
    }

    public PostCreateTopicPage submit() {
        return new Button<PostCreateTopicPage>(getDriver(), By.xpath("//input[@type='submit']"), PostCreateTopicPage.class).click();
    }

    public CreateTopicPage fillCreateTopicForm(Topic topic) {
        setTopicSubject(topic.getSubject());
        setTopicCategory(topic.getCategory());
        setTopicMessage(topic.getFirstPost());
        return this;
    }

    public PostCreateTopicPage addTopic(Topic topic) {
        return fillCreateTopicForm(topic).submit();
    }
}
