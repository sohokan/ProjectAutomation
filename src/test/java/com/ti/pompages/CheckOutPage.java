package com.ti.pompages;

import com.ti.tests.Base;
import org.apache.commons.collections4.CollectionUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import static com.ti.pompages.SignUpPage.users;
import static org.testng.AssertJUnit.assertTrue;

public class CheckOutPage extends HomePage {
    //YOUR DELIVERY ADDRESS
    By  addressDeliveryLocator= By.xpath("//ul[@id='address_delivery']");

    By addressInvoiceLocator=By.xpath("//ul[@id='address_invoice']");

    By commentLocator=By.cssSelector("textarea[name='message']");

    By placeOrderLocator=By.cssSelector(".btn.btn-default.check_out");

    WebElement addressDelivery;

    WebElement addressInvoice;

    List<WebElement> listAddressDelivery;

    WebElement verifyCorrectFirstName;

    WebElement verifyCorrectLastName;
    WebElement verifyWebelementCompany;
    WebElement verifyWebelementAddress1;
    WebElement verifyWebelementAddress2;
    WebElement verifyWebelementCity;

    WebElement verifyWebelementState;

    WebElement verifyWebelementZipecode;

    WebElement verifyWebelementCountry;

    WebElement verifyWebelementPhoneNumber;

    WebElement textBoxComment;

    WebElement btnPlaceOrder;

    public void VerifyCheckoutAddress()
    {


        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.visibilityOfAllElements(driver.findElement(By.xpath("//h2[contains(.,'Address Details')]"))));

        System.out.println(driver.findElement(By.xpath("//h2[contains(.,'Address Details')]")).getText());

        addressDelivery=driver.findElement(addressDeliveryLocator);

        addressInvoice=driver.findElement(addressInvoiceLocator);

//        System.out.println("all the users list");
//
//        users.forEach(user -> {
//
//            System.out.println(user.getStrUserFirstName()+" " +user.getStrUserLastName());
//        });

        CheckAddress(addressDelivery);



        CheckAddress(addressInvoice);

    }


    public void  CheckAddress(WebElement element)


    {
        listAddressDelivery =element.findElements(By.tagName("li"));

        System.out.println("size"+listAddressDelivery.size());

        if (users.size()>0) // only can be user was register in the execution you can cross check the registration screen
        {

         verifyCorrectFirstName = listAddressDelivery.stream().filter((e) -> e.getText().contains(users.get(0).strUserFirstName)).findFirst().orElse(null);
        assertTrue(verifyCorrectFirstName.isDisplayed());

         verifyCorrectLastName = listAddressDelivery.stream().filter((e) -> e.getText().contains(users.get(0).strUserLastName)).findFirst().orElse(null);
        assertTrue(verifyCorrectLastName.isDisplayed());

        verifyWebelementCompany = listAddressDelivery.stream().filter((e) -> e.getText().contains(users.get(0).strCompany)).findFirst().orElse(null);
        assertTrue(verifyWebelementCompany.isDisplayed());


        verifyWebelementAddress1 = listAddressDelivery.stream().filter((e) -> e.getText().contains(users.get(0).strAddress1)).findFirst().orElse(null);
        assertTrue(verifyWebelementAddress1.isDisplayed());


        verifyWebelementAddress2 = listAddressDelivery.stream().filter((e) -> e.getText().contains(users.get(0).strAddress2)).findFirst().orElse(null);
        assertTrue(verifyWebelementAddress2.isDisplayed());

        verifyWebelementState = listAddressDelivery.stream().filter((e) -> e.getText().contains(users.get(0).strState)).findFirst().orElse(null);
        assertTrue(verifyWebelementState.isDisplayed());


        verifyWebelementCountry = listAddressDelivery.stream().filter((e) -> e.getText().contains(users.get(0).strCountry)).findFirst().orElse(null);
        assertTrue(verifyWebelementCountry.isDisplayed());

        verifyWebelementCity = listAddressDelivery.stream().filter((e) -> e.getText().contains(users.get(0).strCity)).findFirst().orElse(null);
        assertTrue(verifyWebelementCity.isDisplayed());

        verifyWebelementZipecode = listAddressDelivery.stream().filter((e) -> e.getText().contains(users.get(0).strZipecode)).findFirst().orElse(null);
        assertTrue(verifyWebelementZipecode.isDisplayed());


        verifyWebelementPhoneNumber = listAddressDelivery.stream().filter((e) -> e.getText().contains(users.get(0).strPhoneNumber)).findFirst().orElse(null);
        assertTrue(verifyWebelementPhoneNumber.isDisplayed());
        }
//
//        for (int i=1;i<listAddressDelivery.size();i++)
//        {
//
//            System.out.println(listAddressDelivery.get(i).getText());
//
//        }




    }


    public void inputComment()
    {

        textBoxComment=driver.findElement(commentLocator);

        textBoxComment.sendKeys(random);

    }


    public void PlaceOrder()
    {
        btnPlaceOrder=driver.findElement(placeOrderLocator);
        btnPlaceOrder.click();

    }


}
