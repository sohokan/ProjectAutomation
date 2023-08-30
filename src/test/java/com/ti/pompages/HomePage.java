package com.ti.pompages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.ti.DriverFactory;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.equalToIgnoringCase;

public class HomePage {

    By AutomationImageLocator= By.cssSelector("img[alt*='automation']");

    By AutomationCarouselLocator=By.xpath("//li[contains(@data-target,'carousel')]");

    By AutomationCarouselTextLocator=By.xpath("//h2[contains(text(), 'Automation')]");

    By userLocator=By.cssSelector("ul[class='nav navbar-nav'] li a b");

    By deleteUserLocator=By.xpath("//a[contains(@href,'delete')]");



    By ads= By.xpath("//div[contains(@id,'ad')]");

    By continueLocator=By.xpath("//a[contains(@data-qa,'continue')]");


    By accountDeletedLocator=By.xpath("//h2[contains(@data-qa,'deleted')]");

    By iconDeletedLocator=By.xpath("//a[contains(@href,'delete')]");
    WebDriver driver = DriverFactory.getInstance().getDriver();

    WebElement WebsiteText;
    List<WebElement> CarrouselDot;

    WebElement labeluser;

    WebElement iconDeleteUser;

    WebElement labelaccountDeleted;
    WebElement btnContinue;

    WebElement iconDelete;



    public void HomePageTitle()

    {
        WebsiteText=driver.findElement(AutomationImageLocator);
        assertThat(WebsiteText.getAttribute("alt"), containsString("automation"));

    }

    public void Clickoncarousel()
    {
        CarrouselDot=driver.findElements(AutomationCarouselLocator);

        for ( var carrousel:CarrouselDot) {
            carrousel.click();
            assertThat(driver.findElement(AutomationCarouselTextLocator).getText(), containsString("Automation"));


        }





    }

    public void LoggedUser() throws InterruptedException {
        disableAds();
       boolean checkexistent= driver.findElements(userLocator).size()>0;
if (checkexistent){
            labeluser=driver.findElement(userLocator);

        System.out.println("User Register: "+labeluser.getText());}

        System.out.println("User is shown:"+checkexistent);

    }



    public void clickonDeleteUser()
    {

        iconDelete= driver.findElement(iconDeletedLocator);

        iconDelete.click();

    }

    public void VerifyAccountDeleted() throws InterruptedException {
        labelaccountDeleted=driver.findElement(accountDeletedLocator);

        btnContinue=driver.findElement(continueLocator);

        assertThat(labelaccountDeleted.getText(), containsString("DELETED"));
        btnContinue.click();

        disableAds();
        if(driver.getCurrentUrl().contains("google_vignette"))
            btnContinue.click();


    }



    void disableAds() throws InterruptedException {

        if(driver.getCurrentUrl().contains("google_vignette"))  {
// Comparing the web URL
//            assertEquals("https://practice.automationtesting.in/#google_vignette", driver.getCurrentUrl());

//            new WebDriverWait(driver, Duration.ofSeconds(10))
//                    .until(ExpectedConditions.visibilityOfAllElements(driver.findElements(By.xpath("//div[contains(@class,'close')]"))));



            Thread.sleep(1000);

            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("const elements = document.getElementsByClassName('adsbygoogle adsbygoogle-noablate'); while (elements.length > 0) elements[0].remove()");
          /*  WebElement AdButton = driver.findElement(By.xpath("//div[contains(@class,'close')]"));
            AdButton.click();*/

// Comparing the web URL
//            String newURL = driver.getCurrentUrl();
//            assertEquals("https://practice.automationtesting.in/my-account/", newURL);
        }



    }
}
