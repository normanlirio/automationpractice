package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CheckoutPage extends BasePage {
    public CheckoutPage(WebDriver driver) {
        super(driver);
    }

    private final By ad_iframe = By.cssSelector("[data-ad-status='filled']");
    private final By body = By.xpath("//html/ins/div");
    private final By anchor_place_order = By.xpath("//html/body/section/div/div/a");
    private final By header_page_subheading = By.cssSelector("h3[class='page-subheading'");
    private final By textarea_comment = By.cssSelector("textarea[name='message'");

    public WebElement getBody() {
        return findElement(body);
    }

    public WebElement getAnchor_place_order() {
        return findElement(anchor_place_order);
    }

    public WebElement getHeader_page_subheading() {
        return findElement(header_page_subheading);
    }

    public WebElement getTextarea_comment() {
        return findElement(textarea_comment);
    }
}
