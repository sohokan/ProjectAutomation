package com.ti.tests;


import org.testng.annotations.Test;


public  class TC3 extends Base{

    @Test(priority = 1,enabled = true)
    void LoginUserInValidCreds(){
        Login.VerifyLogin(email,"passw");
        Login.VerifyincorretLoginMessage();

    }


}
