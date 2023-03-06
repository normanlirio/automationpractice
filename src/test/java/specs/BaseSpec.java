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

public class BaseSpec {

    private Drivers drivers;

    public Actions actions;
    public Properties testProperties;
    public WebDriver webDriver;
    public WebDriverWait wait;
    public SimpleActions simpleActions;

    @BeforeTest
    public void setUp() {
        testProperties = new PropertiesHelper().loadProperties();
        setUpWebDriver();
        initializeWait();
        simpleActions = new SimpleActions();
        actions = new Actions(webDriver);
    }
    private void setUpWebDriver() {
        if (testProperties.getProperty("driver").equals("firefox")) {
            webDriver = new FirefoxDriver();
        } else {
            webDriver = new ChromeDriver();
        }
        webDriver.manage().window().maximize();
    }

    private WebDriverWait initializeWait() {
        try {
            wait = new WebDriverWait(webDriver, Duration.ofMillis(5000L));
        } catch (NullPointerException e) {
            e.getLocalizedMessage();
            System.out.println("WebDriver not initialized: " + e.getLocalizedMessage());
        }
        return wait;
    }

    @AfterTest
    public void tearDown() { webDriver.close(); }
}
