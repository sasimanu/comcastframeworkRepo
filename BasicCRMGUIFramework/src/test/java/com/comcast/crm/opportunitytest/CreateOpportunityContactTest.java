package com.comcast.crm.opportunitytest;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.comcast.crm.baseclasstest.BaseClass;
import com.comcast.crm.objectrepositoryUtility.ContactInfoPage;
import com.comcast.crm.objectrepositoryUtility.ContactsPage;
import com.comcast.crm.objectrepositoryUtility.CreatingNewContactPage;
import com.comcast.crm.objectrepositoryUtility.CreatingNewOpportunityPage;
import com.comcast.crm.objectrepositoryUtility.CreatingNewOrganizationPage;
import com.comcast.crm.objectrepositoryUtility.CreatingNewProductPage;
import com.comcast.crm.objectrepositoryUtility.CreatingNewTicketPage;
import com.comcast.crm.objectrepositoryUtility.HomePage;
import com.comcast.crm.objectrepositoryUtility.OpportunitiesPage;
import com.comcast.crm.objectrepositoryUtility.OpportunityInfoPage;
import com.comcast.crm.objectrepositoryUtility.OrganizationInfoPage;
import com.comcast.crm.objectrepositoryUtility.OrganizationsPage;
import com.comcast.crm.objectrepositoryUtility.ProductInfoPage;
import com.comcast.crm.objectrepositoryUtility.ProductsPage;
import com.comcast.crm.objectrepositoryUtility.TroubleTicketInfoPage;
import com.comcast.crm.objectrepositoryUtility.TroubleTicketsPage;

public class CreateOpportunityContactTest extends BaseClass {

	@Test
	public void createOpportunityContactTest() throws Throwable {

		// read data from excel file
		String lastname = eLib.getDataFromExcelFile("opportunites", 4, 4) + jLib.getRandomNumber();
		String oppname = eLib.getDataFromExcelFile("opportunites", 4, 2) + jLib.getRandomNumber();

		// navigate to contact module
		HomePage hp = new HomePage(driver);
		hp.getConLink().click();

		// click on create new contack button
		ContactsPage cp = new ContactsPage(driver);
		cp.getCreateNewContactBtn().click();

		// fill the details and click save button
		CreatingNewContactPage cnp = new CreatingNewContactPage(driver);
		cnp.createCon(lastname);

		// validation with header message
		ContactInfoPage cip = new ContactInfoPage(driver);
		String headerInfo = cip.getHeaderInfo().getText();
		boolean status =headerInfo.contains(lastname);
		Assert.assertTrue(status);
		
		// Navigate to opportunity module
		hp.getOppoLink().click();

		// click on create new opportunity button
		OpportunitiesPage op = new OpportunitiesPage(driver);
		op.getCreateNewOpportunityBtn().click();

		// fill the deatils
		CreatingNewOpportunityPage cno = new CreatingNewOpportunityPage(driver);
		cno.createOppo(oppname, "Contacts");

		// switch child window
		wLib.switchToTabOnURL(driver, "module=Contact&action");

		// search and select contact
		cp.getSearchEdt().sendKeys(lastname);
		cp.getSearchBtn().click();
		driver.findElement(By.xpath("//a[contains(text(),'" + lastname + "')]")).click();

		// switch parent window
		wLib.switchToTabOnURL(driver, "module=Potentials&action");
		cno.getSaveBtn().click();

		// validation with header message
		OpportunityInfoPage oip = new OpportunityInfoPage(driver);
		String headInfo = oip.getHeaderInfo().getText();
		boolean sta =headInfo.contains(oppname);
		Assert.assertTrue(sta);

		// validation with contact name
		String actcon = oip.getContactInfo().getText();
		SoftAssert assertobj=new SoftAssert();
		assertobj.assertEquals(lastname, actcon);

	}

	@Test
	public void createOpportunityOrgTest() throws Throwable {

		// read data from excel file
		String orgname = eLib.getDataFromExcelFile("opportunites", 1, 3) + jLib.getRandomNumber();
		String oppname = eLib.getDataFromExcelFile("opportunites", 1, 2) + jLib.getRandomNumber();

		// Navigate to organization module
		HomePage hp = new HomePage(driver);
		hp.getOrgLink().click();

		// click on create organization button
		OrganizationsPage op = new OrganizationsPage(driver);
		op.getCreateNewOrgBtn().click();

		// enter all the details & click on save button---create new organization
		CreatingNewOrganizationPage cnop = new CreatingNewOrganizationPage(driver);
		cnop.createOrg(orgname);

		// Verify Header msg Expected Result
		OrganizationInfoPage oip = new OrganizationInfoPage(driver);
		String headerInfo = oip.getHeaderMsg().getText();
		if (headerInfo.contains(orgname)) {
			System.out.println(orgname + "is created ==PASS");
		} else {
			System.out.println(orgname + "is created ==FAIL");
		}

		// navigate to opportunity module
		hp.getOppoLink().click();

		// click on create new opportunity button
		OpportunitiesPage opp = new OpportunitiesPage(driver);
		opp.getCreateNewOpportunityBtn().click();

		// fill the details and click on add button
		CreatingNewOpportunityPage cop = new CreatingNewOpportunityPage(driver);
		cop.createOppo(oppname);

		// switch to child window
		wLib.switchToTabOnURL(driver, "module=Accounts&action");

		// search organame and click
		op.getSearchEdt().sendKeys(orgname);
		op.getSearchBtn().click();
		driver.findElement(By.xpath("//a[text()='" + orgname + "']")).click();

		// switch to parent window
		wLib.switchToTabOnURL(driver, "module=Potentials&action");
		cop.getSaveBtn().click();

		// validation with header info
		OpportunityInfoPage opip = new OpportunityInfoPage(driver);
		String headInfo = opip.getHeaderInfo().getText();
		boolean status =headInfo.contains(oppname);
		Assert.assertTrue(status);
		
		// validation with orgname
		String actorg = opip.getOrgInfo().getText();
		SoftAssert assertobj =new SoftAssert();
		assertobj.assertEquals(actorg, orgname);
	}

	@Test
	public void createProduct() throws Throwable {

		// read data from excel file
		String proname = eLib.getDataFromExcelFile("product", 1, 3) + jLib.getRandomNumber();
		// navigate to products module
		HomePage hp = new HomePage(driver);
		hp.getProLink().click();

		// click on create new product button
		ProductsPage pp = new ProductsPage(driver);
		pp.getCreateproBtn().click();

		// fill the details and click save
		CreatingNewProductPage cpp = new CreatingNewProductPage(driver);
		cpp.createPro(proname);

		// validation with header Message
		ProductInfoPage pip = new ProductInfoPage(driver);
		String headInfo = pip.getHeaderInfo().getText();
		boolean stat =headInfo.contains(proname);
		Assert.assertTrue(stat);

	}

	@Test
	public void createTroubleTicket() throws Throwable {
		// read data from excel file
		String titlename = eLib.getDataFromExcelFile("product", 4, 3) + jLib.getRandomNumber();
		
		// navigate to trouble tickets module
		HomePage hp = new HomePage(driver);
		hp.getTrolink().click();

		// click on new create trouble ticket
		TroubleTicketsPage ttp = new TroubleTicketsPage(driver);
		ttp.getCreateTTBtn().click();

		// fill the details and click save button
		CreatingNewTicketPage ctp = new CreatingNewTicketPage(driver);
		ctp.createtrouble(titlename);

		// validation with headerInfo
		TroubleTicketInfoPage ttip = new TroubleTicketInfoPage(driver);
		String headInfo = ttip.getHeaderinfo().getText();
		boolean status =headInfo.contains(titlename);
		Assert.assertTrue(status);
	}
}
