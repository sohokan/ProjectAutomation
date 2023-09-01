package com.ti.tests;

import org.testng.annotations.Test;

public class TC5 extends Base{

    @Test()

    void RegisteredUser()
    {
        Login.RegisterNewEmail(email);
        Login.EmailExist();


    }

}
