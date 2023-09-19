package com.ti.tests;

import org.testng.annotations.Test;

public class TC20 extends Base {


    @Test
    void VerifyProductSearch() throws InterruptedException {
        Products.GotoProductPage();
        Products.SearchProducts("tshirt");
        Products.VerifyProductList();
        Products.AddtoCart(0);//first one
        Products.AddtoCart(1);//second one
        Carts.GotoCart();
        Carts.CheckCartProducts();
    }

}
