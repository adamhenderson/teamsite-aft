package com.azudio.teamsite.automatedtesting.pagesobjects74;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.azudio.teamsite.automatedtesting.utils.UISnoozer;

/**
 * The TeamSite CCPro Page
 * 
 * @version 7.4.1
 * 
 * @author adamhenderson
 *
 */
public class CCProPage {

	private WebDriver driver;

	private ContentTab contentTab = null;

	public CCProPage(WebDriver driver) {
		this.driver = driver;

		navigateToContentTab();
	}

	public ContentTab navigateToContentTab() {

		driver.get("http://localhost/iw-cc/command/iw.ccpro.filesys");

		if (contentTab == null) contentTab = new ContentTab();

		return contentTab;
	}

	public class ContentTab {
		public ContentTab navigateToVPath(String vpath) {

			driver.findElement(By.id("fs_location_external")).clear();

			driver.findElement(By.id("fs_location_external")).sendKeys(vpath);

			driver.findElement(By.id("fs_navigate_to_location_bar")).click();

			// TS HACK: This sleep allows TeamSite to catch up if navigating from another VPath as it may need to update menu items etc.
			// -------: Need to look at the DriverWait API
			UISnoozer.snz(1000);

			return this;
		}

		public SitePubNewPage clickNewPageMenuItem() {

			driver.findElement(By.cssSelector("a[title='File']")).click();

			WebElement e = driver.findElement(By.cssSelector("a[title='New Page']"));

			JavascriptExecutor executor = (JavascriptExecutor) driver;
			executor.executeScript("arguments[0].click();", e);
			e.click();

			return new SitePubNewPage(switchToPageByTitle("New Page"));

		}
	}

	public String getTitle() {
		return driver.getTitle();
	}

	public WebDriver switchToPageByTitle(String title) {
		for (String handle : driver.getWindowHandles()) {

			WebDriver d = driver.switchTo().window(handle);

			System.out.println(d.getTitle());

			if (d.getTitle().equals(title)) {
				return d;
			}

		}
		return null;
	}

}
