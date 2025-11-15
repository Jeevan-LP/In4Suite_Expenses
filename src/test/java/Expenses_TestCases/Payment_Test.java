package Expenses_TestCases;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import Expenses_SingleExecution_Object.Payment_Object;
import Utilities.ApplicationScript;
import Utilities.BaseClass;

//@Listeners(Utilities.ExtentReportManager.class)
public class Payment_Test extends BaseClass{

	public ApplicationScript application;
	public Payment_Object PayObject;
	
	@Test(priority = 2)
	public void PaymentCreateTest() throws Throwable {
		
		///Application login
		application = new ApplicationScript();
		application.loginTest();
		
		PayObject = new Payment_Object(getDriver());
		PayObject.CreatePayment();
		
		///Application logout
		application.logoutTest();
	}
}
