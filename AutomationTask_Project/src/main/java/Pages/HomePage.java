package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {
    private WebDriver driver;

    //HomePage Fields
    private By SignInLink = By.className("login");

    public HomePage(WebDriver driver){
        this.driver=driver;
    }

    //HomePage Methods
    public CreateAnAccountPage clickOnSignIn(){
        driver.findElement(SignInLink).click();
        return new CreateAnAccountPage(driver);
    }
}
