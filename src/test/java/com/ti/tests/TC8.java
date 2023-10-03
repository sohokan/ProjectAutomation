package com.ti.tests;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TC8 extends Base{


    @Test(priority = 1,description = "View all the products")
    void VerifyProductsVisible() throws InterruptedException {

        Products.GotoProductPage();
        Products.VerifyProductList();
        Products.SelecttoViewProducts(0);//first one

    }

    @Test(priority = 2,dependsOnMethods = {"VerifyProductsVisible"},description = "Check the products details")
    void VerifyProductsDetails(){
        ProductDetail.CheckProductDetail();

    }


}
