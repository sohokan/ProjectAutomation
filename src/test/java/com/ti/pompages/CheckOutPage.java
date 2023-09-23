package com.ti.pompages;

import static com.ti.restapi.HttpsMethod.usersgo;
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

        System.out.println("size "+listAddressDelivery.size());

        if (users.size()>0) //  can only be use with a register user in the webpage
        {
            VerifyDeliveryAddress(users.get(0).strUserFirstName,users.get(0).strUserLastName,users.get(0).strCompany,users.get(0).strAddress1,users.get(0).strAddress2,users.get(0).strState,users.get(0).strCountry,users.get(0).strCity,users.get(0).strZipecode,users.get(0).strPhoneNumber);



        }
else  //  can only be use with a restapi user

        {
            System.out.println("REST Name"+usersgo.users.firstName);
            System.out.println("REST zipcode"+usersgo.users.zipcode);

            VerifyDeliveryAddress(usersgo.users.firstName,usersgo.users.lastName,usersgo.users.company,usersgo.users.address1,usersgo.users.address2,usersgo.users.state,usersgo.users.country,usersgo.users.city,usersgo.users.zipcode,"usersgo.phone");

        }



    }

    public void VerifyDeliveryAddress(String firstName, String lastName, String company, String address1,String address2, String state, String country, String city,String zipcode,String phonenumber)

    {

        verifyCorrectFirstName = listAddressDelivery.stream().filter((e) -> e.getText().contains(firstName)).findFirst().orElse(null);
        assertTrue(verifyCorrectFirstName.isDisplayed());

        verifyCorrectLastName = listAddressDelivery.stream().filter((e) -> e.getText().contains(lastName)).findFirst().orElse(null);
        assertTrue(verifyCorrectLastName.isDisplayed());

        verifyWebelementCompany = listAddressDelivery.stream().filter((e) -> e.getText().contains(company)).findFirst().orElse(null);
        assertTrue(verifyWebelementCompany.isDisplayed());


        verifyWebelementAddress1 = listAddressDelivery.stream().filter((e) -> e.getText().contains(address1)).findFirst().orElse(null);
        assertTrue(verifyWebelementAddress1.isDisplayed());


        verifyWebelementAddress2 = listAddressDelivery.stream().filter((e) -> e.getText().contains(address2)).findFirst().orElse(null);
        assertTrue(verifyWebelementAddress2.isDisplayed());

        verifyWebelementState = listAddressDelivery.stream().filter((e) -> e.getText().contains(state)).findFirst().orElse(null);
        assertTrue(verifyWebelementState.isDisplayed());


        verifyWebelementCountry = listAddressDelivery.stream().filter((e) -> e.getText().contains(country)).findFirst().orElse(null);
        assertTrue(verifyWebelementCountry.isDisplayed());

        verifyWebelementCity = listAddressDelivery.stream().filter((e) -> e.getText().contains(city)).findFirst().orElse(null);
        assertTrue(verifyWebelementCity.isDisplayed());

        verifyWebelementZipecode = listAddressDelivery.stream().filter((e) -> e.getText().contains(zipcode)).findFirst().orElse(null);
        assertTrue(verifyWebelementZipecode.isDisplayed());

        if (users.size()>0){
            verifyWebelementPhoneNumber = listAddressDelivery.stream().filter((e) -> e.getText().contains(phonenumber)).findFirst().orElse(null);
        assertTrue(verifyWebelementPhoneNumber.isDisplayed());}
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
