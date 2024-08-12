package PageClass;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class OverwiewPage {
    By finishbtn = By.xpath("//button[@name='finish']");
    By cartitem = By.xpath("//div[@class='cart_item']");
    By inverntryItemPrice = By.xpath("//div[@class='inventory_item_price']");
    By totalprice = By.xpath("//div[@class='summary_subtotal_label']");
    By tax = By.xpath("//div[@class='summary_tax_label']");
    By total= By.xpath("//div[@class='summary_total_label']");
    By complete = By.xpath("//span[@class='title']");
    By backhomebtn = By.xpath("//button[@id='back-to-products']");

    WebDriver driver;
    double TotalItemPrice = 0;
double TotalAmountToPay;
    public OverwiewPage(WebDriver driver) {
        this.driver = driver;
    }

    public void getTotalItemPrice(){
        List<WebElement> cartItems = driver.findElements(cartitem);
        int itemCount = cartItems.size();
        System.out.println(itemCount);


        for(int i=0; i<itemCount; i++) {
            WebElement itemPriceElement = cartItems.get(i).findElement(By.xpath(".//div[@class='inventory_item_price']"));
            String itemPrice = itemPriceElement.getText();
            System.out.println("Price of item " + (i + 1) + ": " + itemPrice);
            itemPrice = itemPrice.substring(1);
            double itemPriceInt = Double.parseDouble(itemPrice);

            TotalItemPrice = TotalItemPrice + itemPriceInt;
        }
            System.out.println("Item total price: $" + TotalItemPrice);

    }

     public double checkTotalItemPrice() {
        return TotalItemPrice;

    }

    public void getTotalAmountToPayWithTax() {

        String tax2 = driver.findElement(tax).getText();
        String integerPart = tax2.replaceAll("[^\\d.]", "");
        double tax2Int = Double.parseDouble(integerPart);
        double TotalAmountToPay = TotalItemPrice + tax2Int;
        System.out.println(tax2);
       // System.out.println(tax2Int);
        System.out.println("Total amount to pay: $" + TotalAmountToPay);
    }

    public String getItemTotal() {
        return driver.findElement(totalprice).getText();
    }

    public String getTotal() {
        return driver.findElement(total).getText();
    }

    public double checkTotalPriceWithTax() {
        //double TotalAmountToPay2= TotalAmountToPay;
        return TotalAmountToPay;
    }



    public void clickFinish() {
        driver.findElement(finishbtn).click();
    }

    public String getComplete() {
        return driver.findElement(complete).getText();
    }

    public void clickBackHome() {
        driver.findElement(backhomebtn).click();
    }
}
