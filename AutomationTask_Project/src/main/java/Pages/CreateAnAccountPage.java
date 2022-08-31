package Pages;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CreateAnAccountPage {

    private WebDriver driver;

    // Page Fields
    private By PageText = By.xpath("//h1[normalize-space()='Authentication']");
    private By EmailField = By.id("email_create");
    private By CreateButton = By.id("SubmitCreate");
    
    public CreateAnAccountPage(WebDriver driver){
        this.driver=driver;
    }

    // Page Methods
    public String GetText(){
       return driver.findElement(PageText).getText();
    }

    // To enter a random email everytime i want to test the site
    public String Randomstring(){
        return(RandomStringUtils.randomAlphabetic(10));
    }
    public void SetEmailAddress(String email){
        driver.findElement(EmailField).sendKeys(email);
    }
    public AuthenticationPage ClickCreateButton(){
        driver.findElement(CreateButton).click();
        return new AuthenticationPage(driver);
    }
}
