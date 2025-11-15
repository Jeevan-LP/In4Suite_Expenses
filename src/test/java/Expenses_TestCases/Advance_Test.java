package Expenses_TestCases;

import org.openqa.selenium.WebElement;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import Expenses_SingleExecution_Object.Advance_Object;
import Utilities.ApplicationScript;
import Utilities.BaseClass;

//@Listeners(Utilities.ExtentReportManager.class)
public class Advance_Test extends BaseClass {
	
	public ApplicationScript application;
	public Advance_Object AdvObject;

	@Test(priority = 2)
	public void AdvanceCreateTest() throws Throwable {
		
		///Application login
		application = new ApplicationScript();
		application.loginTest();
		
		//AdvObject = new Advance_Object(getDriver());
		//AdvObject.CreateAdvance();
		Thread.sleep(3000);
		
		browserDriver.quit();
		System.out.println("IN4 Suite Browser quit");
		///Application logout
		//application.logoutTest();
	}
	
}
