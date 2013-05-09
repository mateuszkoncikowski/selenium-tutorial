package pages;

import objects.Post;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import webElements.Button;
import webElements.InputField;

import java.util.List;

/**
 * User: Mateusz Koncikowski
 * Date: 5/6/13
 * Time: 9:54 AM
 */

public class TopicPage extends ForumPage {

    public TopicPage(WebDriver driver) {
        super(driver);
        logPageOpening(this.getClass());
    }

    public TopicPage setPostContent(String postContent) {
        new InputField(getDriver(), By.name("reply-content")).type(postContent);
        return this;
    }

    public PostCreatePostPage submit() {
        return new Button<PostCreatePostPage>(getDriver(),
                By.xpath("//input[@type='submit']"), PostCreatePostPage.class).click();
    }

    public TopicPage fillAddPostForm(Post post) {
        setPostContent(post.getContent());
        return this;
    }

    public PostCreatePostPage addPost(Post post) {
        return fillAddPostForm(post).submit();
    }

    public List<String> getPosts() {
        List<WebElement> posts = getDriver().findElements(By.xpath("//td[@class='post-content']"));
        return extractTextFromWebElementList(posts);
    }
}
