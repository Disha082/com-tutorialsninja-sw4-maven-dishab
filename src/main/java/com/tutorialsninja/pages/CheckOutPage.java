package com.tutorialsninja.pages;

import com.tutorialsninja.utility.Utility;
import org.openqa.selenium.By;

public class CheckOutPage extends Utility {
    By checkOutText = By.xpath("//h1[contains(text(),'Checkout')]");
    By newCustomerText = By.xpath("//h2[contains(text(),'New Customer')]");
    By clickOnRadioButton = By.xpath("//body/div[@id='checkout-checkout']/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[2]/label[1]/input[1]");
    By clickOnContinueButton = By.id("button-account");
    By firstName = By.id("input-payment-firstname");
    By lastName = By.id("input-payment-lastname");
    By email = By.id("input-payment-email");
    By telephone = By.id("input-payment-telephone");
    By address =By.id("input-payment-address-1");
    By city = By.id("input-payment-city");
    By postcode = By.id("input-payment-postcode");
    By country = By.id("input-payment-country");
    By state = By.id("input-payment-zone");
    By continueLink = By.id("button-guest");
    By warningMessage = By.xpath("//div[@class='alert alert-danger alert-dismissible'][text()='Warning: Payment method required!']");
    By addCommentsText = By.xpath("//body/div[@id='checkout-checkout']/div[1]/div[1]/div[1]/div[3]/div[2]/div[1]/p[2]/textarea[1]");
    By addTerms = By.xpath("//body/div[@id='checkout-checkout']/div[1]/div[1]/div[1]/div[3]/div[2]/div[1]/div[2]/div[1]/input[1]");
    By checkoutContinueLink = By.id("button-payment-method");
    public String verifyCheckoutText(){
        return getTextFormElement(checkOutText);
    }
    public String verifyCustomerText(){
        return getTextFormElement(newCustomerText);
    }

    public void clickOnGuestCheckOut(){
        clickOnElement(clickOnRadioButton);
        clickOnElement(clickOnContinueButton);
    }

    public void enterFirstName(String text){
        sendTextToElement(firstName,text);
    }
    public void enterLastName(String text) {
        sendTextToElement(lastName, text);
    }
    public void enterEmail(String text) {
        sendTextToElement(email, text);
    }
    public void enterTelephone(String text) {
        sendTextToElement(telephone, text);
    }
    public void enterAddress(String text) {
        sendTextToElement(address, text);
    }
    public void enterCity(String text) {
        sendTextToElement(city, text);
    }
    public void enterPostcode(String text) {
        sendTextToElement(postcode, text);
    }
    public void entercountry(String text) {
        selectByValueFromDropDown(country, text);
    }
    public void enterState(String text) {
        selectByValueFromDropDown(state, text);
    }

    public void clickOnContinue(){
        clickOnElement(continueLink);
    }

    public String verifyWarningMethod(){
        System.out.println("Warning" + getTextFormElement(warningMessage));
        return getTextFormElement(warningMessage);
    }

    public void addComments(){
        sendTextToElement(addCommentsText, "This is my comment");
    }

    public void clickOnCheckBox(){
        clickOnElement(addTerms);
    }

    public void checkOutContinueButton(){
        clickOnElement(checkoutContinueLink);
    }
}
