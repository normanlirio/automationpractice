package specs;

import Actions.SimpleActions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import util.Drivers;
import util.PropertiesHelper;

import java.time.Duration;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class BaseSpec {

    private Drivers drivers;

    public Actions actions;
    public Properties testProperties;
    public WebDriver webDriver;
    public WebDriverWait wait;
    public SimpleActions simpleActions;

    public BaseSpec(Drivers drivers) {
        this.drivers = drivers;
    }

    private WebDriverWait initializeWait() {
        try {
            wait = new WebDriverWait(webDriver, Duration.ofMillis(3000L));
        } catch (NullPointerException e) {
            e.getLocalizedMessage();
            System.out.println("WebDriver not initialized: " + e.getLocalizedMessage());
        }
        return wait;
    }

    private void setUpWebDriver() {
        switch (this.drivers) {
            case FIREFOX -> webDriver = new FirefoxDriver();
            default -> webDriver = new ChromeDriver();
        }
        webDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);


    }

    @BeforeTest
    public void setUp() {
        setUpWebDriver();
        initializeWait();
        simpleActions = new SimpleActions();
        actions = new Actions(webDriver);
        testProperties = new PropertiesHelper().loadProperties();
    }

    @AfterTest
    public void tearDown() {
        webDriver.close();
    }


}
