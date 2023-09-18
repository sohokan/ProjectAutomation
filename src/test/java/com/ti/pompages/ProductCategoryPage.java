package com.ti.pompages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.containsStringIgnoringCase;

public class ProductCategoryPage extends HomePage {

    By productLocator=By.cssSelector(".title.text-center");

    By panelJeanLocator=By.xpath("//a[normalize-space()='Jeans']");

    WebElement titleProduct;

    WebElement panelJean;



    String urlCategoryPage;

    JavascriptExecutor js = (JavascriptExecutor) driver;

   public void VerifyCategoryPageisDisplayed()

   {

       urlCategoryPage= driver.getCurrentUrl();

       assertThat(urlCategoryPage, containsString("category_products"));

   }


   public void VerifyCategoryTitle(String s)

   {
       titleProduct=driver.findElement(productLocator);
       assertThat(s, containsStringIgnoringCase(titleProduct.getText()));

   }

   public void SelectManCategory() throws InterruptedException {
       panelJean=driver.findElement(panelJeanLocator) ;

       js.executeScript("arguments[0].click();", panelJean);

       DisableAds();

   }
}
