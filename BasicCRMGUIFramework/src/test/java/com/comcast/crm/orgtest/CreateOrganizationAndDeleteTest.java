package com.comcast.crm.orgtest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import com.comcast.crm.generic.fileutility.ExcelUtility;
import com.comcast.crm.generic.fileutility.FileUtility;
import com.comcast.crm.generic.webdriverutility.JavaUtility;
import com.comcast.crm.generic.webdriverutility.WebDriverUtility;
import com.comcast.crm.objectrepositoryUtility.CreatingNewOrganizationPage;
import com.comcast.crm.objectrepositoryUtility.HomePage;
import com.comcast.crm.objectrepositoryUtility.LoginPage;
import com.comcast.crm.objectrepositoryUtility.OrganizationInfoPage;
import com.comcast.crm.objectrepositoryUtility.OrganizationsPage;

public class CreateOrganizationAndDeleteTest {

	public static void main(String[] args) throws Throwable {

		FileUtility fLib = new FileUtility();
		ExcelUtility eLib = new ExcelUtility();
		JavaUtility jLib = new JavaUtility();
		WebDriverUtility wLib = new WebDriverUtility();

		// read data from property file
		String URL = fLib.getDataFromPropertiesFile("url");
		String BROWSER = fLib.getDataFromPropertiesFile("browser");
		String USERNAME = fLib.getDataFromPropertiesFile("username");
		String PASSWORD = fLib.getDataFromPropertiesFile("password");

		// read data from excel file
		String orgname = eLib.getDataFromExcelFile("org", 10, 2) + jLib.getRandomNumber();

		WebDriver driver = null;
		if (BROWSER.equals("chrome")) {
			driver = new ChromeDriver();
		} else if (BROWSER.equals("edge")) {
			driver = new EdgeDriver();
		} else {
			driver = new FirefoxDriver();
		}

		wLib.waitForPageToLoad(driver);
		
		//Login to App
		LoginPage lp =new LoginPage(driver);
		lp.loginToApp(URL,USERNAME, PASSWORD);
		
		//Navigate to organization module
		HomePage hp =new HomePage(driver);
		hp.getOrgLink().click();
		
		//click on create organization button
		OrganizationsPage op=new OrganizationsPage(driver);
		op.getCreateNewOrgBtn().click();
		
		//enter all the details & click on save button---create new organization
		CreatingNewOrganizationPage cnop =new CreatingNewOrganizationPage(driver);
		cnop.createOrg(orgname);

		// Verify Header msg Expected Result
		OrganizationInfoPage oip =new OrganizationInfoPage(driver);
		String headerInfo = oip.getHeaderMsg().getText();
		if (headerInfo.contains(orgname)) {
			System.out.println(orgname + " is created ==PASS");
		} else {
			System.out.println(orgname + " is created ==FAIL");
		}
		//Thread.sleep(1000);
		
		//go to organization link
		hp.getOrgLink().click();
		
		//search for organization
		op.searchOrg(orgname);
		
		driver.findElement(By.xpath("//a[text() ='"+orgname+"']/../../td[8]/a[text()='del']")).click();
		wLib.switchToAlertAndAccept(driver);
		
		
		// Logout
		hp.logout();

		driver.quit();

	}

}
