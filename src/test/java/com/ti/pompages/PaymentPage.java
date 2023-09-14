package com.ti.pompages;

import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import static com.ti.pompages.SignUpPage.faker;
import static com.ti.pompages.SignUpPage.users;

public class PaymentPage extends HomePage{

    By cardNameLocator=By.cssSelector("input[name='name_on_card']");

    By cardNumberLocator=By.cssSelector("input[name='card_number']");

    By cvcLocator=By.cssSelector("input[name$='cvc']");

    By expiredMonthLocator=By.cssSelector("input[name*='month']");

    By expiredYearLocator=By.cssSelector("input[name*='year']");

    By payConfirmLocator=By.id("submit");

    WebElement inputCardName;

    WebElement inputCardNumber;

    WebElement inputCVC;

    WebElement inputExpiredMonth;

    WebElement inputExpiredYear;

    WebElement btnPay;

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
        btnPay.click();

    }

}
