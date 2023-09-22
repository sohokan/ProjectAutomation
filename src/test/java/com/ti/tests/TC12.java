package com.ti.tests;

import org.testng.annotations.*;

public class TC12 extends Base{

    @BeforeClass

    void CloseAdblocker()
    {

        Home.WaitForAdblocker();
    }

    @Test

    void VerifyAddtoCart() throws InterruptedException {

        Products.GotoProductPage();
        Products.VerifyProductList();
       Products.AddtoCart(0);//first one
        Products.AddtoCart(1);//second one
        Carts.GotoCart();
        Carts.CheckCartProducts();
    }
}
