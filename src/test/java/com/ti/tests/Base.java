package com.ti.tests;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.ti.pompages.*;
import com.google.common.base.Throwables;
import com.ti.restapi.HttpsMethod;
import org.apache.commons.codec.binary.Base64;
import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
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
import org.ti.DriverFactory.FrameworkException;
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
    public void getResult(ITestResult result) throws IOException {

        String TestStatus= null;
        Path path;
        Path absolutePath;
        String feature = result.getMethod().getRealClass().getName() + ":" + result.getMethod().getMethodName();
         extentTest = extentReports.createTest(feature.substring(13), result.getMethod().getDescription()+ " on "+ getBrowser() +" v."+  getVersion());

        if(result.getStatus() == ITestResult.FAILURE)
        {
            System.out.println(driver.getCurrentUrl());
            TestStatus="Fail";


//            extentTest.fail(String.valueOf(Status.FAIL));
            extentTest.log(Status.FAIL, MarkupHelper.createLabel("FAILED", ExtentColor.RED));
//            extentTest.log(Status.FAIL, MarkupHelper.createLabel(" Result: " + result.getMethod().getRealClass().getName(), ExtentColor.RED));
//            extentTest.log(Status.FAIL, "StackTrace Result: " + Thread.currentThread().getStackTrace());
//            extentTest.fail(String.valueOf(Status.FAIL)).addScreenCaptureFromPath(invokeScreenshotMethod( result,TestStatus));


            extentTest.fail(result.getThrowable());

        }
        else if(result.getStatus() == ITestResult.SUCCESS)
        {
            TestStatus="Pass";

            System.out.println("path "+invokeScreenshotMethod( result,TestStatus));

//            extentTest.pass(String.valueOf(Status.PASS));
            extentTest.log(Status.PASS, MarkupHelper.createLabel("PASS", ExtentColor.GREEN));
//            extentTest.pass(String.valueOf(Status.PASS)).addScreenCaptureFromPath(invokeScreenshotMethod( result,TestStatus));
//            extentTest.pass(result.getMethod().getDescription(),MediaEntityBuilder.createScreenCaptureFromPath(invokeScreenshotMethod( result,TestStatus)).build());

            extentTest.addScreenCaptureFromBase64String(getBase64Screenshot(result,TestStatus));
        }
        else
        {
            TestStatus="Skip";


            extentTest.log(Status.SKIP, MarkupHelper.createLabel(" Result: " + result.getMethod().getRealClass().getName(), ExtentColor.ORANGE));
//            extentTest.skip(String.valueOf(Status.SKIP)).addScreenCaptureFromPath(invokeScreenshotMethod( result,TestStatus));

//            extentTest.log(Status.SKIP, MarkupHelper.createLabel("SKIPPED", ExtentColor.ORANGE));
            extentTest.skip(result.getThrowable());
//            extentTest.skip(String.valueOf(Status.SKIP));

        }

    }


    public static File invokeScreenshotMethod(ITestResult res, String Status) {

        String imageName = res.getMethod().getMethodName()+"-"+new SimpleDateFormat("MM-dd-yyyy_HH-ss").format(new GregorianCalendar().getTime()) + ".png";
//        String imageName = res.getMethod().getMethodName()+".png";

        String file = null;
        File target;
        try {
            file = createFolder(SCREENSHOT_FOLDER) + "/"+getBrowser()+ "/"+Status+"/"+res.getMethod().getRealClass().getName().substring(13)+"/"+imageName;
        } catch (FrameworkException e) {
            e.printStackTrace();
        }



            try {
                File srcFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
//

                FileUtils.copyFile(srcFile, new File(file));
            } catch (Exception e) {
                Log.error(
                        "Class SeleniumUtils | Method takeSnapShot | Exception desc: " + e.getMessage());
            }

        target= new File(file);


        return target;

        }


    public static String getBase64Screenshot(ITestResult res, String Status) throws IOException {

        FileInputStream fileInputStream = null;
        String encodedBase64 = null;
        File target=invokeScreenshotMethod( res,Status).getAbsoluteFile();

        try {
            fileInputStream =new FileInputStream(target);
            byte[] bytes =new byte[(int)target.length()];
            fileInputStream.read(bytes);
            encodedBase64 = new String(Base64.encodeBase64(bytes));

        }catch (FileNotFoundException e){
            e.printStackTrace();
        }
        return "data:image/png;base64,"+encodedBase64;

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
        extentReports.setSystemInfo(getBrowser(), getVersion());
        extentReports.flush();
    }
}


