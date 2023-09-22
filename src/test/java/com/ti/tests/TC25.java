package com.ti.tests;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TC25 extends Base{

    @BeforeClass

    void CloseAdblocker()
    {

        Home.WaitForAdblocker();
    }

    @Test
    public void VerifyScrollUpArrowbutton() throws InterruptedException {

      Home.HomePageTitle();
      Home.ScrolltoBotom();

      Home.btnScrolltoUp();
      Home.CheckCarouselText();
    }

}
