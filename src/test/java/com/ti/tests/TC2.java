package com.ti.tests;

import com.ti.pompages.HomePage;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

public class TC2 extends Base {



    @Test(priority = 1,enabled = true)
    void LoginUserValidCreds() throws InterruptedException {
        Home.LoggedUser();
        Home.Logout();
        Login.VerifyLogin(email,password);
        Home.LoggedUser();

    }

//@AfterClass
//    public void Logout()
//{
//    Home.Logout();
//
//}
//
//
//
}