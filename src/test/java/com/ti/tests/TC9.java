package com.ti.tests;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TC9 extends Base {

//    @BeforeClass
//
//    void CloseAdblocker()
//    {
//
//        Home.WaitForAdblocker();
//    }

    @Test (description = "Search all the products")
    void VerifyProductSearch() throws InterruptedException {

        Products.GotoProductPage();
        Products.SearchProducts("tshirt");
        Products.VerifyProductList();
    }
}
