package com.ti.tests;

import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

public class TC23 extends Base{


    @Test
    void VerifyAddressinCheckoutPage() throws InterruptedException {
        Home.HomePageTitle();
        Login.RegisterNewEmail();
        Login.AccountInformation();
        Login.AccountCreated();
        Products.GotoProductPage();
        Products.VerifyProductList();
        Products.SelecttoViewProducts(5);
        ProductDetail.CheckProductDetail();
        ProductDetail.AddProducttoCart(2);
        Carts.GotoCart();
        Carts.CheckCartProducts();
        Carts.ProceedtoCheckout();
        CheckOutPage.VerifyCheckoutAddress();
        Carts.CheckCartProducts(); //this in checkoutpage
//        CheckOutPage.inputComment();
//        CheckOutPage.PlaceOrder();
//        Payment.PlacePayment();
//        Payment.SuccessMsg();
//        PaymentDone.ContinuetoHome();
        Home.ClickonDeleteUser();
        Home.VerifyAccountDeleted();

    }


    @AfterClass
    public void Logger()
    {
        Home.GenerateLogs();

    }

}
