package TestCase;

import PageClass.LoginPage;
import PageClass.ProductPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class ProductPageTest {
    WebDriver driver;
    LoginPage objLoginPage;
    ProductPage objProductPage;
    SoftAssert softAsrt = new SoftAssert();

    @BeforeClass
    public void setUp() {
        driver = new ChromeDriver();
        objLoginPage = new LoginPage(driver);
        objLoginPage.openUrlToSwagLabsPage();
        objLoginPage.loginSwagLabs();
    }
    @Test(priority = 1)
    public void verifyUserCanSelectItem() {
        objProductPage = new ProductPage(driver);
        objProductPage.selectInventryItem1();

    }

    @Test(priority = 2)
    public void verifyNameOfTheItem() {
        objProductPage = new ProductPage(driver);
        objProductPage.getNameOfTheItem();
        softAsrt.assertEquals(objProductPage.getNameOfTheItem(), "Sauce Labs Fleece Jacket");
        softAsrt.assertAll();
    }

    @Test(priority = 3)
    public void verifyDescriptionOfTheItem() {
       // objProductPage = new ProductPage(driver);
        objProductPage.getDescriptionOfTheItem();
        softAsrt.assertNotNull(objProductPage.getDescriptionOfTheItem(),"Text is not present");
        softAsrt.assertAll();
    }

    @Test(priority = 4)
    public void verifyPriceOfTheItem() {
        objProductPage.getPriceOfTheItem();
        softAsrt.assertEquals(objProductPage.getPriceOfTheItem(), "$49.99");
        softAsrt.assertAll();
    }

    @Test(priority = 5)
    public void verifyAddToCart() {
        objProductPage.addToCart();
        softAsrt.assertEquals(objProductPage.getTextAfterClickingAddToCart(), "Remove");
        softAsrt.assertEquals(objProductPage.getShoppingCartBadgeColor(), "rgba(226, 35, 26, 1)");
        softAsrt.assertAll();
    }

    @Test(priority = 6)
    public void verifyBackToProducts() {
        objProductPage.clickBackToProducts();
        softAsrt.assertEquals(objLoginPage.getHomePageTitle(), "Products", "Navigation is failed");
        softAsrt.assertAll();
    }

    @Test(priority = 7)
    public void verifySelectInventryItem2() {
        objProductPage.selectInventryItem2();
    }

}
