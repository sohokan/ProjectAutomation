package com.ti.tests;

import org.testng.annotations.Test;

public class TC20 extends Base {


    @Test
    void VerifyProductSearch() throws InterruptedException {
        Products.GotoProductPage();
        Products.SearchProducts("tshirt");
        Products.VerifyProductList();
        Products.AddtoCart(2);//first one
        Products.AddtoCart(3);//second one
        Carts.GotoCart();
        Carts.CheckCartProducts();
        Login.VerifyLogin(inputemail,password);
        Carts.GotoCart();
        Carts.CheckCartProducts();
    }

}
