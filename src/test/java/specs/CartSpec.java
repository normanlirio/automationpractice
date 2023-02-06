package specs;

import Actions.SimpleActions;
import PageObjects.CartPage;
import PageObjects.TopMenuBar;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import util.Drivers;

public class CartSpec extends BaseSpec {

    public CartPage cartPage;
    public TopMenuBar topMenuBar;

    public String URL = "view_cart";

    @BeforeTest
    public void initialize() {
        webDriver = initWebDriver(Drivers.CHROME);
        cartPage = new CartPage(webDriver);
        topMenuBar = new TopMenuBar(webDriver);
        simpleActions = new SimpleActions();
        actions = new Actions(webDriver);
        cartPage.visit(URL);
    }

    @Test
    public void gotoCartPage() {
        Assert.assertTrue(cartPage.getList_item_active().isDisplayed());

        if(cartPage.getSpan_empty_cart().isDisplayed()) {
            cartPage.visit("");
        }

    }
}
