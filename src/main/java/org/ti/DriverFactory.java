package org.ti;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

public class DriverFactory {
    private static DriverFactory instance = new DriverFactory();

    public static DriverFactory getInstance() {
        return instance;
    }

    ThreadLocal<WebDriver> driver = new ThreadLocal<>();

    public WebDriver getDriver() {
        return driver.get();
    }

    public void setDriver(BrowserType browserType) {


        String ExtensionFile=System.getProperty("user.dir")+"\\Extensions\\"+"Adblock.crx";

        String downloadPath=System.getProperty("user.dir")+"\\Downloads";

//        ChromeOptions options = new ChromeOptions();
//        options.addArguments("--headless");
//        ChromeOptions options = new ChromeOptions();
//

        ChromeOptions options=new ChromeOptions() ;
        options.addExtensions(new File(ExtensionFile) );
        options.addArguments("start-maximized");
        options.addArguments("disable-notifications");


        Map<String, Object> prefs = new HashMap<String, Object>();
        prefs.put("credentials_enable_service", false);
        prefs.put("profile.password_manager_enabled", false);
        prefs.put("download.prompt_for_download", false);
        prefs.put("disable-popup-blocking", true);
        prefs.put("autofill.profile_enabled", false);
        prefs.put("download.default_directory", downloadPath);
        options.setExperimentalOption("prefs", prefs);


        switch (browserType) {

            case CHROME -> driver.set(new ChromeDriver(options));
//            case CHROME -> driver.set(new ChromeDriver());
            case EDGE -> driver.set(new EdgeDriver());
            case FIREFOX -> driver.set(new FirefoxDriver());
        }
        driver.get().manage().window().maximize();

    }

    public void removeDriver() {
        if (driver.get() != null) {
            try {
                driver.get().quit();
                driver.remove();
            } catch (Exception e) {
                System.err.println("Unable to remove WebDrvier | Exception: " + e.getMessage());
            }
        }
    }
}
