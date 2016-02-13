package com.azudio.teamsite.automatedtesting.pagesobjects74;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.azudio.teamsite.automatedtesting.utils.UISnoozer;

/**
 * Represents the SitePublisher New Page screen
 * 
 * @version 7.4.1
 * 
 * @author adamhenderson
 *
 */
public class SitePubNewPage {

    private final WebDriver driver;

    public SitePubNewPage(final WebDriver driver) {
        this.driver = driver;
    }

    public SitePubNewPage setPageName(final String name) {

        driver.findElement(By.id("newPageName")).sendKeys(name);

        return this;
    }

    public String getTitle() {
        return driver.getTitle();
    }

    public SitePubNewPage setPageType(final String pageType) {

        WebElement e = driver.findElement(By.cssSelector("select[name='pageType']"));

        Select clickThis = new Select(e);
        clickThis.selectByVisibleText(pageType);

        return this;
    }

    public SitePubNewPage setLayoutType(final String layoutType) {

        WebElement e = driver.findElement(By.cssSelector("select[name='layout']"));

        Select clickThis = new Select(e);
        clickThis.selectByVisibleText(layoutType);

        return this;
    }

    public SitePubEditPage proceed() {

        driver.findElement(By.id("nextButton")).click();

        UISnoozer.snz(1000);

        for (String handle : driver.getWindowHandles()) {
            driver.switchTo().window(handle);
        }

        return new SitePubEditPage(driver);
    }
}
