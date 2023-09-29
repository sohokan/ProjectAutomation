package com.ti.tests;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TC26 extends Base {

//    @BeforeClass
//
//    void CloseAdblocker()
//    {
//
//        Home.WaitForAdblocker();
//    }


    @Test(description = "Verify Scroll Up without 'Arrow' button and Scroll Down functionality")
    public void VerifyScrollUpJS() throws InterruptedException {

        Home.HomePageTitle();
        Home.ScrolltoBotom();
        Home.ScrolltoTop();
        Home.CheckCarouselText();
    }


}
