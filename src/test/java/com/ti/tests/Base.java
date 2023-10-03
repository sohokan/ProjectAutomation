package com.ti.tests;


import com.ti.pompages.*;
import com.ti.restapi.HttpsMethod;
import org.testng.annotations.*;
import org.ti.DriverFactory.DriverFactory;
import org.ti.DriverFactory.BrowserType;
import java.io.IOException;
import java.util.concurrent.TimeUnit;




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


    public static String inputemail = "1k51iov-n.@testdata.com";
    String password = "piNhcMbG";


    @BeforeTest


    @Parameters("browser")
    public void setup(String browser) throws IOException {

        DriverFactory.getInstance().setDriver(BrowserType.valueOf(browser));
        DriverFactory.getInstance().getDriver().navigate().to(baseUrl);
        DriverFactory.getInstance().getDriver().manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);


    }


    @BeforeClass
    void CreateObjects() {

        Login = new SignUpPage();
        Products = new ProductPage();
        Home = new HomePage();
        ContactUs = new ContactUsPage();
        TestCase = new TestCasePage();
        ProductDetail = new ProductDetailPage();
        Carts = new CartPage();
        CheckOutPage = new CheckOutPage();
        Payment = new PaymentPage();
        PaymentDone = new PaymentDonePage();
        AutomationApi = new HttpsMethod();
        ProductCategory = new ProductCategoryPage();
        ProductBrand = new ProductBrandPage();

    }


    @AfterTest
    void CloseBrowser() {

        DriverFactory.getInstance().getDriver().quit();
    }
}




