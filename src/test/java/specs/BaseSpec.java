package specs;

import Actions.SimpleActions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import util.Drivers;

import java.time.Duration;

public class BaseSpec {

    public Actions actions;
    public WebDriver webDriver;
    public WebDriverWait wait;
    public SimpleActions simpleActions;

    public WebDriver initWebDriver(Drivers driver) {
        return switch (driver) {
            case FIREFOX -> new FirefoxDriver();
            default -> new ChromeDriver();
        };
    }

    public WebDriverWait initializeWait() {
       try {
           wait = new WebDriverWait(webDriver, Duration.ofMillis(3000L));
       } catch (NullPointerException e) {
           e.getLocalizedMessage();
           System.out.println("WebDriver not initialized: "  + e.getLocalizedMessage());
       }
       return wait;
    }


}
