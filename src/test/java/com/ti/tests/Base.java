package com.ti.tests;

import com.aventstack.extentreports.*;
import com.google.inject.Inject;
import com.google.inject.Provides;
import com.ti.pompages.*;
import com.google.common.base.Throwables;
import com.ti.restapi.HttpsMethod;
import org.apache.commons.codec.binary.Base64;
import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.*;
import org.ti.DriverFactory.DriverFactory;
import org.ti.DriverFactory.BrowserType;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;


import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import org.ti.DriverFactory.FrameworkException;
import org.ti.utils.extentreports.ExtentTestManager;
import org.ti.utils.logs.Log;


import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.concurrent.TimeUnit;

import static com.ti.pompages.HomePage.*;
import static org.ti.config.Constants.SCREENSHOT_FOLDER;
import static org.ti.config.CreateFolder.createFolder;
import static org.ti.utils.extentreports.ExtentTestManager.*;

import static org.ti.utils.ui.SeleniumUtil.highLight;


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

    public static WebDriver driverSelenium()

    {

       return  driver;
    }


@BeforeSuite
public void StartReport() throws IOException {



//    extentReports = new ExtentReports();
//    extentSparkReporter = new ExtentSparkReporter("results/ExecutionReport.html");
//    extentSparkReporter.loadJSONConfig(new File("./src/main/resources/extent-reports-config.json"));
//    extentReports.attachReporter(extentSparkReporter);
}


    @BeforeTest



    @Parameters("browser")
    public void setup(String browser) throws IOException {

//        String LogFile=System.getProperty("user.dir")+"\\imgs\\"+;
        DriverFactory.getInstance().setDriver(BrowserType.valueOf(browser));
        DriverFactory.getInstance().getDriver().navigate().to(baseUrl);
        DriverFactory.getInstance().getDriver().manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
//        driverSelenium=  DriverFactory.getInstance().getDriver();


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
        driverSelenium();
    }

     @AfterMethod
      public void getResult(ITestResult result) throws IOException {
//         ExtentTestManager.startTest( result);

     }







//    public static String getBase64Screenshot(ITestResult res, String Status) throws IOException {
//
//        FileInputStream fileInputStream = null;
//        String encodedBase64 = null;
//        File target=invokeScreenshotMethod( res,Status).getAbsoluteFile();
//
//        try {
//            fileInputStream =new FileInputStream(target);
//            byte[] bytes =new byte[(int)target.length()];
//            fileInputStream.read(bytes);
//            encodedBase64 = new String(Base64.encodeBase64(bytes));
//
//        }catch (FileNotFoundException e){
//            e.printStackTrace();
//        }
//        return "data:image/png;base64,"+encodedBase64;
//
//    }





    @AfterTest
    void CloseBrowser()

    {
//        extentReports.flush();
        DriverFactory.getInstance().getDriver().quit();
    }

//    @AfterSuite
//
//    void CloseReport()
//    {
//        extentReports.setSystemInfo(getBrowser(), getVersion());
//
//        extentReports.flush();
//    }
}


