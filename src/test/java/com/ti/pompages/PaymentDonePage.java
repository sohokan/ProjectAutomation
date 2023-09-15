package com.ti.pompages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class PaymentDonePage extends HomePage{
    By msgCongratsLocator= By.xpath("//p[contains(.,'Congratulations')]");

    By btnContinueLocator= By.xpath("//a[contains(.,'Continue')]");

    By btnDownLoadLocator=By.xpath("//a[contains(.,'Download')]");

    WebElement msgCongrats;

    WebElement btnContinue;

    WebElement btnDownLoad;

    public void ContinuetoHome()

    {
        btnContinue=driver.findElement(btnContinueLocator);
        btnContinue.click();

    }
}
