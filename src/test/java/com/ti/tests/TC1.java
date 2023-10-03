package com.ti.tests;


import org.testng.annotations.*;
import org.ti.DriverFactory.FrameworkException;

import static org.ti.utils.ui.SeleniumUtil.WaitForAdblocker;


public class TC1 extends Base {



    @BeforeClass

    void CloseAdblocker()
    {

        WaitForAdblocker();


    }

    @Test(priority = 1,enabled = true,description = "Verify HomePage Carrousel Text")
    void VerifyCarouselText(){

        Home.CheckCarouselText();


    }

    @Test(priority = 2,description = "Input new user data")
    void CreateNewRegistration() {

        Login.RegisterNewEmail();
    }

    @Test(priority = 3,description = "New user created")
    void BeginNewRegister() throws InterruptedException, FrameworkException {

        Login.AccountInformation();
        Login.AccountCreated();

    }
    @Test(priority = 4,dependsOnMethods = {"BeginNewRegister"},description = "Check user is logged")
    void VerifyUserisLogged() throws InterruptedException {

        Home.LoggedUser();
    }



    @Test(priority = 5,dependsOnMethods = {"BeginNewRegister"},enabled = true,description = "New user is deleted")
    void VerifyUserisDeleted() throws InterruptedException {


        Home.ClickonDeleteUser();


    }


    @Test(priority = 6,dependsOnMethods = {"VerifyUserisDeleted"},description = "Check deleted user is not logged")
    void VerifyDeletedUserNotShown() throws InterruptedException {
        Home.VerifyAccountDeleted();
        Home.LoggedUser();
    }
    @AfterClass
    public void Logger()
    {
        Home.GenerateLogs();


    }

}
