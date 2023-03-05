package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import util.ByPageSelector;

public class CartPage extends BasePage {

    public CartPage(WebDriver driver) {
        super(driver);
    }

    private final By button_proceed_to_checkout= By.linkText("Proceed To Checkout");
    private final By list_item_active = By.cssSelector("li[class='active']");
    private final By table_cart_info = By.id("cart_info_table");

    public WebElement getButton_proceed_to_checkout() {
        return findElement(button_proceed_to_checkout);
    }

    public WebElement getCustomElement(String element, ByPageSelector byPageSelector) {
        return findElement(findCustomElement(element, byPageSelector));
    }
    public WebElement getList_item_active() {
        return findElement(list_item_active);
    }
    public WebElement getTable_cart_info() {
        return findElement(table_cart_info);
    }
}
