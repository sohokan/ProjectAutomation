package com.ti.pompages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.containsStringIgnoringCase;

public class ProductCategoryPage extends HomePage {

    By productLocator=By.cssSelector("h2[class*='text-center']");

    By panelJeanLocator=By.cssSelector("a[href*='category_products/6']");

    WebElement titleProduct;

    WebElement panelJean;



    String urlCategoryPage;

    JavascriptExecutor js = (JavascriptExecutor) driver;

   public void VerifyCategoryPageisDisplayed()

   {

       WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

       wait.until(ExpectedConditions.urlContains("products"));

       urlCategoryPage= driver.getCurrentUrl();

       assertThat(urlCategoryPage, containsString("category_products"));

   }


   public void VerifyCategoryTitle(String s)

   {
       WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

       wait.until(ExpectedConditions.urlContains("products"));

       assertThat(s, containsStringIgnoringCase(driver.findElement(productLocator).getText()));

   }

   public void SelectManCategory() throws InterruptedException {
       panelJean=driver.findElement(panelJeanLocator) ;

       js.executeScript("arguments[0].click();", panelJean);

       DisableAds();

   }
}
