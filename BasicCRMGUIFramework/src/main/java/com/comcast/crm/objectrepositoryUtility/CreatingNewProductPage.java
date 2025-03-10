package com.comcast.crm.objectrepositoryUtility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreatingNewProductPage {
	
	public CreatingNewProductPage(WebDriver driver) {
		PageFactory.initElements(driver,this);
	}

	@FindBy(name ="productname")
	private WebElement pronameEdt;
	
	@FindBy(name="button")
	private WebElement saveBtn;

	public WebElement getPronameEdt() {
		return pronameEdt;
	}

	public WebElement getSaveBtn() {
		return saveBtn;
	}
	
	public void createPro(String proname) {
		pronameEdt.sendKeys(proname);
		saveBtn.click();
	}

	
}
