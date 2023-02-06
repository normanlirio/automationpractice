package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage extends BasePage {

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    private final By button_login_submit = By.cssSelector("[data-qa='login-button']");
    private final By input_login_email = By.cssSelector("[data-qa='login-email']");
    private final By input_login_password = By.cssSelector("[data-qa='login-password']");
    private final By form_login = By.className("login-form");

    public WebElement getButton_login_submit() {
        return webDriver.findElement(button_login_submit);
    }
    public WebElement getInput_login_email() {
        return webDriver.findElement(input_login_email);
    }
    public WebElement getInput_login_password() { return webDriver.findElement(input_login_password); }
    public WebElement getForm_login() { return webDriver.findElement(form_login); }

}
