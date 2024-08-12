package TestCase;

import PageClass.CheckoutPage;
import PageClass.LoginPage;
import PageClass.ProductPage;
import PageClass.YourCartPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class CheckoutPageTest {
    LoginPage objLoginPage;
    ProductPage objProductPage;
    YourCartPage objYourCartPage;
    CheckoutPage objCheckoutPage;
    WebDriver driver;

    @BeforeClass
    public void setUp() {
        driver = new ChromeDriver();
        objLoginPage = new LoginPage(driver);
        objProductPage = new ProductPage(driver);
        objYourCartPage = new YourCartPage(driver);
        objLoginPage.openUrlToSwagLabsPage();
        objLoginPage.loginSwagLabs();
        objProductPage.selectInventryItem1();
        objProductPage.addToCart();
        objYourCartPage.clickYourCartLink();
        objYourCartPage.clickCheckout();
    }

    @Test(priority = 1)
    public void verifyCheckoutPage() {
        objCheckoutPage = new CheckoutPage(driver);
        objCheckoutPage.enterFirstName();
        objCheckoutPage.enterLastName();
        objCheckoutPage.enterPostalCode();
        objCheckoutPage.clickContinue();
        Assert.assertEquals(objCheckoutPage.getCheckoutOverwiewPageTitle(), "Checkout: Overview");
    }
}
