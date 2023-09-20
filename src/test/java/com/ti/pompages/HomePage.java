package com.ti.pompages;

import com.ti.pompages.SignUpPage ;

import org.apache.commons.lang3.ObjectUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.ti.DriverFactory;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.UUID;

import static com.ti.pompages.SignUpPage.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.testng.AssertJUnit.assertTrue;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


public class HomePage {

    By HomePageLocator=By.xpath("//a[normalize-space()='Home']");

    By automationImageLocator= By.cssSelector("img[alt*='automation']");

    By automationCarouselLocator=By.xpath("//li[contains(@data-target,'carousel')]");

    By automationCarouselTextLocator=By.xpath("//h2[contains(text(), 'Automation')]");

    By userLocator=By.cssSelector("ul[class='nav navbar-nav'] li a b");

    By SubsLocator=By.xpath("//h2[text()='Subscription']");

    By continueLocator=By.xpath("//a[contains(@data-qa,'continue')]");


    By accountDeletedLocator=By.xpath("//h2[contains(@data-qa,'deleted')]");

    By iconDeletedLocator=By.xpath("//a[contains(@href,'delete')]");

    By LogoutLocator=By.cssSelector("a[href='/logout']");

    By suscribeemailLocator=By.id("susbscribe_email");

    By subscribeLocator=By.id("subscribe");

    By sucessalertLocator=By.xpath("//div[@class='alert-success alert']");

    By categoryLocator=By.id("accordian");

    By dressLocator=By.xpath("//div[@id=\"Women\"]//a[contains(text(),\"Dress\")]");

   By lblRecommendedLocator=By.cssSelector("div[class=\"recommended_items\"] h2[class=\"title text-center\"]");

   By carouselRecommendedProductLocator=By.xpath("//div[contains(@class,'carousel slide')]//div[@class='productinfo text-center']");

   By btnContinueLocator=By.xpath("//div[@class='modal-content']//button[normalize-space()='Continue Shopping']");

   WebDriver driver = DriverFactory.getInstance().getDriver();

    WebElement WebsiteText;
    List<WebElement> CarrouselDot;

    WebElement labeluser;



    WebElement labelaccountDeleted;
    WebElement btnContinue;

    WebElement iconDelete;

    WebElement linkLogout;

    WebElement txtSubscription;

    WebElement iconHome;

    WebElement inputsusbscribeEmail;

    WebElement btnsubscribe;

    WebElement alertSuscribe;

    List<WebElement> panelCategory;
    WebElement panelDress;

    WebElement lblRecommended;

    WebElement btnContinueShooping;

    List<WebElement> carouselRecommendedProduct;

    String random = UUID.randomUUID()
            .toString()
            .substring(0, 6);

    JavascriptExecutor js = (JavascriptExecutor) driver;

    private static Logger log = LogManager.getLogger(HomePage.class);

    boolean checkexistent;
    String UserId= "";

    static public List<ProductsObjects> products = new ArrayList<>();

    static public List<ProductsObjects> recommendProducts = new ArrayList<>();

    static public int position;


    public void WaitForAdblocker()

    {
        Set<String> AllWindowHandles = driver.getWindowHandles();
//        ArrayList<String> tabs = new ArrayList<String> (driver.getWindowHandles());
//        driver.switchTo().window(tabs.get(1));
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.numberOfWindowsToBe(2));
        String window1 = (String) AllWindowHandles.toArray()[0];
        String window2 = (String) AllWindowHandles.toArray()[1];

        driver.switchTo().window(window2);

        WebElement Adblock = driver.findElement(By.xpath("//h2[@class='installed__heading']"));

        wait.until(ExpectedConditions.visibilityOf(Adblock));
        driver.close();

        driver.switchTo().window(window1);


    }
    public void GotoHomePage()
    {


        iconHome= driver.findElement(HomePageLocator);
        iconHome.click();

    }
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
        if (checkexistent) {
            linkLogout = driver.findElement(LogoutLocator);
            linkLogout.click();
        }
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

    public void CheckSubscription()
    {

        System.out.println(txtSubscription.getText());
        assertThat(txtSubscription.getText(), containsString("SUBSCRIPTION"));
        inputsusbscribeEmail=driver.findElement(suscribeemailLocator);
        inputsusbscribeEmail.sendKeys(GenerateRandomEmail(10));
        btnsubscribe=driver.findElement(subscribeLocator);
        btnsubscribe.click();
        alertSuscribe=driver.findElement(sucessalertLocator);
        System.out.println( alertSuscribe.getText());
        assertThat(alertSuscribe.getText(), containsString("success"));
    }

    public void ScrolltoBotom()

    {
        js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
        txtSubscription=driver.findElement(SubsLocator);

    }

    public void ScrolltoTop()

    {
         js.executeScript("window.scrollTo(0, -document.body.scrollHeight)");;


    }


    public void ScrapRecommendedProduct()

    {



        List<WebElement> addToCart = new ArrayList<>();


        String hiddenPrice;

        String hiddenName;
        lblRecommended=driver.findElement(lblRecommendedLocator);

        assertThat(lblRecommended.getText(), containsStringIgnoringCase("recommended items"));


        carouselRecommendedProduct=driver.findElements(carouselRecommendedProductLocator);

        System.out.println("Recommend Product total items "+carouselRecommendedProduct.size());


        for (var p:carouselRecommendedProduct){

             hiddenPrice=   (String)((JavascriptExecutor)driver).executeScript(
                    "return arguments[0].textContent;", p.findElement(By.tagName("h2")));

            hiddenName=   (String)((JavascriptExecutor)driver).executeScript(
                    "return arguments[0].textContent;", p.findElement(By.tagName("p")));
            System.out.println(hiddenPrice);
            System.out.println(hiddenName);
//            products.findElement(By.tagName("a"));

             addToCart.add(p.findElement(By.tagName("a")));


            recommendProducts.add(new ProductsObjects(hiddenPrice,hiddenName,p.findElement(By.tagName("a")),null,0));



        }


//        js.executeScript("arguments[0].click();", btnContinueShooping);

    }

    public void AddtoCartRecommendProduct(int itemSelection)
    {

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        js.executeScript("arguments[0].click();", recommendProducts.get(itemSelection).addToCart);


        btnContinueShooping= driver.findElement(btnContinueLocator);
        wait.until(ExpectedConditions.elementToBeClickable(btnContinueShooping));
        driver.switchTo().activeElement();
        btnContinueShooping.click();
        recommendProducts.get(itemSelection).intquantity=1;


    }





    public void CategoryVisibility()

    {
        js.executeScript("window.scrollBy(0,300)");

        panelCategory=driver.findElements(categoryLocator);




        panelCategory.forEach(c-> System.out.println(c.getText()));

        panelCategory.forEach(c-> assertTrue(c.isDisplayed()));





    }

    public void SelectWomanCategory() throws InterruptedException {


        panelDress=driver.findElement(dressLocator);

        js.executeScript("arguments[0].click();", panelDress);

        DisableAds();

    }

    public  void GenerateLogs(){


//        log.info("User is Register: "+ checkexistent);
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
