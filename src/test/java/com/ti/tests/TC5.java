package com.ti.tests;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TC5 extends Base{


    @BeforeClass

    void CloseAdblocker()
    {

        Home.WaitForAdblocker();
    }

    @Test()

    void RegisteredUser()
    {

        Login.RegisterNewEmail(inputemail);
        Login.EmailExist();


    }

}
