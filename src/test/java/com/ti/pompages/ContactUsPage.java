package com.ti.pompages;

import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebElement;

import com.ti.pompages.SignUpPage;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;

public class ContactUsPage extends HomePage {



    By ContactUsLocator= By.cssSelector("a[href='/contact_us']");

    By GetInTouchLocator=By.xpath("//h2[contains(normalize-space(),' Touch')]");

    By NameLocator= By.cssSelector("input[placeholder='Name']");
    By EmailLocator= By.cssSelector("input[placeholder='Email']");

    By SubjectLocator=By.cssSelector("input[placeholder='Subject']");

    By MessageLocator=By.id("message");

    By uploadfileLocator=By.cssSelector("input[name='upload_file']");

    By submitlocator=By.cssSelector("input[value='Submit']");

    By sucessMessagelocator =By.xpath("//div[contains(@class,'status alert alert-success')]");

    By btnHomeLocator=By.xpath("//a[contains(@class,'success')]");


    WebElement linkContactUs;

    WebElement GetInTouch;

    WebElement inputName;

    WebElement inputEmail;

    WebElement inputSubject;

    WebElement inputMessage;

    WebElement uploadFile;

    WebElement btnSubmit;

    WebElement sucessMessage;

    WebElement btnHome;
    public void FillContactUs()
    {
        String File ="Testing-3-2.jpg";

        String filetoUpload=System.getProperty("user.dir")+"\\imgs\\"+File;
        linkContactUs=driver.findElement(ContactUsLocator);
        linkContactUs.click();

        GetInTouch= driver.findElement(GetInTouchLocator);

        System.out.println(GetInTouch.getText());

        assertThat(GetInTouch.getText(),containsString("TOUCH"));

        inputName=driver.findElement(NameLocator);
        inputEmail=driver.findElement(EmailLocator);
        inputSubject=driver.findElement(SubjectLocator);
        inputMessage=driver.findElement(MessageLocator);
        inputName.sendKeys(random);
        inputEmail.sendKeys(SignUpPage.generateRandomEmail(10));
        inputSubject.sendKeys(random);
        inputMessage.sendKeys(random);
        uploadFile=driver.findElement(uploadfileLocator);
        uploadFile.sendKeys(filetoUpload);
        btnSubmit=driver.findElement(submitlocator);
        btnSubmit.click();
        System.out.println("Theres alert "+isAlertPresent());
        sucessMessage= driver.findElement(sucessMessagelocator);

        System.out.println(sucessMessage.getText());
        assertThat(sucessMessage.getText(),containsString("Success"));

        btnHome=driver.findElement(btnHomeLocator);
        btnHome.click();
        try {

            disableAds();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }


    public boolean isAlertPresent()
    {
        try
        {
            driver.switchTo().alert().accept();
            return true;
        }   // try
        catch (NoAlertPresentException Ex)
        {
            return false;
        }   // catch
    }

}
