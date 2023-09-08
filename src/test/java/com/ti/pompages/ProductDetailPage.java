package com.ti.pompages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class ProductDetailPage extends HomePage {

//    Verify that detail detail is visible: product name, category, price, availability, condition, brand

By productDetailPage=By.cssSelector(".product-information");

List<WebElement> productDetail;

public void CheckProductDetail()
{

    productDetail=driver.findElements(productDetailPage);

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


}
