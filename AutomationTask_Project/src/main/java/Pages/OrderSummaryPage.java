package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class OrderSummaryPage {
    private WebDriver driver;

    // Page Fields
    private By CartMessage = By.cssSelector(".heading-counter");
    private By ProceedToCheckOutBtn = By.cssSelector("a[class='button btn btn-default standard-checkout button-medium'] span");


    public OrderSummaryPage(WebDriver driver){
        this.driver=driver;
    }

    // Page Methods
    public String GetCartMsg (){
        return driver.findElement(CartMessage).getText();
    }

    public AddressPage ClickOnButton(){
        driver.findElement(ProceedToCheckOutBtn).click();
        return new AddressPage(driver);
    }
}
