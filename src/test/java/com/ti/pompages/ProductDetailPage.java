package com.ti.pompages;

import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.containsStringIgnoringCase;

public class ProductDetailPage extends HomePage {

//    Verify that detail detail is visible: product name, category, price, availability, condition, brand

By productDetailLocator=By.cssSelector("div[class='product-information']");

By productquantityLocator=By.cssSelector("input[id='quantity']");

By productaddtocartLocator=By.cssSelector("button[type='button']");

By labelReviewLocator=By.cssSelector("a[href=\"#reviews\"]");

By nameLocator=By.id("name");

By emailLocator=By.id("email");

By textAreaReviewLocator=By.id("review");

By btnReviewLocator=By.id("button-review");

By successAlertLocator=By.cssSelector("div[class=\"alert-success alert\"] span");

WebElement productDetail;

WebElement inputQuantity;

WebElement btnAddtoCart;

WebElement labelReview;

WebElement inputName;

WebElement inputemail;

WebElement textAreaReview;

WebElement btnReview;

WebElement successAlert;



Faker reviewdata = new Faker();




public void CheckProductDetail()
{
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

    wait.until(ExpectedConditions.urlContains("detail"));
    productDetail=driver.findElement(productDetailLocator);
    System.out.println("product detail is displayed "+productDetail.isDisplayed());

//    for ( var detail:productDetail
//         ) {

        System.out.println("Product name: "+productDetail.findElement(By.tagName("h2")).getText());
        System.out.println(productDetail.findElement(By.tagName("p")).getText());
//        System.out.println("Rating: "+detail.findElement(By.tagName("img")).getAttribute("alt"));
        System.out.println("Price: "+productDetail.findElement(By.tagName("span")).getText());
        System.out.println(productDetail.findElements(By.tagName("p")).get(1).getText());
        System.out.println(productDetail.findElements(By.tagName("p")).get(2).getText());
        System.out.println(productDetail.findElements(By.tagName("p")).get(3).getText());
//    }


}

public void AddProducttoCart(int amount) throws InterruptedException {

   WebElement latestId= driver.findElement(By.xpath("//div[@id='cartModal']//button[normalize-space()='Continue Shopping']"));

    inputQuantity=driver.findElement(productquantityLocator);
    inputQuantity.clear();
    inputQuantity.sendKeys(String.valueOf(amount));


    products.get(position).intquantity=amount;
    btnAddtoCart=driver.findElement(productaddtocartLocator);
    btnAddtoCart.click();


    WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
    wait.until(ExpectedConditions.elementToBeClickable(latestId));
    driver.switchTo().activeElement();
    latestId.click();


}

public void VerifyReviewLabel()

    {
        labelReview=driver.findElement(labelReviewLocator);


        assertThat(labelReview.getText(), containsStringIgnoringCase("Write Your Review"));



    }

public void AddReview()

{
    inputName=driver.findElement(nameLocator);
    inputemail=driver.findElement(emailLocator);
    textAreaReview=driver.findElement(textAreaReviewLocator);
    btnReview=driver.findElement(btnReviewLocator);
    inputName.sendKeys(reviewdata.name().firstName()+ " "+reviewdata.name().lastName());
    inputemail.sendKeys(reviewdata.internet().emailAddress());
    textAreaReview.sendKeys(random);
    btnReview.click();

    successAlert=driver.findElement(successAlertLocator);
    assertThat(successAlert.getText(), containsStringIgnoringCase("Thank you for your review"));


}


}
