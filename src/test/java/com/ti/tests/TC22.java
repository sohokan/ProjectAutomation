package com.ti.tests;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TC22 extends Base{

//    @BeforeClass
//
//    void CloseAdblocker()
//    {
//
//        Home.WaitForAdblocker();
//    }

    @Test
    void VerifyAddtoCartRecommended() throws InterruptedException {

        Home.GotoHomePage();
        Home.ScrolltoBotom();
        Home.ScrapRecommendedProduct();
        Home.AddtoCartRecommendProduct(0);
        Home.AddtoCartRecommendProduct(1);
        Home.ScrolltoTop();
        Carts.GotoCart();
        Carts.CheckCartProducts();



    }

}
