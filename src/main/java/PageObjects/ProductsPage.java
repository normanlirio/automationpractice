package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class ProductsPage extends BasePage {

    public ProductsPage(WebDriver driver) {
        super(driver);
    }

    private final By anchor_add_to_cart = By.linkText("Add to cart");
    private final By anchor_view_cart = By.linkText("View Cart");
    private final By button_dismiss_modal = By.cssSelector("[data-dismiss='modal']");
    private final By div_modal_body = By.id("cartModal");
    private final By div_products = By.className("col-sm-4");


    public WebElement getButton_dismiss_modal() {
        return webDriver.findElement(button_dismiss_modal);
    }
    public WebElement getDiv_modal_body() {
        return webDriver.findElement(div_modal_body);
    }
    public List<WebElement> getDiv_products() {
        return webDriver.findElements(div_products);
    }

    public WebElement getAnchor_add_to_cart() {
        return webDriver.findElement(anchor_add_to_cart);
    }

    public WebElement getAnchor_view_cart() {
        return webDriver.findElement(anchor_view_cart);
    }
}
