package Expenses_TestCases;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import Expenses_SingleExecution_Object.WorkOrder_Object;
import Utilities.Application;
import Utilities.BaseClass;

//@Listeners(Utilities.ExtentReportManager.class)
public class WorkOrder_Test extends BaseClass {
    
	public Application application;
    WorkOrder_Object WoObject;

    @Test(priority = 2)
    public void WOCreateTest() throws Throwable {
    	
    	///Application login
    	application = new Application();
    	application.loginTest();
    			
    	WoObject = new WorkOrder_Object(getDriver());
    	WoObject.CreateExpenseWO();
    	
    	///Application logout
    	application.logoutTest();
    }
}

