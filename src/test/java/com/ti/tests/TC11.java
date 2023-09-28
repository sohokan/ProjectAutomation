package com.ti.tests;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TC11  extends Base{

//    @BeforeClass
//
//    void CloseAdblocker()
//    {
//
//        Home.WaitForAdblocker();
//    }

    @Test
    void VerifySubscriptionCartPage()
    {


        Carts.GotoCart();
        Home.CheckSubscription();
    }
}