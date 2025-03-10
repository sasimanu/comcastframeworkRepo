package com.comcast.crm.objectrepositoryUtility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class CreatingNewOpportunityPage {

	public CreatingNewOpportunityPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(name="potentialname")
	private WebElement oppNameEdt;
	
	@FindBy(id="related_to_type")
	private WebElement relatedDD;
	
	@FindBy(xpath="//input[@id='related_to_display']/following-sibling::img")
	private WebElement addBtn;

	@FindBy(name="button")
	private WebElement saveBtn;

	public WebElement getOppNameEdt() {
		return oppNameEdt;
	}

	public WebElement getRelatedDD() {
		return relatedDD;
	}

	public WebElement getAddBtn() {
		return addBtn;
	}

	public WebElement getSaveBtn() {
		return saveBtn;
	}
	
	public void createOppo(String opponame,String realtedname) {
		oppNameEdt.sendKeys(opponame);
		Select sel =new Select(relatedDD);
		sel.selectByVisibleText(realtedname);
		addBtn.click();
		
	}
	public void createOppo(String opponame) {
		oppNameEdt.sendKeys(opponame);
		addBtn.click();
	}
}
