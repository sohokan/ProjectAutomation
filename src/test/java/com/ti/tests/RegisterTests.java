package com.ti.tests;

import org.testng.annotations.Test;

public class RegisterTests  extends Base {

    @Test(priority = 1)
    void ClickonRegister() {

        Login.RegisterNewEmail();
    }

    @Test(priority = 2)
    void BeginRegister() {

        Login.AccountInformation();
        Login.AccountCreated();
    }
}
