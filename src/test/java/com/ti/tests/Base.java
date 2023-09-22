package com.ti.tests;

import com.ti.pompages.*;

import com.ti.restapi.HttpsMethod;
import org.testng.annotations.*;
import org.ti.DriverFactory.DriverFactory;
import org.ti.DriverFactory.BrowserType;


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

    public static String inputemail="535zbp1apt@testdata.com";
    String password="FG3v9yU7";




    @BeforeClass



    @Parameters("browser")
    public void setup(String browser) {

//        String LogFile=System.getProperty("user.dir")+"\\imgs\\"+;
        DriverFactory.getInstance().setDriver(BrowserType.valueOf(browser));
        DriverFactory.getInstance().getDriver().navigate().to(baseUrl);
//        System.setProperty("log4j2.configuration", "C:\\Users\\scointe\\Documents\\Eclipse\\SeleniumPractice\\properties\\log4j2.xml");
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


    }

//    @BeforeClass
//    public void runObjects()
//    {
//
//
//        Login =new SignUpPage();
//        Products= new ProductPage();
//        Home= new HomePage();
//        ContactUs= new ContactUsPage();
//        TestCase= new TestCasePage();
//        ProductDetail=new ProductDetailPage();
//        Carts=new CartPage();
//        CheckOutPage=new CheckOutPage();
//        Payment= new PaymentPage();
//        PaymentDone=new PaymentDonePage();
//        AutomationApi=new HttpsMethod();
//        ProductCategory=new ProductCategoryPage();
//        ProductBrand= new ProductBrandPage();
//
//    }









    @AfterClass
    void CloseBrowser()

    {

        DriverFactory.getInstance().removeDriver();
    }
}


