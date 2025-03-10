package com.comcast.crm.objectrepositoryUtility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OpportunityInfoPage {

	public OpportunityInfoPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath="//span[@class='dvHeaderText']")
	private WebElement headerInfo;
	
	@FindBy(xpath ="//a[@title='Contacts']")
	private WebElement contactInfo;
	
	@FindBy(xpath ="//a[@title='Organizations']")
	private WebElement orgInfo;

	public WebElement getOrgInfo() {
		return orgInfo;
	}

	public WebElement getHeaderInfo() {
		return headerInfo;
	}

	public WebElement getContactInfo() {
		return contactInfo;
	}
	
	
}
