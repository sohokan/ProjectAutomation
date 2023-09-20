package com.ti.tests;

import com.ti.pompages.*;

import com.ti.restapi.HttpsMethod;
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

    ProductDetailPage ProductDetail;
    CartPage Carts;

    CheckOutPage CheckOutPage;

    PaymentPage Payment;

    PaymentDonePage PaymentDone;

    HttpsMethod AutomationApi;

    ProductCategoryPage ProductCategory;

    ProductBrandPage ProductBrand;

    public static String inputemail="0n3xmd1wu-@testdata.com";
    String password="krT41EiW";


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
        ProductDetail=new ProductDetailPage();
        Carts=new CartPage();
        CheckOutPage=new CheckOutPage();
        Payment= new PaymentPage();
        PaymentDone=new PaymentDonePage();
        AutomationApi=new HttpsMethod();
        ProductCategory=new ProductCategoryPage();
        ProductBrand= new ProductBrandPage();
        Home.WaitForAdblocker();


    }




//    @AfterSuite
//    void turnDown() {
//
//        DriverFactory.getInstance().removeDriver();
//    }
}

