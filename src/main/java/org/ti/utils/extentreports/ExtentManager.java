package org.ti.utils.extentreports;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import java.io.File;
import java.io.IOException;

public class ExtentManager {
    public static final ExtentReports extentReports = new ExtentReports();

    public static ExtentSparkReporter extentSparkReporter;

    public synchronized static ExtentReports createExtentReports() throws IOException {
        ExtentSparkReporter reporter = new ExtentSparkReporter("./results/extent-report.html");
        reporter.config().setReportName("Test Execution Report");
        extentReports.attachReporter(reporter);
        extentSparkReporter = new ExtentSparkReporter("results/TUReport.html");
        extentSparkReporter.loadJSONConfig(new File("./src/main/resources/extent-reports-config.json"));

//        extentReports.setSystemInfo("Plataforma", "Automation Exercise");
//        extentReports.setSystemInfo("Author", "Miguel Soto");

        return extentReports;
    }
}
