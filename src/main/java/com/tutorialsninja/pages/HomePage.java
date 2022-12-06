package com.tutorialsninja.pages;

import com.tutorialsninja.utility.Utility;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;

import java.util.List;

public class HomePage extends Utility {
    By topMenu = By.xpath("//nav[@id='menu']//ul/li[contains(@class, 'open')]/div/child::*");
    By desktopLink = By.linkText("Desktops");
    By laptopNotebooksLink = By.linkText("Laptops & Notebooks");
    By componentsLink = (By.linkText("Components"));
    By currencyLink = By.xpath("//span[contains(text(),'Currency')]");
    By myAccountLink = By.xpath("//span[text()='My Account']");


    public void clickOnCurrency(){
        clickOnElement(currencyLink);
        List<WebElement> currencyList = driver.findElements(By.xpath("//ul[@class = 'dropdown-menu']/li"));
        for (WebElement e:currencyList ) {
            if (e.getText().equalsIgnoreCase("£ Pound Sterling")) {
                e.click();
                break;
            }
        }
    }
    public void selectMenu(String menu) {
        List<WebElement> topMenuList = driver.findElements(topMenu);
        try {
            for (WebElement element : topMenuList) {
                if (element.getText().equalsIgnoreCase(menu)) {
                    element.click();
                }
            }
        } catch (StaleElementReferenceException e) {
            topMenuList = driver.findElements(topMenu);
        }
    }

    public void mouseHoverToDesktopAndClick(){
        mouseHoverToElementAndClick(desktopLink);
    }

    public void mouseHoverToLaptopsNotebooksAndClick(){
        mouseHoverToElementAndClick(laptopNotebooksLink);
    }

    public void mouseHoverToComponentsAndClick(){
        mouseHoverToElementAndClick(componentsLink);
    }

    public void clickOnMyAccount(){
        clickOnElement(myAccountLink);
    }

    public void selectMyAccountOptions(String menu){
        String exp = String.format("//a[text()='%s']", menu) ;
        driver.findElement(By.xpath(exp)).click();
    }

}

