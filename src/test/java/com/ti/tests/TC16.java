package com.ti.tests;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.testng.annotations.*;

public class TC16 extends Base{


//   @BeforeClass
//
//   void CloseAdblocker()
//   {
//
//      Home.WaitForAdblocker();
//   }


   @Test(priority = 1, description = " Api scrapping for User data")

   void GetUserData() throws JsonProcessingException {

      AutomationApi.givenDeserializing();

   }

   @Test(priority = 2, description = "Place Order: Login before Checkout")
    void PlaceOrderLoginBeforeCheckout() throws InterruptedException {

     Home.HomePageTitle();
        Login.VerifyLogin(inputemail,password);
        Products.GotoProductPage();
        Products.VerifyProductList();
        Products.SelecttoViewProducts(6);
        ProductDetail.CheckProductDetail();
        ProductDetail.AddProducttoCart(2);
        Carts.GotoCart();
        Carts.CheckCartProducts();
        Carts.ProceedtoCheckout();
        CheckOutPage.VerifyCheckoutAddress();
        Carts.CheckCartProducts(); //this in checkoutpage
        CheckOutPage.inputComment();
        CheckOutPage.PlaceOrder();
        Payment.PlacePayment();
        Payment.SuccessMsg();
        PaymentDone.ContinuetoHome();
//        Home.ClickonDeleteUser();
//        Home.VerifyAccountDeleted();

    }

   @AfterClass

  void SetNull()
 {

    AutomationApi.removehttpObject();
   }
}
