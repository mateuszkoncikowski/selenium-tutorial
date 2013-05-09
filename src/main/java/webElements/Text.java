package webElements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * User: Mateusz Koncikowski
 * Date: 04.04.13
 * Time: 20:20
 */

public class Text extends CommonWebElement {

    public Text(WebDriver driver, By locator) {
        super(driver, locator);
    }

    public String getText() {
        return getWebElement().getText();
    }
}
