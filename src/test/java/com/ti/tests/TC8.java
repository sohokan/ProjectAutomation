package com.ti.tests;

import org.testng.annotations.Test;

public class TC8 extends Base{


    @Test
    void VerifyProductsVisible() throws InterruptedException {
        Products.VerifyProductList();
        Products.SelecttoViewProducts(33);//first one

    }

    @Test(dependsOnMethods = {"VerifyProductsVisible"})
    void VerifyProductsDetails(){
        productDetail.CheckProductDetail();

    }
}
