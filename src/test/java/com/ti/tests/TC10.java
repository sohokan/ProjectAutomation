package com.ti.tests;

import org.testng.annotations.Test;

public class TC10  extends Base{

    @Test
void VerifySubscription()
{
Home.GotoHomePage();
Home.CheckSubscription();

}
}
