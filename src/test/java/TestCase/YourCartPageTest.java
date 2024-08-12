package TestCase;

import PageClass.LoginPage;
import PageClass.ProductPage;
import PageClass.YourCartPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class YourCartPageTest {
    WebDriver driver;
    LoginPage objLoginPage;
    SoftAssert softAsrt = new SoftAssert();
    ProductPage objproductPage;
    YourCartPage objYourCartPage;

    @BeforeClass
    public void setUp() {
        driver = new ChromeDriver();
        objLoginPage = new LoginPage(driver);
        objproductPage = new ProductPage(driver);
        objYourCartPage = new YourCartPage(driver);
        objLoginPage.openUrlToSwagLabsPage();
        objLoginPage.loginSwagLabs();
        objproductPage.selectInventryItem1();
        objproductPage.addToCart();

    }

    @Test(priority = 1)
    public void verifyYourCartPage() {
        objYourCartPage.clickYourCartLink();
        softAsrt.assertEquals(objYourCartPage.getYourCartPageTitle(), "Your Cart");
        softAsrt.assertAll();
    }


    @Test(priority = 2)
    public void verifyNameOfTheItem() {
        softAsrt.assertEquals(objYourCartPage.checkNameOfTheItem(), "Sauce Labs Fleece Jacket");
        softAsrt.assertAll();
    }

    @Test(priority = 3)
    public void verifyQuantityOfTheItem() {
        softAsrt.assertEquals(objYourCartPage.checkQuantityOfTheItem(), 1);
        softAsrt.assertAll();
    }

    @Test(priority = 4)
    public void verifyUserCanRItem() {
        objYourCartPage.removeItem();
        objYourCartPage.checkItemremoved();
    }

    @Test(priority = 5)
    public void verifyUserCanClickCheckout() {
        objYourCartPage.clickCheckout();
        softAsrt.assertEquals(objYourCartPage.getCheckoutPageTitle(), "Checkout: Your Information");
        softAsrt.assertAll();
    }
}
