package com.ti.tests;

import org.testng.annotations.Test;

public class HomeTests extends Base{


    @Test(priority = 1,enabled = false)
    void VerifyWebsiteisVisibleSuccefully(){

        Home.HomePageTitle();


    }


    @Test(priority = 2, enabled = false)
    void ClickonCarousel(){

        Home.Clickoncarousel();
    }

    @Test(priority = 3,dependsOnMethods = {"com.ti.tests.RegisterTests.BeginRegister"})
    void isUserVisible() throws InterruptedException {

        Home.LoggedUser();
    }



    @Test(priority = 4,dependsOnMethods = {"com.ti.tests.RegisterTests.BeginRegister"})
    void VerifyDeleteUser() throws InterruptedException {


        Home.clickonDeleteUser();
        Home.VerifyAccountDeleted();
        Home.LoggedUser(); //verify if user is logged
    }





}