package com.ti.tests;

import org.testng.annotations.Test;

public class TC9 extends Base {


    @Test
    void VerifyProductSearch() throws InterruptedException {
        Products.GotoProductPage();
        Products.SearchProducts("tshirt");
        Products.VerifyProductList();
    }
}
