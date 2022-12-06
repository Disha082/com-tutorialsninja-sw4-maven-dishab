package com.tutorialsninja.pages;

import com.tutorialsninja.utility.Utility;
import org.openqa.selenium.By;

import javax.swing.text.Utilities;

public class MacBookPage extends Utility {
    By macBookText = By.xpath("//h1[contains(text(),'MacBook')]");
    By macAddToCart = By.xpath("//button[@id='button-cart']");
    By shoppingCartLink = By.xpath("//a[contains(text(),'shopping cart')]");

    public String macBookErrorMessage(){
        return getTextFormElement (macBookText);
    }

    public void macBookAddToCart(){
        clickOnElement(macAddToCart);

    }

    public void clickOnShoppingCartButton(){
        clickOnElement(shoppingCartLink);
    }

}
