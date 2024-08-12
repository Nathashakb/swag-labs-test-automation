package PageClass;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProductPage {

    By inventryitem1 = By.xpath("//*[contains(text(), 'Sauce Labs Fleece Jacket')]");
    By inventryitem2 = By.xpath("//button[@id='add-to-cart-sauce-labs-bike-light']");

    By inventryitemprice = By.xpath("//*[@class='inventory_details_price']");
    By addtocartbtn = By.xpath("//button[@id='add-to-cart']");
    By description = By.xpath("//*[@class='inventory_details_desc large_size']");
    By removebtn = By.xpath("//button[@class='btn btn_secondary btn_small btn_inventory']");
    By shoppingcartbadge = By.xpath("//span[@class='shopping_cart_badge']");
    By backtoProductsbtn = By.xpath("//button[@id='back-to-products']");

    WebDriver driver;


    public ProductPage(WebDriver driver) {
        this.driver = driver;
    }
    public void selectInventryItem1() {
        driver.findElement(inventryitem1).click();

    }

    public String getNameOfTheItem() {
        return driver.findElement(inventryitem1).getText();
    }
    public String getPriceOfTheItem() {
        return driver.findElement(inventryitemprice).getText();
    }
    public String getDescriptionOfTheItem() {
        return driver.findElement(description).getText();
    }
    public void addToCart() {
        driver.findElement(addtocartbtn).click();

    }
    public String getTextAfterClickingAddToCart() {
        return driver.findElement(removebtn).getText();

    }
    public String getShoppingCartBadgeColor() {
        return driver.findElement(shoppingcartbadge).getCssValue("background-color");
    }
    public void clickBackToProducts() {
        driver.findElement(backtoProductsbtn).click();
    }

    public void selectInventryItem2() {
       driver.findElement(inventryitem2).click();}
}
