package com.tutorialsninja.testsuite;

import com.tutorialsninja.pages.*;
import com.tutorialsninja.testbase.BaseTest;
import junit.framework.Assert;
import org.testng.annotations.Test;

public class MyAccountsTest extends BaseTest {
    HomePage homePage = new HomePage();
    RegisterPage registerPage = new RegisterPage();
    Loginpage loginPage = new Loginpage();
    SuccessPage successPage = new SuccessPage();
   MyAccountPage myAccountPage = new MyAccountPage();
    LogoutPage logoutPage = new LogoutPage();
    @Test
    public void verifyUserShouldNavigateToRegisterPageSuccessfully(){
        homePage.clickOnMyAccount();
        homePage.selectMyAccountOptions("Register");
       Assert.assertEquals(registerPage.verifyRegisterAccount(), "Register Account", "Register page not displayed");
    }

    @Test
    public void verifyUserShouldNavigateToLoginPageSuccessfully(){
        homePage.clickOnMyAccount();
        homePage.selectMyAccountOptions("Login");
        Assert.assertEquals(loginPage.verifyReturningCustomer(), "Returning Customer", "Login page not displayed");
    }

    @Test
    public void verifyThatUserRegisterAccountSuccessfully(){
        homePage.clickOnMyAccount();
        homePage.selectMyAccountOptions("Register");
        registerPage.enterFirstname("Joe");
        registerPage.enterLastname("Jhones");
        registerPage.enterEmail("joejhones@example.com");
        registerPage.enterTelephone("9876543215");
        registerPage.enterPassword("joe123456");
        registerPage.enterConfirmPassword("joe123456");
        registerPage.clickOnSubscribe();
        registerPage.clickOnAgree();
        registerPage.clickOnContinue();
        Assert.assertEquals(successPage.verifyYourAccountMessage(), "Your Account Has Been Created!", "Text not displayed");
        successPage.clickOnSuccessContinueButton();
        myAccountPage.clickOnMYAccount();
        homePage.selectMyAccountOptions("Logout");
        Assert.assertEquals(logoutPage.verifyAccountLogoutText(), "Account Logout", "Not logged out");
        logoutPage.clickOnContinue();
    }

    @Test
    public void verifyThatUserShouldLoginAndLogoutSuccessfully(){
        homePage.clickOnMyAccount();
        homePage.selectMyAccountOptions("Login");
        loginPage.enterEmailId("prime123@gmail.com");
        loginPage.enterPassword("test123");
        loginPage.clickOnLoginButton();
        myAccountPage.clickOnMYAccount();
        homePage.selectMyAccountOptions("Logout");
        Assert.assertEquals(logoutPage.verifyAccountLogoutText(), "Account Logout", "Not logged out");
        logoutPage.clickOnContinue();
    }

}
