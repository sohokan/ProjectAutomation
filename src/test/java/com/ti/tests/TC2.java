package com.ti.tests;

import com.ti.pompages.HomePage;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

public class TC2 extends Base {



    @Test(priority = 1,enabled = true)
    void LoginUserValidCreds(){
        Login.VerifyLogin(email,password);

    }

@AfterClass
    public void Logout()
{
    Home.Logout();

}


    }
