package com.ti.pompages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CartPage extends HomePage{

    By cartLocator= By.xpath("//a[normalize-space()='Cart']");

    WebElement iconCart;

    public void GotoCart()
    {
        iconCart=driver.findElement(cartLocator);
        iconCart.click();

    }
}
