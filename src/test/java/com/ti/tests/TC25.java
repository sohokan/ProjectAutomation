package com.ti.tests;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TC25 extends Base{


    @Test(description = "Verify Scroll Up using 'Arrow' button and Scroll Down functionality")
    public void VerifyScrollUpArrowbutton() throws InterruptedException {

      Home.GotoHomePage();
      Home.ScrolltoBotom();

      Home.btnScrolltoUp();
      Home.CheckCarouselText();
    }

}
