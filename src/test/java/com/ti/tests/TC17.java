package com.ti.tests;

import org.testng.annotations.Test;

public class TC17 extends Base{

    @Test
    void RemoveProducts() throws InterruptedException {
        Products.GotoProductPage();
        Products.VerifyProductList();
        Products.AddtoCart(4);
        Products.AddtoCart(20);
        Products.AddtoCart(7);
        Carts.GotoCart();
        Carts.CheckCartProducts();
        Carts.DeleteProduct(20);
        Carts.VerifyDeleteProduct();


    }
}