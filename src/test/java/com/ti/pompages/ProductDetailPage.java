package com.ti.pompages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class ProductDetailPage extends HomePage {

//    Verify that detail detail is visible: product name, category, price, availability, condition, brand

By productDetailLocator=By.cssSelector(".product-information");

By productquantityLocator=By.id("quantity");

By productaddtocartLocator=By.cssSelector("button[type='button']");

List<WebElement> productDetail;

WebElement inputQuantity;

WebElement btnAddtoCart;
public void CheckProductDetail()
{

    productDetail=driver.findElements(productDetailLocator);

    for ( var detail:productDetail
         ) {

        System.out.println("Product name: "+detail.findElement(By.tagName("h2")).getText());
        System.out.println(detail.findElement(By.tagName("p")).getText());
//        System.out.println("Rating: "+detail.findElement(By.tagName("img")).getAttribute("alt"));
        System.out.println("Price: "+detail.findElement(By.tagName("span")).getText());
        System.out.println(detail.findElements(By.tagName("p")).get(1).getText());
        System.out.println(detail.findElements(By.tagName("p")).get(2).getText());
        System.out.println(detail.findElements(By.tagName("p")).get(3).getText());
    }


}

public void AddProducttoCart(int amount) throws InterruptedException {

    inputQuantity=driver.findElement(productquantityLocator);
    inputQuantity.clear();
    inputQuantity.sendKeys(String.valueOf(amount));


    products.get(position).intquantity=amount;
    btnAddtoCart=driver.findElement(productaddtocartLocator);
    btnAddtoCart.click();
    driver.switchTo().activeElement();

    Thread.sleep(3000);

    driver.findElement(By.xpath("//div[@id='cartModal']//button[normalize-space()='Continue Shopping']")).click();


}


}
