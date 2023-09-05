package com.ti.pompages;

import com.ti.pompages.SignUpPage ;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.ti.DriverFactory;

import java.util.List;
import java.util.UUID;

import static com.ti.pompages.SignUpPage.email;
import static com.ti.pompages.SignUpPage.password;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.equalToIgnoringCase;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


public class HomePage {

    By automationImageLocator= By.cssSelector("img[alt*='automation']");

    By automationCarouselLocator=By.xpath("//li[contains(@data-target,'carousel')]");

    By automationCarouselTextLocator=By.xpath("//h2[contains(text(), 'Automation')]");

    By userLocator=By.cssSelector("ul[class='nav navbar-nav'] li a b");

    By deleteUserLocator=By.xpath("//a[contains(@href,'delete')]");



    By ads= By.xpath("//div[contains(@id,'ad')]");

    By continueLocator=By.xpath("//a[contains(@data-qa,'continue')]");


    By accountDeletedLocator=By.xpath("//h2[contains(@data-qa,'deleted')]");

    By iconDeletedLocator=By.xpath("//a[contains(@href,'delete')]");

    By LogoutLocator=By.cssSelector("a[href='/logout']");
    WebDriver driver = DriverFactory.getInstance().getDriver();

    WebElement WebsiteText;
    List<WebElement> CarrouselDot;

    WebElement labeluser;

    WebElement iconDeleteUser;

    WebElement labelaccountDeleted;
    WebElement btnContinue;

    WebElement iconDelete;

    WebElement linkLogout;

    String random = UUID.randomUUID()
            .toString()
            .substring(0, 6);

    private static Logger log = LogManager.getLogger(HomePage.class);

    boolean checkexistent;
    String UserId= "";

    public void HomePageTitle()

    {
        WebsiteText=driver.findElement(automationImageLocator);
        System.out.println(WebsiteText.getAttribute("alt"));
        assertThat(WebsiteText.getAttribute("alt"), containsString("automation"));

    }

    public void Clickoncarousel()
    {
        CarrouselDot=driver.findElements(automationCarouselLocator);

        for ( var carrousel:CarrouselDot) {
            carrousel.click();
            assertThat(driver.findElement(automationCarouselTextLocator).getText(), containsString("Automation"));


        }





    }

    public void LoggedUser() throws InterruptedException {

        DisableAds();
        checkexistent= driver.findElements(userLocator).size()>0;
        if (checkexistent){
            labeluser=driver.findElement(userLocator);
            UserId=labeluser.getText();
            System.out.println("User "+UserId +" is Logged:"+checkexistent);}
        else{
            System.out.println("User "+UserId +"is Logged:"+checkexistent);}

    }
    public void Logout()
    {
        linkLogout=driver.findElement(LogoutLocator);
        linkLogout.click();

    }



    public void ClickonDeleteUser()
    {

        iconDelete= driver.findElement(iconDeletedLocator);

        iconDelete.click();

    }

    public void VerifyAccountDeleted() throws InterruptedException {
        labelaccountDeleted=driver.findElement(accountDeletedLocator);

        btnContinue=driver.findElement(continueLocator);
        log.info("User deleted");
        assertThat(labelaccountDeleted.getText(), containsString("DELETED"));
        btnContinue.click();

        DisableAds();
        if(driver.getCurrentUrl().contains("google_vignette"))
            btnContinue.click();


    }

    public  void GenerateLogs(){


        log.info("User exist: "+ checkexistent);
        log.info(email);
        log.info(password);
        log.info("________________________________________________________");

    }



    void DisableAds() throws InterruptedException {

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
