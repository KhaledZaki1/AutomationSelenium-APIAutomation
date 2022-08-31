package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class MyAccountPage {
    private WebDriver driver;


    // Page Fields
    private By PageText = By.className("page-heading");
    private By WomenMainMenu = By.cssSelector("a[title='Women']");
    private By BlousesSelection = By.cssSelector("a[title='Blouses']");

    public MyAccountPage(WebDriver driver){
        this.driver=driver;
    }

    // Page Methods

    // validate we are in the correct page
    public String GetText(){
        return driver.findElement(PageText).getText();
    }
    public void HoverOver(int i){
        WebElement title = driver.findElements(WomenMainMenu).get(i - 1);
        Actions actions = new Actions(driver);
        actions.moveToElement(title).perform();
        /*WebElement WomenMenu = driver.findElement(WomenMainMenu);
        Actions actions = new Actions(driver);
        actions.moveToElement(WomenMenu);*/
    }

    public ProductPage ClickOnBlouses(){
        driver.findElement(BlousesSelection).click();
        driver.manage().timeouts().implicitlyWait(3000,TimeUnit.SECONDS);
        return new ProductPage(driver);
        /*WebElement submenu = driver.findElement(BlousesSelection);
        Actions actions = new Actions(driver);
        actions.moveToElement(submenu);
        actions.click().build().perform();
        return new ProductPage(driver);*/
    }





}
