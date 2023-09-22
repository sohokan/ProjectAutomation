package com.ti.tests;


import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;


public  class TC3 extends Base{

    @BeforeClass

    void CloseAdblocker()
    {

        Home.WaitForAdblocker();
    }

    @Test(priority = 1,enabled = true)
    void LoginUserInValidCreds() throws InterruptedException {

        Home.LoggedUser();
        Home.Logout();
        Login.VerifyLogin(inputemail,"passw");
        Login.VerifyincorretLoginMessage();

    }


}
