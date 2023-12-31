package com.ti.pompages;

import com.ti.dao.ProductsObjects;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.*;
import java.util.stream.Collectors;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;
import static org.testng.AssertJUnit.assertTrue;



public class CartPage extends HomePage{

    By cartLocator= By.xpath("//a[normalize-space()='Cart']");
    By productscartLocator=By.xpath("//tr[contains(@id,'product')]");

    By checkoutLocator=By.cssSelector(".btn.btn-default.check_out");

    By CartRegisterLocator=By.xpath("//div[@id='checkoutModal']//u[contains(.,'Register')]");

    By deleteProductLocator ;
            //By.xpath("/parent::*/parent::td/following-sibling::td[4]//a//i");

    //a[contains(.,'Fancy Green Top')]/parent::*/parent::td/following-sibling::td[4]//a//i

    By prodsNameDeletedLocator=By.xpath("//a[contains(@href,'product_detail')]");

    WebElement iconCart;

    List<WebElement> productsCart;

    List<WebElement> lscart;

    WebElement btnCheckout;

     WebElement  iconDeleteProduct;

    ArrayList<String> arrayclothes= new ArrayList<>();



    public void GotoCart()
    {
        iconCart=driver.findElement(cartLocator);
        iconCart.click();

    }


    public void CheckCartProducts()
    {

        productsCart=driver.findElements(productscartLocator);

        int counterProductSelected=0;
        int dItemPrice;
        int iItemQuantity;
        int TotalItemPrice;



        System.out.println("Total products in cart "+productsCart.size());
//        System.out.println("Total products in pojo "+products.size());

        String[] strItemPrice;


        for (var objcart:productsCart)
        {


            lscart=objcart.findElements( By.tagName("td"));



//          assertTrue(compareProductsInfo(objcart.findElement( By.tagName("h4")).getText(),lscart.get(2).getText(),lscart.get(3).getText()));


            compareProducts(objcart.findElement( By.tagName("h4")).getText(),lscart.get(2).getText(),lscart.get(3).getText());

            strItemPrice= lscart.get(2).getText().split("Rs. ");

            dItemPrice= Integer.parseInt(strItemPrice[1]);

            iItemQuantity= Integer.parseInt(lscart.get(3).getText());

            TotalItemPrice=dItemPrice*iItemQuantity;

            System.out.println(objcart.findElement( By.tagName("h4")).getText()+" has a Total Price "+TotalItemPrice);

            assertThat(lscart.get(4).getText(),containsString(String.valueOf(TotalItemPrice))); //compare price from website with Total Price (calculated)
            arrayclothes.add(objcart.findElement( By.tagName("h4")).getText());
            counterProductSelected++;


        }




    }

    public void DeleteProduct(int i)
    {

        String completeDeletexpath= "//a[contains(.,'"+products.get(i).strItemType +
                "')]/parent::*/parent::td/following-sibling::td[4]//a//i";

        deleteProductLocator=By.xpath(completeDeletexpath);


//        iconDeleteProduct=driver.findElements(deleteProductLocator);

      WebElement deleteProduct=driver.findElement( deleteProductLocator);
        System.out.println(deleteProduct.getAttribute("class"));

        JavascriptExecutor executor = (JavascriptExecutor)driver;
        executor.executeScript("window.scrollBy(0,300)");

        executor.executeScript("arguments[0].click();", deleteProduct);


//        deleteProduct.click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.invisibilityOf(deleteProduct));

    }

    public void VerifyDeleteProduct() throws InterruptedException {



        List<WebElement> newproductsCart=driver.findElements(prodsNameDeletedLocator);
        ArrayList<String> NewCartProducts = new ArrayList<String>();
        for (WebElement p : newproductsCart ) {
            NewCartProducts.add(p.getText());
        }


        List<String> result = arrayclothes.stream().filter(elem -> !NewCartProducts.contains(elem)).collect(Collectors.toList());


        result.forEach(p-> System.out.println(p+" was removed for the Cart Page"));


        }




    public void ProceedtoCheckout() throws InterruptedException {

        btnCheckout=driver.findElement(checkoutLocator);
        btnCheckout.click();



        if (driver.findElements(CartRegisterLocator).size()>0) // if user is not logged in
            driver.findElement(CartRegisterLocator).click();

    }

    public boolean compareProductsInfo(  String itemname,  String itemprice ,String quantity){
        return products.stream().allMatch(o -> itemname.contains(o.getStrItemType()) && itemprice.contains(o.getStrItemPrice()) && quantity.contains(String.valueOf(o.getIntquantity())));

//        return products.stream().anyMatch(o -> itemname.contains(o.getStrItemType()) && itemprice.contains(o.getStrItemPrice()));
    }

    public void compareProducts(  String itemname,  String itemprice ,String quantity){
        if (products.size()>0)

            ReturnMatch(products,itemname,itemprice,quantity, "The");

        if(recommendProducts.size()>0)

            ReturnMatch(recommendProducts,itemname,itemprice,quantity, "The Recommended");
    }


     void ReturnMatch(List<ProductsObjects> object, String itemname, String itemprice , String quantity, String text)

    {
        object.forEach(o ->{ if(Integer.parseInt(quantity)==o.getIntquantity() && itemname.contains(o.getStrItemType()) && itemprice.contains(o.getStrItemPrice()))
            System.out.println(text+" Quantity and Price match for "+o.strItemType);
        });

    }



}
