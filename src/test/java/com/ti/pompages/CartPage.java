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

    WebElement iconCart;

    List<WebElement> productsCart;

    List<WebElement> lscart;



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

        String[] strItemPrice;

        int dItemPrice;
        int iItemQuantity;
        int TotalItemPrice;


        for (var objcart:productsCart)
        {

            lscart=objcart.findElements( By.tagName("td"));
            System.out.println(lscart.get(2).getText());
            System.out.println(lscart.get(3).getText());
            System.out.println(lscart.get(4).getText());
//            System.out.println(objcart.findElement( By.xpath("//td[@class='cart_total']")).getText());

//            assertThat(products.get(counterProductSelected).strItemType,containsString(objcart.findElement( By.tagName("h4")).getText())); //compare name
//            assertThat(products.get(counterProductSelected).strItemPrice,containsString(lscart.get(2).getText())); //compare price
//            System.out.println(objcart.findElement( By.tagName("h4")).getText());
//            System.out.println(objcart.findElement( By.tagName("p")).getText());


            System.out.println(compareProductsName(products,objcart.findElement( By.tagName("h4")).getText(),lscart.get(2).getText(),lscart.get(3).getText()));
            assertTrue(compareProductsName(products,objcart.findElement( By.tagName("h4")).getText(),lscart.get(2).getText(),lscart.get(3).getText()));
            strItemPrice= lscart.get(2).getText().split("Rs. ");

            dItemPrice= Integer.parseInt(strItemPrice[1]);

            iItemQuantity= Integer.parseInt(lscart.get(3).getText());

            TotalItemPrice=dItemPrice*iItemQuantity;

            System.out.println("Total Price: "+TotalItemPrice);

            assertThat(lscart.get(4).getText(),containsString(String.valueOf(TotalItemPrice))); //compare price from website with Total Price (calculated)

            counterProductSelected++;
        }


    }


    public boolean compareProductsName( List<ProductsObjects> list,  String itemname,  String itemprice ,String quantity){
        return list.stream().anyMatch(o -> itemname.contains(o.getStrItemType()) && itemprice.contains(o.getStrItemPrice()) && quantity.contains(String.valueOf(o.getIntquantity())));
    }


}
