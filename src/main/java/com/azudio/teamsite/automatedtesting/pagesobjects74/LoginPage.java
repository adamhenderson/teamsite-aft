package com.azudio.teamsite.automatedtesting.pagesobjects74;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * A TeamSite Login Page
 * 
 * @version 7.4.1
 * 
 * @author adamhenderson
 *
 */
public class LoginPage {

    private final WebDriver driver;
    private final String baseURL;

    public LoginPage(final WebDriver driver, final String baseURL) {
        this.driver = driver;
        this.baseURL = baseURL;
    }

    public LoginPage navigateTo() {

        driver.get(baseURL);

        return this;

    }

    public CCProPage login(final String username, final String password, final String domain) {

        driver.findElement(By.id("iw_user")).sendKeys(username);

        driver.findElement(By.id("iw_password")).sendKeys(password);

        driver.findElement(By.id("iw_domain")).sendKeys(domain);

        WebElement loginButton = driver.findElement(By.cssSelector("a[title='Login']"));
        loginButton.click();

        return new CCProPage(driver);
    }

    public String getTitle() {
        return driver.getTitle();
    }

    public void login(final String string, final String string2, final String string3, final String string4) {

    }

}
