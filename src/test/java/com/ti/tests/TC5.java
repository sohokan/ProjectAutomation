package com.ti.tests;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TC5 extends Base{


//    @BeforeClass
//
//    void CloseAdblocker()
//    {
//
//        Home.WaitForAdblocker();
//    }

    @Test(description = "New user created")

    void RegisteredUser()
    {

        Login.RegisterNewEmail(inputemail);
        Login.EmailExist();


    }

}
