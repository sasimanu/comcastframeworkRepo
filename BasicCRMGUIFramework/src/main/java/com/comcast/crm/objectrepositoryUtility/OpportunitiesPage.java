package com.comcast.crm.objectrepositoryUtility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OpportunitiesPage {

	public OpportunitiesPage(WebDriver driver) {
		PageFactory.initElements(driver, this);	
	}

	@FindBy(xpath = "//img[@src='themes/softed/images/btnL3Add.gif']")
	private WebElement createNewOpportunityBtn;

	public WebElement getCreateNewOpportunityBtn() {
		return createNewOpportunityBtn;
	}
	
	
}
