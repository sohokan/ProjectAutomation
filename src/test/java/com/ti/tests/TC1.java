package com.ti.tests;

import org.testng.annotations.*;

public class TC1 extends Base {
    @BeforeClass

    void CloseAdblocker()
    {

        Home.WaitForAdblocker();
    }

    @Test(priority = 1,enabled = true)
    void VerifyHomePageTitle(){

        Home.HomePageTitle();


    }

    @Test(priority = 2)
    void CreateNewRegistration() {

        Login.RegisterNewEmail();
    }

    @Test(priority = 3)
    void BeginNewRegister() throws InterruptedException {

        Login.AccountInformation();
        Login.AccountCreated();

    }
    @Test(priority = 4,dependsOnMethods = {"BeginNewRegister"})
    void VerifyUserisLogged() throws InterruptedException {

        Home.LoggedUser();
    }



    @Test(priority = 5,dependsOnMethods = {"BeginNewRegister"},enabled = false)
    void VerifyUserisDeleted() throws InterruptedException {


        Home.ClickonDeleteUser();
        Home.VerifyAccountDeleted();
        Home.LoggedUser(); //verify if user is logged or not
    }

    @AfterClass
    public void Logger()
    {
        Home.GenerateLogs();

    }

}
