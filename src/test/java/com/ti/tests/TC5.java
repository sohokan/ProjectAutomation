package com.ti.tests;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TC5 extends Base{




    @Test(description = "New user created")

    void RegisteredUser()
    {

        Login.RegisterNewEmail(inputemail);
        Login.EmailExist();


    }

}
