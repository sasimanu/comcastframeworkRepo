package com.comcast.crm.objectrepositoryUtility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class CreatingNewOrganizationPage {
	
	public CreatingNewOrganizationPage(WebDriver driver) {
		PageFactory.initElements(driver,this);
	}

	@FindBy(name="accountname")
	private WebElement orgNameEdt;
	
	@FindBy(id="phone")
	private WebElement phoneEdt;
	
	@FindBy(name ="button")
	private WebElement saveBtn;
	
	@FindBy(name="industry")
	private WebElement industryDD;
	
	@FindBy(name="accounttype")
	private WebElement typeDD;

	public WebElement getOrgNameEdt() {
		return orgNameEdt;
	}
	
	public WebElement getPhoneEdt() {
		return phoneEdt;
	}

	public WebElement getSaveBtn() {
		return saveBtn;
	}
	
	public WebElement getIndustryDD() {
		return industryDD;
	}

	public WebElement getTypeDD() {
		return typeDD;
	}

	public void createOrg(String orgname) {
		orgNameEdt.sendKeys(orgname);
		saveBtn.click();
	}
	
	public void createOrg(String orgname,String phonenum) {
		orgNameEdt.sendKeys(orgname);
		phoneEdt.sendKeys(phonenum);
		saveBtn.click();
	}
	
	public void createOrg(String orgname,String industry,String type) {
		orgNameEdt.sendKeys(orgname);
		Select sel =new Select(industryDD);
		sel.selectByVisibleText(industry);
		Select sel1 =new Select(typeDD);
		sel1.selectByVisibleText(type);
		saveBtn.click();
	}
}
