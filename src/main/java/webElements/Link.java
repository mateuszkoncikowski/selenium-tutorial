package webElements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

/**
 * User: Mateusz Koncikowski
 * Date: 01.04.13
 * Time: 19:01
 */

public class Link<DestinationClass> extends CommonWebElement {

    Class<DestinationClass> destinationClass;

    public Link(WebDriver driver, By locator, Class<DestinationClass> destinationClass) {
        super(driver, locator);
        this.destinationClass = destinationClass;
    }

    public DestinationClass click() {
        getWebElement().click();
        return PageFactory.initElements(getDriver(), destinationClass);
    }

    public String getLinkText() {
        return getWebElement().getText();
    }
}
