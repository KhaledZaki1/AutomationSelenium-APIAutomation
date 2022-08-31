package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.concurrent.TimeUnit;

public class OrderHistoryPage {
    private WebDriver driver;

    // Page Fields
    private By OrderHistoryPrice = By.className("history_price");
    private By ShowDetails = By.xpath("//span[normalize-space()='Details']");
    private By ProductDetails = By.cssSelector("td[class='bold'] label[for='cb_554735']");

    public OrderHistoryPage(WebDriver driver){
        this.driver=driver;
    }

    // Page Methods
    public String ValidatePrice(){
        return driver.findElement(OrderHistoryPrice).getText();
    }
    public void ClickDetails(){
        driver.findElement(ShowDetails).click();
    }
    public String ValidateThatOrderWasPlaced(){
       return driver.findElement(ProductDetails).getText();
    }
}
