package com.ti.tests;

import org.testng.annotations.Test;

public class TC8 extends Base{


    @Test(priority = 1)
    void VerifyProductsVisible() throws InterruptedException {
        Products.GotoProductPage();
        Products.VerifyProductList();
        Products.SelecttoViewProducts(0);//first one

    }

    @Test(priority = 2,dependsOnMethods = {"VerifyProductsVisible"})
    void VerifyProductsDetails(){
        productDetail.CheckProductDetail();

    }


}
