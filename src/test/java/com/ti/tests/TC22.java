package com.ti.tests;

import org.testng.annotations.Test;

public class TC22 extends Base{


    @Test
    void VerifyAddtoCartRecommended()
    {
        Home.GotoHomePage();
        Home.ScrolltoBotom();
        Home.ScrapRecommendedProduct(0);
        Home.ScrapRecommendedProduct(1);



    }

}
