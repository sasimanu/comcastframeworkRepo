package com.comcast.crm.objectrepositoryUtility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreatingNewContactPage {

	public CreatingNewContactPage(WebDriver driver) {
		
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(name="lastname")
	private WebElement lastNameEdt;
	
	@FindBy(name="button")
	private WebElement saveBtn;
	
	@FindBy(xpath="//input[@name='account_name']/following-sibling::img")
	private WebElement addOrgBtn;
	
	@FindBy(id="jscal_field_support_start_date")
	private WebElement startDateEdt;
	
	@FindBy(id="jscal_field_support_end_date")
	private WebElement endDateEdt;

	public WebElement getStartDateEdt() {
		return startDateEdt;
	}

	public WebElement getEndDateEdt() {
		return endDateEdt;
	}

	public WebElement getAddOrgBtn() {
		return addOrgBtn;
	}

	public WebElement getLastNameEdt() {
		return lastNameEdt;
	}

	public WebElement getSaveBtn() {
		return saveBtn;
	}
	
	
	public void createCon(String lastname) {
		lastNameEdt.sendKeys(lastname);
		saveBtn.click();
	}
	 public void createCon(String lastname,String startdate,String enddate) {
		 lastNameEdt.sendKeys(lastname);
		 startDateEdt.clear();
		 startDateEdt.sendKeys(startdate);
		 endDateEdt.clear();
		 endDateEdt.sendKeys(enddate);
		 saveBtn.click();
	 }
	
}
