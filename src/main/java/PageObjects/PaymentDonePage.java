package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class PaymentDonePage extends BasePage {
    public PaymentDonePage(WebDriver driver) {
        super(driver);
    }

    private final By button_continue = By.cssSelector("[data-qa='continue-button']");
    private final By header_order_placed = By.cssSelector("[data-qa='order-placed']");


    public WebElement getButton_continue() {
        return findElement(button_continue);
    }

    public WebElement getHeader_order_placed() {
        return findElement(header_order_placed);
    }
}
