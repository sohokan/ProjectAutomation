package com.ti.pompages;

import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Calendar;
import java.util.Date;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

import static com.ti.pompages.SignUpPage.faker;
import static com.ti.pompages.SignUpPage.users;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;

public class PaymentPage extends HomePage{

    By cardNameLocator=By.cssSelector("input[name='name_on_card']");

    By cardNumberLocator=By.cssSelector("input[name='card_number']");

    By cvcLocator=By.cssSelector("input[name$='cvc']");

    By expiredMonthLocator=By.cssSelector("input[name*='month']");

    By expiredYearLocator=By.cssSelector("input[name*='year']");

    By payConfirmLocator=By.id("submit");

    By sucessMsgLocator=By.cssSelector("div[id='success_message'] div[class='alert-success alert']");

    WebElement inputCardName;

    WebElement inputCardNumber;

    WebElement inputCVC;

    WebElement inputExpiredMonth;

    WebElement inputExpiredYear;

    WebElement btnPay;

    WebElement msgSuccess;
     Faker card = new Faker();

    public void PlacePayment()
    {


        inputCardName=driver.findElement(cardNameLocator);

        inputCardNumber=driver.findElement(cardNumberLocator);

        inputCVC=driver.findElement(cvcLocator);
        inputExpiredMonth=driver.findElement(expiredMonthLocator);

        inputExpiredYear=driver.findElement(expiredYearLocator);

        btnPay=driver.findElement(payConfirmLocator);


        inputCardName.sendKeys(users.get(0).strUserFirstName+" "+users.get(0).strUserLastName);

        inputCardNumber.sendKeys(card.number().digits(16));

        inputCVC.sendKeys(card.number().digits(3));

        inputExpiredMonth.sendKeys(String.valueOf(card.number().numberBetween(1, 12)));

        inputExpiredYear.sendKeys(String.valueOf(card.number().numberBetween(2024, 2026)));




    }

    public void SuccessMsg() throws InterruptedException {

        WebElement elem = driver.findElement(sucessMsgLocator);
        String hiddenText = (String)((JavascriptExecutor)driver).executeScript(
                "return arguments[0].textContent;", elem);

//        JavascriptExecutor js = (JavascriptExecutor)driver;
//        js.executeScript("arguments[0].click();", element);


//        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));



//        getStaleElement(sucessMsgLocator);
//        wait.until(ExpectedConditions.stalenessOf(driver.findElement(sucessMsgLocator)));


        btnPay.click();
        assertThat(hiddenText, containsString("successfully"));







//        Thread.sleep(3000);


//        Thread.sleep(1000);


//        new WebDriverWait(driver, Duration.ofSeconds(10))
//                .until(ExpectedConditions.visibilityOfAllElements(driver.findElement(By.xpath("//div[@class='alert-success alert']"))));
//              Thread.sleep(1000);




    }

    WebElement getStaleElement(By by) {
        try {

            return driver.findElement(by);
        } catch (StaleElementReferenceException | NoSuchElementException e) {
            System.out.println("Attempting to recover from " + e.getClass().getSimpleName() + "...");
            return getStaleElement(by);
        }
    }
}
