package Expenses_SingleExecution_Object;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import Utilities.AppDependent;
import Utilities.AppIndependent;
import Utilities.BaseClass;
import Utilities.DataTable;

public class Advance_Object extends BaseClass {
	
	public WebDriver BrowserDriver;
	public AppIndependent AppInd;
	public AppDependent AppDep;
	public DataTable data;
	public WebDriverWait ExpWait;
	public Select dropdown;
	public int wait=20;
	
	
	public Advance_Object(WebDriver BrowserDriver){
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
	}
	
	@FindBy(xpath = "//span[text()='Expenses']")
	private WebElement Expenses;
	public void getExpenses() {
		AppInd.waitForClickable(BrowserDriver, Expenses, wait);
		Expenses.click();
	}
	
	@FindBy(xpath ="//a[text()='Payments ']")
	private WebElement PaymentTabClick;
	public void getPaymentsTabClick() {
		AppInd.waitForClickable(BrowserDriver, PaymentTabClick, wait);
		PaymentTabClick.click();
	}
	
	@FindBy(xpath ="//a[text()='Advance']")
	private WebElement AdvanceTabClick;
	public void getAdvanceTabClick() {
		ExpWait.until(ExpectedConditions.elementToBeClickable(AdvanceTabClick));
		PaymentTabClick.click();
	}
	
	@FindBy(xpath = "//input[@id='btnNewRequest']")
	private WebElement CreateAdvanceBtn;
	public void getCreateAdvanceBtn() {
		ExpWait.until(ExpectedConditions.elementToBeClickable(CreateAdvanceBtn));
		CreateAdvanceBtn.click();
	}
	
	@FindBy(xpath = "//select[@id='ddlCompany']")
	private WebElement CompanyDD;
	public WebElement getCompanyDD() {
		return CompanyDD;
	}
	
	@FindBy(xpath = "//select[@id='ddlExpenseType']")
	private WebElement ExpenseTypeDD;
	public WebElement getExpenseTypeDD() {
		return ExpenseTypeDD;
	}
	
	@FindBy(xpath = "//select[@id='ddlExpenseSubType']")
	private WebElement ExpenseSubTypeDD;
	public WebElement getExpenseSubTypeDD() {
		return ExpenseSubTypeDD;
	}
		
	@FindBy(xpath = "//input[@id='btnGo']")
	private WebElement GoBtn;
	public void getGoBtn() {
		ExpWait.until(ExpectedConditions.elementToBeClickable(GoBtn));
		GoBtn.click();
	}
	
	@FindBy(xpath = "//input[@id='dgExpenseDetailItems_ctl02_txtAmount']")
	private WebElement AmountTxtF;
	public WebElement getAmountTxtF() {
		return AmountTxtF;
	}
	
	@FindBy(xpath = "//select[@id='ddlExpenseSubType']")
	private WebElement CertificateType;
	public WebElement getCertificateType() {
		return CertificateType;
	}
	
	@FindBy(xpath = "//select[@id='ddlVendor']")
	private WebElement VendorDD;
	public WebElement getVendorDD() {
		return VendorDD;
	}
	
	@FindBy(xpath = "//select[@id='ddlPlaceofSupply']")
	private WebElement PlaceOfSupplyDD;
	public WebElement getPlaceOfSupplyDD() {
		return PlaceOfSupplyDD;
	}
	
	@FindBy(xpath = "//input[@name='txtInvoiceDate$txtDatePicker']")
	private WebElement AdvDatePicker;
	public WebElement getAdvDatePickerr() {
		AppInd.waitForVisibility(BrowserDriver, AdvDatePicker, wait);
		return AdvDatePicker;
	}
	
	@FindBy(xpath = "//select[@id='ddlWorkOrder']")
	private WebElement WorkOrderDD;
	public WebElement getWorkOrderDD() {
		return WorkOrderDD;
	}
	
	@FindBy(xpath = "//input[@id='txtInvoiceNumber']")
	private WebElement InvoiceNumberTxtF;
	public WebElement getInvoiceNumberTxtF() {
		return InvoiceNumberTxtF;
	}
	
	@FindBy(xpath = "//select[@id='ddlModeOfpayment']")
	private WebElement ModeOfPaymentDD;
	public WebElement getModeOfPaymentDD() {
		return ModeOfPaymentDD;
	}
	
	@FindBy(xpath = "//input[@id='txtPaymentDueDate_txtDatePicker']")
	private WebElement PaymentDueDatePicker;
	public WebElement getPaymentDueDatePicker() {
		AppInd.waitForVisibility(BrowserDriver, PaymentDueDatePicker, wait);
		return PaymentDueDatePicker;
	}
	
	@FindBy(xpath = "//select[@id='ddlStatus']")
	private WebElement StatusDD;
	public WebElement getStatusDD() {
		return StatusDD;
	}
	
	@FindBy(xpath = "//input[@id='txtSACCode']")
	private WebElement SACHSNTxtF;
	public WebElement getSACHSNTxtF() {
		return SACHSNTxtF;
	}
	
	@FindBy(xpath = "//textarea[@id='txtRemarks']")
	private WebElement RemarksTxtF;
	public WebElement getRemarksTxtF() {
		return RemarksTxtF;
	}
	
	@FindBy(xpath = "//a[@id='lnkBtnAddFile']")
	private WebElement DocAddNewLink;
	public void getDocAddNewLink() {
		ExpWait.until(ExpectedConditions.elementToBeClickable(DocAddNewLink));
		DocAddNewLink.click();
	}
	
	@FindBy(xpath = "//a[@id='gvDocuments_ctl02_lnkBtnUploadFile']")
	private WebElement UploadDocumentLink;
	public void getUploadDocumentLink() {
		ExpWait.until(ExpectedConditions.elementToBeClickable(UploadDocumentLink));
		UploadDocumentLink.click();
	}
	
	@FindBy(xpath = "//textarea[@id='gvDocuments_ctl02_txtRemarks']")
	private WebElement DocCommentsTxtF;
	public WebElement getDocCommentsTxtF() {
		return DocCommentsTxtF;
	}
	
	@FindBy(xpath = "//input[@id='btnSave']")
	private WebElement SubmitBtn;
	public void getSubmitBtn() {
		ExpWait.until(ExpectedConditions.elementToBeClickable(SubmitBtn));
		SubmitBtn.click();
	}
	
	@FindBy(xpath = "//span[@id='lblExpReqId']")
	private WebElement AdvanceRequestId;
	public String getAdvanceRequestId() {
		return AdvanceRequestId.getText();
	}
	
	//////Finance part
	@FindBy(xpath = "//span[text()='Finance']")
	private WebElement FinanceMenuTab;
	public void getFinanceMenuTab() {
		ExpWait.until(ExpectedConditions.elementToBeClickable(FinanceMenuTab));
		FinanceMenuTab.click();
	}
	
	@FindBy(xpath ="//a[text()='Expense']")
	private WebElement FinExpenseMenuTab;
	public void getFinExpenseMenuTab() {
		ExpWait.until(ExpectedConditions.elementToBeClickable(FinExpenseMenuTab));
		FinExpenseMenuTab.click();
	}
	
	@FindBy(xpath = "//a[text()='Advance']")
	private WebElement FinAdvanceTab;
	public void getFinAdvanceTab() {
		ExpWait.until(ExpectedConditions.elementToBeClickable(FinAdvanceTab));
		FinAdvanceTab.click();
	}
	
	@FindBy(xpath = "//select[@id='ddlCompany']")
	private WebElement FinListCompanyDD;
	public WebElement getFinListCompanyDD() {
		return FinListCompanyDD;
	}
	
	@FindBy(xpath = "//select[@id='ddlStatus']")
	private WebElement FinListStatusDD;
	public WebElement getFinListStatusDD() {
		return FinListStatusDD;
	}
	
	@FindBy(xpath = "//textarea[@id='txtRemarks']")
	private WebElement FinRemarksTxtF;
	public WebElement getFinRemarksTxtF() {
		return FinRemarksTxtF;
	}
	
	@FindBy(xpath = "//input[@id='txtExpenseId']")
	private WebElement FinExpNoTxtF;
	public WebElement getFinExpNoTxtF() {
		return FinExpNoTxtF;
	}
	
	@FindBy(xpath = "//input[@id='btnSearch']")
	private WebElement FinListGoBtn;
	public void getFinListGoBtn() {
		ExpWait.until(ExpectedConditions.elementToBeClickable(FinListGoBtn));
		FinListGoBtn.click();
	}
	
	@FindBy(xpath = "//td[@align='center']//a[contains(@id, 'dgExpenseDetails_ctl')]")
	private WebElement FinExpNoLink;
	public void getFinExpNoLink() {
		ExpWait.until(ExpectedConditions.elementToBeClickable(FinExpNoLink));
		FinExpNoLink.click();
	}
	
	@FindBy(xpath = "//select[@id='ddlStatus']")
	private WebElement FinStatusDD;
	public WebElement getFinStatusDD() {
		return FinStatusDD;
	}
	
	@FindBy(xpath = "//input[@id='btnSave']")
	private WebElement FinUpdateBtn;
	public void getFinUpdateBtn() {
		ExpWait.until(ExpectedConditions.elementToBeClickable(FinUpdateBtn));
		FinUpdateBtn.click();
	}
	
	@FindBy(xpath = "//input[@name='txtVoucherDate$txtDatePicker']")
	private WebElement ProcessedDateDatePicker;
	public WebElement getProcessedDateDatePicker() {
		AppInd.waitForVisibility(BrowserDriver, ProcessedDateDatePicker, wait);
		return ProcessedDateDatePicker;
	}
	
	@FindBy(xpath = "//a[text()='Make Bank Payment']")
	private WebElement MakeBankPaymentLink  ;
	public void getMakeBankPaymentLink() {
		ExpWait.until(ExpectedConditions.elementToBeClickable(MakeBankPaymentLink));
		MakeBankPaymentLink.click();
	}
	
	@FindBy(xpath = "//select[@id='ddlBankCash']")
	private WebElement BankAccountDD;
	public WebElement getBankAccountDD() {
		return BankAccountDD;
	}
	
	@FindBy(xpath = "//input[@name='txtInstrumentNo']")
	private WebElement InstrumentNoTxtF;
	public WebElement getInstrumentNoTxtF() {
		return InstrumentNoTxtF;
	}
	
	@FindBy(xpath = "//input[@name='btnSubmit']")
	private WebElement BankPaymentSubBtn  ;
	public void getBankPaymentSubBtn() {
		ExpWait.until(ExpectedConditions.elementToBeClickable(BankPaymentSubBtn));
		BankPaymentSubBtn.click();
	}
	
	public void CreateAdvance() throws Throwable {
		
		try {
		AppDep.MainParentFrame();
		AppDep.LeftFrame();
		getExpenses();
		Thread.sleep(2000);
		AppDep.DefaultContentFrame();
		AppDep.MainParentFrame();
		AppDep.MiddleFrame();
		getPaymentsTabClick();
		Thread.sleep(4000);
		AppDep.DefaultContentFrame();
		AppDep.MainParentFrame();
		AppDep.MiddleFrame();
		getAdvanceTabClick();
		Thread.sleep(4000);
		AppDep.DefaultContentFrame();
		AppDep.MainParentFrame();
		AppDep.MainFrame();
		AppDep.RightFrame();
		getCreateAdvanceBtn();
		Thread.sleep(2000);
		
		int Advance_Rows = AppInd.getRowNumber(data.XLFilepath, data.XlShee4);
		
		for(int i=1;i<=Advance_Rows;i++) {
			
        	String company = AppInd.readCellValueEmpty(data.XLFilepath, data.XlShee4, i, 0);
        	String expense = AppInd.readCellValueEmpty(data.XLFilepath, data.XlShee4, i, 1);

        	if (company.isEmpty() && expense.isEmpty()) {
        	    System.out.println("🛑 CreateAdvance Blank row found, exiting...");
        	    break;
        	}
        	
			AppInd.selectDropdownFromExcel(data.XLFilepath, data.XlShee4, i, 0, getCompanyDD());
            Thread.sleep(2000);
            AppInd.selectDropdownFromExcel(data.XLFilepath, data.XlShee4, i, 1, getExpenseTypeDD());
            Thread.sleep(2000);
            AppInd.selectDropdownFromExcel(data.XLFilepath, data.XlShee4, i, 2, getExpenseSubTypeDD());
            Thread.sleep(2000);
            getGoBtn();
            Thread.sleep(2000);
            AppInd.jsClearTextFieldSafe(BrowserDriver, getAmountTxtF());
            Thread.sleep(2000);
            AppInd.selectTextFieldFromExcel(data.XLFilepath, data.XlShee4, i, 3, getAmountTxtF());
            Thread.sleep(2000);
            AppInd.selectDropdownFromExcel(data.XLFilepath, data.XlShee4, i, 4, getVendorDD());
            Thread.sleep(3000);
            
            if (getWorkOrderDD().isEnabled() && getWorkOrderDD().isDisplayed()) {
	    		List<WebElement> AllWO = AppInd.getALLOptions(getWorkOrderDD());
	    		for(int j=0;j<AllWO.size();j++) {
	    			if(j==AllWO.size()-1) {
	    				AppInd.selectByIndex(getWorkOrderDD(), j);
	    			}
	    		  }
	            }
            
    		Thread.sleep(3000);
    		if(getPlaceOfSupplyDD().isDisplayed()&&getPlaceOfSupplyDD().isEnabled()) {
				AppInd.selectByIndex(getPlaceOfSupplyDD(), 1);
			}
			else {
				System.out.println("No PlaceOfSupply for this company");
			}
            Thread.sleep(2000);
            AppInd.selectTextFieldFromExcel(data.XLFilepath, data.XlShee4, i, 5, getInvoiceNumberTxtF());
            Thread.sleep(2000);
            AppDep.selectCurrentDate(BrowserDriver, getAdvDatePickerr());
            Thread.sleep(2000);
            AppInd.jsScrollToBottom(BrowserDriver);
            Thread.sleep(2000);
            AppInd.selectDropdownFromExcel(data.XLFilepath, data.XlShee4, i, 6, getModeOfPaymentDD());
            Thread.sleep(2000);
            AppDep.selectCurrentDate(BrowserDriver, getPaymentDueDatePicker());
            Thread.sleep(2000);
            AppInd.selectByVisibleText("SUBMITTED", getStatusDD());
            Thread.sleep(2000);
            AppInd.selectTextFieldFromExcel(data.XLFilepath, data.XlShee4, i, 7, getSACHSNTxtF());
            Thread.sleep(1500);
            AppInd.selectTextFieldFromExcel(data.XLFilepath, data.XlShee4, i, 8, getRemarksTxtF());
            Thread.sleep(2000);
            getDocAddNewLink();
            Thread.sleep(2000);
            getUploadDocumentLink();
            AppInd.Childwindow();
            Thread.sleep(2000);
            WebElement upload = BrowserDriver.findElement(By.xpath("//input[@id='fupldDocument']"));
            upload.sendKeys(data.FileUpload);
            Thread.sleep(2000);
            BrowserDriver.findElement(By.xpath("//input[@id='btnUpload']")).click();
            AppInd.Parentwindow();
            BrowserDriver.switchTo().defaultContent(); // very important after switching windows
            AppDep.MainParentFrame();
            AppDep.MainFrame();
            AppDep.RightFrame(); 
            Thread.sleep(2000);
            AppInd.selectTextFieldFromExcel(data.XLFilepath, data.XlShee4, i, 9, getDocCommentsTxtF());
            Thread.sleep(2500);
            getSubmitBtn();
            Thread.sleep(2000);
			
			///For advance submit
			if(AppInd.isAlertPresent(BrowserDriver, wait)) {
				BrowserDriver.switchTo().alert().accept();
			}
			else {
				System.out.println("No alert Present");
			}
			Thread.sleep(2000);

			///For duplicate invoice number
			if(AppInd.isAlertPresent(BrowserDriver, wait)) {
				BrowserDriver.switchTo().alert().accept();
			}
			else {
				System.out.println("No alert Present");
			}
			
			Thread.sleep(2000);
            String AdvanceID = getAdvanceRequestId();
            //System.out.println("Expenses Advance Request Id: "+AdvanceID);
            Thread.sleep(2000);
        	   
            /////Finance part
    		AppDep.DefaultContentFrame();
            AppDep.MainParentFrame();
    		AppDep.LeftFrame();
            getFinanceMenuTab();
            Thread.sleep(2000);
    		AppDep.DefaultContentFrame();
    		AppDep.MainParentFrame();
    		AppDep.MiddleFrame();
    		getFinExpenseMenuTab();
    		Thread.sleep(2500);
    		AppDep.DefaultContentFrame();
    		AppDep.MainParentFrame();
    		AppDep.MainFrame();
    		AppDep.RightFrame();
    		AppDep.TabFrame();
    		getFinAdvanceTab();
    		Thread.sleep(2500);
            AppDep.DefaultContentFrame();
    		AppDep.MainParentFrame();
    		AppDep.MainFrame();
            AppDep.RightFrame();
            AppDep.MainDinFrame();
            AppInd.selectDropdownFromExcel(data.XLFilepath, data.XlShee4, i, 0, getFinListCompanyDD());
            Thread.sleep(2000);
            AppInd.selectByVisibleText("--All--", getFinListStatusDD());
            Thread.sleep(2000);
            getFinExpNoTxtF().sendKeys(AdvanceID);
            Thread.sleep(2000);
            getFinListGoBtn();
            Thread.sleep(2000);
            getFinExpNoLink();
            Thread.sleep(3000);
            AppInd.jsScrollToBottom(BrowserDriver);
            Thread.sleep(2000);
            
            AppInd.selectByVisibleText("APPROVED", getFinStatusDD());
            Thread.sleep(2000);
            getFinRemarksTxtF().sendKeys("Expenses Advance Approved");
            Thread.sleep(2000);
            getFinUpdateBtn();
            Thread.sleep(2000);
            AppInd.selectByVisibleText("PROCESSED", getFinStatusDD());
            Thread.sleep(2000);
            AppDep.selectCurrentDate(BrowserDriver, getProcessedDateDatePicker());
            Thread.sleep(2000);
            getFinRemarksTxtF().sendKeys("Expenses Advance Processed");
            Thread.sleep(2000);
            getFinUpdateBtn();
            //AppInd.jsScrollToTop(BrowserDriver);
            Thread.sleep(2000);
            
            //////Payment part
            getMakeBankPaymentLink();
            AppInd.Childwindow();
            Thread.sleep(2000);
            AppInd.selectByIndex(getBankAccountDD(), 1);
            Thread.sleep(2000);
            
            if(AppInd.isAlertPresent(BrowserDriver, wait)) {
				BrowserDriver.switchTo().alert().accept();
			}
			else {
				System.out.println("No alert Present");
			}
            Thread.sleep(2000);
            getInstrumentNoTxtF().sendKeys("27092001");
            Thread.sleep(2000);
            getBankPaymentSubBtn();
            Thread.sleep(2000);
            if(AppInd.isAlertPresent(BrowserDriver, wait)) {
				BrowserDriver.switchTo().alert().accept();
			}
			else {
				System.out.println("No alert Present");
			}
            Thread.sleep(2000);
            if(AppInd.isAlertPresent(BrowserDriver, wait)) {
				BrowserDriver.switchTo().alert().accept();
			}
			else {
				System.out.println("No alert Present");
			}
            
            AppInd.Parentwindow();
            BrowserDriver.switchTo().defaultContent(); // very important after switching windows
            AppDep.DefaultContentFrame();
    		AppDep.MainParentFrame();
    		AppDep.MainFrame();
    		AppDep.RightFrame();
    		AppDep.MainDinFrame();
            Thread.sleep(1500);
            AppInd.jsScrollToBottom(BrowserDriver);
            Thread.sleep(1500);
            String paidAmount = BrowserDriver.findElement(By.xpath("//span[@id='dgPayment_ctl02_lblAmountPaid']")).getText();
            System.out.println("Expenses Advance Request Id: "+AdvanceID+" Paid amount is: "+paidAmount);
         

        }
	}
		catch (Exception e) {
	        System.out.println("❌❌❌ Error during CreateAdvance execution:.............................");
	        e.printStackTrace();
			
		}  
            
	}
}
	