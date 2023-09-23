package com.ti.tests;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TC16 extends Base{


   @BeforeClass

   void CloseAdblocker()
   {

      Home.WaitForAdblocker();
   }


   @Test(priority = 1)

   void GetUserData() throws JsonProcessingException {

      AutomationApi.givenDeserializing();

   }

@Test(priority = 2)
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
}
