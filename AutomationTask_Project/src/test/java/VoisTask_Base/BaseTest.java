package VoisTask_Base;

import Pages.HomePage;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import java.util.concurrent.TimeUnit;

public class BaseTest {

    private WebDriver driver;
    protected HomePage homepage;

    @BeforeTest
    public void SetUp(){
       System.setProperty("webdriver.chrome.driver","resources/chromedriver.exe");
       driver = new ChromeDriver();
       driver.get("http://automationpractice.com/index.php");
       driver.manage().timeouts().implicitlyWait(3000, TimeUnit.SECONDS);
       driver.manage().window().setSize(new Dimension(1024,768));
       homepage=new HomePage(driver);
    }

    /*@AfterTest
    public void teardown(){
        driver.quit();
    }*/
}
