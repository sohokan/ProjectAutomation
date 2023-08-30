package com.ti.tests;

import org.testng.annotations.Test;

public class TC1 extends Base {

    @Test(priority = 1,enabled = true)
    void VerifyHomePageTitle(){

        Home.HomePageTitle();


    }

    @Test(priority = 1)
    void CreateNewRegistration() {

        Login.RegisterNewEmail();
    }

    @Test(priority = 2)
    void BeginNewRegister() throws InterruptedException {

        Login.AccountInformation();
        Login.AccountCreated();

    }
    @Test(priority = 3,dependsOnMethods = {"BeginNewRegister"})
    void VerifyUserisLogged() throws InterruptedException {

        Home.LoggedUser();
    }



    @Test(priority = 4,dependsOnMethods = {"BeginNewRegister"})
    void VerifyUserisDeleted() throws InterruptedException {


        Home.clickonDeleteUser();
        Home.VerifyAccountDeleted();
        Home.LoggedUser(); //verify if user is logged
    }

}
