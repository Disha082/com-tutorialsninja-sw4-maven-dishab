package com.tutorialsninja.pages;

import com.tutorialsninja.utility.Utility;
import org.openqa.selenium.By;

public class LogoutPage extends Utility {
    By accountLogoutText = By.xpath("//h1[contains(text(),'Account Logout')]");
    By continueText = By.xpath("//a[contains(text(),'Continue')]");
    public String verifyAccountLogoutText(){
        return getTextFormElement(accountLogoutText);
    }

    public void clickOnContinue(){
        clickOnElement(continueText);
    }
}
