package com.ti.tests;

import com.ti.pompages.HomePage;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TC18  extends Base{

//    @BeforeClass
//
//    void CloseAdblocker()
//    {
//
//        Home.WaitForAdblocker();
//    }

    @Test(description = "View Category Products")
    void VerifyViewCategoryProducts() throws InterruptedException {

        Home.CategoryVisibility();
        Home.SelectWomanCategory();
        ProductCategory.VerifyCategoryPageisDisplayed();
        ProductCategory.VerifyCategoryTitle("Women - Dress Products");
        ProductCategory.SelectManCategory();
        ProductCategory.VerifyCategoryPageisDisplayed();
        ProductCategory.VerifyCategoryTitle("Men - Jeans Products");
    }
}
