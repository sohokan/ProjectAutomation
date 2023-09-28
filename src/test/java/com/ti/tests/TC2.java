package com.ti.tests;

import com.ti.pompages.HomePage;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TC2 extends Base {

//    @BeforeClass
//
//    void CloseAdblocker()
//    {
//
//        Home.WaitForAdblocker();
//    }

    @Test(priority = 1,enabled = true,description = "Login with valid Credentials")
    void LoginUserValidCreds() throws InterruptedException {

        Home.LoggedUser();
        Home.Logout();
        Login.VerifyLogin(inputemail,password);
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