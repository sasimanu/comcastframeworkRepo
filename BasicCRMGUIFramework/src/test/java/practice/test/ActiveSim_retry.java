package practice.test;

import org.testng.Assert;
import org.testng.annotations.Test;

public class ActiveSim_retry {
	
	@Test(retryAnalyzer = com.comcast.crm.generic.listenerutility.RetryListenerImp.class)
	public void activatesim() {
		System.out.println("excute start");
		Assert.assertEquals("", "Login");
		System.out.println("step-1");
		System.out.println("excute end");
	}
	

}
