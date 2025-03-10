package com.comcast.crm.orgtest;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.aventstack.extentreports.Status;
import com.comcast.crm.baseclasstest.BaseClass;
import com.comcast.crm.generic.webdriverutility.UtilityClassObject;
import com.comcast.crm.objectrepositoryUtility.CreatingNewOrganizationPage;
import com.comcast.crm.objectrepositoryUtility.HomePage;
import com.comcast.crm.objectrepositoryUtility.OrganizationInfoPage;
import com.comcast.crm.objectrepositoryUtility.OrganizationsPage;
@Listeners(com.comcast.crm.generic.listenerutility.ListenerImp.class)
public class CreateOrganizationTest extends BaseClass {

	@Test(groups = "smokeTest")
	public void createOrganizationTest() throws Throwable {
		
		UtilityClassObject.getTest().log(Status.INFO, "read data from excel");
		// read data from excel file
		String orgname = eLib.getDataFromExcelFile("org", 1, 2) + jLib.getRandomNumber();
		
		UtilityClassObject.getTest().log(Status.INFO, "navigate to org module");
		// Navigate to organization module
		HomePage hp = new HomePage(driver);
		hp.getOrgLink().click();

		UtilityClassObject.getTest().log(Status.INFO, "click on org button");
		// click on create organization button
		OrganizationsPage op = new OrganizationsPage(driver);
		op.getCreateNewOrgBtn().click();

		UtilityClassObject.getTest().log(Status.INFO, "create org");
		// enter all the details & click on save button---create new organization
		CreatingNewOrganizationPage cnop = new CreatingNewOrganizationPage(driver);
		cnop.createOrg(orgname);
		
		UtilityClassObject.getTest().log(Status.INFO, orgname+"orgnization created");
		
		// Verify Header msg Expected Result
		OrganizationInfoPage oip = new OrganizationInfoPage(driver);
		String headerInfo = oip.getHeaderMsg().getText();
		boolean status = headerInfo.contains(orgname);
		Assert.assertEquals(status, true);
	}

	@Test(groups = "regressionTest")
	public void createOrganizationWithIndustryTest() throws Throwable {
		
		UtilityClassObject.getTest().log(Status.INFO, "read data from excel");
		// read data from excel file
		String orgname = eLib.getDataFromExcelFile("org", 4, 2) + jLib.getRandomNumber();
		String industry = eLib.getDataFromExcelFile("org", 4, 3);
		String type = eLib.getDataFromExcelFile("org", 4, 4);

		UtilityClassObject.getTest().log(Status.INFO, "navigate to org module");
		// Navigate to organization module
		HomePage hp = new HomePage(driver);
		hp.getOrgLink().click();

		UtilityClassObject.getTest().log(Status.INFO, "click on org button");
		// click on create organization button
		OrganizationsPage op = new OrganizationsPage(driver);
		op.getCreateNewOrgBtn().click();

		UtilityClassObject.getTest().log(Status.INFO, "create org");
		// enter all details and click on save
		CreatingNewOrganizationPage cnop = new CreatingNewOrganizationPage(driver);
		cnop.createOrg(orgname, industry, type);
		
		UtilityClassObject.getTest().log(Status.PASS, orgname+"created");
		
		// validation with industry
		OrganizationInfoPage oip = new OrganizationInfoPage(driver);
		String indInfo = oip.getIndInfo().getText();
		boolean status = indInfo.contains(industry);
		Assert.assertEquals(status, true);

		// validation with type
		String typeInfo = oip.getTypeInfo().getText();
		boolean stat = typeInfo.trim().equals(type);
		SoftAssert assertobj = new SoftAssert();
		assertobj.assertTrue(stat);

	}

	@Test(groups = "regressionTest")
	public void createOrganizationWithPhoneNumberTest() throws Throwable {
		UtilityClassObject.getTest().log(Status.INFO, "read data from excel");
		// read data from excel file
		String orgname = eLib.getDataFromExcelFile("org", 7, 2) + jLib.getRandomNumber();
		String phonenum = eLib.getDataFromExcelFile("org", 7, 3);

		UtilityClassObject.getTest().log(Status.INFO, "navigate to org module");
		// navigating to organization module
		HomePage hp = new HomePage(driver);
		hp.getOrgLink().click();

		UtilityClassObject.getTest().log(Status.INFO, "click on org button");
		// click on create new organization button
		OrganizationsPage op = new OrganizationsPage(driver);
		op.getCreateNewOrgBtn().click();

		UtilityClassObject.getTest().log(Status.INFO, "craeting organization");
		// fill all the details and click on save button
		CreatingNewOrganizationPage cop = new CreatingNewOrganizationPage(driver);
		cop.createOrg(orgname, phonenum);

		UtilityClassObject.getTest().log(Status.PASS, orgname+"created");
		
		// Verify Header msg Expected Result
		OrganizationInfoPage oip = new OrganizationInfoPage(driver);
		String headerInfo = oip.getHeaderMsg().getText();
		boolean status = headerInfo.contains(orgname);
		Assert.assertEquals(status, true);

		// validation with phone number
		String actualphone = oip.getPhoneInfo().getText();
		boolean sta =actualphone.trim().equals(phonenum);
		SoftAssert assertobj =new SoftAssert();
		assertobj.assertTrue(sta);
	}
}
