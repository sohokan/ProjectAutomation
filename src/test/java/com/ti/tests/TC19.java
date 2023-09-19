package com.ti.tests;

import org.testng.annotations.Test;

public class TC19 extends Base{


    @Test
    void ViewBrands() throws InterruptedException {
        Products.GotoProductPage();
        Products.VerifyBrand();
        Products.SelectBrand();
        ProductBrand.VerifyBrandPageisDisplayed();
        ProductBrand.VerifyCategoryTitle("MADAME");
        Products.VerifyProductList();
        ProductBrand.SelectAnyCategory();
        ProductBrand.VerifyCategoryTitle("Baby");
        Products.VerifyProductList();
    }
}
