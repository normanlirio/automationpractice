package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CartPage extends BasePage {

    public CartPage(WebDriver driver) {
        super(driver);
    }
    private final By button_proceed_to_checkout= By.linkText("Proceed To Checkout");
    private final By table_cart_info = By.id("cart_info_table");
    public WebElement getButton_proceed_to_checkout() {
        return findElement(button_proceed_to_checkout);
    }
    public WebElement getTable_cart_info() {
        return findElement(table_cart_info);
    }
}
