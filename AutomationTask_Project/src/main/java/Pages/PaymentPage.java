package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PaymentPage {
    private WebDriver driver;

    // Page Fields
    private By PayOption = By.className("bankwire");
    private By TotalPrice = By.id("total_price");


    public PaymentPage(WebDriver driver){
        this.driver=driver;
    }

    // Page Methods
    public ConfirmPaymentPage ClickBankWire(){
        driver.findElement(PayOption).click();
        return new ConfirmPaymentPage(driver);
    }

    public String totalprice(){
        return driver.findElement(TotalPrice).getText();
    }

}
