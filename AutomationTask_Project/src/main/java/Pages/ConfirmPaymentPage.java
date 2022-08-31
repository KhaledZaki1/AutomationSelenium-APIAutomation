package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ConfirmPaymentPage {
    private WebDriver driver;

    // Page Fields
    private By ConfirmButton = By.cssSelector("button[class='button btn btn-default button-medium']");

    public ConfirmPaymentPage(WebDriver driver){
        this.driver=driver;
    }

    // Page Methods
    public OrderConfirmationPage ClickConfirm(){
        driver.findElement(ConfirmButton).click();
        return new OrderConfirmationPage(driver);
    }
}
