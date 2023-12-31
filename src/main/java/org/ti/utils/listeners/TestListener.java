package org.ti.utils.listeners;

import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.events.WebDriverListener;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import  org.ti.DriverFactory.DriverFactory;
import org.ti.utils.extentreports.ExtentTest;
import org.openqa.selenium.support.events.EventFiringDecorator;


import java.util.Objects;

import static org.ti.utils.extentreports.ExtentTestManager.*;
import static org.ti.utils.ui.SeleniumUtil.getBrowser;
import static org.ti.utils.ui.SeleniumUtil.getVersion;
import org.ti.utils.logs.Log;

public class TestListener extends DriverFactory implements ITestListener {

    WebDriver decorated;

   public static ITestResult execution;

public static String ExecutionStatus;

    @Override
    public void onStart(ITestContext context) {



//        context.setAttribute("myDriver",getInstance().getDriver());

        Log.info( "Starting test method {}"+ context.getName());




    }

    @Override
    public void onFinish(ITestContext context) {
        Log.info( "Finishing test method {}"+context.getName());
        Log.info("XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX    -E--N--D      XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX");

        ExtentTest.extentReports.setSystemInfo(getBrowser(), getVersion());
        ExtentTest.extentReports.flush();

    }

    @Override
    public void onTestStart(ITestResult result) {

        execution=result;
        startTest(result);

//        WebDriverEventListener  driverEventListener = new WebDriverEventListener ();


//        EventFiringDecorator<WebDriver> decorator = new EventFiringDecorator<>( driverEventListener);

//         decorated = new EventFiringDecorator<>( driverEventListener).decorate(getInstance().getDriver());



        Log.info("**************************************************************************************************************");
        Log.info(" Test starting!!! "+ result.getMethod().getConstructorOrMethod().getName());
        Log.info("**************************************************************************************************************");
    }

    @Override
    public void onTestSuccess(ITestResult result) {

        ExecutionStatus="Pass";

        Log.info("test execution success"+ result.getMethod().getConstructorOrMethod().getName());

        String base64Screenshot =
                "data:image/png;base64," + ((TakesScreenshot) getInstance().getDriver()).getScreenshotAs(OutputType.BASE64);
//        getTest().log(Status.PASS, "Test passed",
//                getTest().addScreenCaptureFromBase64String(base64Screenshot).getModel().getMedia().get(0));
            getTest().log(Status.PASS  ,MediaEntityBuilder.createScreenCaptureFromBase64String(base64Screenshot).build());


    }


    @Override
    public void onTestFailure(ITestResult result) {

        ExecutionStatus="Fail";
        Log.error("test execution failed "+ result.getMethod().getConstructorOrMethod().getName());
//        String base64Screenshot =
//                "data:image/png;base64," + ((TakesScreenshot) Objects.requireNonNull(driver)).getScreenshotAs(OutputType.BASE64);
        String base64Screenshot =
                "data:image/png;base64," + ((TakesScreenshot)  getInstance().getDriver()).getScreenshotAs(OutputType.BASE64);
//        getTest().log(Status.FAIL, "Test failed",
//                getTest().addScreenCaptureFromBase64String(base64Screenshot).getModel().getMedia().get(0));
        getTest().log(Status.FAIL , MediaEntityBuilder.createScreenCaptureFromBase64String(base64Screenshot).build());
        extentTest.fail(result.getThrowable());

    }

    @Override
    public void onTestSkipped(ITestResult result) {

        ExecutionStatus="Skip";
        Log.warn("Test execution skipped "+ result.getMethod().getConstructorOrMethod().getName());

        String base64Screenshot =
                "data:image/png;base64," + ((TakesScreenshot) Objects.requireNonNull(getInstance().getDriver())).getScreenshotAs(OutputType.BASE64);


        getTest().log(Status.SKIP , MediaEntityBuilder.createScreenCaptureFromBase64String(base64Screenshot).build());
        extentTest.skip(result.getThrowable());    }
}
