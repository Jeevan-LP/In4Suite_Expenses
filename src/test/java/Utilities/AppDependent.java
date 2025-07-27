package Utilities;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.time.LocalDate;
import java.time.format.TextStyle;
import java.util.Locale;
import java.util.Properties;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AppDependent extends BaseClass{

	public WebDriver appDepDriver;
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
	
	
	////****** Switching Methods........ ******////
	public void MainParentFrame() {
	    ExpWait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.xpath("//iframe[@id='erpContainer']")));
	}

	public void LeftFrame() {
	    ExpWait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.xpath("//iframe[@name='mainmenuFrame']")));
	}

	public void MiddleFrame() {
	    ExpWait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.xpath("//iframe[@id='slideleft']")));
	}

	public void MainFrame() {
	    ExpWait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.xpath("//iframe[@name='mainFrame']")));
	}

	public void RightFrame() {
		ExpWait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.xpath("//frame[@name='rightframe']")));
	}
	    
	public void TopFrame() {
	    ExpWait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.xpath("//iframe[@src='topFrame.aspx']")));
	}
	
	public void TabFrame() {
	    ExpWait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.xpath("//frame[@name='TabFrame']")));
	}
	
	public void MainDinFrame() {
	    ExpWait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.xpath("//frame[@name='mainDn']")));
	}
	  
	public void DefaultContentFrame() {
		appDepDriver = getDriver(); // from BaseClass
		    if (appDepDriver == null) {
		        throw new IllegalStateException("❌ WebDriver not initialized in defaultContentFrame()");
		    }
		    appDepDriver.switchTo().defaultContent();
	}

	public void ParentContentFrame() {
		appDepDriver = getDriver();
		    if (appDepDriver == null) {
		        throw new IllegalStateException("❌ WebDriver not initialized in switchToParentFrame()");
		    }
		    appDepDriver.switchTo().parentFrame();
	}
	
	public void selectCurrentDate(WebDriver driver, WebElement dateInputField) {
        dateInputField.click();

        // Step 2: Get current date
        LocalDate today = LocalDate.now();
        String day = String.valueOf(today.getDayOfMonth());
        String monthFull = today.getMonth().getDisplayName(TextStyle.FULL, Locale.ENGLISH); // e.g., "July"
        String year = String.valueOf(today.getYear());

        // Step 3: Select month from dropdown
        WebElement monthDropdown = driver.findElement(By.xpath("//select[@title='Change the month']"));
        Select selectMonth = new Select(monthDropdown);
        selectMonth.selectByVisibleText(monthFull);

        // Step 4: Select year from dropdown
        WebElement yearDropdown = driver.findElement(By.xpath("//select[@title='Change the year']"));
        Select selectYear = new Select(yearDropdown);
        selectYear.selectByVisibleText(year);

        // Step 5: Click the correct day cell
        java.util.List<WebElement> dayCells = driver.findElements(By.xpath("//a[contains(@title,'Select')]"));

        for (WebElement cell : dayCells) {
            if (cell.getText().equals(day)) {
                cell.click();
                break;
            }
        }
     }
  }
