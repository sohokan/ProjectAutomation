package com.ti.tests;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TC13 extends Base {

//    @BeforeClass
//
//    void CloseAdblocker()
//    {
//
//        Home.WaitForAdblocker();
//    }

    @Test
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
