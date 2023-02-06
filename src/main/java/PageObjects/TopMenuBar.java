package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class TopMenuBar extends BasePage {


    public TopMenuBar(WebDriver driver) {
        super(driver);
    }
    private final By anchor_cart = By.linkText("Cart");
    private final By anchor_logout = By.linkText("Logout");

    public WebElement getAnchor_cart() { return  webDriver.findElement(anchor_cart); }
    public WebElement getAnchor_logout() {
        return webDriver.findElement(anchor_logout);
    }

}
