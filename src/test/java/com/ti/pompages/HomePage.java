package com.ti.pompages;

import com.ti.dao.ProductsObjects;
import org.openqa.selenium.*;
import org.openqa.selenium.support.events.EventFiringDecorator;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import org.ti.DriverFactory.DriverFactory;

import org.ti.utils.listeners.WebDriverEventListener;

import static com.ti.pompages.SignUpPage.randomEmail;
import static com.ti.pompages.SignUpPage.password;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.testng.AssertJUnit.assertTrue;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import static org.ti.RandomDataGeneration.GenerateUserData.GenerateRandomEmail;
import static org.ti.utils.ui.SeleniumUtil.DisableAds;


public class HomePage {

    By HomePageLocator=By.cssSelector("ul[class='nav navbar-nav'] li:nth-child(1)");

    By automationImageLocator= By.cssSelector("img[alt*='automation']");

    By automationCarouselLocator=By.xpath("//div[contains(@class,'item')]//h2[contains(text(),'Full-Fledged')]");

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

    By dressLocator=By.cssSelector("a[href*='category_products/1']");

   By lblRecommendedLocator=By.cssSelector("div[class=\"recommended_items\"] h2[class=\"title text-center\"]");

   By carouselRecommendedProductLocator=By.xpath("//div[contains(@class,'carousel slide')]//div[@class='productinfo text-center']");

   By btnContinueLocator=By.xpath("//div[@class='modal-content']//button[normalize-space()='Continue Shopping']");


   By btnAngelUpLocator=By.cssSelector("i[class='fa fa-angle-up']");
  public static WebDriver driver = DriverFactory.getInstance().getDriver();
    WebDriverEventListener driverEventListener = new WebDriverEventListener ();


//        EventFiringDecorator<WebDriver> decorator = new EventFiringDecorator<>( driverEventListener);

    public WebDriver decorated= new EventFiringDecorator<>( driverEventListener).decorate(driver);

    WebElement WebsiteText;
    List<WebElement> carrouselText;

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

    WebElement btnAngelUp;

    List<WebElement> carouselRecommendedProduct;



    JavascriptExecutor js = (JavascriptExecutor) driver;

    private static Logger log = LogManager.getLogger(HomePage.class);




    boolean checkexistent;
    String UserId= "";

     public static List<ProductsObjects> products = new ArrayList<>();

     public static List<ProductsObjects> recommendProducts = new ArrayList<>();

      public static int position;





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

    public void CheckCarouselText()
    {
        carrouselText=decorated.findElements(automationCarouselLocator);
        String hiddenText ;
        System.out.println("Carossel elements "+   carrouselText.size());


        for ( var carrousel:carrouselText) {
            hiddenText = (String)((JavascriptExecutor)driver).executeScript(
                    "return arguments[0].textContent;", carrousel);
            assertThat(hiddenText, containsStringIgnoringCase("Full-Fledged"));

        }





    }

    public void LoggedUser() throws InterruptedException {


        checkexistent= driver.findElements(userLocator).size()>0;
        if (checkexistent){
            labeluser=decorated.findElement(userLocator);
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

        iconDelete= decorated.findElement(iconDeletedLocator);


//        getScreenShot(carrouselText.get(0),getBrowser());



        iconDelete.click();

    }

    public void VerifyAccountDeleted() throws InterruptedException {
        labelaccountDeleted=decorated.findElement(accountDeletedLocator);

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
        txtSubscription=driver.findElement(SubsLocator);
        System.out.println(txtSubscription.getText());
        assertThat(txtSubscription.getText(), containsString("SUBSCRIPTION"));
        inputsusbscribeEmail=driver.findElement(suscribeemailLocator);
        inputsusbscribeEmail.sendKeys(GenerateRandomEmail());
        btnsubscribe=driver.findElement(subscribeLocator);
        btnsubscribe.click();
        alertSuscribe=driver.findElement(sucessalertLocator);
        System.out.println( alertSuscribe.getText());
        assertThat(alertSuscribe.getText(), containsString("success"));
    }

    public void ScrolltoBotom() throws InterruptedException {
//        Thread.sleep(2000);
        js.executeScript("window.scrollBy(0,document.body.scrollHeight)");
        txtSubscription=driver.findElement(SubsLocator);
        assertThat(txtSubscription.getText(), containsString("SUBSCRIPTION"));

    }

    public void ScrolltoTop() throws InterruptedException {
        Thread.sleep(2000);
        js.executeScript("scroll(0, -250);");

    }

    public void btnScrolltoUp()  {

        btnAngelUp=driver.findElement(btnAngelUpLocator);

        js.executeScript("arguments[0].click();", btnAngelUp);



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

        js.executeScript("arguments[0].click();", recommendProducts.get(itemSelection).getAddToCart());


        btnContinueShooping= driver.findElement(btnContinueLocator);
        wait.until(ExpectedConditions.elementToBeClickable(btnContinueShooping));
        driver.switchTo().activeElement();
        btnContinueShooping.click();
        recommendProducts.get(itemSelection).intquantity=1;


    }





    public void CategoryVisibility()

    {
        js.executeScript("window.scrollBy(0,400)");

        panelCategory=driver.findElements(categoryLocator);


        panelCategory.forEach(c-> System.out.println(c.getText()));

        panelCategory.forEach(c-> assertTrue(c.isDisplayed()));





    }

    public void SelectWomanCategory() throws InterruptedException {



        js.executeScript("arguments[0].click();", driver.findElement(By.cssSelector("a[href$='Women']")));


        panelDress=driver.findElement(dressLocator);

        js.executeScript("arguments[0].click();", panelDress);

        DisableAds();

    }

    public  void GenerateLogs(){


//        log.info("User is Register: "+ checkexistent);
        log.info(randomEmail);
        log.info(password);
        log.info("________________________________________________________");

    }



}
