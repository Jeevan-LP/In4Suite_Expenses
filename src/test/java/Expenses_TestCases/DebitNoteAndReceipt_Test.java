package Expenses_TestCases;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import Expenses_SingleExecution_Object.DebitNoteReceipt_Object;
import Expenses_SingleExecution_Object.DebitNote_Object;
import Utilities.ApplicationScript;
import Utilities.BaseClass;

//@Listeners(Utilities.ExtentReportManager.class)
public class DebitNoteAndReceipt_Test extends BaseClass {

	public ApplicationScript application;
	public DebitNote_Object DbtNote;
	public DebitNoteReceipt_Object DbtNoteRec;
	
	@Test(priority = 2)
	public void DebitNoteAndReceiptCreateTest() throws Throwable {
		
		///Application login
		application = new ApplicationScript();
		application.loginTest();
		
		DbtNote = new DebitNote_Object(getDriver());
		DbtNote.CreateDebitNote();
		
		DbtNoteRec = new DebitNoteReceipt_Object(getDriver(), DbtNote);
		DbtNoteRec.CreateDebitNoteReceipt();
		
		///Application logout
		application.logoutTest();
	}
 }
