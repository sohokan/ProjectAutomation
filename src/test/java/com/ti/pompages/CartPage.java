package com.ti.pompages;

import org.openqa.selenium.By;

import org.openqa.selenium.WebElement;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;
import static org.testng.AssertJUnit.assertTrue;

public class CartPage extends HomePage{

    By cartLocator= By.xpath("//a[normalize-space()='Cart']");
    By productscartLocator=By.xpath("//tr[contains(@id,'product')]");

    By checkoutLocator=By.cssSelector(".btn.btn-default.check_out");

    By CartRegisterLocator=By.xpath("//div[@id='checkoutModal']//u[contains(.,'Register')]");

    WebElement iconCart;

    List<WebElement> productsCart;

    List<WebElement> lscart;

    WebElement btnCheckout;



    public void GotoCart()
    {
        iconCart=driver.findElement(cartLocator);
        iconCart.click();

    }


    public void CheckCartProducts()
    {

        productsCart=driver.findElements(productscartLocator);

        int counterProductSelected=0;

        System.out.println("Total products in cart "+productsCart.size());
        System.out.println("Total products in pojo "+products.size());

        String[] strItemPrice;

        int dItemPrice;
        int iItemQuantity;
        int TotalItemPrice;




        for (var objcart:productsCart)
        {


            lscart=objcart.findElements( By.tagName("td"));


                    System.out.println(objcart.findElement( By.tagName("h4")).getText());
                    System.out.println(lscart.get(2).getText());
                    System.out.println(lscart.get(3).getText());





            System.out.println(compareProductsName(objcart.findElement( By.tagName("h4")).getText(),lscart.get(2).getText()/*,lscart.get(3).getText()*/));
          assertTrue(compareProductsName(objcart.findElement( By.tagName("h4")).getText(),lscart.get(2).getText()/*,lscart.get(3).getText()*/));
            strItemPrice= lscart.get(2).getText().split("Rs. ");

            dItemPrice= Integer.parseInt(strItemPrice[1]);

            iItemQuantity= Integer.parseInt(lscart.get(3).getText());

            TotalItemPrice=dItemPrice*iItemQuantity;

            System.out.println("Total Price: "+TotalItemPrice);

            assertThat(lscart.get(4).getText(),containsString(String.valueOf(TotalItemPrice))); //compare price from website with Total Price (calculated)

            counterProductSelected++;
        }


    }

    public void

    ProceedtoCheckout() throws InterruptedException {

        btnCheckout=driver.findElement(checkoutLocator);
        btnCheckout.click();

//        Thread.sleep(1000);

        if (driver.findElements(CartRegisterLocator).size()>0) // if user is not logged in
            driver.findElement(CartRegisterLocator).click();

    }

    public boolean compareProductsName(  String itemname,  String itemprice /*,String quantity*/){
//        return products.stream().allMatch(o -> itemname.contains(o.getStrItemType()) && itemprice.contains(o.getStrItemPrice()) && quantity.contains(String.valueOf(o.getIntquantity())));

        return products.stream().anyMatch(o -> itemname.contains(o.getStrItemType()) && itemprice.contains(o.getStrItemPrice()));
    }



}
