package com.ti.pompages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.ti.DriverFactory;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.equalToIgnoringCase;

public class HomePage {

    By AutomationImageLocator= By.cssSelector("img[alt*='automation']");

    By AutomationCarouselLocator=By.xpath("//li[contains(@data-target,'carousel')]");

    By AutomationCarouselTextLocator=By.xpath("//h2[contains(text(), 'Automation')]");


    WebDriver driver = DriverFactory.getInstance().getDriver();

    WebElement WebsiteText;
    List<WebElement> CarrouselDot;



    public void HomePageTitle()

    {
        WebsiteText=driver.findElement(AutomationImageLocator);
        assertThat(WebsiteText.getAttribute("alt"), containsString("automation"));

    }

    public void Clickoncarousel()
    {
        CarrouselDot=driver.findElements(AutomationCarouselLocator);

        for ( var carrousel:CarrouselDot) {
            carrousel.click();
            assertThat(driver.findElement(AutomationCarouselTextLocator).getText(), containsString("Automation"));


        }


    }
}
