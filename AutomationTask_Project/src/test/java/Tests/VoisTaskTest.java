package Tests;

import Pages.*;
import VoisTask_Base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class VoisTaskTest extends BaseTest {

      @Test
      public void ProjectTest() {
            // homepage action
            CreateAnAccountPage createaccount = homepage.clickOnSignIn();
            /*---------------------------------------------------*/

            //CreateAccountPage actions
            // 1- Create An Account
            assertEquals(createaccount.GetText(), "AUTHENTICATION", "Authentication page can't be found");
            createaccount.SetEmailAddress(createaccount.Randomstring() + "@yahoo.com");
            AuthenticationPage authenticationpage = createaccount.ClickCreateButton();
            /*---------------------------------------------------*/

            //Authenticationpage actions
            // 2- Authenticate as a new user
            authenticationpage.ClickGender();
            authenticationpage.EnterFirstName();
            authenticationpage.EnterLastName();
            authenticationpage.SetPassword(authenticationpage.RandomPassword());
            authenticationpage.SetBirthDay();
            authenticationpage.SetBirthMonth();
            authenticationpage.SetBirthYear();
            authenticationpage.SetCompany("Telecom Industry");
            authenticationpage.SetAddress1();
            authenticationpage.SetAddress2();
            authenticationpage.SetCity("Los Angelos");
            authenticationpage.SetPostalCode(authenticationpage.RandomInt());
            authenticationpage.SetCountry("United States");
            authenticationpage.SetState();
            authenticationpage.SetAddInfo("I do test automation with dynamic values and static values");
            authenticationpage.SetMobilePhone();
            MyAccountPage myaccountpage = authenticationpage.ClickOnRegister();
            assertEquals(myaccountpage.GetText(), "MY ACCOUNT", "MyAccount Page can't be found");
            /*--------------------------------------------------*/

            //MyAccountPage Actions
            // 3- Select "Blouses" Subcategory in "Women" Category
            myaccountpage.HoverOver(1);
            ProductPage productpage = myaccountpage.ClickOnBlouses();
            /*--------------------------------------------------*/

            //ProductPage Actions
            // 4- Select resulted product
            productpage.HoverOverPhoto();
            productpage.ClickAddToCartButton();
            OrderSummaryPage ordersummarypage = productpage.ClickProceedToCheck();
            /*--------------------------------------------------*/

            //OrderSummaryPage Actions
            // 5- ProceedToCheck Process
            assertEquals(ordersummarypage.GetCartMsg(),"Your shopping cart contains: 1 Product","Your Shopping Cart is empty");
            AddressPage addresspage = ordersummarypage.ClickOnButton();
            /*--------------------------------------------------*/

            //AddressPage Actions
            assertEquals(addresspage.GetTitle(),"ADDRESSES", "Address Page can't be found");
            addresspage.EnterText("Try to deliver the order on time");
            ShippingPage shippingpage = addresspage.ClickSubmit();
            /*--------------------------------------------------*/

            //ShippingPage Actions
            shippingpage.ClickOnCheckBox();
            PaymentPage paymentpage = shippingpage.ClickOnCheck();
            /*--------------------------------------------------*/

            //PaymentPage Actions
            // this point to make a validation on the total price
            String ProductPrice = paymentpage.totalprice();
            ConfirmPaymentPage confirmpaymentpage = paymentpage.ClickBankWire();
            /*--------------------------------------------------*/

            // 6- Confirm order by selecting bank wire option
           OrderConfirmationPage orderconfirmpage = confirmpaymentpage.ClickConfirm();
            /*--------------------------------------------------*/

            //OrderConfirmationPage
            assertEquals(orderconfirmpage.GetConfirmed(),"Your order on My Store is complete.","  ");
            OrderHistoryPage orderhistorypage = orderconfirmpage.ClickMyOrders();
            /*--------------------------------------------------*/

            //OrderHistoryPage
            // 7- Validate the order with the actual one in My OrdersHistory Page
            assertEquals(orderhistorypage.ValidatePrice(),ProductPrice ,"The Price is not correct");
            orderhistorypage.ClickDetails();
            //Assert.assertTrue(orderhistorypage.ValidateThatOrderWasPlaced().contains("Blouse - Color : Black, Size : S"));




      }
}
