package com.ti.tests;

import org.testng.annotations.Test;

public class TC21 extends Base{

    @Test(priority = 1)
    void VerifyProductsVisible() throws InterruptedException {
        Products.GotoProductPage();
        Products.VerifyProductList();
        Products.SelecttoViewProducts(0);//first one
        ProductDetail.CheckProductDetail();
        ProductDetail.VerifyReviewLabel();
        ProductDetail.AddReview();

    }
}
