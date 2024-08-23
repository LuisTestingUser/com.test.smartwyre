package com.smartwyre.utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import java.time.Duration;

public class actions  {

    private WebDriver driver;

    public actions(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public WebDriver openBrowser() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--incognito");
        WebDriver driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.get("https://www.wikipedia.org/");

        return driver;
    }

    public String getText(WebElement element) {
       WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10) );// Adjust timeout as needed
        wait.until(ExpectedConditions.visibilityOf(element));
        return element.getText();
    }

    public void assertElementText(String expectedText, String actualText) {
        Assert.assertEquals(actualText, expectedText, "actual text does not match expected value");
    }

    public void waitForElement( WebElement element) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10)); // Adjust timeout as needed
        wait.until(ExpectedConditions.or(
                ExpectedConditions.visibilityOf(element),
                ExpectedConditions.elementToBeClickable(element)
        ));
    }
    public void sendKeysToVisibleElement(WebElement element, String text) {
        waitForElement(element);
        element.sendKeys(text);
    }
}

