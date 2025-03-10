package com.comcast.crm.objectrepositoryUtility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactInfoPage {

	public ContactInfoPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="mouseArea_Last Name")
	private WebElement lastnameInfo;

	@FindBy(xpath = "//span[@class='dvHeaderText']")
	private WebElement headerInfo;
	
	@FindBy(id="mouseArea_Organization Name")
	private WebElement orgInfo;
	
	@FindBy(id="mouseArea_Support Start Date")
	private WebElement startDateInfo;

	public WebElement getHeaderInfo() {
		return headerInfo;
	}

	public WebElement getOrgInfo() {
		return orgInfo;
	}

	public WebElement getStartDateInfo() {
		return startDateInfo;
	}

	public WebElement getLastnameInfo() {
		return lastnameInfo;
	}
	
	
	
}
