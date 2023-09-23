package org.ti.utils.listeners;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class TestListener implements ITestListener {
    private static final Logger logger = LogManager.getLogger(TestListener.class.getName());

    @Override
    public void onStart(ITestContext context) {
        logger.log(Level.INFO, "Starting test method {}", context.getName());
    }

    @Override
    public void onFinish(ITestContext context) {
        logger.log(Level.INFO, "Finishing test method {}", context.getName());
        logger.info("XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX    -E--N--D      XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX");
    }

    @Override
    public void onTestStart(ITestResult result) {
        logger.info("**************************************************************************************************************");
        logger.log(Level.INFO, "{} test starting!!! ", result.getMethod().getConstructorOrMethod().getName());
        logger.info("**************************************************************************************************************");
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        logger.log(Level.INFO, "{} test execution success", result.getMethod().getConstructorOrMethod().getName());
    }

    @Override
    public void onTestFailure(ITestResult result) {
        logger.log(Level.ERROR, "{} test execution failed", result.getMethod().getConstructorOrMethod().getName());
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        logger.log(Level.WARN, "{} test execution skipped", result.getMethod().getConstructorOrMethod().getName());
    }
}
