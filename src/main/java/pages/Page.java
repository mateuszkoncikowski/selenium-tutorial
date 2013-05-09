package pages;

import org.apache.log4j.Logger;
import org.apache.log4j.xml.DOMConfigurator;
import org.jsoup.Jsoup;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

/**
 * User: Mateusz Koncikowski
 * Date: 01.04.13
 * Time: 16:38
 */

public class Page {

    protected static Logger log = Logger.getLogger(Logger.class.getName());
    protected WebDriver driver;

    public Page(WebDriver driver) {
        this.driver = driver;
        DOMConfigurator.configure("log4j.xml");
    }

    public WebDriver getDriver() {
        return driver;
    }

    public String getPageSource() {
        return driver.getPageSource();
    }

    public String getPageSourceWithoutTags() {
        return Jsoup.parse(driver.getPageSource()).text();
    }

    public void refresh() {
        driver.navigate().refresh();
    }

    public List<String> extractTextFromWebElementList(List<WebElement> webElements) {
        List<String> webElementList = new ArrayList<String>();
        for (WebElement webElement : webElements) {
            webElementList.add(webElement.getText());
        }
        return webElementList;
    }

    public void logPageOpening(Class loadedClass) {
        String className = loadedClass.toString();
        className = Character.toUpperCase(className.charAt(0)) + className.substring(1);
        log.info(className + " has been opened");
    }
}
