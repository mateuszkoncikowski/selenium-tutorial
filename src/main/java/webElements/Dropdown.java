package webElements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

/**
 * User: Mateusz Koncikowski
 * Date: 4/30/13
 * Time: 12:36 PM
 */

public class Dropdown extends CommonWebElement{

    public Dropdown(WebDriver driver, By locator) {
        super(driver, locator);
    }

    public void setValue(String value) {
        new Select(getWebElement()).selectByVisibleText(value);
    }
}
