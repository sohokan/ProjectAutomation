package com.ti.tests;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.ti.DriverFactory.FrameworkException;

public class TC23 extends Base{


    @Test(description = "Verify address details in checkout page")
    void VerifyAddressinCheckoutPage() throws InterruptedException, FrameworkException {

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
        Home.ClickonDeleteUser();
        Home.VerifyAccountDeleted();

    }


    @AfterClass
    public void Logger()
    {
        Home.GenerateLogs();

    }

}
