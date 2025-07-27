package Expenses_FullExecution_Object;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import Utilities.AppDependent;
import Utilities.AppIndependent;
import Utilities.BaseClass;
import Utilities.DataTable;

public class DebitNoteReceipt_Object extends BaseClass{
	
	public WebDriver BrowserDriver;
	public String sheetname;
	public AppIndependent AppInd;
	public AppDependent AppDep;
	public DataTable data;
	public WebDriverWait ExpWait;
	public int wait=20;
	public DebitNote_Object debitNote;
	
	public DebitNoteReceipt_Object(WebDriver BrowserDriver, DebitNote_Object debitNote){
		
		this.BrowserDriver = BrowserDriver;
		this.ExpWait = new WebDriverWait(BrowserDriver, Duration.ofSeconds(wait));
		PageFactory.initElements(BrowserDriver, this);

		AppInd = new AppIndependent();
		AppInd.appIndDriver = BrowserDriver;
		AppInd.ExpWait = ExpWait;

		AppDep = new AppDependent();
		AppDep.appDepDriver = BrowserDriver;
		AppDep.ExpWait = ExpWait;

		data = new DataTable();
		
		this.debitNote=debitNote;
	}
	
	@FindBy(xpath = "//span[text()='Expenses']")
	private WebElement Expenses;
	public void getExpenses() {
		AppInd.waitForClickable(BrowserDriver, Expenses, wait);
		Expenses.click();
	}
	
	@FindBy(xpath ="//a[text()='Payments ']")
	private WebElement PaymentTabClick;
	public void getPaymentTabClick() {
		AppInd.waitForClickable(BrowserDriver, PaymentTabClick, wait);
		PaymentTabClick.click();
	}
	
	@FindBy(xpath ="//a[text()='Debit Note Receipt']")
	private WebElement DebitNoteReceiptTabClick;
	public void getDebitNoteReceiptTabClick() {
		AppInd.waitForClickable(BrowserDriver, DebitNoteReceiptTabClick, wait);
		DebitNoteReceiptTabClick.click();
	}
	
	@FindBy(xpath = "//input[@id='btnCreateDebitNoteReceipt']")
	private WebElement CreateDebitNoteReceiptBtn;
	public void getCreateDebitNoteReceiptBtn() {
		AppInd.waitForClickable(BrowserDriver, CreateDebitNoteReceiptBtn, wait);
		CreateDebitNoteReceiptBtn.click();
	}
	
	@FindBy(xpath = "//select[@id='ddlCompany']")
	private WebElement CompanyDD;
	public WebElement getCompanyDD() {
		return CompanyDD;
	}
	
	@FindBy(xpath = "//select[@id='ddlVendor']")
	private WebElement VendorDD;
	public WebElement getVendorDD() {
		return VendorDD;
	}
	
	@FindBy(xpath = "//input[@id='dtReceiptDate_txtDatePicker']")
	private WebElement DatePicker;
	
	@FindBy(xpath = "//input[@id='btnSearch']")
	private WebElement GoBtn;
	public void getGoBtn() {
		AppInd.waitForClickable(BrowserDriver, GoBtn, wait);
		GoBtn.click();
	}
	
	@FindBy(xpath = "//select[@id='ddlPaymentModeList']")
	private WebElement PaymentModeDD;
	public WebElement getPaymentModeDD() {
		return PaymentModeDD;
	}
	
	@FindBy(css = "#txtRemarks")
	private WebElement RemarksTxtF;
	public WebElement getRemarksTxtF() {
		return RemarksTxtF;
	}
	
	@FindBy(xpath = "//input[@id='btnSave']")
	private WebElement CreateBtn;
	public void getCreateBtn() {
		AppInd.waitForClickable(BrowserDriver, CreateBtn, wait);
		CreateBtn.click();
	}
	
	@FindBy(xpath = "//a[@id='linkChangeStatus']")
	private WebElement  ChangeStatusLink;
	public void getChangeStatusLink() {
		AppInd.waitForClickable(BrowserDriver, ChangeStatusLink, wait);
		ChangeStatusLink.click();
	}
	
	@FindBy(xpath = "//a[@id='linkUpdateStatus']")
	private WebElement UpdateStatusLink;
	public void getUpdateStatusLink() {
		AppInd.waitForClickable(BrowserDriver, UpdateStatusLink, wait);
		UpdateStatusLink.click();
	}
	
	@FindBy(xpath = "//textarea[@id='txtStatusRemark']")
	private WebElement ApproverRemarksTxtF;
	public WebElement getApproverRemarksTxtF() {
		return ApproverRemarksTxtF;
	}
	
	@FindBy(xpath = "//select[@id='ddlUpdateStatusList']")
	private WebElement StatusDD;
	public WebElement getStatusDD() {
		return StatusDD;
	}
	
	@FindBy(xpath = "//select[@id='ddlBankHeaderAccount']")
	private WebElement BankAndCashDD;
	public WebElement getBankAndCashDD() {
		return BankAndCashDD;
	}
	
	@FindBy(xpath = "//input[@id='dtReceivedDate_txtDatePicker']")
	private WebElement ReceivedDatePicker;
	public WebElement getReceivedDatePicker() {
		return ReceivedDatePicker;
	}
	
	@FindBy(xpath = "//input[@id='dtRealizedDate_txtDatePicker']")
	private WebElement RealizedDatePicker;
	public WebElement getRealizedDatePicker() {
		return RealizedDatePicker;
	}
	
	@FindBy(xpath = "//span[@id='lblReceiptNo']")
	private WebElement ReceiptID;
	public String getReceiptID() {
		return ReceiptID.getText();
	}
	
	public void CreateDebitNoteReceipt() throws Throwable {
		
		try {
		Thread.sleep(1000);
		AppDep.DefaultContentFrame();
		AppDep.MainParentFrame();
		AppDep.MiddleFrame();
		Thread.sleep(2000);
		getDebitNoteReceiptTabClick();
		Thread.sleep(2000);
		AppDep.DefaultContentFrame();
		AppDep.MainParentFrame();
		AppDep.MainFrame();
		AppDep.RightFrame();
		getCreateDebitNoteReceiptBtn();
		Thread.sleep(2000);
		
		int DbtRec_Rows = AppInd.getRowNumber(data.XLFilepath, data.XlShee6);
		
		for(int i=1;i<=DbtRec_Rows;i++) {
			
			String company = AppInd.readCellValueEmpty(data.XLFilepath, data.XlShee6, i, 0);
        	String vendor = AppInd.readCellValueEmpty(data.XLFilepath, data.XlShee6, i, 1);

        	if (company.isEmpty() && vendor.isEmpty()) {
        	    System.out.println("🛑 CreateDebitNoteReceipt Blank row found, exiting...");
        	    break;
        	}
        	
			AppInd.selectDropdownFromExcel(data.XLFilepath, data.XlShee6, i, 0, getCompanyDD());
			Thread.sleep(2000);
			AppInd.selectDropdownFromExcel(data.XLFilepath, data.XlShee6, i, 1, getVendorDD());
			Thread.sleep(2000);
			AppDep.selectCurrentDate(BrowserDriver, DatePicker);
			Thread.sleep(2000);
			getGoBtn();
			Thread.sleep(2000);
			AppInd.selectDropdownFromExcel(data.XLFilepath, data.XlShee6, i, 2, getPaymentModeDD());
			Thread.sleep(2000);
			AppInd.selectTextFieldFromExcel(data.XLFilepath, data.XlShee6, i, 3, getRemarksTxtF());

	        List<WebElement> DbtIDs = BrowserDriver.findElements(
	        By.xpath("//table[@class='in4-table']//tr//td//a[@title='Click to View Details']"));

	        List<WebElement> AllTXTf = BrowserDriver.findElements(
	        By.xpath("//table[@class='in4-table']//tr//td//input[@type='text']"));
	        
	        for (int k = 0; k < DbtIDs.size(); k++) {
	            	if (debitNote.DbtNoteID.equals(DbtIDs.get(k).getText())) {
	                WebElement amountField = AllTXTf.get(k);
	                amountField.clear();
	                Thread.sleep(1000);
	                AppInd.selectTextFieldFromExcel(data.XLFilepath, data.XlShee6, i, 4, amountField);
	                Thread.sleep(2000);
	                break;
	            }
	        }
	            Thread.sleep(2000);
	            getCreateBtn();
	            Thread.sleep(2000);
	            getChangeStatusLink();
	            Thread.sleep(2000);
	            AppInd.selectByVisibleText("Approved", getStatusDD());
	            Thread.sleep(2000);
	            getApproverRemarksTxtF().sendKeys("Debit Note Receipt Approved");	   
	            Thread.sleep(2000);
	            getUpdateStatusLink();
	            Thread.sleep(2000);
	            getChangeStatusLink();
	            Thread.sleep(2000);
	            AppInd.selectByVisibleText("Received", getStatusDD());
	            Thread.sleep(2000);
	            AppInd.selectByIndex(getBankAndCashDD(), 1);
	            Thread.sleep(2000);
	            AppDep.selectCurrentDate(BrowserDriver, getReceivedDatePicker());
	            Thread.sleep(2000);
	            getApproverRemarksTxtF().sendKeys("Debit Note Receipt Received");	   
	            Thread.sleep(2000);
	            getUpdateStatusLink();
	            Thread.sleep(2000);
	            getChangeStatusLink();
	            Thread.sleep(2000);
	            AppInd.selectByVisibleText("Realized", getStatusDD());
	            Thread.sleep(2000);
	            AppDep.selectCurrentDate(BrowserDriver, getRealizedDatePicker());
	            Thread.sleep(2000);
	            getApproverRemarksTxtF().sendKeys("Debit Note Receipt Realized");	
	            Thread.sleep(2000);
	            getUpdateStatusLink();
	            Thread.sleep(2000);
	            String ReceiptID = getReceiptID();
	            String ReceiptAmount = BrowserDriver.findElement(By.xpath("//span[@id='lblReceiptAmount']")).getText();
	            System.out.println("4. Expenses Debit Note Receipt: "+ReceiptID+" Received amount with: "+ReceiptAmount+" INR...From Debite Note ID: "+debitNote.DbtNoteID);
	            System.out.println();///Console purpose
	            Thread.sleep(2000);
	            Assert.assertTrue(true);
	           }
		   }
		catch (Exception e) {
			System.out.println("❌❌❌ Error during Create DebitNote Receipt execution:.............................");
	        e.printStackTrace();
		}
   }
}
	
	
