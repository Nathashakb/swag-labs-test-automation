package PageClass;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.time.Instant;

public class LoginPage {

    WebDriver driver;
    private WebDriverWait wait;

By username = By.id("user-name");
By passward  = By.id("password");
By loginbtn = By.id("login-button");
By loginlogo = By.xpath("//*[@class='login_logo']");
By pagetitle = By.xpath("//*[@class='title']");


    public LoginPage(WebDriver driver) {
        this.driver = driver;
        int timeoutInSeconds = 10; // example timeout value
        Duration timeout = Duration.ofSeconds(timeoutInSeconds);
        wait = new WebDriverWait(driver, timeout);
        driver.manage().window().maximize();
    }

    public void openUrlToSwagLabsPage() {
        driver.get("https://www.saucedemo.com/");
        driver.manage().window().maximize(); // Update the URL as needed
    }

    public String getPageTitle() {
        return driver.getTitle();
    }

    public void loginSwagLabs() {
        WebElement uersernameElement = wait.until(ExpectedConditions.visibilityOfElementLocated(username));
        uersernameElement.sendKeys("standard_user");
        WebElement passwardElement = wait.until(ExpectedConditions.visibilityOfElementLocated(passward));
        passwardElement.sendKeys("secret_sauce");
        WebElement loginbtnElement = wait.until(ExpectedConditions.visibilityOfElementLocated(loginbtn));
        loginbtnElement.click();
       // driver.findElement(passward).sendKeys("secret_sauce");
      //  driver.findElement(loginbtn).click();

    }
    public void threadSleep(int milliseconds) {
        try {
            Thread.sleep(milliseconds);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public String getHomePageTitle() {
        threadSleep(2000);
       return driver.findElement(pagetitle).getText();

    }
}

