package com.ti.pompages;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import static org.testng.AssertJUnit.assertTrue;


public class ProductPage extends HomePage {

    By productsPageLocator= By.cssSelector("a[href='/products']");

    By productsLocator =By.xpath("//div[@class='productinfo text-center']");

    By viewProductLocator=By.cssSelector("a[href *='/product_details/']");

    By addCartLocator=By.xpath("//div[@class='productinfo text-center']//i[contains(@class,'cart')]");

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



    public void GotoProductPage() throws InterruptedException {
        ArrayList<String> tabs = new ArrayList<String> (driver.getWindowHandles());
        driver.switchTo().window(tabs.get(0));
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

//            System.out.println(addCart.get(countViewProducts));
//            System.out.println(linkViewProducts.get(countViewProducts).getText());

            products.add(new ProductsObjects(item.findElement( By.tagName("p")).getText(),item.findElement( By.tagName("h2")).getText(),addCart.get(countViewProducts),linkViewProducts.get(countViewProducts),0));

            countViewProducts++;


        }
//verify click 1st
//productItems.get(0).findElement( By.xpath("//a[contains(text(),'Add to cart')]")).click()





    }

    public void SelecttoViewProducts(int selecteditem) throws InterruptedException {
        position=selecteditem;
        products.get(selecteditem).viewProduct.click();

        DisableAds();

        if (driver.getCurrentUrl().contains("google_vignette"))
            linkViewProducts.get(selecteditem).click();

        DisableAds();

    }

    public void AddtoCart(int i) throws InterruptedException {

        WebElement latestId = driver.findElement(By.xpath("//div[@id='cartModal']//button[normalize-space()='Continue Shopping']"));
        products.get(i).addToCart.click();
        products.get(i).intquantity=products.get(i).intquantity+1;

        DisableAds();

        if (driver.getCurrentUrl().contains("google_vignette"))
            addCart.get(i).click();

        DisableAds();


        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
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

        js.executeScript("window.scrollBy(0,400)");
        panelBrand=driver.findElements(panelBrandLocator);

//        System.out.println(panelBrand.size());

        panelBrand.forEach(c-> System.out.println(c.getText()));

        panelBrand.forEach(c-> assertTrue(c.isDisplayed()));

    }

    public  void SelectBrand() throws InterruptedException {
        DisableAds();
        panelBrand.get(2).click();
        DisableAds();

        if (driver.getCurrentUrl().contains("google_vignette") ||driver.getCurrentUrl().equals("https://automationexercise.com/products") )
        {
//            driver.navigate().refresh();

            panelBrand.get(2).click();
//            js.executeScript("arguments[0].click();", panelBrand);
            DisableAds();

        }



    }
}
