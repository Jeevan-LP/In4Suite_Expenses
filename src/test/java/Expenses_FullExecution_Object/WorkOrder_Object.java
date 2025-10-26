package Expenses_FullExecution_Object;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import Utilities.AppDependent;
import Utilities.AppIndependent;
import Utilities.BaseClass;
import Utilities.DataTable;

public class WorkOrder_Object extends BaseClass{
	
	public WebDriver BrowserDriver;
	public AppIndependent AppInd;
	public AppDependent AppDep;
	public DataTable data;
	public WebDriverWait ExpWait;
	public int wait=20;
	public String WODisplayNo="";
	
	public WorkOrder_Object(WebDriver BrowserDriver) {
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
		AppInd.waitForVisibility(BrowserDriver, Expenses, wait);
		AppInd.waitForClickable(BrowserDriver, Expenses, wait);
		AppInd.jsClick(BrowserDriver, Expenses);
	}
	
	@FindBy(xpath  = "//a[text()='Work Order ']")
	private WebElement WorkOrder;
	public void getWorkOrder() {
		AppInd.waitForVisibility(BrowserDriver, WorkOrder, wait);
		AppInd.waitForClickable(BrowserDriver, WorkOrder, wait);
		AppInd.jsClick(BrowserDriver, WorkOrder);
	}
	
	@FindBys({@FindBy(css = "#btnCreate"),@FindBy(xpath = "//input[@id='btnCreate']")})
	private WebElement WObtnCreate;
	public void getWOCreateBtn() {
		AppInd.waitForVisibility(BrowserDriver, WObtnCreate, wait);
		AppInd.waitForClickable(BrowserDriver, WObtnCreate, wait);
		AppInd.jsClick(BrowserDriver, WObtnCreate);
	}

	@FindBy(xpath = "//select[@id='ddlCompany']")
	private WebElement CompanyDD;
	public WebElement getCompanyDD() {
		AppInd.waitForVisibility(BrowserDriver, CompanyDD, wait);
		return CompanyDD;
	}
	
	@FindBy(xpath = "//select[@id='ddlcurrencytype']")
	private WebElement WorkOrderTypeDD;
	public WebElement getWorkOrderTypeDD() {
		AppInd.waitForVisibility(BrowserDriver, WorkOrderTypeDD, wait);
		return WorkOrderTypeDD;
	}
	
	@FindBy(xpath = "//select[@id='ddlType']")
	private WebElement ExpenseTypeDD;
	public WebElement getExpenseTypeDD() {
		AppInd.waitForVisibility(BrowserDriver, ExpenseTypeDD, wait);
		return ExpenseTypeDD;
	}
	
	@FindBy(xpath = "//select[@id='ddlSubType']")
	private WebElement ExpenseSubTypeDD;
	public WebElement getExpenseSubTypeDD() {
		AppInd.waitForVisibility(BrowserDriver, ExpenseSubTypeDD, wait);
		return ExpenseSubTypeDD;
	}
	
	@FindBy(xpath = "//select[@id='ddlContractorName']")
	private WebElement VendorNameDD;
	public WebElement getVendorNameDD() {
		return VendorNameDD;
	}
	
	@FindBy(xpath = "//textarea[@id='txtScopeOfWork']")
	private WebElement ScopeOfWorkTxtf;
	public WebElement getScopeOfWorkTxtf() {
		return ScopeOfWorkTxtf;
	}
	
	@FindBy(xpath = "//textarea[@id='txtContactName']")
	private WebElement ContactNameTxtf;
	public WebElement getContactNameTxtf() {
		return ContactNameTxtf;
	}
	
	@FindBy(xpath = "//input[@id='dtFromDate_txtDatePicker']")
	private WebElement FromDatePicker;
	public WebElement getFromDatePicker() {
		AppInd.waitForVisibility(BrowserDriver, FromDatePicker, wait);
		return FromDatePicker;
	}
	
	@FindBy(xpath = "//input[@id='dtToDate_txtDatePicker']")
	private WebElement ToDatePicker;
	public WebElement getToDatePicker() {
		AppInd.waitForVisibility(BrowserDriver, ToDatePicker, wait);
		return ToDatePicker;
	}
	
	////****Work Order Item details started......
	@FindBy(xpath = "//a[@id='lnkWODetails']")
	private WebElement AddDetailsLink;
	public void getAddDetailsLink() {
		AppInd.waitForClickable(BrowserDriver, AddDetailsLink, wait);
		AddDetailsLink.click();
	}
	
	@FindBy(xpath = "//a[@id='lnkBtnWODetailsAddRow']")
	private WebElement AddRowLink;
	public void getAddRowLink() {
		AppInd.waitForClickable(BrowserDriver, AddRowLink, wait);
		AddRowLink.click();
	}
	
	@FindBy(xpath = "//textarea[@id='dgWorkOrderDetails_ctl02_txtWODetailsItem']")
	private WebElement ItemTxtf;
	public WebElement getItemTxtf() {
		return ItemTxtf;
	}
	
	@FindBy(xpath = "//textarea[@id='dgWorkOrderDetails_ctl02_txtWODetailsDesc']")
	private WebElement ItemDescriptionTxtf;
	public WebElement getItemDescriptionTxtff() {
		return ItemDescriptionTxtf;
	}
	
	@FindBy(xpath = "//select[@id='dgWorkOrderDetails_ctl02_ddlWODetailsUnits']")
	private WebElement UnitsDD;
	public WebElement getUnitsDD() {
		return UnitsDD;
	}
	
	@FindBy(xpath = "//input[@id='dgWorkOrderDetails_ctl02_txtWODetailsRate']")
	private WebElement RateTxtf;
	public WebElement getRateTxtf() {
		return RateTxtf;
	}
	
	@FindBy(xpath = "//input[@id='dgWorkOrderDetails_ctl02_txtWODetailsQuantity']")
	private WebElement QuantityTxtf;
	public WebElement getQuantityTxtf() {
		return QuantityTxtf;
	}
	
	@FindBy(xpath = "//select[@id='dgWorkOrderDetails_ctl02_ddlDiscountType']")
	private WebElement DiscountTypeDD;
	public WebElement getDiscountTypeDD() {
		return DiscountTypeDD;
	}
	
	@FindBy(xpath = "//input[@id='dgWorkOrderDetails_ctl02_txtDiscountAmount']")
	private WebElement DiscountValueTxtf;
	public WebElement getDiscountValueTxtf() {
		return DiscountValueTxtf;
	}
	
	@FindBy(xpath = "//input[@id='btnSubmit']")
	private WebElement WOItemSubBtn;
	public void getWObtnItem() {
		AppInd.waitForClickable(BrowserDriver, WOItemSubBtn, wait);
		WOItemSubBtn.click();
	}
	////****Work Order Item details ended......
	
	@FindBy(xpath  = "//textarea[@name='txtWorkDesc']")
	private WebElement WorkOrderDescriptionTxtf;
	public WebElement getWorkOrderDescriptionTxtf() {
		return WorkOrderDescriptionTxtf;
	}
	
	////****Tax Addition started......
	/// 1st tax
	@FindAll({@FindBy(css = "#lnkBtnAddRow"),@FindBy (xpath = "//a[@id='lnkBtnAddRow']")})
	private WebElement TaxAddRowLink;
	public void getTaxAddRowLink() {
		AppInd.waitForClickable(BrowserDriver, TaxAddRowLink, wait);
		TaxAddRowLink.click();
	}
	
	@FindBy(xpath = "//select[@id='dgTaxAdditions_ctl02_ddlAdditionTax']")
	private WebElement AdditionTaxDD_01;
	public WebElement getAdditionTaxDD_01() {
		return AdditionTaxDD_01;
	}
	
	@FindBy(xpath = "//select[@id='dgTaxAdditions_ctl02_ddlAdditionTaxType']")
	private WebElement TaxTypeDD_01;
	public WebElement getTaxTypeDD_01() {
		return TaxTypeDD_01;
	}
	
	@FindBy(xpath = "//td[@align='center']//input[@name='dgTaxAdditions$ctl02$txtAdditionTaxAmount']")
	private WebElement PercOfWOTxtf_01;
	public WebElement getPercOfWOTxtf_01() {
		return PercOfWOTxtf_01;
	}
	/// 2nd tax
	
	@FindBy(xpath = "//select[@id='dgTaxAdditions_ctl03_ddlAdditionTax']")
	private WebElement AdditionTaxDD_02;
	public WebElement getAdditionTaxDD_02() {
		return AdditionTaxDD_02;
	}
	
	@FindBy(xpath = "//select[@id='dgTaxAdditions_ctl03_ddlAdditionTaxType']")
	private WebElement TaxTypeDD_02;
	public WebElement getTaxTypeDD_02() {
		return TaxTypeDD_02;
	}
	
	@FindBy(xpath = "//input[@id='dgTaxAdditions_ctl03_txtAdditionTaxAmount']")
	private WebElement PercOfWOTxtf_02;
	public WebElement getPercOfWOTxtf_02() {
		return PercOfWOTxtf_02;
	}
	////****Tax Addition ended......
	
	@FindBy(xpath = "//select[@id='ddlAdvanceType']")
	private WebElement TypeOfAdvanceDD;
	public WebElement getTypeOfAdvanceDD() {
		return TypeOfAdvanceDD;
	}
	
	@FindBy(xpath = "//input[@id='txtCtAdvPerc']")
	private WebElement AdvancePercentageTxtf;
	public WebElement getAdvancePercentageTxtf() {
		return AdvancePercentageTxtf;
	}

	@FindBy(xpath = "//a[@id='lnkBtnDedTaxAddRow']")
	private WebElement TaxDedRowLink;
	public void getTaxDedRowLink() {
		AppInd.waitForClickable(BrowserDriver, TaxDedRowLink, wait);
		TaxDedRowLink.click();
	}
	
	@FindBy(xpath = "//select[@id='dgTaxDeductions_ctl02_ddlDeductionTax']")
	private WebElement DeductionTaxDD;
	public WebElement getDeductionTaxDD() {
		return DeductionTaxDD;
	}
	
	@FindBy(xpath = "//select[@id='ddlStatus']")
	private WebElement StatusDD;
	public WebElement getStatusDD() {
		return StatusDD;
	}
	
	@FindBy(xpath = "//textarea[@id='txtRemarks']")
	private WebElement RemarksTxtf;
	public WebElement getRemarksTxtf() {
		return RemarksTxtf;
	}
	
	@FindBy(xpath = "//a[@id='lnkAddTermsConditions']")
	private WebElement TermAndConLink;
	public void getTermAndConLink() {
		AppInd.waitForClickable(BrowserDriver, TermAndConLink, wait);
		TermAndConLink.click();
	}
	
	@FindBy(xpath = "//a[@id='lnkAcceptSelected']")
	private WebElement TermAndConAcceptBtn;
	public void getTermAndConAcceptBtn() {
		AppInd.waitForClickable(BrowserDriver, TermAndConAcceptBtn, wait);
		TermAndConAcceptBtn.click();
	}
	
	@FindBy(xpath = "//textarea[@id='gvTermsAndConditionsList_ctl02_txtTermsCondition']")
	private WebElement TermAndConTxtf;
	public WebElement getTermAndConTxtf() {
		return TermAndConTxtf;
	}
	
	@FindBy(xpath = "//a[@id='lnkBtnAddFile']")
	private WebElement DocumentsAddLink;
	public void getDocumentsAddLink() {
		AppInd.waitForClickable(BrowserDriver, DocumentsAddLink, wait);
		DocumentsAddLink.click();
	}
	
	@FindBy(xpath = "//a[text()='Upload Document']")
	private WebElement UploadDocumentLink;
	public void getUploadDocumentLink() {
		AppInd.waitForClickable(BrowserDriver, UploadDocumentLink, wait);
		UploadDocumentLink.click();
	}
	
	@FindBy(xpath = "//textarea[@id='gvDocuments_ctl02_txtRemarks']")
	private WebElement DocumentsRemarksTxtf;
	public WebElement getDocumentsRemarksTxtf() {
		return DocumentsRemarksTxtf;
	}

	@FindBy(xpath = "//input[@id='btnCreate']")
	private WebElement WoSubBtn;
	public void getWoSubBtn() {
		AppInd.waitForClickable(BrowserDriver, WoSubBtn, wait);
		WoSubBtn.click();
	}
	
	@FindBy(xpath = "//a[text()='Approvals ']")
	private WebElement ApprovalTab;
	public void getApprovalTab() {
		AppInd.waitForClickable(BrowserDriver, ApprovalTab, wait);
		ApprovalTab.click();
	}
	
	@FindBy(xpath = "//a[text()='Work Order']")
	private WebElement WoApprovalTab;
	public void getWoApprovalTab() {
		AppInd.waitForClickable(BrowserDriver, WoApprovalTab, wait);
		WoApprovalTab.click();
	}

	@FindBy(xpath = "//select[@id='ddlStatus']")
	private WebElement AppStatusDD;
	public WebElement getAppStatusDD() {
		return AppStatusDD;
	}
	
	@FindBy(xpath = "//textarea[@id='gvDocuments_ctl02_txtRemarks']")
	private WebElement AppRemarksTxtf;
	public WebElement getAppRemarksTxtf() {
		return AppRemarksTxtf;
	}
	
	@FindBy(xpath = "//input[@name='btnCreate']")
	private WebElement AppWoSubBtn;
	public void getAppWoSubBtn() {
		AppInd.waitForClickable(BrowserDriver, AppWoSubBtn, wait);
		AppWoSubBtn.click();
	}
	
	@FindBy(xpath = "//span[@id='lblDisplayNo']")
	private WebElement WODisNo;
	public String  getWODisplayNo() {
		return WODisNo.getText();		
	}
	
	public void CreateExpenseWO() throws Throwable {
	    try {
	        AppDep.MainParentFrame();
	        AppDep.LeftFrame();
	        getExpenses();
	        Thread.sleep(5000);

	        AppDep.DefaultContentFrame();
	        AppDep.MainParentFrame();
	        AppDep.MiddleFrame();
	        getWorkOrder();
	        AppDep.DefaultContentFrame();

	        Thread.sleep(3000);
	        AppDep.MainParentFrame();
	        AppDep.MainFrame();
	        AppDep.RightFrame();
	        getWOCreateBtn();

	        Thread.sleep(1500);
	        int WO_Rows = AppInd.getRowNumber(data.XLFilepath, data.XlShee3);
	        
	        for (int i = 2; i <= WO_Rows; i++) {
	        	
	        	String company = AppInd.readCellValueEmpty(data.XLFilepath, data.XlShee3, i, 0);
	        	String expense = AppInd.readCellValueEmpty(data.XLFilepath, data.XlShee3, i, 1);

	        	if (company.isEmpty() && expense.isEmpty()) {
	        	    System.out.println("🛑 CreateExpenseWO next row blank found, exiting...");
	        	    System.out.println();///Console purpose
	        	    break;
	        	}

	            AppInd.selectDropdownFromExcel(data.XLFilepath, data.XlShee3, i, 0, getCompanyDD());
	            Thread.sleep(2000);
	            AppInd.selectByVisibleText("Domestic", getWorkOrderTypeDD());
	            Thread.sleep(2000);
	            AppInd.selectDropdownFromExcel(data.XLFilepath, data.XlShee3, i, 1, getExpenseTypeDD());
	            Thread.sleep(2000);
	            AppInd.selectDropdownFromExcel(data.XLFilepath, data.XlShee3, i, 2, getExpenseSubTypeDD());
	            Thread.sleep(2000);
	            AppInd.selectDropdownFromExcel(data.XLFilepath, data.XlShee3, i, 3, getVendorNameDD());
	            Thread.sleep(2000);
	            AppInd.selectTextFieldFromExcel(data.XLFilepath, data.XlShee3, i, 4, getScopeOfWorkTxtf());
	            Thread.sleep(2000);
	            AppInd.selectTextFieldFromExcel(data.XLFilepath, data.XlShee3, i, 5, getContactNameTxtf());
	            Thread.sleep(3000);
	            AppDep.selectCurrentDate(BrowserDriver, getFromDatePicker());
	            Thread.sleep(3000);
	            AppDep.selectCurrentDate(BrowserDriver, getToDatePicker());
	            Thread.sleep(2500);
	           
	            ////****Work Order Item details started......
	            try{
	            getAddDetailsLink();
	            AppInd.Childwindow();
	            Thread.sleep(1750);
	            getAddRowLink();
	            Thread.sleep(1750);
	            AppInd.selectTextFieldFromExcel(data.XLFilepath, data.XlShee3, i, 6, getItemTxtf());
	            Thread.sleep(1750);
	            AppInd.selectTextFieldFromExcel(data.XLFilepath, data.XlShee3, i, 7, getItemDescriptionTxtff());
	            Thread.sleep(1750);
	            AppInd.selectDropdownFromExcel(data.XLFilepath, data.XlShee3, i, 8, getUnitsDD());
	            Thread.sleep(1500);
	            AppInd.selectTextFieldFromExcel(data.XLFilepath, data.XlShee3, i, 9, getRateTxtf());
	            Thread.sleep(1500);
	            AppInd.selectTextFieldFromExcel(data.XLFilepath, data.XlShee3, i, 10, getQuantityTxtf());
	            Thread.sleep(1500);
	            AppInd.selectByVisibleText("[Percent]", getDiscountTypeDD());
	            Thread.sleep(1500);
	            getDiscountValueTxtf().clear();
	            Thread.sleep(1000);
	            AppInd.selectTextFieldFromExcel(data.XLFilepath, data.XlShee3, i, 11, getDiscountValueTxtf());
	            Thread.sleep(1750);
	            getWObtnItem();
	            Thread.sleep(1750);
	            AppInd.Parentwindow();
	            BrowserDriver.switchTo().defaultContent(); // very important after switching windows
	            AppDep.MainParentFrame();
	            AppDep.MainFrame();
	            AppDep.RightFrame(); 
	            Thread.sleep(1750);
	            }
	            catch (Exception e) {
					System.out.println("Error on entering Work Order Item details.... "+e.getMessage());
				}
	            ////****Work Order Item details ended......
	            
	            AppInd.selectTextFieldFromExcel(data.XLFilepath, data.XlShee3, i, 12, getWorkOrderDescriptionTxtf());
	            Thread.sleep(1750);
	            
	            ////****Tax Addition started......
	            try {
	            getTaxAddRowLink();
	            Thread.sleep(2000);
	            AppInd.selectDropdownFromExcel(data.XLFilepath, data.XlShee3, i, 13, getAdditionTaxDD_01());
	            Thread.sleep(2000);
	            AppInd.selectByVisibleText("Exclusive", getTaxTypeDD_01());
	            Thread.sleep(1000);
	            AppInd.jsClearTextFieldSafe(BrowserDriver, getPercOfWOTxtf_01());
	            Thread.sleep(1500);
	            AppInd.selectTextFieldFromExcel(data.XLFilepath, data.XlShee3, i, 14, getPercOfWOTxtf_01());
	            Thread.sleep(2000);
	            getTaxAddRowLink();
	            Thread.sleep(2000);
	            AppInd.selectDropdownFromExcel(data.XLFilepath, data.XlShee3, i, 15, getAdditionTaxDD_02());
	            Thread.sleep(2000);
	            AppInd.selectByVisibleText("Exclusive", getTaxTypeDD_02());
	            Thread.sleep(2000);
	            AppInd.jsClearTextFieldSafe(BrowserDriver, getPercOfWOTxtf_02());
	            Thread.sleep(1000);
	            AppInd.selectTextFieldFromExcel(data.XLFilepath, data.XlShee3, i, 16, getPercOfWOTxtf_02());
	            Thread.sleep(1500);
	            }
	            catch (Exception e) {
					System.out.println("Error on selecting Tax Addition details.... "+e.getMessage());
				}
	            ////****Tax Addition ended......
	            AppInd.jsScrollToBottom(BrowserDriver);
	            Thread.sleep(1500);
	            AppInd.selectDropdownFromExcel(data.XLFilepath, data.XlShee3, i, 17, getTypeOfAdvanceDD());
	            Thread.sleep(2000);
	            AppInd.selectTextFieldFromExcel(data.XLFilepath, data.XlShee3, i, 18, getAdvancePercentageTxtf());
	            Thread.sleep(2000);
	           
	            ////****Tax Deduction started......
	            try {
	            getTaxDedRowLink();
	            Thread.sleep(1500);
	            AppInd.selectDropdownFromExcel(data.XLFilepath, data.XlShee3, i, 19, getDeductionTaxDD());
	            Thread.sleep(2000);
	            }
	            catch (Exception e) {
					System.out.println("Error on selecting Tax Deduction details.... "+e.getMessage());
				}
	            ////****Tax Deduction ended......
	            
	            AppInd.selectByVisibleText("SUBMITTED", getStatusDD());
	            Thread.sleep(2000);
	            AppInd.selectTextFieldFromExcel(data.XLFilepath, data.XlShee3, i, 20, getRemarksTxtf());
	            Thread.sleep(2000);
	            
	            ////**** TermAndConditions started......
	            try {
	            getTermAndConLink();
	            AppInd.Childwindow();
	            Thread.sleep(2000);
	            
	            List<WebElement> AllCheckBoxes = BrowserDriver.findElements(By.xpath("//input[@type='checkbox']"));
	            for(int j=1;j<=AllCheckBoxes.size();j++) {
	            	if(AllCheckBoxes.get(j).isDisplayed()) {
	            		AllCheckBoxes.get(j).click();
	            		break;
	            	}
	            }
	            Thread.sleep(1750);
	            getTermAndConAcceptBtn();
	            Thread.sleep(1750);
	            AppInd.Parentwindow();
	            BrowserDriver.switchTo().defaultContent(); // very important after switching windows
	            AppDep.MainParentFrame();
	            AppDep.MainFrame();
	            AppDep.RightFrame(); 
	            AppInd.selectTextFieldFromExcel(data.XLFilepath, data.XlShee3, i, 21, getTermAndConTxtf());
	            Thread.sleep(1750);
	            }
	            catch (Exception e) {
					System.out.println("Error on selecting Term and Conditions.... "+e.getMessage());
				}
		        ////**** TermAndConditions ended......
	            
	            ////**** Document attached started......
	            try {
	            getDocumentsAddLink();
	            Thread.sleep(1750);
	            getUploadDocumentLink();
	            AppInd.Childwindow();
	            Thread.sleep(1750);
	            WebElement upload = BrowserDriver.findElement(By.xpath("//input[@id='fupldDocument']"));
	            upload.sendKeys(data.FileUpload);
	            Thread.sleep(1750);
	            BrowserDriver.findElement(By.xpath("//input[@id='btnUpload']")).click();
	            AppInd.Parentwindow();
	            BrowserDriver.switchTo().defaultContent(); // very important after switching windows
	            AppDep.MainParentFrame();
	            AppDep.MainFrame();
	            AppDep.RightFrame(); 
	            Thread.sleep(1750);
	            AppInd.selectTextFieldFromExcel(data.XLFilepath, data.XlShee3, i, 22, getDocumentsRemarksTxtf());
	            }
	            catch (Exception e) {
					System.out.println("Error on uploading documents.... "+e.getMessage());
				}
	            ////**** Document attached ended......
	            Thread.sleep(1750);
	            getWoSubBtn();
	           
	        
	    Thread.sleep(3000);
        
	  ///Work order hyper link capturing
        List<WebElement> WorkOrderDispNo = BrowserDriver.findElements(By.xpath("//td[@align='left']//a[contains(@id, 'dgWorkOrder_ctl')]"));
        String capturedText = null;
        for (int k = 0; k < WorkOrderDispNo.size()-1; k++) {
            String linkText = WorkOrderDispNo.get(k).getText().trim(); // Trim for safety
            if (!linkText.isEmpty()) {
                capturedText = linkText;
                //System.out.println("✅ Work Order display No in create Work Order List page: " + capturedText);
                break; // Stop after first valid one
            }
        }
        
        try {
        AppDep.DefaultContentFrame();
		AppDep.MainParentFrame();
		AppDep.MiddleFrame();
		getApprovalTab();
		Thread.sleep(2500);
		AppDep.DefaultContentFrame();
		AppDep.MainParentFrame();
		AppDep.MiddleFrame();
		getWoApprovalTab();
		Thread.sleep(2500);
		AppDep.DefaultContentFrame();
		AppDep.MainParentFrame();
		AppDep.MainFrame();
		AppDep.RightFrame();
		
		///Work order hyper link clicking
		List<WebElement> updatedWorkOrderList = BrowserDriver.findElements(By.xpath("//td[@align='left']//a[contains(@id, 'dgWorkOrder_ctl')]"));
		if (capturedText != null) {
	        for (int l = 0; l < updatedWorkOrderList.size()-1; l++) {
	            String currentLinkText = updatedWorkOrderList.get(l).getText().trim();
	              if (capturedText.equals(currentLinkText)) {
	                WebElement matchingLink = updatedWorkOrderList.get(l);
	                    if(matchingLink.isDisplayed() && matchingLink.isEnabled()) {
	                    matchingLink.click();
	                    //System.out.println("✅ Work Order display No in Approval Work Order List page: " + currentLinkText);
	                    break;
	                }
	            }
	        }
	    } else {
	        System.out.println("⚠️ No valid Work Order link found in first loop.");
	    }
		
	        Thread.sleep(2000);
	        //String WoDispNO = BrowserDriver.findElement(By.xpath("//span[@id='lblDisplayNo']")).getText();
	        //System.out.println("Work Order display No is :"+WoDispNO);
	        AppInd.jsScrollToBottom(BrowserDriver);
	        Thread.sleep(1750);
	        AppInd.selectByVisibleText("APPROVED", getAppStatusDD());
	        Thread.sleep(2000);
	        String WoAmount = BrowserDriver.findElement(By.xpath("//span[@id='lblGrossAmount']")).getText();
	        WODisplayNo = getWODisplayNo();
	        System.out.println();///Console purpose
	        System.out.println("1. Expenses Work Order "+WODisplayNo+" Approved for "+WoAmount+" INR");
	        getAppWoSubBtn(); // Click the submit button
	        Thread.sleep(2000);
	        Assert.assertTrue(true);
        }
        catch (Exception e) {
        	System.out.println("Error on Approving the Work Order.... "+e.getMessage());
		}
     }
 }
	    
	    catch (Exception e) {
	        System.out.println("❌❌❌ Error during CreateExpenseWO execution:.............................");
	        e.printStackTrace();
	    }
    }
}

