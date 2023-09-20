package com.ti.tests;

import org.testng.annotations.Test;

public class TC25 extends Base{

@Test
    public void VerifyScrollUpArrowbutton()
    {
      Home.HomePageTitle();
      Home.ScrolltoBotom();
      Home.btnScrolltoUp();
      Home.CheckCarouselText();
    }

}
