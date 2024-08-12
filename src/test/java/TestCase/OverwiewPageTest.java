package TestCase;

import PageClass.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class OverwiewPageTest {
    LoginPage objLoginPage;
    ProductPage objProductPage;
    YourCartPage objYourCartPage;
    CheckoutPage objCheckoutPage;
    OverwiewPage objOverwiewPage;
    SoftAssert Asrt = new SoftAssert();

    @BeforeClass
    public void setUp() {
        WebDriver driver = new ChromeDriver();
        objLoginPage = new LoginPage(driver);
        objProductPage = new ProductPage(driver);
        objYourCartPage = new YourCartPage(driver);
        objCheckoutPage = new CheckoutPage(driver);
        objOverwiewPage = new OverwiewPage(driver);
        objLoginPage.openUrlToSwagLabsPage();
        objLoginPage.loginSwagLabs();
        objProductPage.selectInventryItem1();
        objProductPage.addToCart();
        objProductPage.clickBackToProducts();
        objProductPage.selectInventryItem2();
        objYourCartPage.clickYourCartLink();
        objYourCartPage.clickCheckout();
        objCheckoutPage.enterFirstName();
        objCheckoutPage.enterLastName();
        objCheckoutPage.enterPostalCode();
        objCheckoutPage.clickContinue();
    }

    @Test(priority = 1)
    public void verifyItemTotalToPay() {

        objOverwiewPage.getTotalItemPrice();
        Asrt.assertEquals(objOverwiewPage.getItemTotal(), "Item total: $"+objOverwiewPage.checkTotalItemPrice());
        Asrt.assertAll();

    }

    @Test(priority = 2)
    public void verifyTotalAmountToPayWithTax() {
        objOverwiewPage.getTotalAmountToPayWithTax() ;
        Asrt.assertEquals(objOverwiewPage.getTotal(), "Item total: $"+objOverwiewPage.checkTotalPriceWithTax(),"Invalid total amount");
        Asrt.assertAll();
    }

    @Test(priority = 3)
    public void verifyFinish() {
        objOverwiewPage.clickFinish();
        Asrt.assertEquals(objOverwiewPage.getComplete(), "Checkout: Complete!");
        Asrt.assertAll();
    }

    @Test(priority = 4)
    public void verifyBackToProducts() {
        objOverwiewPage.clickBackHome();
        Asrt.assertEquals(objLoginPage.getHomePageTitle(), "Products");
        Asrt.assertAll();
    }
}
