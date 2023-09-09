package com.ti.tests;

import org.testng.annotations.Test;

public class TC11  extends Base{

    @Test
    void VerifySubscriptionCartPage()
    {


        Carts.GotoCart();
        Home.CheckSubscription();
    }
}