package Expenses_TestCases;

import org.testng.annotations.Test;

import Expenses_SingleExecution_Object.DebitNoteReceipt_Object;
import Expenses_SingleExecution_Object.DebitNote_Object;
import Utilities.Application;
import Utilities.BaseClass;

public class DebitNoteAndReceipt_Test extends BaseClass {

	public Application application;
	public DebitNote_Object DbtNote;
	public DebitNoteReceipt_Object DbtNoteRec;
	
	@Test(priority = 2)
	public void DebitNoteCreateTest() throws Throwable {
		
		///Application login
		application = new Application();
		application.loginTest();
		
		DbtNote = new DebitNote_Object(getDriver());
		DbtNote.CreateDebitNote();
		
		DbtNoteRec = new DebitNoteReceipt_Object(getDriver(), DbtNote);
		DbtNoteRec.CreateDebitNoteReceipt();
		
		///Application logout
		application.logoutTest();
	}
 }
