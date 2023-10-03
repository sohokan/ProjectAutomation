package com.ti.tests;


import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;


public  class TC3 extends Base{



    @Test(priority = 1,enabled = true,description = "Login with invalid Credentials")
    void LoginUserInValidCreds() throws InterruptedException {

        Home.LoggedUser();
        Home.Logout();
        Login.VerifyLogin(inputemail,"passw");
        Login.VerifyincorretLoginMessage();

    }


}
