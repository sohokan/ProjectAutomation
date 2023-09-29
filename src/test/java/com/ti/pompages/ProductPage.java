package com.ti.pompages;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import static org.testng.AssertJUnit.assertTrue;


public class ProductPage extends HomePage {

    By productsPageLocator= By.cssSelector("a[href='/products']");

    By productsLocator =By.cssSelector("div[class*='productinfo']");

    By viewProductLocator=By.cssSelector("div[class*='choose'] a[href*='product_details']");
//    a[href*='product_details']
    By addCartLocator=By.cssSelector("div[class='productinfo text-center'] a[class*='cart']");

     By searchProductLocator=By.id("search_product");

     By submit_search=By.id("submit_search");

     By continueshoppingLocator=By.xpath("//button[normalize-space()='Continue Shopping']");

     By panelBrandLocator=By.cssSelector("a[href*=\"brand_products\"]");

    WebElement linkProductsPage;

    List<WebElement> productItems;

    List<WebElement> addCart;

    List<WebElement> linkViewProducts;

    WebElement inputSearchProduct;
    WebElement btnSearchProduct;

    WebElement btnContinueShopping;

    List<WebElement> panelBrand;

    JavascriptExecutor jse = (JavascriptExecutor)driver;
    List<WebElement> overallContent;




    public void GotoProductPage() throws InterruptedException {

        linkProductsPage=driver.findElement(productsPageLocator);
        linkProductsPage.click();
        DisableAds();
        if(driver.getCurrentUrl().contains("google_vignette"))
            linkProductsPage.click();



    }

    public void VerifyProductList() throws InterruptedException {
        int countViewProducts=0;

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        wait.until(ExpectedConditions.urlContains("products"));
       overallContent= driver.findElements(By.xpath("(//img[@alt='ecommerce website products'])"));


        jse.executeScript("window.scrollBy(0,500)");
        DisableAds();

        productItems=driver.findElements(productsLocator);

        System.out.println("Total Items: "+productItems.size());

        linkViewProducts=driver.findElements(viewProductLocator);
        addCart=driver.findElements(addCartLocator);


        for (var item:productItems) {


            System.out.println(item.findElement( By.tagName("h2")).getText());
            System.out.println(item.findElement( By.tagName("p")).getText());
            System.out.println(item.findElement( By.tagName("a")).getText());

//            System.out.println(addCart.get(countViewProducts));
//            System.out.println(linkViewProducts.get(countViewProducts).getText());

//            products.add(new ProductsObjects(item.findElement( By.tagName("p")).getText(),item.findElement( By.tagName("h2")).getText(),item.findElement( By.tagName("a")),linkViewProducts.get(countViewProducts),0));
           products.add(new ProductsObjects(item.findElement( By.tagName("p")).getText(),item.findElement( By.tagName("h2")).getText(),item.findElement( By.tagName("a")),linkViewProducts.get(countViewProducts),0));

            countViewProducts++;


        }
//verify click 1st
//productItems.get(0).findElement( By.xpath("//a[contains(text(),'Add to cart')]")).click()





    }

    public void SelecttoViewProducts(int selecteditem) throws InterruptedException {

        Actions actions = new Actions(driver);

        overallContent= driver.findElements(By.xpath("(//img[@alt='ecommerce website products'])"));


        List<WebElement> iconViewProducts=driver.findElements(By.cssSelector("a[href*='product_details']"));
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));


        position=selecteditem;

        System.out.println(products.get(selecteditem).viewProduct);

        System.out.println("size"+iconViewProducts.size());

        js.executeScript("arguments[0].scrollIntoView(true);", iconViewProducts.get(selecteditem));

//        actions.moveToElement(overallContent.get(selecteditem)).perform();

           getStaleElement(products.get(selecteditem).viewProduct,iconViewProducts.get(selecteditem));



        DisableAds();

        if (driver.getCurrentUrl().contains("google_vignette"))
            getStaleElement(products.get(selecteditem).viewProduct,iconViewProducts.get(selecteditem));


        DisableAds();
    }

    public void AddtoCart(int i) throws InterruptedException {


        Actions actions = new Actions(driver);

        List<WebElement> carticon=driver.findElements(By.cssSelector("div[class='product-overlay'] a[class*='cart']"));

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));




        WebElement latestId = driver.findElement(By.xpath("//div[@id='cartModal']//button[normalize-space()='Continue Shopping']"));
        System.out.println(products.get(i).addToCart);


   js.executeScript("arguments[0].scrollIntoView();", overallContent.get(i));

//        actions.moveToElement(overallContent.get(i)).perform();

        wait.until(ExpectedConditions.visibilityOf(overallContent.get(i)));
//        wait.until(ExpectedConditions.elementToBeClickable(products.get(i).addToCart));
        getStaleElement(products.get(i).addToCart,carticon.get(i));
     ;
//        products.get(i).addToCart.click();
        products.get(i).intquantity=products.get(i).intquantity+1;

        DisableAds();

        if (driver.getCurrentUrl().contains("google_vignette"))
            getStaleElement(products.get(i).addToCart,carticon.get(i));

        DisableAds();



        wait.until(ExpectedConditions.elementToBeClickable(latestId));
        driver.switchTo().activeElement();
        latestId.click();


    }

    public void SearchProducts(String searchitem) throws InterruptedException {

        inputSearchProduct=driver.findElement(searchProductLocator);
        inputSearchProduct.sendKeys(searchitem);

        btnSearchProduct=driver.findElement(submit_search);
        btnSearchProduct.click();

    }

    public void VerifyBrand()

    {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.urlContains("products"));
        js.executeScript("window.scrollBy(0,400)");
        panelBrand=driver.findElements(panelBrandLocator);

//        System.out.println(panelBrand.size());

        panelBrand.forEach(c-> System.out.println(c.getText()));

        panelBrand.forEach(c-> assertTrue(c.isDisplayed()));

    }

    public  void SelectBrand() throws InterruptedException {

        panelBrand.get(2).click();
        DisableAds();


    }
}
