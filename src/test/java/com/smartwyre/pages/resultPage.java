package com.smartwyre.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class resultPage {
    private WebDriver driver;

    public resultPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public WebElement findText( String text) {
        return driver.findElement(By.xpath("//*[contains(text(), '" + text + "')]"));
    }

    public void scrollToText(String text) {
        WebElement element = findText(text);
        if (element != null) {
            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("arguments[0].scrollIntoView(true);", element);
        } else {
            System.out.println("Element with text '" + text + "' not found.");
        }
    }

}
