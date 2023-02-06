package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class PaymentPage extends BasePage {
    public PaymentPage(WebDriver driver) {
        super(driver);
    }

    private final By body = By.xpath("//html/ins/div");
  //  private By body = By.id("dismiss-button");
    private final By button_payment_button = By.cssSelector("button[id='submit']");
    private final By header_payment = By.className("heading");
    private final By input_card_number = By.cssSelector("[data-qa='card-number']");
    private final By input_cvc = By.cssSelector("[data-qa='cvc']");
    private final By input_expiration_mm = By.cssSelector("[data-qa='expiry-month']");
    private final By input_expiration_yy = By.cssSelector("[data-qa='expiry-year']");
    private final By input_name_of_card = By.cssSelector("[data-qa='name-on-card']");


    public WebElement getBody() {
        return findElement(body);
    }
    public WebElement getButton_payment_button() {
        return findElement(button_payment_button);
    }

    public WebElement getHeader_payment() {
        return findElement(header_payment);
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
