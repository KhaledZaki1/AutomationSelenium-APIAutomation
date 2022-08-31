package Pages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ShippingPage {
    private WebDriver driver;

    // Page Fields
    private By CheckBox = By.cssSelector("#cgv");
    private By CheckoutButton = By.cssSelector("button[name='processCarrier']");
    //private By ErrorMesasge = By.className("fancybox-error");
    //private By CloseErrorMsg = By.className("fancybox-item fancybox-close");


    public ShippingPage(WebDriver driver){
        this.driver=driver;
    }

    public void ClickOnCheckBox(){
        driver.findElement(CheckBox).click();
    }
    public PaymentPage ClickOnCheck(){
        driver.findElement(CheckoutButton).click();
        return new PaymentPage(driver);
    }


}
