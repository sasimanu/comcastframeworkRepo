package com.comcast.crm.objectrepositoryUtility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TroubleTicketInfoPage {

	public TroubleTicketInfoPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath ="//span[@class='dvHeaderText']")
	private WebElement headerinfo;

	public WebElement getHeaderinfo() {
		return headerinfo;
	}
	
}
