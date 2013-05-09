package webElements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * User: Mateusz Koncikowski
 * Date: 04.04.13
 * Time: 20:27
 */

public class Button<DestinationClass> extends Link<DestinationClass> {

    public Button(WebDriver driver, By locator, Class<DestinationClass> destinationClass) {
        super(driver, locator, destinationClass);
    }
}
