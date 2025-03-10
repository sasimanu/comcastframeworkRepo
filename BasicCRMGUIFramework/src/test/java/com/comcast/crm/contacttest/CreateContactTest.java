package com.comcast.crm.contacttest;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.aventstack.extentreports.Status;
import com.comcast.crm.baseclasstest.BaseClass;
import com.comcast.crm.generic.webdriverutility.UtilityClassObject;
import com.comcast.crm.objectrepositoryUtility.ContactInfoPage;
import com.comcast.crm.objectrepositoryUtility.ContactsPage;
import com.comcast.crm.objectrepositoryUtility.CreatingNewContactPage;
import com.comcast.crm.objectrepositoryUtility.CreatingNewOrganizationPage;
import com.comcast.crm.objectrepositoryUtility.HomePage;
import com.comcast.crm.objectrepositoryUtility.OrganizationInfoPage;
import com.comcast.crm.objectrepositoryUtility.OrganizationsPage;
@Listeners(com.comcast.crm.generic.listenerutility.ListenerImp.class)
public class CreateContactTest extends BaseClass {

	@Test(groups = "smokeTest")
	public void createContactTest() throws Throwable {
		UtilityClassObject.getDriver().log(Status.INFO,"read data from excelfile");
		// read data from excel file
		String lastname = eLib.getDataFromExcelFile("contact", 1, 2) + jLib.getRandomNumber();

		UtilityClassObject.getDriver().log(Status.INFO,"navigate to contact module");
		// navigate to contact module
		HomePage hp = new HomePage(driver);
		hp.getConLink().click();

		UtilityClassObject.getDriver().log(Status.INFO,"click on contact button");
		// click on create new contact button
		ContactsPage cp = new ContactsPage(driver);
		cp.getCreateNewContactBtn().click();

		UtilityClassObject.getDriver().log(Status.INFO,"creating contact");
		// fill the details and click on save button
		CreatingNewContactPage cnc = new CreatingNewContactPage(driver);
		cnc.createCon(lastname);

		UtilityClassObject.getDriver().log(Status.PASS,lastname +"created");
		// validation with header message
		ContactInfoPage cip = new ContactInfoPage(driver);
		String headerInfo = cip.getHeaderInfo().getText();
		boolean status = headerInfo.contains(lastname);
		Assert.assertTrue(status);

		// validation with lastname
		String lastnameInfo = cip.getLastnameInfo().getText();
		boolean sta = lastnameInfo.contains(lastname);
		SoftAssert assertobj = new SoftAssert();
		assertobj.assertTrue(sta);
		assertobj.assertAll();
	}

	@Test(groups = "regressionTest")
	public void createContactwithOrganizationnameTest() throws Throwable {

		UtilityClassObject.getDriver().log(Status.INFO,"read data from excel");
		// read data from excel file
		String orgname = eLib.getDataFromExcelFile("org", 7, 2) + jLib.getRandomNumber();
		String lastname = eLib.getDataFromExcelFile("contact", 1, 2) + jLib.getRandomNumber();

		UtilityClassObject.getDriver().log(Status.INFO,"navigate to org module");
		// Navigate to organization module
		HomePage hp = new HomePage(driver);
		hp.getOrgLink().click();

		UtilityClassObject.getDriver().log(Status.INFO,"click on org button");
		// click on create organization button
		OrganizationsPage op = new OrganizationsPage(driver);
		op.getCreateNewOrgBtn().click();

		UtilityClassObject.getDriver().log(Status.INFO,"creating orgnization");
		// enter all the details & click on save button---create new organization
		CreatingNewOrganizationPage cnop = new CreatingNewOrganizationPage(driver);
		cnop.createOrg(orgname);

		UtilityClassObject.getDriver().log(Status.PASS,orgname+"created");
		// Verify Header msg Expected Result
		OrganizationInfoPage oip = new OrganizationInfoPage(driver);
		String headerInfo = oip.getHeaderMsg().getText();
		boolean sta = headerInfo.contains(orgname);
		Assert.assertEquals(sta, true);

		UtilityClassObject.getDriver().log(Status.INFO,"navigating to contact module");
		// navigate to contact module
		hp.getConLink().click();

		UtilityClassObject.getDriver().log(Status.INFO,"click on contact button");
		// click on create new contact button
		ContactsPage cp = new ContactsPage(driver);
		cp.getCreateNewContactBtn().click();

		UtilityClassObject.getDriver().log(Status.INFO,"creating contact");
		// fill the details and click on save button
		CreatingNewContactPage cnc = new CreatingNewContactPage(driver);
		cnc.getLastNameEdt().sendKeys(lastname);
		cnc.getAddOrgBtn().click();

		// Switch to child window
		wLib.switchToTabOnURL(driver, "Accounts&action");

		op.getSearchEdt().sendKeys(orgname);
		op.getSearchBtn().click();
		driver.findElement(By.xpath("//a[text()='" + orgname + "']")).click();

		// switch to parent window
		wLib.switchToTabOnURL(driver, "Contacts&action");

		cnc.getSaveBtn().click();
		UtilityClassObject.getDriver().log(Status.PASS,lastname +"created");

		// validation with header message
		ContactInfoPage cip = new ContactInfoPage(driver);
		String conheaderInfo = cip.getHeaderInfo().getText();
		boolean stat = conheaderInfo.contains(lastname);
		Assert.assertTrue(stat);

		// validation of orgname
		String actorg = cip.getOrgInfo().getText();
		boolean status = actorg.contains(orgname);
		Assert.assertEquals(status, true);
	}

	@Test(groups = "regressionTest")
	public void createContactwithSupportDateTest() throws Throwable {

		UtilityClassObject.getDriver().log(Status.INFO,"read data from excel");
		// read data from excel file
		String lastname = eLib.getDataFromExcelFile("contact", 1, 2) + jLib.getRandomNumber();

		UtilityClassObject.getDriver().log(Status.INFO,"date from javautility");
		// date from javaUtility
		String startdate = jLib.getSystemDateYYYYDDMM();
		String enddate = jLib.getRequiredDateYYYYDDMM(30);

		UtilityClassObject.getDriver().log(Status.INFO,"navigate to contact module");
		// navigate to contacts module
		HomePage hp = new HomePage(driver);
		hp.getConLink().click();
		
		UtilityClassObject.getDriver().log(Status.INFO,"click on contact button");
		// click on create new contact button
		ContactsPage cp = new ContactsPage(driver);
		cp.getCreateNewContactBtn().click();
		
		UtilityClassObject.getDriver().log(Status.INFO,"creating contact withsystemdate");
		// fill the details and click on save button
		CreatingNewContactPage cnp = new CreatingNewContactPage(driver);
		cnp.createCon(lastname, startdate, enddate);
		UtilityClassObject.getDriver().log(Status.PASS,lastname +"created");

		// validation with header message
		ContactInfoPage cip = new ContactInfoPage(driver);
		String conheaderInfo = cip.getHeaderInfo().getText();
		boolean stat = conheaderInfo.contains(lastname);
		Assert.assertTrue(stat);

		// Validation with Start Date
		String stdate = cip.getStartDateInfo().getText();
		boolean status=stdate.trim().contains(startdate);
	
		SoftAssert assertobj =new SoftAssert();
		assertobj.assertTrue(status);
	}
}
