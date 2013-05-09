package webElements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

/**
 * User: Mateusz Koncikowski
 * Date: 04.04.13
 * Time: 20:03
 */

public class CommonWebElement {
    private final WebDriver driver;
    private final By locator;

    public CommonWebElement(WebDriver driver, By locator) {
        this.driver = driver;
        this.locator = locator;
    }

    public WebElement getWebElement() {
        return driver.findElement(locator);
    }

    public List<WebElement> getWebElements() {
        return driver.findElements(locator);
    }

    public WebDriver getDriver() {
        return driver;
    }

    public boolean isPresent() {
        try {
            driver.findElement(locator);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
