package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class ProductPage {

    private WebDriver driver;

    // Page Field
    private By SelectedBlouse = By.cssSelector("img[title='Blouse']");
    private By AddToCartButton = By.cssSelector("a[title='Add to cart']");
    private By ProceedToCheck = By.cssSelector("a[title='Proceed to checkout']");

    public ProductPage(WebDriver driver){
        this.driver=driver;
    }

    // Page Methods
    public void HoverOverPhoto(){
        WebElement photo = driver.findElement(SelectedBlouse);
        Actions action = new Actions(driver);
        action.moveToElement(photo).perform();
    }
    public void ClickAddToCartButton(){
        driver.findElement(AddToCartButton).click();
    }
    public OrderSummaryPage ClickProceedToCheck(){
        driver.findElement(ProceedToCheck).click();
        return new OrderSummaryPage(driver);
    }

}
