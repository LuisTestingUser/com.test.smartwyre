package com.smartwyre.tests;

import com.smartwyre.pages.homePage;
import com.smartwyre.pages.resultPage;
import com.smartwyre.utils.actions;
import com.smartwyre.utils.data;
import org.openqa.selenium.WebDriver;;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class wikipediaTests {

    WebDriver driver;
    actions actions = new actions(driver);
    homePage home;
    resultPage result;



    @BeforeClass
    public void OpeningBrowser() {
        driver = actions.openBrowser();
    }

    @Test(priority = 1)
    public void VerifyHeadingIsDisplayed() {
        System.out.println("Running Test -> Heading");
        home = new homePage(driver);
        actions.assertElementText(data.HOMEPAGE_HEADING,actions.getText(home.Heading));
    }

    @Test(priority = 2)
    public void SelectAnotherLanguage() {
        System.out.println("Running Test -> Changing Language");
        home = new homePage(driver);
        home.LanguageDropDown.click();
        home.selectLanguage(data.LANGUAGE);
    }

    @Test(priority = 3)
    public void EnterTextAndSearch() {
        System.out.println("Running Test -> Enter text on the text field and search");
        home = new homePage(driver);
        actions.sendKeysToVisibleElement( home.SearchTextField,data.INPUT_SEARCH);
        home.SearchButton.click();
    }
    @Test(priority = 4)
    public void ScrollDownToFindElement() {
        System.out.println("Running Test -> Scroll Down to Find Element");
        result = new resultPage(driver);
        result.scrollToText(data.SCROLL_FIND_TEXT);
    }

    @AfterSuite
    public void CloseBrowser() {
        driver.quit();
    }
}
