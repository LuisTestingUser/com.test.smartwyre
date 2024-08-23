package com.smartwyre.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class homePage {

    private WebDriver driver;

    public homePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//*[contains(text(), 'The Free Encyclopedia')]")
    public WebElement Heading;

    @FindBy(id = "searchLanguage")
    public WebElement LanguageDropDown;

    @FindBy(id = "searchInput")
    public WebElement SearchTextField;

    @FindBy(xpath = "//button[@class='pure-button pure-button-primary-progressive' and contains(., 'Search')]")
    public  WebElement SearchButton;

    public void selectLanguage(String language) {
        Select select = new Select(LanguageDropDown);
        select.selectByVisibleText(language);
    }
}
