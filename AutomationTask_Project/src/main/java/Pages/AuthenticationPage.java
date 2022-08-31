package Pages;

import com.github.javafaker.Faker;
import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.Random;
import java.util.concurrent.TimeUnit;

public class AuthenticationPage {

    private WebDriver driver;

    //Create an object of Faker class with default locale
    Faker faker = new Faker();
    // To select random selection
    Random random = new Random();

    // Page Fields
    private final By Gender = By.id("id_gender2");
    private final By FirstNameField = By.id("customer_firstname");
    private final By LastNameField = By.id("customer_lastname");
    private final By PasswordField = By.id("passwd");
    private final By Day = By.id("days");
    private final By Month = By.id("months");
    private final By Year = By.id("years");
    private final By Company = By.id("company");
    private final By Address1 = By.id("address1");
    private final By Address2 = By.id("address2");
    private final By City = By.id("city");
    private final By State = By.id("id_state");
    private final By ZipCode = By.id("postcode");
    private final By Country = By.id("id_country");
    private final By AdditionalInfo = By.id("other");
    private final By MobilePhone = By.id("phone_mobile");
    private final By RegisterButton = By.id("submitAccount");

    public AuthenticationPage(WebDriver driver) {
        this.driver = driver;
    }

    // Page Methods
    public void ClickGender() {
        driver.findElement(Gender).click();
    }

    //To generate valid random first name
    public void EnterFirstName() {
        driver.findElement(FirstNameField).sendKeys(faker.name().firstName());
    }

    //To generate valid random last name
    public void EnterLastName() {
        driver.findElement(LastNameField).sendKeys(faker.name().lastName());
    }

    public void SetPassword(String pass) {
        driver.findElement(PasswordField).sendKeys(pass);
    }
    public void SetBirthDay(){
        // to enter a static value
        /*WebElement D = driver.findElement(Day);
        Select DropDownList = new Select(D);
        DropDownList.selectByValue(birthday);*/
// to enter a dynamic value randomly
        WebElement DayDropDown = driver.findElement(Day);
        Select Days = new Select(DayDropDown);
        int dropdownDayCount = driver.findElements(By.cssSelector("#days>option")).size();
        int index = random.nextInt(dropdownDayCount-2)+1;
        Days.selectByIndex(index);
    }

    public void SetBirthMonth(){
        /*WebElement M = driver.findElement(Month);
        Select DropDownList = new Select(M);
        DropDownList.selectByValue(birthmonth);*/

        WebElement MonthDropDown = driver.findElement(Month);
        Select months = new Select(MonthDropDown);
        int dropdownMonthCount = driver.findElements(By.cssSelector("#months>option")).size();
        int index = random.nextInt(dropdownMonthCount-2)+1;
        months.selectByIndex(index);
    }

    public void SetBirthYear(){
        /*WebElement Y = driver.findElement(Year);
        Select DropDownList = new Select(Y);
        DropDownList.selectByValue(birthyear);*/

        WebElement YearDropDown = driver.findElement(Year);
        Select Years = new Select(YearDropDown);
        int dropdownYearCount = driver.findElements(By.cssSelector("#years>option")).size();
        int index = random.nextInt(dropdownYearCount-2)+1;
        Years.selectByIndex(index);
    }
    public void SetCompany(String company){
        driver.findElement(Company).sendKeys(company);
    }
    public void SetAddress1() {
        driver.findElement(Address1).sendKeys(faker.address().streetAddress());
    }
    public void SetAddress2() {
        driver.findElement(Address2).sendKeys(faker.address().secondaryAddress());
    }
    public void SetCity(String city){
        driver.findElement(City).sendKeys(city);
    }
    public void SetPostalCode(String code) {
        driver.findElement(ZipCode).sendKeys(code);
    }
    public void SetCountry(String country){
        WebElement  visibletext = driver.findElement(Country);
        Select DropDownList = new Select(visibletext);
        DropDownList.selectByVisibleText(country);
    }
    public void SetState(){
        WebElement stateDropDown = driver.findElement(State);
        Select states = new Select(stateDropDown);
        int dropdownValuesCount = driver.findElements(By.cssSelector("#id_state>option")).size();
        int index = random.nextInt(dropdownValuesCount-2)+1;
        states.selectByIndex(index);
    }
    public void SetAddInfo(String Info){
        driver.findElement(AdditionalInfo).sendKeys(Info);
    }
    public void SetMobilePhone(){
        driver.findElement(MobilePhone).sendKeys(faker.phoneNumber().cellPhone());
    }
    public MyAccountPage ClickOnRegister(){
        driver.findElement(RegisterButton).click();
        driver.manage().timeouts().implicitlyWait(3000, TimeUnit.SECONDS);
        return new MyAccountPage(driver);
    }

    // Helper Methods
    // To enter a random password at least 5 characters minimum(5,--)
    public String RandomPassword(){
        return (RandomStringUtils.randomAlphanumeric(5,11));
    }
    // To enter a random values everytime
    public String Randomvalues(){
        return (RandomStringUtils.randomAlphanumeric(8));
    }
    // to enter a postal code that must follow a format of Integers only(00000)
    public String RandomInt(){
        return (RandomStringUtils.randomNumeric(5));
    }
}
