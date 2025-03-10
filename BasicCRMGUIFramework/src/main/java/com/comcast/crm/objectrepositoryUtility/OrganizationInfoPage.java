package com.comcast.crm.objectrepositoryUtility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrganizationInfoPage {
	
	
	public OrganizationInfoPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//span[@class='dvHeaderText']")
	private WebElement headerMsg;
	
	@FindBy(id="mouseArea_Phone")
	private WebElement phoneInfo;
	
	@FindBy(id="mouseArea_Industry")
	private WebElement indInfo;
	
	@FindBy(id="mouseArea_Type")
	private WebElement typeInfo;

	public WebElement getHeaderMsg() {
		return headerMsg;
	}

	public WebElement getIndInfo() {
		return indInfo;
	}

	public WebElement getTypeInfo() {
		return typeInfo;
	}

	public WebElement getPhoneInfo() {
		return phoneInfo;
	}
	
	
	
}
