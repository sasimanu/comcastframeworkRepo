package com.comcast.crm.objectrepositoryUtility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	WebDriver driver;
	public HomePage(WebDriver driver) {
		this.driver =driver;
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(linkText = "Documents")
	private WebElement docLink;
	
	public WebElement getDocLink() {
		return docLink;
	}

	public void setDocLink(WebElement docLink) {
		this.docLink = docLink;
	}

	@FindBy(linkText="Organizations")
	private WebElement orgLink;
	
	@FindBy(linkText ="Contacts")
	private WebElement conLink;
	
	public WebElement getOppoLink() {
		return oppoLink;
	}

	@FindBy(linkText ="Opportunities")
	private WebElement oppoLink;
	
	@FindBy(linkText="Products")
	private WebElement proLink;
	
	@FindBy(linkText="Trouble Tickets")
	private WebElement trolink;
	
	public WebElement getTrolink() {
		return trolink;
	}

	public WebElement getProLink() {
		return proLink;
	}

	@FindBy(xpath = "//img[@src='themes/softed/images/user.PNG']")
	private WebElement adminImg;
	
	@FindBy(linkText = "Sign Out")
	private WebElement signoutBtn;

	public WebElement getOrgLink() {
		return orgLink;
	}

	public WebElement getConLink() {
		return conLink;
	}
	
	public WebElement getAdminImg() {
		return adminImg;
	}

	public WebElement getSignoutBtn() {
		return signoutBtn;
	}
	
	public void logout() {
		Actions action=new Actions(driver);
		action.moveToElement(adminImg).perform();;
		signoutBtn.click();
	}

}
