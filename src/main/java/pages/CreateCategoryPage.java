package pages;

import objects.Category;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import webElements.Button;
import webElements.InputField;

/**
 * User: Mateusz Koncikowski
 * Date: 22.04.13
 * Time: 21:16
 */

public class CreateCategoryPage extends ForumPage {

    public CreateCategoryPage(WebDriver driver) {
        super(driver);
        logPageOpening(this.getClass());

    }

    public CreateCategoryPage setCategoryName(String categoryName) {
        new InputField(getDriver(), By.name("cat_name")).type(categoryName);
        return this;
    }

    public CreateCategoryPage setCategoryDescription(String categoryDescription) {
        new InputField(getDriver(), By.name("cat_description")).type(categoryDescription);
        return this;
    }

    public PostCreateCategoryPage submit() {
        return new Button<PostCreateCategoryPage>(getDriver(), By.id("create_category_button"), PostCreateCategoryPage.class).click();
    }

    public CreateCategoryPage fillCreateCategoryForm(Category category) {
        setCategoryName(category.getName());
        setCategoryDescription(category.getDescription());
        return this;
    }

    public PostCreateCategoryPage addCategory(Category category) {
        return fillCreateCategoryForm(category).submit();
    }
}
