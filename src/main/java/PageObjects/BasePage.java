package PageObjects;

import Interface.BaseInterface;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import util.BySelector;

public class BasePage implements BaseInterface {

    public WebDriver webDriver;

    //TODO: set BASE URL to env variables
    public BasePage(WebDriver driver) {
        this.webDriver = driver;
    }

    public void visit(String url) {
        String BASE_URL = "https://automationexercise.com/";
        this.webDriver.get(BASE_URL + url);
    }

    @Override
    public By findCustomElement(String element, BySelector bySelector) {
        return switch (bySelector) {
            case CLASSNAME ->By.className(element);
            case ID -> By.id(element);
            default -> By.cssSelector(element);
        };
    }

    @Override
    public WebElement findElement(By element) {
        return webDriver.findElement(element);
    }
}
