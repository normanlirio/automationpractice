package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class PaymentPage extends BasePage {
    public PaymentPage(WebDriver driver) {
        super(driver);
    }

    private final By iframe_host = By.tagName("ins");
    private final By button_payment_button = By.cssSelector("button[id='submit']");
    private final By input_card_number = By.cssSelector("[data-qa='card-number']");
    private final By input_cvc = By.cssSelector("[data-qa='cvc']");
    private final By input_expiration_mm = By.cssSelector("[data-qa='expiry-month']");
    private final By input_expiration_yy = By.cssSelector("[data-qa='expiry-year']");
    private final By input_name_of_card = By.cssSelector("[data-qa='name-on-card']");

    public WebElement getButton_payment_button() {
        return findElement(button_payment_button);
    }
    public List<WebElement> getIframe_host() {
        return webDriver.findElements(iframe_host);
    }
    public WebElement getInput_card_number() {
        return findElement(input_card_number);
    }

    public WebElement getInput_cvc() {
        return findElement(input_cvc);
    }

    public WebElement getInput_expiration_mm() {
        return findElement(input_expiration_mm);
    }

    public WebElement getInput_expiration_yy() {
        return findElement(input_expiration_yy);
    }

    public WebElement getInput_name_of_card() {
        return findElement(input_name_of_card);
    }
}
