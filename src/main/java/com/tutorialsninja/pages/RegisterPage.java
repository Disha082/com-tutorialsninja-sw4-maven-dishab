package com.tutorialsninja.pages;

import com.tutorialsninja.utility.Utility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class RegisterPage extends Utility {
    By registerAccountText = By.xpath("//h1[contains(text(),'Register Account')]");
    By firstname = By.id("input-firstname");
    By lastname = By.id("input-lastname");
    By emailId = By.id("input-email");
    By telephone = By.id("input-telephone");
    By password = By.id("input-password");
    By confirmPassword = By.id("input-confirm");
    By agreeCheckbox = By.xpath("//div[@class = 'buttons']//input[@name='agree']");
    By continueLink = By.xpath("//div[@class = 'buttons']//input[@value='Continue']");

    public String verifyRegisterAccount(){
        return getTextFormElement(registerAccountText);

    }

    public void enterFirstname(String text){
        sendTextToElement(firstname, text + getAlphaNumericString(5));
    }

    public void enterLastname(String text){
        sendTextToElement(lastname, text + getAlphaNumericString(5));
    }
    public void enterEmail(String text){
        sendTextToElement(emailId, text + getAlphaNumericString(5));
    }

    public void enterTelephone(String text){
        sendTextToElement(telephone, text);
    }
    public void enterPassword(String text){
        sendTextToElement(password, text);
    }
    public void enterConfirmPassword(String text){
        sendTextToElement(confirmPassword, text);
    }
    public void clickOnSubscribe(){
        List<WebElement> radioButtons = driver.findElements(By.xpath("//fieldset[3]//input"));
        for (WebElement e : radioButtons) {
            if (e.getText().equals("Yes")) {
                e.click();
                break;
            }
        }
    }

    public void clickOnAgree(){
        clickOnElement(agreeCheckbox);
    }

    public void clickOnContinue(){
        clickOnElement(continueLink);
    }


}
