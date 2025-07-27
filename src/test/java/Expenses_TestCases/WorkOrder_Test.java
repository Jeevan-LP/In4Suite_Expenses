package Expenses_TestCases;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import Expenses_SingleExecution_Object.WorkOrder_Object;
import Utilities.ApplicationScript;
import Utilities.BaseClass;

//@Listeners(Utilities.ExtentReportManager.class)
public class WorkOrder_Test extends BaseClass{

	public ApplicationScript application;
	public WorkOrder_Object WorkObject;
	
	@Test(priority = 2)
	public void WorkOrderCreateTest() throws Throwable {
		
		///Application login
		application = new ApplicationScript();
		application.loginTest();
		
		WorkObject = new WorkOrder_Object(getDriver());
		WorkObject.CreateExpenseWO();
		
		///Application logout
		application.logoutTest();
	}
}
