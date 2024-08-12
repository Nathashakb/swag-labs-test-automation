package TestCase;

import PageClass.LoginPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class LoginPageTest {
    WebDriver driver;
    LoginPage objLoginPage;
    SoftAssert softAsrt = new SoftAssert();

    @BeforeClass
    public void setUp() {
        driver = new ChromeDriver();
        objLoginPage = new LoginPage(driver);
    }


     @Test(priority = 1)
     public void verifyOpenUrlToSwagLabsPage() {
        objLoginPage.openUrlToSwagLabsPage();
        softAsrt.assertEquals(driver.getCurrentUrl(), "https://www.saucedemo.com/");
        softAsrt.assertAll();
    }

    @Test(priority = 2)
    public void verifyLoginPageTitle() {
        String expectedTitle = "Swag Labs";
        String actualTitle = objLoginPage.getPageTitle();
        softAsrt.assertEquals(actualTitle,expectedTitle, "Page title did not match the expected title");
        softAsrt.assertAll();
    }

    @Test(priority = 3)
    public void verifySwagLabsLogin() {
        objLoginPage.loginSwagLabs();
        softAsrt.assertEquals(objLoginPage.getHomePageTitle(), "Products", "Navigation is failed");
        softAsrt.assertAll();
    }




}
