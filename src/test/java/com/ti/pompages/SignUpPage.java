package com.ti.pompages;

import com.github.javafaker.Faker;
import org.apache.commons.lang3.RandomStringUtils;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class SignUpPage extends HomePage{

    By loginLocator= By.cssSelector("a[href=\"/login\"]");

    By NewUserNameLocator =By.cssSelector("input[placeholder='Name']");
    By NewEmailLocator= By.cssSelector("input[data-qa='signup-email']");

    By LoginEmailLocator=By.cssSelector("input[data-qa='login-email']");

    By LoginPasswordLocator=By.cssSelector("input[data-qa='login-password']");

    By LoginBtnLocator=By.cssSelector("button[data-qa='login-button']");

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

    By incorrectloginLocator=By.xpath("//p[contains(normalize-space(),' incorrect!')]");

    By LoginLocator=By.xpath("(//h2[normalize-space()='Login to your account'])[1]");

    By EmailexistLocator=By.xpath("//p[contains(normalize-space(),'exist!')]");



    WebElement txtBoxEmailLogin;
    WebElement txtBoxPassword;

    WebElement txtBoxNewEmail;
    WebElement txtBoxNewName;

    WebElement btnLogin;

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

    WebElement msgInvalidcred;

    WebElement msgLoginPage;

    WebElement msgEmailExist;


//    private static Logger log = LogManager.getLogger(SignUpPage.class);

    public static String email = "";

    public static String password = "";


    static Faker faker = new Faker();


    static public List<UserObjects> users = new ArrayList<>();

    public void VerifyLogin(String email, String password)
    {


        WebElement LinkLogin= driver.findElement(loginLocator);
        LinkLogin.click();


        new WebDriverWait(driver, Duration.ofSeconds(15))
                .until(ExpectedConditions.visibilityOfAllElements(driver.findElements(By.xpath("(//h2[normalize-space()='New User Signup!'])[1]"))));


        txtBoxEmailLogin=driver.findElement(LoginEmailLocator);
        txtBoxEmailLogin.sendKeys(email);

        txtBoxPassword=driver.findElement(LoginPasswordLocator);
        txtBoxPassword.sendKeys(password);

        btnLogin=driver.findElement(LoginBtnLocator);
        btnLogin.click();
    }

    public void VerifyincorretLoginMessage()
    {
        msgInvalidcred=driver.findElement(incorrectloginLocator);
        System.out.println(msgInvalidcred.getText());
        assertThat("Message is presented",msgInvalidcred.getText(), containsString("incorrect"));

    }


    public void RegisterNewEmail(String... email)  {




        WebElement LinkLogin= driver.findElement(loginLocator);
        LinkLogin.click();


        new WebDriverWait(driver, Duration.ofSeconds(15))
                .until(ExpectedConditions.visibilityOfAllElements(driver.findElements(By.xpath("(//h2[normalize-space()='New User Signup!'])[1]"))));

//        js.executeScript("window.scrollBy(0,500)");
        txtBoxNewEmail =driver.findElement(NewEmailLocator);
        txtBoxNewName=driver.findElement(NewUserNameLocator);

        btnSignup=driver.findElement(SignupLocator);


        txtBoxNewName.sendKeys(random);
        if (email.length>0) {
            txtBoxNewEmail.sendKeys(email[0]);
        }
        else{
            txtBoxNewEmail.sendKeys(GenerateRandomEmail(10));

        }
        btnSignup.click();

    }

    public void EmailExist()
    {
        msgEmailExist=driver.findElement(EmailexistLocator);
        System.out.println(msgEmailExist.getText());
        assertThat(msgEmailExist.getText(),containsString("exist"));

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

        textBoxPassword.sendKeys(GenerateRandomPassword(8));



        selectDay.selectByVisibleText("20");

        selectMonth.selectByVisibleText("July");

        selectYear.selectByVisibleText("1977");

        checkBoxNews.click();
        checkBoxOffer.click();

        users.add(new UserObjects(GenerateRandomFName(),GenerateRandomLName(),GenerateRandomComponany(),GenerateRandomFullAddress(),GenerateRandomBuilding(),GenerateRandomCapital(),GenerateRandomCity(),GenerateRandomZipcode(),"Canada",GenerateRandomPhoneNumber()));

        textBoxFirstName.sendKeys(users.get(0).strUserFirstName);
        textBoxLastName.sendKeys(users.get(0).strUserLastName);
        textBoxCompany.sendKeys(users.get(0).strCompany);
        textBoxAddress1.sendKeys(users.get(0).strAddress1);

        textBoxAddress2.sendKeys(users.get(0).strAddress2);

        selectCountry.selectByVisibleText("Canada");

        textBoxState.sendKeys(users.get(0).strState);

        textBoxCity.sendKeys(users.get(0).strCity);

        textBoxZipcode.sendKeys(users.get(0).strZipecode);

        textBoxMobile_Number.sendKeys(users.get(0).strPhoneNumber);


        btnCreate.click();


    }


    public void AccountCreated() throws InterruptedException {
        labelaccountCreated=driver.findElement(accountCreatedLocator);

        btnContinue=driver.findElement(continueLocator);

        assertThat(labelaccountCreated.getText(), containsString("CREATED"));
        btnContinue.click();

        DisableAds();
        if(driver.getCurrentUrl().contains("google_vignette"))
            btnContinue.click();


    }

    public void VerifyLoginPage()
    {
        msgLoginPage=driver.findElement(LoginLocator);


        System.out.println(msgLoginPage.getText());
        assertThat(msgLoginPage.getText(), containsString("Login"));
    }








    public static String GenerateRandomEmail(int length) {

        String allowedChars = "abcdefghijklmnopqrstuvwxyz" + "1234567890" + "_-.";

        String temp = RandomStringUtils.random(length, allowedChars);
        email = temp.substring(0, temp.length()) + "@testdata.com";
        System.out.println(email);
//        log.info(email);
        return email;
    }


    public static String GenerateRandomPassword(int length) {
//        System.out.println("Generating a Random PW ");
        String allowedChars = "abcdefghijklmnopqrstuvwxyz" +"ABCDEFGHIJKLMNOPQRSTUVWXYZ"+ "1234567890" + "$";

        String temp = RandomStringUtils.random(length, allowedChars);
        password = temp.substring(0, temp.length());
        System.out.println(password);
//        log.info(password);
        return password;
    }


    public final String GenerateRandomFName()
    {
        String strFname= faker.name().firstName();

        return strFname;

    }

    public final String GenerateRandomLName()
    {
        String strLname= faker.name().lastName();

        return strLname;

    }


    public final String GenerateRandomFullAddress()
    {
        String strAddress= faker.address().fullAddress();

        return strAddress;

    }


    public final String GenerateRandomBuilding()
    {
        String strAddress= faker.address().buildingNumber();

        return strAddress;

    }

    public final String GenerateRandomComponany()
    {
        String strCompany= faker.company().name();

        return strCompany;

    }

    public final String GenerateRandomCountry()
    {
        String strCountry= faker.country().name();

        return strCountry;

    }

    public final String GenerateRandomCapital()
    {
        String strCapital= faker.country().capital();

        return strCapital;

    }


    public final String GenerateRandomCity()
    {
        String strCapital= faker.country().countryCode2();

        return strCapital;

    }
    public final String GenerateRandomZipcode()
    {
        String strZipcode= faker.address().zipCode();

        return strZipcode;

    }

    public final String GenerateRandomPhoneNumber()
    {
        String strPhoneNumber= faker.phoneNumber().phoneNumber();

        return strPhoneNumber;

    }





}
