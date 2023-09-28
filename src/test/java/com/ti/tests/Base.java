package com.ti.tests;

import com.aventstack.extentreports.ExtentReports;
import com.ti.pompages.*;
import com.google.common.base.Throwables;
import com.ti.restapi.HttpsMethod;
import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.*;
import org.ti.DriverFactory.DriverFactory;
import org.ti.DriverFactory.BrowserType;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;


import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import org.ti.utils.logs.Log;


import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import static com.ti.pompages.HomePage.getBrowser;
import static com.ti.pompages.HomePage.getVersion;
import static java.sql.DriverManager.getDriver;


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



    public static String inputemail="1k51iov-n.@testdata.com";
    String password="piNhcMbG";



    public static ExtentSparkReporter extentSparkReporter;
    public static ExtentReports extentReports;
    public static ExtentTest extentTest;


@BeforeSuite
public void StartReport() throws IOException {

    extentReports = new ExtentReports();
    extentSparkReporter = new ExtentSparkReporter("results/ExecutionReport.html");
    extentSparkReporter.loadJSONConfig(new File("./src/main/resources/extent-reports-config.json"));
    extentReports.attachReporter(extentSparkReporter);
}


    @BeforeTest



    @Parameters("browser")
    public void setup(String browser) throws IOException {

//        String LogFile=System.getProperty("user.dir")+"\\imgs\\"+;
        DriverFactory.getInstance().setDriver(BrowserType.valueOf(browser));
        DriverFactory.getInstance().getDriver().navigate().to(baseUrl);
        DriverFactory.getInstance().getDriver().manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);



    }


@BeforeClass
void CreateObjects()
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

    }


    @AfterMethod
    public void getResult(ITestResult result)
    {
        String feature = result.getMethod().getRealClass().getName() + ":" + result.getMethod().getMethodName();
         extentTest = extentReports.createTest(feature.substring(13), result.getMethod().getDescription()+ " "+ getBrowser() +" "+  getVersion());

        extentReports.setSystemInfo(getBrowser(), getVersion());
//        extentTest = extentReports.createTest(result.getTestClass().toString());
        if(result.getStatus() == ITestResult.FAILURE)
        {
//            extentTest.fail(String.valueOf(Status.FAIL));
//            extentTest.log(Status.FAIL, MarkupHelper.createLabel("FAILED", ExtentColor.RED));
            extentTest.log(Status.FAIL, MarkupHelper.createLabel(" Result: " + result.getMethod().getRealClass().getName(), ExtentColor.RED));
//            extentTest.log(Status.FAIL, "StackTrace Result: " + Thread.currentThread().getStackTrace());
            extentTest.fail(result.getThrowable());

        }
        else if(result.getStatus() == ITestResult.SUCCESS)
        {

//            extentTest.pass(String.valueOf(Status.PASS));
            extentTest.log(Status.PASS, MarkupHelper.createLabel("PASS", ExtentColor.GREEN));

        }
        else
        {
            extentTest.log(Status.SKIP, MarkupHelper.createLabel(" Result: " + result.getMethod().getRealClass().getName(), ExtentColor.ORANGE));

//            extentTest.log(Status.SKIP, MarkupHelper.createLabel("SKIPPED", ExtentColor.ORANGE));
            extentTest.skip(result.getThrowable());
//            extentTest.skip(String.valueOf(Status.SKIP));
        }

    }




    @AfterTest
    void CloseBrowser()

    {
//        extentReports.flush();
        DriverFactory.getInstance().getDriver().quit();
    }

    @AfterSuite

    void CloseReport()
    {

        extentReports.flush();
    }
}


