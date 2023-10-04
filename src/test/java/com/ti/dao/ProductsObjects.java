package com.ti.dao;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ProductsObjects {

   public String strItemType;
   public String strItemPrice;
  public  WebElement addToCart;
   public WebElement viewProduct;

   public int  intquantity;

    public ProductsObjects(String strItemType, String strItemPrice, WebElement addToCart, WebElement viewProduct, int intquantity) {
        this.strItemType = strItemType;
        this.strItemPrice = strItemPrice;
        this.addToCart = addToCart;
        this.viewProduct = viewProduct;
        this.intquantity = intquantity;
    }


    public String getStrItemType() {
        return strItemType;
    }

    public void setStrItemType() {
        this.strItemType = strItemType;
    }

    public String getStrItemPrice() {
        return strItemPrice;
    }

    public void setStrItemPrice() {
        this.strItemPrice = strItemPrice;
    }

    public WebElement getAddToCart() {
        return addToCart;
    }

    public void setAddToCart() {
        this.addToCart = addToCart;
    }

    public WebElement getViewProduct() {
        return viewProduct;
    }

    public void setViewProduct() {
        this.viewProduct = viewProduct;
    }

    public int getIntquantity() {
        return intquantity;
    }

    public void setIntquantity() {
        this.intquantity = intquantity;
    }
}



