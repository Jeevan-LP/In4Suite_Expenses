package Expenses_TestCases;

import org.testng.annotations.Test;

import Expenses_SingleExecution_Object.Advance_Object;
import Utilities.Application;
import Utilities.BaseClass;

public class Advance_Test extends BaseClass {
	
	public Application application;
	public Advance_Object AdvObject;

	@Test(priority = 2)
	public void AdvanceCreateTest() throws Throwable {
		
		///Application login
		application = new Application();
		application.loginTest();
		
		AdvObject = new Advance_Object(getDriver());
		AdvObject.CreateAdvance();
		
		///Application logout
		application.logoutTest();
	}
	
}
