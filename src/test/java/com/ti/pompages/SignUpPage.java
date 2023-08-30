package com.ti.pompages;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;
import java.util.UUID;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class SignUpPage extends HomePage{

    By Login= By.xpath("//a[contains(text(),'Login')]");

    By NewUserNameLocator =By.cssSelector("input[placeholder='Name']");
    By NewEmailLocator= By.cssSelector("input[data-qa='signup-email']");

    By SignupLocator=By.cssSelector("button[data-qa^='signup']");

    By AccountLocator=By.xpath("(//h2[@class='title text-center'])[1]");

    By TitleLocator=By.xpath("(//input[contains(@id,'gender')])[1]");

    By PasswordLocator=By.xpath("//input[contains(@type,'password')]");

    By DaysLocator=By.xpath("//select[@id='days']");

    By MonthsLocator=By.id("months");
    By YearLocator=By.id("years");

    By NewsLocator=By.cssSelector("label[for='newsletter']");

    By OfferLocator=By.cssSelector("label[for='optin']");

    By FirstNameLocator=By.id("first_name");

    By LastNameLocator=By.id("last_name");

    By  companyLocator=By.id("company");

    By address1Locator=By.id("address1");

    By address2Locator=By.id("address2");

    By countryLocator=By.id("country");

    By stateLocator=By.id("state");

    By cityLocator=By.id("city");

    By zipcodeLocator=By.id("zipcode");

    By mobile_numberLocator=By.id("mobile_number");

    By createLocator=By.cssSelector("button[data-qa^='create-account']");

    By accountCreatedLocator=By.xpath("//h2[contains(@data-qa,'created')]");

    By continueLocator=By.xpath("//a[contains(@data-qa,'continue')]");







    WebElement txtBoxNewEmail;
    WebElement txtBoxNewName;

    WebElement btnSignup;

    WebElement labelAccountInformation;

    WebElement radioTitle;

    WebElement textBoxPassword;

    Select selectDay;

    Select selectMonth;

    Select selectYear;

    WebElement checkBoxNews;

    WebElement checkBoxOffer;

    WebElement textBoxFirstName;

     WebElement textBoxLastName;

    WebElement textBoxCompany;

    WebElement textBoxAddress1;

    WebElement textBoxAddress2;

    Select selectCountry;

    WebElement textBoxState;

    WebElement textBoxCity;

    WebElement textBoxZipcode;
    WebElement textBoxMobile_Number;

    WebElement btnCreate;

    WebElement labelaccountCreated;

    WebElement btnContinue;





    JavascriptExecutor js = (JavascriptExecutor) driver;

    String random = UUID.randomUUID()
            .toString()
            .substring(0, 6);

    public void RegisterNewEmail()  {




        WebElement LinkLogin= driver.findElement(Login);
        LinkLogin.click();


        new WebDriverWait(driver, Duration.ofSeconds(15))
                .until(ExpectedConditions.visibilityOfAllElements(driver.findElements(By.xpath("(//h2[normalize-space()='New User Signup!'])[1]"))));

//        js.executeScript("window.scrollBy(0,500)");
        txtBoxNewEmail =driver.findElement(NewEmailLocator);
        txtBoxNewName=driver.findElement(NewUserNameLocator);

        btnSignup=driver.findElement(SignupLocator);


        txtBoxNewName.sendKeys(random);
        txtBoxNewEmail.sendKeys(generateRandomEmail(10));
        btnSignup.click();

    }

   public void AccountInformation()
    {

        labelAccountInformation=  driver.findElement(AccountLocator);

        radioTitle= driver.findElement(TitleLocator);

        textBoxPassword= driver.findElement(PasswordLocator);

        selectDay= new Select(driver.findElement(DaysLocator));

        selectMonth= new Select(driver.findElement(MonthsLocator));

        selectYear= new Select(driver.findElement(YearLocator));

        checkBoxNews=driver.findElement(NewsLocator);

        checkBoxOffer=driver.findElement(OfferLocator);

        textBoxFirstName=driver.findElement(FirstNameLocator);

        textBoxLastName=driver.findElement(LastNameLocator);

        textBoxCompany=driver.findElement(companyLocator);
        textBoxAddress1=driver.findElement(address1Locator);

        textBoxAddress2=driver.findElement(address2Locator);

        selectCountry= new Select(driver.findElement(countryLocator));

        textBoxState=driver.findElement(stateLocator);

        textBoxCity=driver.findElement(cityLocator);

        textBoxZipcode=driver.findElement(zipcodeLocator);

        textBoxMobile_Number=driver.findElement(mobile_numberLocator);

        btnCreate=driver.findElement(createLocator);


        assertThat(labelAccountInformation.getText(), containsString("ACCOUNT"));
        radioTitle.click();

        textBoxPassword.sendKeys(generateRandomPassword(8));



        selectDay.selectByVisibleText("20");

        selectMonth.selectByVisibleText("July");

        selectYear.selectByVisibleText("1977");

        checkBoxNews.click();
        checkBoxOffer.click();

        textBoxFirstName.sendKeys(random);
        textBoxLastName.sendKeys(random);
        textBoxCompany.sendKeys(random);
        textBoxAddress1.sendKeys(random);

        textBoxAddress2.sendKeys(random);

        selectCountry.selectByVisibleText("Canada");

        textBoxState.sendKeys(random);

        textBoxCity.sendKeys(random);

        textBoxZipcode.sendKeys(random);

        textBoxMobile_Number.sendKeys(random);

        btnCreate.click();


    }


    public void AccountCreated() throws InterruptedException {
        labelaccountCreated=driver.findElement(accountCreatedLocator);

        btnContinue=driver.findElement(continueLocator);

        assertThat(labelaccountCreated.getText(), containsString("CREATED"));
        btnContinue.click();

        disableAds();
        if(driver.getCurrentUrl().contains("google_vignette"))
        btnContinue.click();


    }

//    17. Verify that 'Logged in as username' is visible







    public static String generateRandomEmail(int length) {

        String allowedChars = "abcdefghijklmnopqrstuvwxyz" + "1234567890" + "_-.";
        String email = "";
        String temp = RandomStringUtils.random(length, allowedChars);
        email = temp.substring(0, temp.length()) + "@testdata.com";
        System.out.println(email);
        return email;
    }


    public static String generateRandomPassword(int length) {
//        System.out.println("Generating a Random PW ");
        String allowedChars = "abcdefghijklmnopqrstuvwxyz" +"ABCDEFGHIJKLMNOPQRSTUVWXYZ"+ "1234567890" + "$";
        String password = "";
        String temp = RandomStringUtils.random(length, allowedChars);
        password = temp.substring(0, temp.length());
        System.out.println(password);
        return password;
    }





}
