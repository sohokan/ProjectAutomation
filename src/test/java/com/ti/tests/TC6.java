package com.ti.tests;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TC6 extends Base{

    @BeforeClass

    void CloseAdblocker()
    {

        Home.WaitForAdblocker();
    }

    @Test()

    void VerifyContacUsForm()
    {

        ContactUs.FillContactUs();
        Home.HomePageTitle();
    }

}
