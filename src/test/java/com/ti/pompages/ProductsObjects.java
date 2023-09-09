package com.ti.pompages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ProductsObjects {

    String strItemType;
    String strItemPrice;
    WebElement addToCart;
    WebElement viewProduct;


    public ProductsObjects(String strItemType, String strItemPrice, WebElement addToCart, WebElement viewProduct) {
        this.strItemType = strItemType;
        this.strItemPrice = strItemPrice;
        this.addToCart = addToCart;
        this.viewProduct = viewProduct;
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
}



