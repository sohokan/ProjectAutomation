package org.ti.utils.ui;

import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;
import org.testng.annotations.Parameters;
import org.ti.DriverFactory.DriverFactory;
import org.ti.DriverFactory.FrameworkException;
import org.ti.utils.logs.Log;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.*;

import static org.ti.config.Constants.SCREENSHOT_FOLDER;
import static org.ti.config.CreateFolder.createFolder;

public class SeleniumUtil {

  private static WebDriver driver = DriverFactory.getInstance().getDriver();
  protected static WebElement element;

  protected static File srcFile;



  public static void WaitForAdblocker() {

    String browser=((RemoteWebDriver) driver).getCapabilities().getBrowserName().toLowerCase();
    System.out.println("Browser Name is : "+browser);

    if (browser.contains("chrome")) {
      Set<String> AllWindowHandles = driver.getWindowHandles();
//        ArrayList<String> tabs = new ArrayList<String> (driver.getWindowHandles());
//        driver.switchTo().window(tabs.get(1));
      String window1 = (String) AllWindowHandles.toArray()[0];
      String window2 = (String) AllWindowHandles.toArray()[1];

      WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
      wait.until(ExpectedConditions.numberOfWindowsToBe(2));


      driver.switchTo().window(window2);

      WebElement Adblock = driver.findElement(By.xpath("//h2[@class='installed__heading']"));

      wait.until(ExpectedConditions.visibilityOf(Adblock));
      driver.close();

      driver.switchTo().window(window1);
    }


  }

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
          Thread.sleep(50);
        } catch (InterruptedException e) {
          Thread.currentThread().interrupt();
        }
        js.executeScript("arguments[0].setAttribute('style','background:')", element);
      }
    }
    return element;
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
    Log.info("Browser name . . ."+browserName);
    return StringUtils.capitalize(browserName);
  }

  public static String getVersion() {
    Log.info("Getting browser version . . .");
    Capabilities cap = ((RemoteWebDriver) driver).getCapabilities();
    String v = cap.getBrowserVersion();
    Log.info("Browser version: " + v);
    return v;
  }

  public static void invokeScreenshotMethod(ITestResult res, String Status) {

    String imageName = res.getMethod().getMethodName()+"-"+new SimpleDateFormat("MM-dd-yyyy_HH-mm-ss").format(new GregorianCalendar().getTime()) + ".png";


    String file = null;
//    File target;

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



  }

  public String currentTime()
  {
    Date todayDate = new Date();
    SimpleDateFormat formatter = new SimpleDateFormat("ddMMyy_HHmmss");
    String formattDate = formatter.format(todayDate);
    return formattDate;
  }



    public static String convertoBase64Screenshot() throws IOException {

        FileInputStream fileInputStream = null;
        String encodedBase64 = null;
        File target=srcFile.getAbsoluteFile();

        try {
            fileInputStream =new FileInputStream(target);
            byte[] bytes =new byte[(int)target.length()];
            fileInputStream.read(bytes);
//            encodedBase64 = new String(Base64.encodeBase64(bytes));

        }catch (FileNotFoundException e){
            e.printStackTrace();
        }
        return "data:image/png;base64,"+encodedBase64;

    }
}
