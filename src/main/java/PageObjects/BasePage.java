package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import util.ByPageSelector;
import util.PropertiesHelper;

import java.util.Properties;

public class BasePage {

    private Properties properties;
    public WebDriver webDriver;

    public BasePage(WebDriver driver) {
        this.webDriver = driver;
        properties = new PropertiesHelper().loadProperties();
    }

    public void visit(String url) {
        this.webDriver.get(properties.getProperty("base.url") + url);
    }

    public By findCustomElement(String element, ByPageSelector byPageSelector) {
        return switch (byPageSelector) {
            case CLASSNAME -> By.className(element);
            case ID -> By.id(element);
            default -> By.cssSelector(element);
        };
    }

    public WebElement findElement(By element) {
        return webDriver.findElement(element);
    }
}
