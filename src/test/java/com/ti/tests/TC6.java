package com.ti.tests;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TC6 extends Base{



    @Test(description = "User input Contact Us Form")

    void VerifyContacUsForm()
    {

        ContactUs.FillContactUs();
//        Home.HomePageTitle();
    }

}
