package com.ti.tests;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TC13 extends Base {



    @Test(description = " Verify Product quantity in Cart")
    void VerifyProductQuantity() throws InterruptedException {

        Products.GotoProductPage();
        Products.VerifyProductList();
        Products.SelecttoViewProducts(3);
        ProductDetail.CheckProductDetail();
        ProductDetail.AddProducttoCart(4);
        Carts.GotoCart();
        Carts.CheckCartProducts();
    }
}
