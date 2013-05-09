package pages;

import objects.Category;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import webElements.Link;

import java.util.ArrayList;
import java.util.List;

/**
 * User: Mateusz Koncikowski
 * Date: 01.04.13
 * Time: 16:49
 */

public class Index extends ForumPage {

    public Index(WebDriver driver) {
        super(driver);
        logPageOpening(this.getClass());
    }

    public List<String> getCategories() {
        List<WebElement> categoryLinks = getDriver().findElements(By.xpath("//td[@class='leftpart']//a"));
        return extractTextFromWebElementList(categoryLinks);
    }

    public CategoryPage navigateToCategoryPage(String categoryName) {
        return new Link<CategoryPage>(getDriver(), By.linkText(categoryName), CategoryPage.class).click();
    }

    public CategoryPage navigateToCategoryPage(Category category) {
        return new Link<CategoryPage>(getDriver(), By.linkText(category.getName()), CategoryPage.class).click();
    }
}
