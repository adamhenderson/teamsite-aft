package com.azudio.teamsite.automatedtesting.pagesobjects74;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.azudio.teamsite.automatedtesting.utils.UISnoozer;

/**
 * @version 7.4.1
 * 
 * @author adamhenderson
 *
 */
public class SitePubEditPage {

    private final WebDriver driver;

    public SitePubEditPage(final WebDriver driver) {
        this.driver = driver;
    }

    public String getTitle() {
        return driver.getTitle();
    }

    public SitePubAddComponentPage clickAddComponent() {

        driver.switchTo().frame("PMCWindow");

        WebElement e = driver.findElement(By.cssSelector("a[title='Add']"));

        JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript("arguments[0].click();", e);
        e.click();

        UISnoozer.snz(1000);

        return new SitePubAddComponentPage(driver);

    }

    public SitePubEditPage clickSaveIcon() {

        System.out.println(driver.getTitle());

        driver.findElement(By.cssSelector("button[title='Save page changes']")).click();

        return this;
    }

}
