package com.comcast.crm.objectrepositoryUtility;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class DocumentPage {

	
	@FindBy(xpath = "//img[@alt='Create Document...']")
	private WebElement adddocbtn;
	

	@FindBy(name ="search_text")
	private WebElement searchtxt;

	@FindBy(name="submit")
	private WebElement searchbtn;

}
