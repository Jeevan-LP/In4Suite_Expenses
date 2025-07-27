package Utilities;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.Set;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AppIndependent{

	public WebDriver appIndDriver;
	public WebElement Element;
    public WebDriverWait ExpWait;
    public FileInputStream fInput;
	public Properties Pfile;
	public FileOutputStream fOutput;
	public XSSFWorkbook XworkBook;
	public XSSFSheet Xsheet;
	public XSSFRow Xrow;
	public XSSFCell Xcell;
	public XSSFCellStyle Xstyle;
	public JavascriptExecutor jsExecutor;
	public WebElement WElement;
	
	////****** Wait Methods........ ******////
	public void waitForVisibility(WebDriver driver, WebElement element, int seconds) {
        WebDriverWait ExpWait = new WebDriverWait(driver, Duration.ofSeconds(seconds));
        ExpWait.until(ExpectedConditions.visibilityOf(element));
    }

	public void waitForClickable(WebDriver driver, WebElement element, int seconds) {
		WebDriverWait ExpWait = new WebDriverWait(driver, Duration.ofSeconds(seconds));
		ExpWait.until(ExpectedConditions.elementToBeClickable(element));
	}
	
	public boolean isAlertPresent(WebDriver driver, int seconds) {
	    try {
	        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(seconds));
	        wait.until(ExpectedConditions.alertIsPresent());
	        return true; // Alert is present
	    } catch (Exception e) {
	        return false; // No alert
	    }
	}

	////****** JavascriptExecutor Methods........ ******////
	public void jsClearTextFieldSafe(WebDriver driver, WebElement element) {
	    JavascriptExecutor js = (JavascriptExecutor) driver;
	    for (int i = 0; i < 3; i++) {
	        try {
	            js.executeScript("arguments[0].value = '';", element);
	            break;
	        } catch (StaleElementReferenceException e) {
	            System.out.println("Element went stale, retrying...");
	        }
	    }
	}
	
	public void jsScrollToBottom(WebDriver driver) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollTo(0, document.body.scrollHeight);");
    }

    
    public void jsScrollToTop(WebDriver driver) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollTo(0, 0);");
    }
    
    public void jsClick(WebDriver driver, WebElement element) {
        try {
            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("arguments[0].click();", element);
        } catch (Exception e) {
            System.out.println("❌ JavaScript click failed: " + e.getMessage());
        }
    }

		////****** Switching To Methods........ ******////
	public void Parentwindow() {
	    	Set<String> windowID = appIndDriver.getWindowHandles();
			List<String> list = new ArrayList<String>(windowID);
			
			String Parent = list.get(0);
			appIndDriver.switchTo().window(Parent);
			//System.out.println("Switching to (Back to Parent) "+BrowserDriver.getTitle()+" Window");
	    }
	    
	public void Childwindow() {
	    	Set<String> windowID = appIndDriver.getWindowHandles();
			List<String> list = new ArrayList(windowID);
			
			String Child = list.get(1);
			appIndDriver.switchTo().window(Child);
			//System.out.println("Switching to (Child) "+BrowserDriver.getTitle()+" Window");
	    }
	    
	public void NestedChildwindow() {
	    	Set<String> windowID = appIndDriver.getWindowHandles();
			List<String> list = new ArrayList(windowID);
			
			String NestedChild = list.get(2);
			appIndDriver.switchTo().window(NestedChild);
			//System.out.println("Switching to "+BrowserDriver.getTitle()+" Window");
	    }
   
	    ////****** Drop downs Methods........ ******////
	 public void selectByVisibleText(String visibleText, WebElement dropdownElement) {
	        Select select = new Select(dropdownElement);
	        select.selectByVisibleText(visibleText);
	    }
	
	 public void selectByValue(WebElement dropdownElement, String value) {
	        Select select = new Select(dropdownElement);
	        select.selectByValue(value);
	    }
	
	 public void selectByIndex(WebElement dropdownElement, int index) {
	        Select select = new Select(dropdownElement);
	        select.selectByIndex(index);
	    }
	    
	 public void deSelectByVisibleText(WebElement dropdownElement, String visibleText) {
	        Select select = new Select(dropdownElement);
	        select.deselectByVisibleText(visibleText);
	    }
	
	 public void deSelectByValue(WebElement dropdownElement, String value) {
	        Select select = new Select(dropdownElement);
	        select.deselectByValue(value);
	    }
	
	 public void deSelectByIndex(WebElement dropdownElement, int index) {
	        Select select = new Select(dropdownElement);
	        select.deselectByIndex(index);
	    }
	
	 public void deselectAll(WebElement dropdownElement) {
	        Select select = new Select(dropdownElement);
	        select.deselectAll();
	    }
	
	 public void printAllSelectedOptions(WebElement dropdownElement) {
	        Select select = new Select(dropdownElement);
	        for (WebElement option : select.getAllSelectedOptions()) {
	            System.out.println("Selected: " + option.getText());
	        }
	    }   
	    
	 public List<WebElement> getALLOptions(WebElement dropdownElement) {
	            Select select = new Select(dropdownElement);
	            return select.getOptions();
	    }
	    
	
	 ////****** Properties class Methods........ ******////
	 public String getKeyValue(String FilePath, String KeyName) throws Throwable {
			fInput=new FileInputStream(FilePath);
			Pfile= new Properties();
			Pfile.load(fInput);
			String Keyvalue = Pfile.getProperty(KeyName);
			//System.out.println(Keyvalue);
			fInput.close();
			return Keyvalue;
		 }
		
	 public Set<String> getKeyName(String FilePath) throws Throwable {
			fInput=new FileInputStream(FilePath);
			Pfile= new Properties();
			Pfile.load(fInput);
			Set<String> KeyName = Pfile.stringPropertyNames();
			for(String KName:KeyName) {
				System.out.println(KName);
			}
			fInput.close();
			return KeyName;
		}
	
		
	 ////****** Excel class Methods........ ******////
	 public int getRowNumber(String XLfileName, String XLsheetName) throws Throwable {
			fInput=new FileInputStream(XLfileName);
			XworkBook=new XSSFWorkbook(fInput);
			Xsheet=XworkBook.getSheet(XLsheetName);
			int RowNO=Xsheet.getLastRowNum();
			//System.out.println("Number of Rows "+RowNO);
			XworkBook.close();
			fInput.close();
			return RowNO;
		}
		
	 public int getCellNumber(String XLfileName, String XLsheetName, int Rows) throws Throwable {
			fInput=new FileInputStream(XLfileName);
			XworkBook=new XSSFWorkbook(fInput);
			Xsheet=XworkBook.getSheet(XLsheetName);
			Xrow=Xsheet.getRow(Rows);
			int CellNo=Xrow.getLastCellNum();
			//System.out.println("Number of Cells "+CellNo);
			XworkBook.close();
			fInput.close();
			return CellNo;
			
		}
		
	 //public static String getCellSingleData(String XLfileName, String XLsheetName, int Rows, int cells)// both also correct
	 public String getCellData(String XLfileName, String XLsheetName, int Rows, int cells)throws Throwable {
			fInput=new FileInputStream(XLfileName);
			XworkBook=new XSSFWorkbook(fInput);
			Xsheet=XworkBook.getSheet(XLsheetName);
			Xrow=Xsheet.getRow(Rows);
			Xcell=Xrow.getCell(cells);
	
			String data;
			try {
			DataFormatter formatter = new DataFormatter();
			data=formatter.formatCellValue(Xcell);
			System.out.println(formatter.formatCellValue(Xcell));
			}
			catch (Exception e) {
				data="";
			}
			XworkBook.close();
			fInput.close();
			return data;
		}
		
	 public String getCellAllData(String XLfileName, String XLsheetName, int Rows) throws Throwable {
			fInput=new FileInputStream(XLfileName);
			XworkBook=new XSSFWorkbook(fInput);
			Xsheet=XworkBook.getSheet(XLsheetName);
			int rowNo=Xsheet.getLastRowNum();
			int cellNo = Xsheet.getRow(Rows).getLastCellNum();
			
			for(int r=0;r<=rowNo;r++) {
				Xrow=Xsheet.getRow(r);
				for(int c=0;c<=cellNo-1;c++) {
					Xcell=Xrow.getCell(c);
					String data;
					try {
					DataFormatter formatter = new DataFormatter();
					data=formatter.formatCellValue(Xcell);
					System.out.print(formatter.formatCellValue(Xcell)+"\t");
					}
					catch (Exception e) {
						data="";
					}
				}
				System.out.println();
			}
			return XLsheetName;
			
		}
		
	 public WebElement selectDropdownFromExcel(String XLfileName, String XLsheetName, int Rows, int cells, WebElement dropdownElement)throws Throwable {
			try {
			fInput=new FileInputStream(XLfileName);
			XworkBook=new XSSFWorkbook(fInput);
			Xsheet=XworkBook.getSheet(XLsheetName);
			if (Xsheet == null) {
				XworkBook.close();
				fInput.close();
	            throw new IllegalArgumentException("Sheet not found: " + XLsheetName);
	        }
			Xrow=Xsheet.getRow(Rows);
			if (Xrow == null) {
				XworkBook.close();
				fInput.close();
	            throw new IllegalArgumentException("Row not found: " + Xrow);
	        }
			Xcell=Xrow.getCell(cells);
	        if (Xcell == null) {
	        	XworkBook.close();
	        	fInput.close();
	            throw new IllegalArgumentException("Cell not found: " + Xcell);
	        }
	        String value = new DataFormatter().formatCellValue(Xcell);
	        new Select(dropdownElement).selectByVisibleText(value);
			}
			catch (Exception e) {
				System.out.println("Error selecting dropdown into textfiled from excel: " + e.getMessage());
				
			}
			return dropdownElement;
		}
		
	 public WebElement selectTextFieldFromExcel(String XLfileName, String XLsheetName, int Rows, int cells, WebElement TextFieldElement)throws Throwable {
			try {
			fInput=new FileInputStream(XLfileName);
			XworkBook=new XSSFWorkbook(fInput);
			Xsheet=XworkBook.getSheet(XLsheetName);
			if (Xsheet == null) {
				XworkBook.close();
				fInput.close();
	            throw new IllegalArgumentException("Sheet not found: " + XLsheetName);
	        }
			Xrow=Xsheet.getRow(Rows);
			if (Xrow == null) {
				XworkBook.close();
				fInput.close();
	            throw new IllegalArgumentException("Row not found: " + Xrow);
	        }
			Xcell=Xrow.getCell(cells);
	        if (Xcell == null) {
	        	XworkBook.close();
	        	fInput.close();
	            throw new IllegalArgumentException("Cell not found: " + Xcell);
	        }
	        String value = new DataFormatter().formatCellValue(Xcell);
			TextFieldElement.sendKeys(value);
			}
			catch (Exception e) {
				System.out.println("Error entering data into textfiled from excel: " + e.getMessage());
			}
			return TextFieldElement;
		}
		
	 public String readCellValueEmpty(String filePath, String sheetName, int rowNum, int colNum) throws Exception {
			try {
			fInput = new FileInputStream(filePath);
	        XworkBook = new XSSFWorkbook(fInput);
	        Xsheet = XworkBook.getSheet(sheetName);
	        Xrow = Xsheet.getRow(rowNum);

	        if (Xrow == null) {
	            XworkBook.close();
	            fInput.close();
	            return "";
	        }
	        Xcell = Xrow.getCell(colNum);
	        DataFormatter formatter = new DataFormatter();
	        String value = (Xcell == null) ? "" : formatter.formatCellValue(Xcell);

	        XworkBook.close();
	        fInput.close();
	        return value.trim();
			}
			catch (Exception e) {
				System.out.println("Read Cell Value Empty: "+e.getMessage());
				e.printStackTrace();
				 return "";
			}
	    }

	 public void SetCellData(String XLfileName, String XLsheetName, int Rows, int cells, String data) throws Throwable {
			 fInput=new FileInputStream(XLfileName);
			 XworkBook=new XSSFWorkbook(fInput);
			 Xsheet=XworkBook.getSheet(XLsheetName);
			 Xrow=Xsheet.getRow(Rows);
			 
			 Xcell= Xrow.createCell(cells);
			 Xcell.setCellValue(data);
			 fOutput=new FileOutputStream(XLfileName);
			 XworkBook.write(fOutput);
			 XworkBook.close();
			 fInput.close();
			 fOutput.close();
	 }
		
	 public void fillGreenColor(String XLfileName, String XLsheetName, int Rows, int cell) throws Throwable {
	 		    try (FileInputStream fInput = new FileInputStream(XLfileName);
			         XSSFWorkbook XworkBook = new XSSFWorkbook(fInput)) {
	
			        XSSFSheet Xsheet = XworkBook.getSheet(XLsheetName);
			        XSSFRow Xrow = Xsheet.getRow(Rows);
			        XSSFCell Xcell = Xrow.getCell(cell);
	
			        XSSFCellStyle Xstyle = XworkBook.createCellStyle();
			        Xstyle.setFillForegroundColor(IndexedColors.GREEN.getIndex());
			        Xstyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);
	
			        Xcell.setCellStyle(Xstyle);
	
			        try (FileOutputStream fOutput = new FileOutputStream(XLfileName)) {
			            XworkBook.write(fOutput);
			        }
			}
	}
			
	 public void fillRedColor(String XLfileName, String XLsheetName, int Rows, int cell) throws Throwable {
			    try (FileInputStream fInput = new FileInputStream(XLfileName);
			         XSSFWorkbook XworkBook = new XSSFWorkbook(fInput)) {
	
			        XSSFSheet Xsheet = XworkBook.getSheet(XLsheetName);
			        XSSFRow Xrow = Xsheet.getRow(Rows);
			        XSSFCell Xcell = Xrow.getCell(cell);
	
			        XSSFCellStyle Xstyle = XworkBook.createCellStyle();
			        Xstyle.setFillForegroundColor(IndexedColors.RED.getIndex());
			        Xstyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);
	
			        Xcell.setCellStyle(Xstyle);
	
			        try (FileOutputStream fOutput = new FileOutputStream(XLfileName)) {
			            XworkBook.write(fOutput);
			        }
			   }
		}
		 
}
