package com.comcast.crm.generic.webdriverutility;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebDriverUtility {
	// implicit wait
	public void waitForPageToLoad(WebDriver driver) {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	}

	// explicit wait
	public void waitForElementPresent(WebDriver driver, WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		wait.until(ExpectedConditions.visibilityOf(element));
	}

	// Switchto Window based on url
	public void switchToTabOnURL(WebDriver driver, String partialURL) {
		Set<String> set = driver.getWindowHandles();
		Iterator<String> it = set.iterator();
		while (it.hasNext()) {
			String windowID = it.next();
			driver.switchTo().window(windowID);

			String acturl = driver.getCurrentUrl();
			if (acturl.contains(partialURL)) {
				break;
			}

		}
	}
	// Switchto Window based on title
	public void switchToTabOnTitle(WebDriver driver,String partialTitle) {
		Set<String> set = driver.getWindowHandles();
		Iterator<String> it = set.iterator();
		while(it.hasNext()) {
			String windowID = it.next();
			driver.switchTo().window(windowID);
		
			String actTitle = driver.getTitle();
			if(actTitle.contains(partialTitle)) {
				break;
			}
		}
	}
	
	//frames
	public void switchToFrame(WebDriver driver,int index) {
		driver.switchTo().frame(index);
	}
	
	public void switchToFrame(WebDriver driver,String nameID) {
		driver.switchTo().frame(nameID);
	}
	
	public void switchToFrame(WebDriver driver,WebElement element) {
		driver.switchTo().frame(element);
	}
	
	//Alerts
	public void switchToAlertAndAccept(WebDriver driver) {
		driver.switchTo().alert().accept();
		
	}
	
	public void switchToAlertAndCancel(WebDriver driver) {
		driver.switchTo().alert().dismiss();;
		
	}
	
	//DropDown---Select
	public void select(WebElement element,String text) {
		Select sel =new Select(element);
		sel.selectByVisibleText(text);
	}
	
	public void select(WebElement element,int index) {
		Select sel =new Select(element);
		sel.selectByIndex(index);
	}
	
	//MouseMovements ----Actions
	public void mousemoveonElement(WebDriver driver,WebElement element) {
		Actions action =new Actions(driver);
		action.moveToElement(element).perform();
	}
	
	public void doubleClick(WebDriver driver,WebElement element) {
		Actions action =new Actions(driver);
		action.doubleClick(element).perform();
	}
	
	public void maximizeTheWebPage(WebDriver driver) {
		driver.manage().window().maximize();
	}
	
	public void minimizeTheWebPage(WebDriver driver) {
		driver.manage().window().minimize();
	}

}
