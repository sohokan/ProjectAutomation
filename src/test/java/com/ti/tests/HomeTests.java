package com.ti.tests;

import org.testng.annotations.Test;

public class HomeTests extends Base{


    @Test(priority = 1)
    void VerifyWebsiteisVisibleSuccefully(){

        Home.HomePageTitle();


    }


    @Test(priority = 2, enabled = false)
    void ClickonCarousel(){

        Home.Clickoncarousel();
    }





}