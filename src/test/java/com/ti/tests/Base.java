package com.ti.tests;

import com.ti.pompages.HomePage;
import com.ti.pompages.SignUpPage;
import com.ti.pompages.ProductPage;

import org.testng.annotations.*;
import org.ti.DriverFactory;
import org.ti.BrowserType;


public class Base {

    protected String baseUrl = "https://automationexercise.com/";


    SignUpPage Login;
    ProductPage Products;

    HomePage Home;





    @BeforeSuite
    @Parameters("browser")
    public void setup(String browser) {
        DriverFactory.getInstance().setDriver(BrowserType.valueOf(browser));
        DriverFactory.getInstance().getDriver().navigate().to(baseUrl);


    }

    @BeforeClass
    public void runObjects()
    {
        Login =new SignUpPage();
        Products= new ProductPage();
        Home= new HomePage();

    }


//    @AfterSuite
//    void turnDown() {
//
//        DriverFactory.getInstance().removeDriver();
//    }
}

