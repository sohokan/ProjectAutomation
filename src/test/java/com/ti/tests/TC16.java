package com.ti.tests;

import org.testng.annotations.Test;

public class TC16 extends Base{

@Test
    void PlaceOrderLoginBeforeCheckout() throws InterruptedException {
     Home.HomePageTitle();
        Login.VerifyLogin(email,password);
        Products.GotoProductPage();
        Products.VerifyProductList();
        Products.SelecttoViewProducts(6);
        productDetail.CheckProductDetail();
        productDetail.AddProducttoCart(2);
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
        Home.ClickonDeleteUser();
        Home.VerifyAccountDeleted();

    }
}
