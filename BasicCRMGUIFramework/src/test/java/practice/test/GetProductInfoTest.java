package practice.test;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.comcast.crm.generic.fileutility.ExcelUtility;


public class GetProductInfoTest {


	@Test(dataProvider = "getData")
	public void getProductInfoTest(String Browser,String brandName,String productName) throws Throwable {
		WebDriver driver = null;
		if (Browser.equals("chrome")) {
			driver = new ChromeDriver();
		} else if (Browser.equals("edge")) {
			driver = new EdgeDriver();
		} else {
			driver = new FirefoxDriver();
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		
		driver.get("https://www.amazon.in/");
		
		driver.findElement(By.id("twotabsearchtextbox")).sendKeys(brandName,Keys.ENTER);
		
		String x="//span[contains(text(),'"+ productName +"')]/../../../../div[3]/div[1]/div/div[1]/div[1]/div[1]/a/span/span[2]/span[2]";
		String price =driver.findElement(By.xpath(x)).getText();
		
		System.out.println(price);
		
		driver.quit();
	}
	
	@DataProvider
	public Object[][] getData() throws Throwable {
		ExcelUtility eLib =new ExcelUtility();
		int rowcount = eLib.getRowCount("AmazonProducts");
		Object[][] objArr=new Object[rowcount][3];
		
		for(int i =0;i<rowcount;i++) {
		objArr[i][0]=eLib.getDataFromExcelFile("AmazonProducts", i+1, 0);
		objArr[i][1]=eLib.getDataFromExcelFile("AmazonProducts",i+1, 1);
		objArr[i][2]=eLib.getDataFromExcelFile("AmazonProducts",i+1, 2);
		}
		
		return objArr;
	}
}
