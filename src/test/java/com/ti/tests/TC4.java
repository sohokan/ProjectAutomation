package com.ti.tests;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TC4 extends Base{

    @BeforeClass

    void CloseAdblocker()
    {

        Home.WaitForAdblocker();
    }

    @Test(priority = 1,enabled = true)
    void LoginUserValidCreds() throws InterruptedException {

        Home.LoggedUser();
        Home.Logout();
        Login.VerifyLogin(inputemail,password);
        Home.LoggedUser();

    }
    @Test(priority = 2/*dependsOnMethods = {"com.ti.tests.TC2.LoginUserValidCreds"}*/)
    public void Logout() throws InterruptedException {

        Home.Logout();
       Login.VerifyLoginPage();

    }


}
