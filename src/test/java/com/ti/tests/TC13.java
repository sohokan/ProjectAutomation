package com.ti.tests;

import org.testng.annotations.Test;

public class TC13 extends Base {

    @Test
    void VerifyProductQuantity() throws InterruptedException {

        Products.GotoProductPage();
        Products.VerifyProductList();
        Products.SelecttoViewProducts(3);
        productDetail.CheckProductDetail();
        productDetail.AddProducttoCart(4);
        Carts.GotoCart();
        Carts.CheckCartProducts();
    }
}
