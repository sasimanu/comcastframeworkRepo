package com.comcast.crm.objectrepositoryUtility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactsPage {

	public ContactsPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//img[@src='themes/softed/images/btnL3Add.gif']")
	private WebElement createNewContactBtn;
	
	@FindBy(id="search_txt")
	private WebElement searchEdt;
	
	@FindBy(name="search")
	private WebElement searchBtn;
	

	public WebElement getCreateNewContactBtn() {
		return createNewContactBtn;
	}


	public WebElement getSearchEdt() {
		return searchEdt;
	}


	public WebElement getSearchBtn() {
		return searchBtn;
	}
	
	
}
