package com.ti.tests;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TC19 extends Base{

//    @BeforeClass
//
//    void CloseAdblocker()
//    {
//
//        Home.WaitForAdblocker();
//    }


    @Test(description = "View & Cart Brand Products")
    void ViewBrands() throws InterruptedException {
        Home.GotoHomePage();
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
