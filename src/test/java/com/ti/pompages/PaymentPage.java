package com.ti.pompages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

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

}
