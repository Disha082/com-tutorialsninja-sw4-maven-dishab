package com.tutorialsninja.testsuite;

import com.tutorialsninja.pages.ComponentsPage;
import com.tutorialsninja.pages.DesktopsPage;
import com.tutorialsninja.pages.HomePage;
import com.tutorialsninja.pages.LaptopsAndNotebooksPage;
import com.tutorialsninja.testbase.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class HomePageTest extends BaseTest {
    HomePage homePage = new HomePage();
    DesktopsPage desktopPage = new DesktopsPage();
    LaptopsAndNotebooksPage laptopsAndNotebooksPage = new LaptopsAndNotebooksPage();
    ComponentsPage componentsPage = new ComponentsPage();

    @Test
    public void verifyUserShouldNavigateToDesktopsPageSuccessfully() {
        homePage.mouseHoverToDesktopAndClick();
        homePage.selectMenu("Show All Desktops");
        String expectedDesktopText = "Desktops";
        Assert.assertEquals(desktopPage.navigateToDesktopErrorMessage(), expectedDesktopText, "Desktops is not displayed");
    }

    @Test
    public void verifyUserShouldNavigateToLaptopsAndNotebooksPageSuccessfully() {
        homePage.mouseHoverToLaptopsNotebooksAndClick();
        homePage.selectMenu("Show All Laptops & Notebooks");
        Assert.assertEquals(laptopsAndNotebooksPage.navigateToLaptopsNotebooksErrorMessage(), "Laptops & Notebooks", "Show All Laptops & Notebooks not displayed");
    }

    @Test
    public void verifyUserShouldNavigateToComponentsPageSuccessfully() {
        homePage.mouseHoverToComponentsAndClick();
        homePage.selectMenu("Show All Components");
        Assert.assertEquals(componentsPage.navigateToComponentsErrorMessage(), "Components", "Text not displayed");
    }


}

