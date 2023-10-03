package com.ti.pompages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

import static org.ti.utils.ui.SeleniumUtil.DisableAds;

public class TestCasePage extends HomePage{

    By testcaseLinkLocator=By.cssSelector("a[href='/test_cases']");

    By testcasesLocator=By.xpath("//u[contains(normalize-space(),'Test Case ')]");


    List<WebElement> panelTestCase;

    WebElement linkTestcase;

    public void CheckTestcases()
    {
        linkTestcase=driver.findElement(testcaseLinkLocator);
        linkTestcase.click();

        try {
            DisableAds();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        panelTestCase=driver.findElements(testcasesLocator);

        System.out.println("Number of testcases: "+panelTestCase.size());

        for (var tc:panelTestCase) {

            System.out.println(tc.getText());

        }

    }



}
