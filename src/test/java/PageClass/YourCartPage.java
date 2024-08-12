package PageClass;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class YourCartPage {

    By pagetitleYourCart = By.xpath("//span[@class='title']");
    By yourcartlink = By.xpath("//a[@class='shopping_cart_link']");
    By inventryitemname = By.xpath("//div[@class='inventory_item_name']");
    By cartquantity = By.xpath("//div[@class='cart_quantity']");
    By checkoutbtn = By.xpath("//button[@id='checkout']");
    By checkoutpagetitle = By.xpath("//span[@class='title']");
    By removebtn = By.xpath("//button[@id='remove-sauce-labs-fleece-jacket']");
    String itemId = "Sauce Labs Fleece Jacket";

    WebDriver driver;

    public YourCartPage(WebDriver driver) {
        this.driver = driver;
    }

    public void clickYourCartLink() {
        driver.findElement(yourcartlink).click();
    }

    public String getYourCartPageTitle() {
        return driver.findElement(pagetitleYourCart).getText();
    }
    public String checkNameOfTheItem() {
        return driver.findElement(inventryitemname).getText();
    }

    public int checkQuantityOfTheItem() {
        WebElement quantityElement = driver.findElement(cartquantity);
        String quantityText = quantityElement.getText();
        return Integer.parseInt(quantityText);
    }

    public void clickCheckout() {
        driver.findElement(checkoutbtn).click();
    }

    public String getCheckoutPageTitle() {
        return driver.findElement(checkoutpagetitle).getText();
    }

    public void removeItem() {
        driver.findElement(removebtn).click();
    }

    public void checkItemremoved(){
        boolean isItemRemoved = false;
        try {
            driver.findElement(By.id(itemId));
        } catch (NoSuchElementException e) {
            isItemRemoved = true;  // If NoSuchElementException is thrown, the item is removed
        }
    }
}
