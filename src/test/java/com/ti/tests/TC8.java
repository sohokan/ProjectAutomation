package com.ti.tests;

import org.testng.annotations.Test;

public class TC8 extends Base{


    @Test
    void VerifyProductsVisible(){
        Products.VerifyProductList();

    }
}
