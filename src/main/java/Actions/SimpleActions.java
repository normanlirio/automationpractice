package Actions;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SimpleActions {

    public void click(WebElement element) {
        element.click();
    }

    public Boolean isVisible(WebElement element) {
        return element.isDisplayed();
    }

    public void scrollIntoView(Actions actions, WebElement element) {
        actions.moveToElement(element).perform();
    }
    public void type(WebElement element, String query) {
        element.sendKeys(query);
    }

    public void waitForElement(WebDriverWait wait, WebElement element) {
        wait.until(ExpectedConditions.visibilityOfAllElements(element));
    }

}
