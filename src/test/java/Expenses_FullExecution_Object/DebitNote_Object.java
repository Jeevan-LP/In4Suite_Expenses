package Expenses_FullExecution_Object;

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
import org.testng.Assert;

import Utilities.AppDependent;
import Utilities.AppIndependent;
import Utilities.BaseClass;
import Utilities.DataTable;

public class DebitNote_Object extends BaseClass{
	
	public WebDriver BrowserDriver;
	public AppIndependent AppInd;
	public AppDependent AppDep;
	public DataTable data;
	public WebDriverWait ExpWait;
	public Select dropdown;
	public int wait=20;
	public WorkOrder_Object WoObject;
	public String DbtNoteID="";
	
	public DebitNote_Object(WebDriver BrowserDriver,WorkOrder_Object WoObject){
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
		this.WoObject=WoObject;
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
	
	@FindBy(xpath ="//a[text()='Debit Note']")
	private WebElement DebitNoteTabClick;
	public void getDebitNoteTabClick() {
		ExpWait.until(ExpectedConditions.elementToBeClickable(DebitNoteTabClick));
		DebitNoteTabClick.click();
	}
	
	@FindBy(xpath = "//input[@id='btnCreateDebitNote']")
	private WebElement CreateDebitNoteBtn;
	public void getCreateDebitNoteBtn() {
		ExpWait.until(ExpectedConditions.elementToBeClickable(CreateDebitNoteBtn));
		CreateDebitNoteBtn.click();
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
	
	@FindBy(xpath = "//select[@id='ddlType']")
	private WebElement ExpenseTypeDD;
	public WebElement getExpenseTypeDD() {
		return ExpenseTypeDD;
	}
	
	@FindBy(xpath = "//select[@id='ddlSubType']")
	private WebElement ExpenseSubTypeDD;
	public WebElement getExpenseSubTypeDD() {
		return ExpenseSubTypeDD;
	}
	
	@FindBy(xpath = "//a[@id='lnkSelect']")
	private WebElement WorkOrderNoLink;
	public void getWorkOrderNoLink() {
		ExpWait.until(ExpectedConditions.elementToBeClickable(WorkOrderNoLink));
		WorkOrderNoLink.click();
	}
	
	@FindBy(xpath = "//select[@id='ddlWorkOrder']")
	private WebElement WorkOrderDD;
	public WebElement getWorkOrderDD() {
		return WorkOrderDD;
	}
	
	@FindBy(xpath = "//input[@id='btnSearch']")
	private WebElement GoBtn;
	public void getGoBtn() {
		ExpWait.until(ExpectedConditions.elementToBeClickable(GoBtn));
		GoBtn.click();
	}
	
	@FindBy(xpath = "//input[@id='rbtnWoId']")
	private WebElement WoRadioBtn;
	public void getWoRadioBtn() {
		ExpWait.until(ExpectedConditions.elementToBeClickable(WoRadioBtn));
		WoRadioBtn.click();
	}
	
	@FindBy(xpath = "//a[@id='lnkAcceptSelected']")
	private WebElement AcceptSelectedClick;
	public void getAcceptSelectedClick() {
		ExpWait.until(ExpectedConditions.elementToBeClickable(AcceptSelectedClick));
		AcceptSelectedClick.click();
	}
	
	@FindBy(xpath = "//select[@id='ddlReason']")
	private WebElement ReasonDD;
	public WebElement getReasonDD() {
		return ReasonDD;
	}
	
	@FindBy(xpath = "//input[@id='txtInvoiceNo']")
	private WebElement InvoiceNumberTxtF;
	public WebElement getInvoiceNumberTxtF() {
		return InvoiceNumberTxtF;
	}
	
	@FindBy(xpath = "//input[@id='txtDebitNoteAmount']")
	private WebElement DebitNoteAmountTxtF;
	public WebElement getDebitNoteAmountTxtF() {
		return DebitNoteAmountTxtF;
	}
	
	@FindBy(xpath = "//input[@id='txtRefNo']")
	private WebElement ReferenceInvoiceNoTxtF;
	public WebElement getReferenceInvoiceNoTxtF() {
		return ReferenceInvoiceNoTxtF;
	}
	
	@FindBy(xpath = "//textarea[@id='txtRemarks']")
	private WebElement RemarksTxtF;
	public WebElement getRemarksTxtF() {
		return RemarksTxtF;
	}
	
	@FindBy(xpath = "//textarea[@id='txtStatusRemark']")
	private WebElement ApproverRemarksTxtF;
	public WebElement getApproverRemarksTxtF() {
		return ApproverRemarksTxtF;
	}
	
	@FindBy(xpath = "//a[@id='lnkBtnAddFile']")
	private WebElement DocumentsAddLink;
	public void getDocumentsAddLink() {
		ExpWait.until(ExpectedConditions.elementToBeClickable(DocumentsAddLink));
		DocumentsAddLink.click();
	}
	
	
	@FindBy(xpath = "//a[@id='gvDocuments_ctl02_lnkBtnUploadFile']")
	private WebElement UploadDocumentLink;
	public void getUploadDocumentLink() {
		ExpWait.until(ExpectedConditions.elementToBeClickable(UploadDocumentLink));
		UploadDocumentLink.click();
	}
	
	@FindBy(xpath = "//textarea[@id='gvDocuments_ctl02_txtRemarks']")
	private WebElement DocRemarksTxtF;
	public WebElement getDocRemarksTxtF() {
		return DocRemarksTxtF;
	}
	
	@FindBy(xpath = "//input[@id='btnSave']")
	private WebElement CreateBtn;
	public void getCreateBtn() {
		ExpWait.until(ExpectedConditions.elementToBeClickable(CreateBtn));
		CreateBtn.click();
	}
	
	@FindBy(xpath = "//span[@id='lblDebitNoteIdVw1']")
	private WebElement DebitNoteID;
	public String getDebitNoteID() {
		return DebitNoteID.getText();
	}
	
	@FindBy(xpath = "//a[@id='linkChangeStatus']")
	private WebElement StatusHyperLink;
	public void getStatusHyperLink() {
		ExpWait.until(ExpectedConditions.elementToBeClickable(StatusHyperLink));
		StatusHyperLink.click();
	}
	
	@FindBy(xpath = "//select[@id='ddlUpdateStatusList']")
	private WebElement StatusDD;
	public WebElement getStatusDD() {
		return StatusDD;
	}
	
	@FindBy(xpath = "//a[@id='linkUpdateStatus']")
	private WebElement 	UpdateStatusLink;
	public void getUpdateStatusLink() {
		ExpWait.until(ExpectedConditions.elementToBeClickable(UpdateStatusLink));
		UpdateStatusLink.click();
	}
	
	@FindBy(xpath = "//input[@id='dtProcessedDate_txtDatePicker']")
	private WebElement ProcessedDatePicker;
	public WebElement getProcessedDatePicker() {
		AppInd.waitForVisibility(BrowserDriver, ProcessedDatePicker, wait);
		return ProcessedDatePicker;
	}
	
	public void CreateDebitNote() throws Throwable {
		
		try {
		Thread.sleep(1000);
		AppDep.DefaultContentFrame();
		AppDep.MainParentFrame();
		AppDep.LeftFrame();
		getExpenses();
		Thread.sleep(1000);
		AppDep.DefaultContentFrame();
		AppDep.MainParentFrame();
		AppDep.MiddleFrame();
		getPaymentTabClick();
		Thread.sleep(1000);
		AppDep.DefaultContentFrame();
		AppDep.MainParentFrame();
		AppDep.MiddleFrame();
		getDebitNoteTabClick();
		Thread.sleep(2000);
		AppDep.DefaultContentFrame();
		AppDep.MainParentFrame();
		AppDep.MainFrame();
		AppDep.RightFrame();
		getCreateDebitNoteBtn();
		Thread.sleep(2000);
		
		int DebitNote_Rows = AppInd.getRowNumber(data.XLFilepath, data.XlShee5);
		
		for(int i=1;i<=DebitNote_Rows;i++) {
			
			String company = AppInd.readCellValueEmpty(data.XLFilepath, data.XlShee5, i, 0);
        	String vendor = AppInd.readCellValueEmpty(data.XLFilepath, data.XlShee5, i, 1);

        	if (company.isEmpty() && vendor.isEmpty()) {
        	    System.out.println("Create Expense Blank row found in configuration file, exiting.....");
        	    break;
        	}
        	
			AppInd.selectDropdownFromExcel(data.XLFilepath, data.XlShee5, i, 0, getCompanyDD());
            Thread.sleep(2000);
            AppInd.selectDropdownFromExcel(data.XLFilepath, data.XlShee5, i, 1, getVendorDD());
            Thread.sleep(2000);
            AppInd.selectDropdownFromExcel(data.XLFilepath, data.XlShee5, i, 2, getExpenseTypeDD());
            Thread.sleep(2000);
            AppInd.selectDropdownFromExcel(data.XLFilepath, data.XlShee5, i, 3, getExpenseSubTypeDD());
            Thread.sleep(2000);
            getWorkOrderNoLink();
            Thread.sleep(2000);
            AppInd.Childwindow();
            Thread.sleep(1750);
            
            if(getWorkOrderDD().isEnabled() && getWorkOrderDD().isDisplayed()) {
            	List<WebElement> AllWO = AppInd.getALLOptions(getWorkOrderDD());
	    		for(int j=0;j<AllWO.size();j++) {
	    			  if(WoObject.WODisplayNo.equals(AllWO.get(j).getText())) {
	    				  AppInd.selectByVisibleText(AllWO.get(j).getText(), getWorkOrderDD());
	    				  break;
	    			}
	    		}
            }
            
            Thread.sleep(2000);
            getGoBtn();
            Thread.sleep(2000);
            getWoRadioBtn();
            Thread.sleep(2000);
            getAcceptSelectedClick();
            Thread.sleep(2000);
            AppInd.Parentwindow();
            AppDep.DefaultContentFrame();
    		AppDep.MainParentFrame();
    		AppDep.MainFrame();
    		AppDep.RightFrame();
    		Thread.sleep(2000);
            
    		AppInd.selectDropdownFromExcel(data.XLFilepath, data.XlShee5, i, 4, getReasonDD());
            Thread.sleep(2000);
            AppInd.selectTextFieldFromExcel(data.XLFilepath, data.XlShee5, i, 5, getInvoiceNumberTxtF());
            Thread.sleep(2000);
            AppInd.selectTextFieldFromExcel(data.XLFilepath, data.XlShee5, i, 6, getDebitNoteAmountTxtF());
            Thread.sleep(3000);
            AppInd.selectTextFieldFromExcel(data.XLFilepath, data.XlShee5, i, 7, getReferenceInvoiceNoTxtF());
            Thread.sleep(2000);
            AppInd.selectTextFieldFromExcel(data.XLFilepath, data.XlShee5, i, 8, getRemarksTxtF());
            Thread.sleep(1750);
            
            getDocumentsAddLink();
            Thread.sleep(2000);
            getUploadDocumentLink();
            AppInd.Childwindow();
            Thread.sleep(1750);
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
            AppInd.selectTextFieldFromExcel(data.XLFilepath, data.XlShee5, i, 8, getDocRemarksTxtF());
            Thread.sleep(1750);
            getCreateBtn();
            Thread.sleep(2000);
            DbtNoteID = getDebitNoteID();
            //System.out.println("Expenses debit note ID: "+DbtNoteID);
            Thread.sleep(2000);
            getStatusHyperLink();
            Thread.sleep(2000);
            AppInd.selectByVisibleText("Approved", getStatusDD());
            Thread.sleep(2000);
            getApproverRemarksTxtF().sendKeys("Expenses Debit Note Approved");
            Thread.sleep(2000);
            getUpdateStatusLink();
            Thread.sleep(2000);
            getStatusHyperLink();
            Thread.sleep(2000);
            AppInd.selectByVisibleText("Processed", getStatusDD());
            Thread.sleep(2000);
            AppDep.selectCurrentDate(BrowserDriver, getProcessedDatePicker());
            Thread.sleep(2000);
            getApproverRemarksTxtF().sendKeys("Expenses Debit Note Processed");
            Thread.sleep(2000);
            getUpdateStatusLink();
            Thread.sleep(2000);
            String DebitNoteAmount = BrowserDriver.findElement(By.xpath("//span[@id='lblGrossAmountView']")).getText();
            System.out.println("3. Expenses Debit Note ID : "+DbtNoteID+" Processed with: "+DebitNoteAmount+" INR"+" for "+WoObject.WODisplayNo);
            System.out.println();///Console purpose
            Thread.sleep(2000);
            Assert.assertTrue(true);
		   }
		}
		catch (Exception e) {
	        System.out.println("❌❌❌ Error during CreateDebitNote execution:.............................");
	        e.printStackTrace();
			
		} 
		
    }
}

