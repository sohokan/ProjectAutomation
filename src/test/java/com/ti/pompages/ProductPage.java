package com.ti.pompages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;


public class ProductPage extends HomePage {

    By productsPageLocator= By.cssSelector("a[href='/products']");

    By productsLocator =By.xpath("//div[@class='productinfo text-center']");

    WebElement linkProductsPage;

    List<WebElement> productItems;

    public void VerifyProductList()
    {
        linkProductsPage=driver.findElement(productsPageLocator);
        linkProductsPage.click();
        try {
            DisableAds();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        if(driver.getCurrentUrl().contains("google_vignette"))
            linkProductsPage.click();







    }
}
