package org.ti.utils.listeners;

import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import  org.ti.DriverFactory.DriverFactory;
import org.ti.utils.extentreports.ExtentTest;


import java.util.Objects;

import static org.ti.utils.extentreports.ExtentTestManager.*;


public class TestListener extends DriverFactory implements ITestListener {
    private static final Logger logger = LogManager.getLogger(TestListener.class.getName());





    @Override
    public void onStart(ITestContext context) {

//        context.setAttribute("myDriver",getInstance().getDriver());

        logger.log(Level.INFO, "Starting test method {}", context.getName());




    }

    @Override
    public void onFinish(ITestContext context) {
        logger.log(Level.INFO, "Finishing test method {}", context.getName());
        logger.info("XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX    -E--N--D      XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX");
        ExtentTest.extentReports.flush();

    }

    @Override
    public void onTestStart(ITestResult result) {


        startTest(result);

        logger.info("**************************************************************************************************************");
        logger.log(Level.INFO, "{} test starting!!! ", result.getMethod().getConstructorOrMethod().getName());
        logger.info("**************************************************************************************************************");
    }

    @Override
    public void onTestSuccess(ITestResult result) {




        logger.log(Level.INFO, "{} test execution success", result.getMethod().getConstructorOrMethod().getName());

//        File screenShot = ((TakesScreenshot)result
//                .getTestContext()
//                .getAttribute("myDriver")).getScreenshotAs(OutputType.FILE);
        String base64Screenshot =
                "data:image/png;base64," + ((TakesScreenshot)  getInstance().getDriver()).getScreenshotAs(OutputType.BASE64);
//        getTest().log(Status.PASS, "Test passed",
//                getTest().addScreenCaptureFromBase64String(base64Screenshot).getModel().getMedia().get(0));
            getTest().log(Status.PASS , MediaEntityBuilder.createScreenCaptureFromBase64String(base64Screenshot).build());

    }

    @Override
    public void onTestFailure(ITestResult result) {
//        WebDriver driver = null;
//
//        try {
//            driver = (WebDriver) result.getTestClass().getRealClass().getDeclaredField("driver").get(result.getInstance());
//        } catch (IllegalArgumentException | IllegalAccessException | NoSuchFieldException | SecurityException e) {
//            e.printStackTrace();
//        }


        logger.log(Level.ERROR, "{} test execution failed", result.getMethod().getConstructorOrMethod().getName());
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
        logger.log(Level.WARN, "{} test execution skipped", result.getMethod().getConstructorOrMethod().getName());

        String base64Screenshot =
                "data:image/png;base64," + ((TakesScreenshot) Objects.requireNonNull(getInstance().getDriver())).getScreenshotAs(OutputType.BASE64);


        getTest().log(Status.SKIP , MediaEntityBuilder.createScreenCaptureFromBase64String(base64Screenshot).build());
        extentTest.skip(result.getThrowable());    }
}
