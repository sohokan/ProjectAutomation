package com.ti.tests;

import com.ti.pompages.*;

import org.testng.annotations.*;
import org.ti.DriverFactory;
import org.ti.BrowserType;


public class Base {

    protected String baseUrl = "https://automationexercise.com/";


    SignUpPage Login;
    ProductPage Products;

    HomePage Home;
    ContactUsPage ContactUs;

    TestCasePage TestCase;

    String email="d4xk7f.be6@testdata.com";
    String password="FH9tg$NZ";





    @BeforeSuite
    @Parameters("browser")
    public void setup(String browser) {

//        String LogFile=System.getProperty("user.dir")+"\\imgs\\"+;
        DriverFactory.getInstance().setDriver(BrowserType.valueOf(browser));
        DriverFactory.getInstance().getDriver().navigate().to(baseUrl);
//        System.setProperty("log4j2.configuration", "C:\\Users\\scointe\\Documents\\Eclipse\\SeleniumPractice\\properties\\log4j2.xml");


    }

    @BeforeClass
    public void runObjects()
    {
        Login =new SignUpPage();
        Products= new ProductPage();
        Home= new HomePage();
        ContactUs= new ContactUsPage();
        TestCase= new TestCasePage();

    }




//    @AfterSuite
//    void turnDown() {
//
//        DriverFactory.getInstance().removeDriver();
//    }
}

