package com.ti.pompages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class ContactUsPage extends HomePage {



    By ContactUsLocator= By.cssSelector("a[href='/contact_us']");

    WebElement linkContactUs;

    public void FillContactUs()
    {
        linkContactUs=driver.findElement(ContactUsLocator);
        linkContactUs.click();


    }


}
