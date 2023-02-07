package specs.e2e;

import PageObjects.LoginPage;
import PageObjects.TopMenuBar;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import specs.BaseSpec;
import util.Drivers;
import util.TestData;

@Test(description = "End to end test for Login")
public class LoginSpec extends BaseSpec {

    private LoginPage loginPage;
    private TopMenuBar topMenuBar;

    public LoginSpec() {
        super(Drivers.CHROME);
    }

    @BeforeClass
    public void initialize() {
        loginPage = new LoginPage(webDriver);
        topMenuBar = new TopMenuBar(webDriver);
    }

    @Test
    public void performLogin() {
        loginPage.visit(TestData.LOGIN_URL);
        Assert.assertEquals(simpleActions.isVisible(loginPage.getForm_login()), true);

        simpleActions.type(loginPage.getInput_login_email(), testProperties.getProperty("login.email"));
        simpleActions.type(loginPage.getInput_login_password(),  testProperties.getProperty("login.password"));
        simpleActions.click(loginPage.getButton_login_submit());

        Assert.assertTrue(simpleActions.isVisible(topMenuBar.getAnchor_logout()));

    }


}
