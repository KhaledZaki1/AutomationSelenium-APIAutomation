package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AddressPage {

    private WebDriver driver;
    // Page Fields

    // To validate we're in the correct page
    private By TitleName = By.className("page-heading");
    private By TextArea = By.xpath("//textarea[@name='message']");
    private By SubmitButton = By.xpath("//button[@name='processAddress']");

    public AddressPage(WebDriver driver){
        this.driver=driver;
    }

    // Page Methods
    public String GetTitle(){
        return driver.findElement(TitleName).getText();
    }
    public void EnterText(String txt){
        driver.findElement(TextArea).sendKeys(txt);
    }
    public ShippingPage ClickSubmit(){
        driver.findElement(SubmitButton).click();
        return new ShippingPage(driver);
    }

}
