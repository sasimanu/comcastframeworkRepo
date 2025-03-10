package com.comcast.crm.objectrepositoryUtility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class OrganizationsPage {

	public OrganizationsPage(WebDriver driver) {
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(xpath = "//img[@title='Create Organization...']")
	private WebElement createNewOrgBtn;
	
	@FindBy(name="search_text")
	private WebElement searchForText;
	
	public WebElement getSearchForText() {
		return searchForText;
	}

	public WebElement getInDD() {
		return inDD;
	}

	public WebElement getSearchNowBtn() {
		return searchNowBtn;
	}

	@FindBy(id="bas_searchfield")
	private WebElement inDD;
	
	@FindBy(name="submit")
	private WebElement searchNowBtn;
	
	@FindBy(id="search_txt")
	private WebElement searchEdt;
	
	@FindBy(name="search")
	private WebElement searchBtn;

	public WebElement getSearchEdt() {
		return searchEdt;
	}

	public WebElement getSearchBtn() {
		return searchBtn;
	}

	public WebElement getCreateNewOrgBtn() {
		return createNewOrgBtn;
	}
	
	public void searchOrg(String orgname) {
		searchForText.sendKeys(orgname);
		Select sel =new Select(inDD);
		sel.selectByVisibleText("Organization Name");
		searchNowBtn.click();
		
	}
	
	
}
