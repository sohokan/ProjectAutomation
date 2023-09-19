package com.ti.pompages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.containsStringIgnoringCase;

import  com.ti.pompages.ProductPage;



public class ProductBrandPage extends HomePage {

    By productLocator=By.cssSelector(".title.text-center");

    By panelBabyHugLocator=By.xpath("//a[@href=\"/brand_products/Babyhug\"]");

    WebElement titleProduct;

    WebElement panelBabyHug;



    String urlCategoryPage;

    String strpanelBabyHug;

    JavascriptExecutor js = (JavascriptExecutor) driver;




   public void VerifyCategoryTitle(String s) throws InterruptedException {
       By xpathLocator;
       if (driver.getCurrentUrl().equals("#google_vignette") || driver.getCurrentUrl().equals("products"))
       {
           if (s.equals("Madame"))

               xpathLocator=By.xpath( "//a[@href=\"/brand_products/Madame\"]");

           else
               xpathLocator=By.xpath( "//a[@href='/brand_products/Babyhug']");


               js.executeScript("arguments[0].click();", driver.findElement(xpathLocator));


           DisableAds();


       }


       DisableAds();
       titleProduct=driver.findElement(productLocator);
       assertThat(titleProduct.getText(), containsStringIgnoringCase(s));

   }

    public void VerifyBrandPageisDisplayed() throws InterruptedException {


        if (driver.getCurrentUrl().equals("#google_vignette"))
        {
            driver.navigate().refresh();
            DisableAds();

        }

        urlCategoryPage= driver.getCurrentUrl();

        assertThat(urlCategoryPage, containsString("brand_products"));

    }

   public void SelectAnyCategory() throws InterruptedException {


       panelBabyHug=driver.findElement(panelBabyHugLocator);
       strpanelBabyHug=panelBabyHug.getText();
       js.executeScript("arguments[0].click();", panelBabyHug);

       if (driver.getCurrentUrl().equals("#google_vignette"))
       {
           driver.navigate().refresh();
           DisableAds();
           js.executeScript("arguments[0].click();", panelBabyHug);

       }

   }
}
