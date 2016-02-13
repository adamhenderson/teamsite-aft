package com.azudio.teamsite.automatedtesting.tests;

import static org.junit.Assert.assertEquals;

import java.util.Date;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.azudio.teamsite.automatedtesting.pagesobjects74.CCProPage;
import com.azudio.teamsite.automatedtesting.pagesobjects74.CCProPage.ContentTab;
import com.azudio.teamsite.automatedtesting.pagesobjects74.LoginPage;
import com.azudio.teamsite.automatedtesting.pagesobjects74.SitePubAddComponentPage;
import com.azudio.teamsite.automatedtesting.pagesobjects74.SitePubEditPage;
import com.azudio.teamsite.automatedtesting.pagesobjects74.SitePubNewPage;

public class TeamSiteDCRTest {

    private static String baseURL = "http://localhost/iw-cc/command/iw.ui";

    String username, password, domain;

    @Before
    private void set() {
        username = System.getProperty("username");
        password = System.getProperty("password");
        domain = System.getProperty("domain");
    }

    @Test
    public void LoggingInToTeamSite() {

        WebDriver driver = new FirefoxDriver();

        LoginPage loginPage = new LoginPage(driver, baseURL);

        loginPage.navigateTo();

        assertEquals("Login", loginPage.getTitle());

        CCProPage ccProPage = loginPage.login(username, password, domain);

        assertEquals("ContentCenter Professional", ccProPage.getTitle());

        driver.close();

        driver.quit();
    }

    @Test
    public void testNavigatingToVPath() {

        WebDriver driver = new FirefoxDriver();

        LoginPage loginPage = new LoginPage(driver, baseURL);

        loginPage.navigateTo();

        assertEquals("Login", loginPage.getTitle());

        CCProPage ccProPage = loginPage.login(username, password, domain);

        assertEquals("ContentCenter Professional", ccProPage.getTitle());

        ccProPage.navigateToContentTab().navigateToVPath("/default/main");

        driver.close();

        driver.quit();
    }

    @Test
    public void testCreateNewSitePublisherPage() {

        WebDriver driver = new FirefoxDriver();

        LoginPage loginPage = new LoginPage(driver, baseURL);

        loginPage.navigateTo();

        CCProPage ccProPage = loginPage.login(username, password, domain);

        ContentTab contentTab = ccProPage.navigateToContentTab();

        contentTab.navigateToVPath("/default/main/lab/WORKAREA/main-wa/sites/AFT");

        SitePubNewPage sitePubNewPage = contentTab.clickNewPageMenuItem();

        SitePubEditPage sitePubEditPage = sitePubNewPage.setPageName("AFTTest_" + new Date().getTime()).setPageType("HTML 5").setLayoutType("Freestyle - Div").proceed();

        SitePubAddComponentPage sitePubAddComponentPage = sitePubEditPage.clickAddComponent();

        sitePubAddComponentPage.select("Interwoven").select("Marketing").select("Content").select("Basic Content").clickCloseButton();

        sitePubEditPage.clickSaveIcon();

        driver.quit();

    }

}
