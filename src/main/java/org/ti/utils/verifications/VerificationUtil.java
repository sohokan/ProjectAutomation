package org.ti.utils.verifications;

import org.ti.DriverFactory.FrameworkException;
import org.openqa.selenium.WebElement;

import static org.ti.utils.ui.WaitUtil.elementVisible;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class VerificationUtil implements VerificationInterface{

  @Override
  public void verifyTestIsDisplayed(WebElement element, String text) {
    assertTrue(element.getText().contains(text),"Element doesn't display the text");
  }

  @Override
  public void verifyTextAreEquals(String actualText, String expectedText) {
    assertEquals(actualText,expectedText);
  }

  @Override
  public void verifyElementExist(WebElement element) {
    try{
      elementVisible(element);
      assertTrue(true);
    }catch (Exception e){
      new FrameworkException("Element doesn't Exist", e);
    }
  }
}
