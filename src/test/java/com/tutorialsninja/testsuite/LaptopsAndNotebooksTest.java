package com.tutorialsninja.testsuite;

import com.tutorialsninja.pages.*;
import com.tutorialsninja.testbase.BaseTest;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Map;

public class LaptopsAndNotebooksTest extends BaseTest {
    HomePage homePage = new HomePage();
    DesktopsPage desktopPage = new DesktopsPage();
    LaptopsAndNotebooksPage laptopsAndNotebooksPage = new LaptopsAndNotebooksPage();
    MacBookPage macBookPage = new MacBookPage();
    ShoppingCartPage shoppingCartPage = new ShoppingCartPage();
    CheckOutPage checkOutPage = new CheckOutPage();

    @Test
    public void verifyProductsPriceDisplayHighToLowSuccessfully(){
        homePage.mouseHoverToLaptopsNotebooksAndClick();
        homePage.selectMenu("Show All Laptops & Notebooks");
        Map<String, ArrayList> mapArrays = laptopsAndNotebooksPage.arrangeProductHighToLowOrder();
        Assert.assertEquals(mapArrays.get("originalProductsPrice"), mapArrays.get("afterSortByPrice"));
    }

    @Test
    public void verifyThatUserPlaceOrderSuccessfully(){
        homePage.clickOnCurrency();
        homePage.mouseHoverToLaptopsNotebooksAndClick();
        homePage.selectMenu("Show All Laptops & Notebooks");
        laptopsAndNotebooksPage.productSortBy();
        laptopsAndNotebooksPage.clickOnMacBookLink();
        Assert.assertEquals(macBookPage.macBookErrorMessage(), "MacBook", "MacBook Product not display");
        macBookPage.macBookAddToCart();
        Assert.assertTrue(getTextFormElement(By.cssSelector("body:nth-child(2) div.container:nth-child(4) > div.alert.alert-success.alert-dismissible")).contains("Success: You have added MacBook to your shopping cart!"), "Product not added to cart");
        macBookPage.clickOnShoppingCartButton();
        Assert.assertEquals(shoppingCartPage.shoppingCartTextErrorMessage(),"Shopping Cart  (0.00kg)", "Shopping cart is not displayed" );
        Assert.assertEquals(shoppingCartPage.macBookNameErrorMessage(), "MacBook", "Product name not matched");
        shoppingCartPage.updateMacBookQuantity();
        Assert.assertTrue(getTextFormElement(By.xpath("//div[@id='checkout-cart']/div[1]")).contains("Success: You have modified your shopping cart!"), "Cart not modified");
        Assert.assertEquals(shoppingCartPage.macBookTotalErrorMessage(), "£737.45", "Total not matched" );
        shoppingCartPage.clickOnCheckButton();
        Assert.assertEquals(checkOutPage.verifyCheckoutText(),"Checkout","Invalid text displayed");
        Assert.assertEquals(checkOutPage.verifyCustomerText(),"New Customer","Invalid text displayed");
        checkOutPage.clickOnGuestCheckOut();
        checkOutPage.enterFirstName("james");
        checkOutPage.enterLastName("Jhones");
        checkOutPage.enterEmail("jamesJhones@example.com");
        checkOutPage.enterTelephone("365258745");
        checkOutPage.enterAddress("3 Procter Close");
        checkOutPage.enterCity("Rugby");
        checkOutPage.enterPostcode("C2 4RT");
        checkOutPage.entercountry("222");
        checkOutPage.enterState("3603");
        checkOutPage.clickOnContinue();
        checkOutPage.addComments();
        checkOutPage.clickOnCheckBox();
        checkOutPage.checkOutContinueButton();
    }



}
