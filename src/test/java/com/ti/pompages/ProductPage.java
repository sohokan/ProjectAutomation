package com.ti.pompages;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import java.util.List;


public class ProductPage extends HomePage {

    By productsPageLocator= By.cssSelector("a[href='/products']");

    By productsLocator =By.xpath("//div[@class='productinfo text-center']");

    By viewProductLocator=By.cssSelector("a[href *='/product_details/']");

    By addCartLocator=By.xpath("//div[@class='productinfo text-center']//i[contains(@class,'cart')]");

     By searchProductLocator=By.id("search_product");

     By submit_search=By.id("submit_search");

     By continueshoppingLocator=By.xpath("//button[normalize-space()='Continue Shopping']");

    WebElement linkProductsPage;

    List<WebElement> productItems;

    List<WebElement> addCart;

    List<WebElement> linkViewProducts;

    WebElement inputSearchProduct;
    WebElement btnSearchProduct;

    WebElement btnContinueShopping;

    JavascriptExecutor jse = (JavascriptExecutor)driver;

    public void GotoProductPage() throws InterruptedException {
        linkProductsPage=driver.findElement(productsPageLocator);
        linkProductsPage.click();
        DisableAds();
        if(driver.getCurrentUrl().contains("google_vignette"))
            linkProductsPage.click();

    }

    public void VerifyProductList() throws InterruptedException {
        int countViewProducts=0;


        jse.executeScript("window.scrollBy(0,400)");
        DisableAds();

        productItems=driver.findElements(productsLocator);

        System.out.println("Total Items: "+productItems.size());

        linkViewProducts=driver.findElements(viewProductLocator);
        addCart=driver.findElements(addCartLocator);


        for (var item:productItems) {


            System.out.println(item.findElement( By.tagName("h2")).getText());
            System.out.println(item.findElement( By.tagName("p")).getText());

            System.out.println(addCart.get(countViewProducts));
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

    public void AddtoCart(int i) throws InterruptedException {
        addCart.get(i).click();


        DisableAds();

        if (driver.getCurrentUrl().contains("google_vignette"))
            addCart.get(i).click();

        DisableAds();
        btnContinueShopping= driver.findElement(continueshoppingLocator);
        driver.switchTo().activeElement();

        Thread.sleep(3000);

        driver.findElement(By.xpath("//div[@id='cartModal']//button[normalize-space()='Continue Shopping']")).click();
//        Thread.sleep(3000);

    }

    public void SearchProducts(String searchitem) throws InterruptedException {

        inputSearchProduct=driver.findElement(searchProductLocator);
        inputSearchProduct.sendKeys(searchitem);

        btnSearchProduct=driver.findElement(submit_search);
        btnSearchProduct.click();

    }
}
