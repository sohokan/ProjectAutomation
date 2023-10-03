package com.ti.tests;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TC11  extends Base{



    @Test(description = "Verify Subscription in Cart page")
    void VerifySubscriptionCartPage()
    {


        Carts.GotoCart();
        Home.CheckSubscription();
    }
}