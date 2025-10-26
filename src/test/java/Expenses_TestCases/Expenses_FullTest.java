package Expenses_TestCases;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import Expenses_FullExecution_Object.Advance_Object;
import Expenses_FullExecution_Object.DebitNoteReceipt_Object;
import Expenses_FullExecution_Object.DebitNote_Object;
import Expenses_FullExecution_Object.Payment_Object;
import Expenses_FullExecution_Object.WorkOrder_Object;
import Utilities.ApplicationScript;
import Utilities.BaseClass;

@Listeners(Utilities.ExtentReportManager.class)
public class Expenses_FullTest extends BaseClass{

	public ApplicationScript application;
	public WorkOrder_Object WoObject;
	public Advance_Object AdvObject;
	public DebitNote_Object DbtNoteObject;
	public DebitNoteReceipt_Object DbtNoteRecObject;
	public Payment_Object PayObject;
	
	@Test(priority = 2, groups = {"ExpenseModule", "WorkOrderFlow", "CriticalWorkflowSuite"})
	public void WorkOrder() throws Throwable {
		///Application login
		application = new ApplicationScript();
		application.loginTest();
		
		WoObject = new WorkOrder_Object(getDriver());
		WoObject.CreateExpenseWO();
	}
	
	@Test(priority = 3, groups = {"ExpenseModule", "AdvanceFlow", "SmokeSuite"})
	public void Advance() throws Throwable {
		AdvObject = new Advance_Object(getDriver(), WoObject);
		AdvObject.CreateAdvance();
	}
	
	@Test(priority = 4, groups = {"ExpenseModule", "DebitNoteFlow", "RegressionSuite1"})
	public void DebitNote() throws Throwable {
		DbtNoteObject = new DebitNote_Object(getDriver(), WoObject);
		DbtNoteObject.CreateDebitNote();
	}
	
	@Test(priority = 5, groups = {"ExpenseModule", "DebitNoteReceiptFlow", "RegressionSuite2"}, dependsOnMethods = {"DebitNote"})
	public void DebitNoteReceipt() throws Throwable {
		DbtNoteRecObject = new DebitNoteReceipt_Object(getDriver(), DbtNoteObject);
		DbtNoteRecObject.CreateDebitNoteReceipt();
	}
	
	@Test(priority = 6, groups = {"ExpenseModule", "PaymentFlow", "CriticalWorkflowSuite"})
	public void Payment() throws Throwable {
		PayObject = new Payment_Object(getDriver(), WoObject, AdvObject, DbtNoteObject);
		PayObject.CreatePayment();
		
		///Application logout
		application.logoutTest();
	}
	/*@Test(priority = 2)
	public void ExpenseModuleFullExecution() throws Throwable {
		
		///Application login
		application = new Application(BrowserDriver);
		application.loginTest();
		
		///Expenses module start
		WoObject = new WorkOrder_Object(BrowserDriver);
		WoObject.CreateExpenseWO();
		
		AdvObject = new Advance_Object(BrowserDriver, WoObject);
		AdvObject.CreateAdvance();
		
		DbtNoteObject = new DebitNote_Object(BrowserDriver, WoObject);
		DbtNoteObject.CreateDebitNote();
		
		DbtNoteRecObject = new DebitNoteReceipt_Object(BrowserDriver, DbtNoteObject);
		DbtNoteRecObject.CreateDebitNoteReceipt();
		
		PayObject = new Payment_Object(BrowserDriver, WoObject, AdvObject, DbtNoteObject);
		PayObject.CreatePayment();
		///Expenses module end
		
		///Application logout
		application.logoutTest();
	}*/
	
 }
