package com.ti.tests;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TC10  extends Base{



    @Test (description = "View all the products")
    void VerifySubscriptionHomePage() throws InterruptedException {

        Home.GotoHomePage();
        Home.ScrolltoBotom();
        Home.CheckSubscription();

    }
}
