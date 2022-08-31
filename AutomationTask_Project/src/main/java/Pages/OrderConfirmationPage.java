package Pages;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class OrderConfirmationPage {
    private WebDriver driver;

    // Page Fields
    private By OrderConfirmed = By.cssSelector("p[class='cheque-indent'] strong[class='dark']");
    private By MyOrders = By.cssSelector("a[title='My orders']");

    public OrderConfirmationPage(WebDriver driver){
        this.driver=driver;
    }

    // Page Methods
    public String GetConfirmed(){
        return driver.findElement(OrderConfirmed).getText();
    }
    public OrderHistoryPage ClickMyOrders(){
        driver.findElement(MyOrders).click();
        return new OrderHistoryPage(driver);
    }
}
