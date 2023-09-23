package com.ti.pompages;

import org.openqa.selenium.*;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Parameters;
import org.ti.DriverFactory.BrowserType;
import org.ti.DriverFactory.DriverFactory;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
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


   By btnAngelUpLocator=By.cssSelector(".fa.fa-angle-up");
   WebDriver driver = DriverFactory.getInstance().getDriver();

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

    String random = UUID.randomUUID()
            .toString()
            .substring(0, 6);

    JavascriptExecutor js = (JavascriptExecutor) driver;

    private static Logger log = LogManager.getLogger(HomePage.class);

    boolean checkexistent;
    String UserId= "";

     public static List<ProductsObjects> products = new ArrayList<>();

     public static List<ProductsObjects> recommendProducts = new ArrayList<>();

      public static int position;

    @Parameters("browser")
    public void WaitForAdblocker() {

        String browser=((RemoteWebDriver) driver).getCapabilities().getBrowserName().toLowerCase();
        System.out.println("Browser Name is : "+browser);

        if (browser.contains("chrome")) {
            Set<String> AllWindowHandles = driver.getWindowHandles();
//        ArrayList<String> tabs = new ArrayList<String> (driver.getWindowHandles());
//        driver.switchTo().window(tabs.get(1));
            String window1 = (String) AllWindowHandles.toArray()[0];
            String window2 = (String) AllWindowHandles.toArray()[1];

            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            wait.until(ExpectedConditions.numberOfWindowsToBe(2));


            driver.switchTo().window(window2);

            WebElement Adblock = driver.findElement(By.xpath("//h2[@class='installed__heading']"));

            wait.until(ExpectedConditions.visibilityOf(Adblock));
            driver.close();

            driver.switchTo().window(window1);
        }

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

    public void CheckCarouselText()
    {
        carrouselText=driver.findElements(automationCarouselLocator);
        String hiddenText ;

        for ( var carrousel:carrouselText) {
            hiddenText = (String)((JavascriptExecutor)driver).executeScript(
                    "return arguments[0].textContent;", carrousel);
            assertThat(hiddenText, containsStringIgnoringCase("Full-Fledged"));

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

    public void CloseBrowser()
    {

        driver.quit();
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
        txtSubscription=driver.findElement(SubsLocator);
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
        btnAngelUp.click();


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



    public void getStaleElement(WebElement web ,WebElement webstale) {
        try {
           Thread.sleep(1000);
            js.executeScript("arguments[0].click();", web);
        } catch (StaleElementReferenceException | org.openqa.selenium.NoSuchElementException | InterruptedException e) {
            System.err.println("Attempting to recover from Exception using instead" + webstale);
            js.executeScript("arguments[0].click();", webstale);
        }
    }
}
