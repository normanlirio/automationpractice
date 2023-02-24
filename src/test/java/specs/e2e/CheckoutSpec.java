package specs.e2e;

import PageObjects.*;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchFrameException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import specs.BaseSpec;
import util.TestData;

import java.time.Duration;

@Test(description = "End to end test for checkout")
public class CheckoutSpec extends BaseSpec {

    private WebDriver adDriver;
    private CartPage cartPage;
    private CheckoutPage checkoutPage;
    private LoginPage loginPage;
    private PaymentPage paymentPage;
    private PaymentDonePage paymentDonePage;
    private ProductsPage productsPage;
    private TopMenuBar topMenuBar;
    private WebDriver creativeDriver;

   @BeforeTest
    public void initialize() {
        cartPage = new CartPage(webDriver);
        checkoutPage = new CheckoutPage(webDriver);
        loginPage = new LoginPage(webDriver);
        paymentPage = new PaymentPage(webDriver);
        paymentDonePage = new PaymentDonePage(webDriver);
        productsPage = new ProductsPage(webDriver);
        topMenuBar = new TopMenuBar(webDriver);
    }

    @Test(priority = 0)
    public void performLogin()  {
        loginPage.visit(TestData.LOGIN_URL);
        simpleActions.waitForElement(wait, loginPage.getForm_login());

        Assert.assertEquals(simpleActions.isVisible(loginPage.getForm_login()), true);

        simpleActions.type(loginPage.getInput_login_email(), System.getProperty("testUsername"));
        simpleActions.type(loginPage.getInput_login_password(),  System.getProperty("testPassword"));
        simpleActions.click(loginPage.getButton_login_submit());
        Assert.assertTrue(simpleActions.isVisible(topMenuBar.getAnchor_logout()));

    }

    @Test(priority = 1)
    public void performAddToCart() {
        Assert.assertTrue(productsPage.getDiv_products().get(1).isDisplayed());
        simpleActions.scrollIntoView(actions, productsPage.getDiv_products().get(1));
        simpleActions.click(productsPage.getAnchor_add_to_cart());

        simpleActions.waitForElement(wait, productsPage.getDiv_modal_body());
        Assert.assertTrue(simpleActions.isVisible(productsPage.getDiv_modal_body()));

        simpleActions.click(productsPage.getButton_dismiss_modal());
    }

    @Test(priority = 2)
    public void performPlaceOrder() {
        simpleActions.click(topMenuBar.getAnchor_cart());
        Assert.assertTrue(simpleActions.isVisible(cartPage.getList_item_active()));

        if (!cartPage.getSpan_empty_cart().isDisplayed()) {
            Assert.assertTrue(simpleActions.isVisible(cartPage.getTable_cart_info()));
            simpleActions.click(cartPage.getButton_proceed_to_checkout());

            Assert.assertTrue(simpleActions.isVisible(checkoutPage.getHeader_page_subheading()));
            simpleActions.type(checkoutPage.getTextarea_comment(), TestData.TEXT_COMMENT);
            simpleActions.waitForElement(wait, checkoutPage.getAnchor_place_order());
            simpleActions.click(checkoutPage.getAnchor_place_order());
            Assert.assertTrue(simpleActions.isVisible(paymentPage.getHeader_payment()));

        } else cartPage.visit(TestData.HOME_URL);

    }

    @Test(priority = 3)
    public void performPayment() {
        System.out.println("performPayment");
        Assert.assertTrue(simpleActions.isVisible(paymentPage.getBody()));
        findWhich();
        WebElement dismissButton;
        if(adDriver.findElements(By.id(TestData.DISMISS_BUTTON)).size() > 0) {
            dismissButton = adDriver.findElement(By.id(TestData.DISMISS_BUTTON));
        } else {
            creativeDriver = adDriver.switchTo().frame("ad_iframe");
            dismissButton = creativeDriver.findElement(By.id(TestData.DISMISS_BUTTON));
        }

        dismissButton.click();
        WebDriverWait creativeDriverWait = new WebDriverWait(creativeDriver, Duration.ofMillis(3000L));
        try {
            creativeDriverWait.until(ExpectedConditions.invisibilityOfElementLocated(By.id(TestData.DISMISS_BUTTON)));
        } catch (Exception e) {
            System.out.println(e.getLocalizedMessage());
        }
        Assert.assertTrue(simpleActions.isVisible(paymentPage.getHeader_payment()));

        simpleActions.type(paymentPage.getInput_name_of_card(), TestData.NAME_ON_CARD);
        simpleActions.type(paymentPage.getInput_card_number(), TestData.CARD_NUMBER);
        simpleActions.type(paymentPage.getInput_cvc(), TestData.CARD_CVC);
        simpleActions.type(paymentPage.getInput_expiration_mm(), TestData.EXPIRATION_MM);
        simpleActions.type(paymentPage.getInput_expiration_yy(), TestData.EXPIRATION_YY);
        simpleActions.click(paymentPage.getButton_payment_button());

        Assert.assertTrue(simpleActions.isVisible(paymentDonePage.getHeader_order_placed()));

        simpleActions.click(paymentDonePage.getButton_continue());

       Assert.assertEquals(webDriver.getCurrentUrl(), TestData.BASE_URL);
    }


    private void findWhich() {
        Boolean aSwift;
        int aswiftCount = 1;
        do {
            aSwift = findAdHostFrame(aswiftCount);
            aswiftCount++;
        } while(!aSwift);
        System.out.println("Current Aswift: " + aswiftCount);
    }


    private Boolean findAdHostFrame(int frame) {
        try {
            adDriver = webDriver.switchTo().frame("aswift_1");
            return true;
        } catch (NoSuchFrameException noSuchFrameException) {
            adDriver = webDriver.switchTo().frame("aswift_" + frame);
            return false;
        }
    }

}
