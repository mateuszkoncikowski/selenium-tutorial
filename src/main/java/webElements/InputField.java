package webElements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * User: Mateusz Koncikowski
 * Date: 07.04.13
 * Time: 13:52
 */

public class InputField extends CommonWebElement {
    public InputField(WebDriver driver, By locator) {
        super(driver, locator);
    }

    public void type(String value) {
        getWebElement().sendKeys(value);
    }
}
