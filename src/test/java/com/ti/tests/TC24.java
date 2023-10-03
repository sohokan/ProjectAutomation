package com.ti.tests;

import com.ti.pompages.PaymentDonePage;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.ti.DriverFactory.FrameworkException;

public class TC24  extends Base {



    @Test(description = "Download Invoice after purchase order")
    void VerifyAddressinCheckoutPage() throws InterruptedException, FrameworkException {

        Home.HomePageTitle();
        Login.RegisterNewEmail();
        Login.AccountInformation();
        Login.AccountCreated();
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
        PaymentDone.DownloadInvoice();
        PaymentDone.CheckFileWasDownloaded();
    }
}