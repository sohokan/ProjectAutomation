package com.ti.pompages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;


public class ProductPage extends HomePage {

    By productsPageLocator= By.cssSelector("a[href='/products']");

    By productsLocator =By.xpath("//div[@class='productinfo text-center']");

    By viewProductLocator=By.cssSelector("a[href *='/product_details/']");

    WebElement linkProductsPage;

    List<WebElement> productItems;

    List<WebElement> linkViewProducts;

    public void VerifyProductList()
    {
        int countViewProducts=0;

        linkProductsPage=driver.findElement(productsPageLocator);
        linkProductsPage.click();
        try {
            DisableAds();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        if(driver.getCurrentUrl().contains("google_vignette"))
            linkProductsPage.click();

        productItems=driver.findElements(productsLocator);

        System.out.println("Total Items: "+productItems.size());

        linkViewProducts=driver.findElements(viewProductLocator);

        for (var item:productItems) {


            System.out.println(item.findElement( By.tagName("h2")).getText());
            System.out.println(item.findElement( By.tagName("p")).getText());
            System.out.println(item.findElement( By.xpath("//a[contains(text(),'Add to cart')]")).getText());

            System.out.println(linkViewProducts.get(countViewProducts).getText());
            countViewProducts++;


        }
//verify click 1st
//productItems.get(0).findElement( By.xpath("//a[contains(text(),'Add to cart')]")).click();
        linkViewProducts.get(1).click();



    }
}
