package com.comcast.crm.objectrepositoryUtility;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class DocumentPage {

	
	@FindBy(xpath = "//img[@alt='Create Document...']")
	private WebElement adddocbtn;
}
