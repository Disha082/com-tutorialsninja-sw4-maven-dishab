package com.tutorialsninja.pages;

import com.tutorialsninja.utility.Utility;
import org.openqa.selenium.By;

public class Loginpage extends Utility {
    By returningCustomerText = By.xpath("//h2[contains(text(),'Returning Customer')]");
    By emailId = By.id("input-email");
    By password = By.id("input-password");
    By loginText = By.xpath("//form[contains(@action,'login')]//input[@type='submit']");

    public String verifyReturningCustomer(){
        return getTextFormElement(returningCustomerText);
    }

    public void enterEmailId(String text){
        sendTextToElement(emailId, text);
    }
    public void enterPassword(String text){
        sendTextToElement(password, text);
    }

    public void clickOnLoginButton(){
        clickOnElement(loginText);
    }

}
