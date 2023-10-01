package org.ti.utils.ui;

import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.ITestResult;
import org.ti.DriverFactory.DriverFactory;
import org.ti.DriverFactory.FrameworkException;
import org.ti.utils.logs.Log;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;

import java.io.File;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Calendar;
import java.util.GregorianCalendar;

import static org.ti.config.Constants.SCREENSHOT_FOLDER;
import static org.ti.config.CreateFolder.createFolder;

public class SeleniumUtil {

  private static WebDriver driver = DriverFactory.getInstance().getDriver();
  protected static WebElement element;

  public static WebElement findElement(String locator){
    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(0));
    try{
      return driver.findElement(By.id(locator));
    }catch (NoSuchElementException ne){
      return returnElementName(locator);
    }
  }

  private static WebElement returnElementName(String name){
    try{
      return driver.findElement(By.name(name));
    }catch (NoSuchElementException ne){
      return returnElementXpath(name);
    }
  }

  private static WebElement returnElementXpath(String xpath) {
    try{
      return driver.findElement(By.xpath(xpath));
    }catch (NoSuchElementException ne){
      return returnElementCssSelector(xpath);
    }
  }

  private static WebElement returnElementCssSelector(String cssSelector) {
    try{
      return driver.findElement(By.cssSelector(cssSelector));
    }catch (NoSuchElementException ne){
      return returnElementClassName(cssSelector);
    }
  }

  private static WebElement returnElementClassName(String className) {
    try{
      return driver.findElement(By.className(className));
    }catch (NoSuchElementException ne){
      return returnElementLinkText(className);
    }
  }

  private static WebElement returnElementLinkText(String linkText) {
    try{
      return driver.findElement(By.linkText(linkText));
    }catch (NoSuchElementException ne){
      return returnElementTagName(linkText);
    }
  }

  private static WebElement returnElementTagName(String tag) {
    try{
      return driver.findElement(By.tagName(tag));
    }catch (NoSuchElementException ne){
      new FrameworkException("Class SeleniumUtil | Method findElement | Exception desc: Can not find the element: " + tag);
      return null;
    }
  }

  public static WebElement highLight(WebElement element) {
    for (int i = 0; i < 3; i++) {
      //Creating JavaScriptExecuter Interface
      JavascriptExecutor js = (JavascriptExecutor) driver;
      for (int iCnt = 0; iCnt < 3; iCnt++) {
        js.executeScript("arguments[0].setAttribute('style','background: yellow')",
            element);
        try {
          Thread.sleep(20);
        } catch (InterruptedException e) {
          Thread.currentThread().interrupt();
        }
        js.executeScript("arguments[0].setAttribute('style','background:')", element);
      }
    }
    return element;
  }

  public static String getScreenShot(WebElement element,String Browser) {
    String ssDateTime = new SimpleDateFormat("yyMMddHHmmss")
        .format(Calendar.getInstance().getTime());
    String file = null;
    try {
      file = createFolder(SCREENSHOT_FOLDER) + "/"+Browser+ "/"+ ssDateTime + ".png";
    } catch (FrameworkException e) {
      e.printStackTrace();
    }

    try {
      File srcFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
      FileUtils.copyFile(
          (element == null ? srcFile : element.getScreenshotAs(OutputType.FILE)),
          new File(file));
    } catch (Exception e) {
      Log.error(
          "Class SeleniumUtils | Method takeSnapShot | Exception desc: " + e.getMessage());
    }
    return file;
  }

  public static void scrollToElement(WebElement element) throws FrameworkException {
    JavascriptExecutor js = (JavascriptExecutor) driver;
    try{
      js.executeScript("arguments[0].scrollIntoView(true)", element);
    }catch (JavascriptException jse){
      throw new FrameworkException(jse.getMessage());
    }
  }

  public static void refresh(){
    driver.navigate().refresh();
  }


  public static String getBrowser() {
    Log.info("Getting system browser name . . .");
    Capabilities cap = ((RemoteWebDriver) driver).getCapabilities();
    String browserName = cap.getBrowserName().toLowerCase();
    return StringUtils.capitalize(browserName);
  }

  public static String getVersion() {
    Log.info("Getting browser version . . .");
    Capabilities cap = ((RemoteWebDriver) driver).getCapabilities();
    String v = cap.getBrowserVersion().toString();
    Log.info("Browser version: " + v);
    return v;
  }

  public static File invokeScreenshotMethod(ITestResult res, String Status) {

    String imageName = res.getMethod().getMethodName()+"-"+new SimpleDateFormat("MM-dd-yyyy_HH-mm-ss").format(new GregorianCalendar().getTime()) + ".png";


    String file = null;
    File target;

    try {
      file = createFolder(SCREENSHOT_FOLDER) + "/"+getBrowser()+ "/"+Status+"/"+new SimpleDateFormat("MM-dd-yyyy_HH").format(new GregorianCalendar().getTime()) +"/"+res.getMethod().getRealClass().getName().substring(13)+"/"+imageName;
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
}
