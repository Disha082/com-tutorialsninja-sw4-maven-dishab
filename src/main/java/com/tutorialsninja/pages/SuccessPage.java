package com.tutorialsninja.pages;

import com.tutorialsninja.utility.Utility;
import org.openqa.selenium.By;

public class SuccessPage extends Utility {
    By yourAccountText = By.xpath("//h1[contains(text(),'Your Account Has Been Created!')]");
    By successContinueText = By.xpath("//a[contains(text(),'Continue')]");
    public String verifyYourAccountMessage(){
        return getTextFormElement(yourAccountText);
    }

    public void clickOnSuccessContinueButton(){
        clickOnElement(successContinueText);
    }
}
