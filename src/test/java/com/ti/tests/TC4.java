package com.ti.tests;

import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

public class TC4 extends Base{

    @Test(dependsOnMethods = {"com.ti.tests.TC2.LoginUserValidCreds"})
    public void Logout() throws InterruptedException {
        Home.Logout();
       Login.VerifyLoginPage();

    }


}
