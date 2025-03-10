package com.comcast.crm.objectrepositoryUtility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreatingNewTicketPage {

	public CreatingNewTicketPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(name="ticket_title")
	private WebElement titleEdt;
	
	@FindBy(name="button")
	private WebElement saveBtn;

	public WebElement getTitleEdt() {
		return titleEdt;
	}

	public WebElement getSaveBtn() {
		return saveBtn;
	}
	
	public void createtrouble(String titlename) {
		titleEdt.sendKeys(titlename);
		saveBtn.click();
	}
}
