package com.ti.pompages;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import java.util.List;


public class ProductPage extends HomePage {

    By productsPageLocator= By.cssSelector("a[href='/products']");

    By productsLocator =By.xpath("//div[@class='productinfo text-center']");

    By viewProductLocator=By.cssSelector("a[href *='/product_details/']");

    WebElement linkProductsPage;

    List<WebElement> productItems;

    List<WebElement> linkViewProducts;

    JavascriptExecutor jse = (JavascriptExecutor)driver;

    public void VerifyProductList() throws InterruptedException {
        int countViewProducts=0;

        linkProductsPage=driver.findElement(productsPageLocator);
        linkProductsPage.click();
     DisableAds();

        if(driver.getCurrentUrl().contains("google_vignette"))
            linkProductsPage.click();

        jse.executeScript("window.scrollBy(0,400)");
        DisableAds();

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
//productItems.get(0).findElement( By.xpath("//a[contains(text(),'Add to cart')]")).click()





    }

    public void SelecttoViewProducts(int i) throws InterruptedException {
        linkViewProducts.get(i).click();


        DisableAds();

        if (driver.getCurrentUrl().contains("google_vignette"))
            linkViewProducts.get(i).click();

        DisableAds();





    }
}
