package specs.e2e;

import Actions.SimpleActions;
import PageObjects.LoginPage;
import PageObjects.TopMenuBar;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import specs.BaseSpec;
import util.Drivers;

public class LoginSpec extends BaseSpec {

    private LoginPage loginPage;
    private TopMenuBar topMenuBar;

    @BeforeTest
    public void initialize() {
        webDriver = initWebDriver(Drivers.CHROME);
        initializeWait();
        loginPage = new LoginPage(webDriver);
        String LOGIN_URL = "login";
        loginPage.visit(LOGIN_URL);
        topMenuBar = new TopMenuBar(webDriver);
        simpleActions = new SimpleActions();
        actions = new Actions(webDriver);
    }

    @Test
    public void performLogin() {
        Assert.assertEquals(simpleActions.isVisible(loginPage.getForm_login()), true);

        simpleActions.type(loginPage.getInput_login_email(), "normz@mailinator.com");
        simpleActions.type(loginPage.getInput_login_password(), "123456");
        simpleActions.click(loginPage.getButton_login_submit());

        Assert.assertTrue(simpleActions.isVisible(topMenuBar.getAnchor_logout()));

    }


}
