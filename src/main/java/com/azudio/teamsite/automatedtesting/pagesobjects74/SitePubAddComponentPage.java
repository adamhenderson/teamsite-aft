package com.azudio.teamsite.automatedtesting.pagesobjects74;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * @version 7.4.1
 * 
 * @author adamhenderson
 *
 */
public class SitePubAddComponentPage {

    private final WebDriver driver;

    private final String editPageHandle;

    public SitePubAddComponentPage(final WebDriver driver) {
        this.driver = driver;
        editPageHandle = driver.getWindowHandle();
        switchToPageByTitle("Add Components");
    }

    public String getTitle() {
        return driver.getTitle();
    }

    public SitePubAddComponentPage select(final String name) {

        WebDriverWait wait = new WebDriverWait(driver, 1);

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText(name)));

        driver.findElement(By.linkText(name)).click();

        if (driver.findElement(By.id("addItemMessage")).getText() != "") {

            wait = new WebDriverWait(driver, 10);

            wait.until(ExpectedConditions.not(ExpectedConditions.textToBePresentInElementLocated(By.id("addItemMessage"), "Adding")));
        }

        return this;
    }

    public SitePubAddComponentPage switchToPageByTitle(final String title) {
        for (String handle : driver.getWindowHandles()) {

            driver.switchTo().window(handle);

            System.out.println(driver.getTitle());

            if (driver.getTitle().equals(title)) {
                break;
            }

        }
        return null;
    }

    public void clickCloseButton() {

        if (driver.findElement(By.id("addItemMessage")).getText() != "") {
            WebDriverWait wait = new WebDriverWait(driver, 10);

            wait.until(ExpectedConditions.not(ExpectedConditions.textToBePresentInElementLocated(By.id("addItemMessage"), "Adding")));

        }

        driver.findElement(By.cssSelector("a[title='Close']")).click();
        driver.switchTo().window(editPageHandle);
    }
}
