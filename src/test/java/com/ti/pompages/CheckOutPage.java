package com.ti.pompages;

import static com.ti.restapi.HttpsMethod.usersgo;
import static com.ti.pompages.SignUpPage.users;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

import static org.apache.commons.lang3.ObjectUtils.isEmpty;
import static org.testng.AssertJUnit.assertTrue;
import static org.ti.utils.ui.SeleniumUtil.random;

public class CheckOutPage extends HomePage {
    //YOUR DELIVERY ADDRESS
    By  addressDeliveryLocator= By.xpath("//ul[@id='address_delivery']");

    By addressInvoiceLocator=By.xpath("//ul[@id='address_invoice']");

    By commentLocator=By.cssSelector("textarea[name='message']");

    By placeOrderLocator=By.cssSelector(".btn.btn-default.check_out");

    WebElement addressDelivery;

    WebElement addressInvoice;

    List<WebElement> listAddressDelivery;

    WebElement verifyAddress;

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



        CheckAddress(addressDelivery);



        CheckAddress(addressInvoice);

    }


    public void  CheckAddress(WebElement element)


    {
        listAddressDelivery =element.findElements(By.tagName("li"));

        System.out.println("size "+listAddressDelivery.size());
        System.out.println("User size");


     if (usersgo.users!=null) // can only be use with a register user in the webpage
        {

            System.out.println("REST Name"+usersgo.users.firstName);
            System.out.println("REST zipcode"+usersgo.users.zipcode);

            VerifyDeliveryAddress(usersgo.users.firstName,usersgo.users.lastName,usersgo.users.company,usersgo.users.address1,usersgo.users.address2,usersgo.users.state,usersgo.users.country,usersgo.users.city,usersgo.users.zipcode);



        }
        else if (users.size()>0)

        {
            System.out.println("Webelement first Name:"+ users.get(0).getStrUserFirstName());
            VerifyDeliveryAddress(users.get(0).getStrUserFirstName(), users.get(0).getStrUserLastName(), users.get(0).getStrCompany(), users.get(0).getStrAddress1(), users.get(0).getStrAddress2(), users.get(0).getStrState(), users.get(0).getStrCountry(), users.get(0).getStrCity(), users.get(0).getStrZipecode());

                verifyWebelementPhoneNumber = listAddressDelivery.stream().filter((e) -> e.getText().contains(users.get(0).getStrPhoneNumber())).findFirst().get();
                assertTrue(verifyWebelementPhoneNumber.isDisplayed());
        }



    }

    public void VerifyDeliveryAddress(String firstName, String lastName, String company, String address1,String address2, String state, String country, String city,String zipcode)

    {


        verifyAddress = listAddressDelivery.stream().filter(e -> e.getText().contains(firstName)||e.getText().contains(lastName)||e.getText().contains(company)|| e.getText().contains(address1)||e.getText().contains(address2)||e.getText().contains(state)||e.getText().contains(country)||e.getText().contains(city)||e.getText().contains(zipcode)).findFirst().orElse(null);


        assertTrue(verifyAddress.isDisplayed());



    }


    public void inputComment()
    {

        textBoxComment=driver.findElement(commentLocator);

        textBoxComment.sendKeys(random());

    }


    public void PlaceOrder()
    {
        btnPlaceOrder=driver.findElement(placeOrderLocator);
        btnPlaceOrder.click();

    }


}
