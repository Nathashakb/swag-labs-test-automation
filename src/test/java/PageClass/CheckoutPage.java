package PageClass;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.time.Instant;


public class CheckoutPage  {

    By firstname = By.xpath("//input[@id='first-name']");
    By lastname = By.xpath("//input[@id='last-name']");
    By postalcode = By.xpath("//input[@id='postal-code']");
    By continuebtn = By.xpath("//input[@id='continue']");
    By cancelbtn = By.xpath("//button[@id='cancel']");
    By overwiewtitle = By.xpath("//span[@class='title']");

    WebDriver driver;
    private WebDriverWait wait;

    public CheckoutPage(WebDriver driver) {
        this.driver = driver;
        int timeoutInSeconds = 10; // example timeout value
        Duration timeout = Duration.ofSeconds(timeoutInSeconds);
        wait = new WebDriverWait(driver, timeout);
       // driver.manage().window().maximize();
    }

    public void enterFirstName() {

        WebElement firstNameElement = wait.until(ExpectedConditions.visibilityOfElementLocated(firstname));
        firstNameElement.sendKeys("Nathasha");
    }
    public void enterLastName() {
        WebElement lastNameElement = wait.until(ExpectedConditions.visibilityOfElementLocated(lastname));
        lastNameElement.sendKeys("Boralessa");
       // driver.findElement(lastname).sendKeys("Boralessa");
    }
    public void enterPostalCode() {
        WebElement postalCodeElement = wait.until(ExpectedConditions.visibilityOfElementLocated(postalcode));
        postalCodeElement.sendKeys("81000");
       // driver.findElement(postalcode).sendKeys("81000");
    }
    public void clickContinue() {
        WebElement continueElement = wait.until(ExpectedConditions.visibilityOfElementLocated(continuebtn));
        continueElement.click();
        //driver.findElement(continuebtn).click();
    }

    public String getCheckoutOverwiewPageTitle() {
        return driver.findElement(overwiewtitle).getText();
    }
   // public void clickCancel() {
     //   driver.findElement(cancelbtn).click();
    //}

}
