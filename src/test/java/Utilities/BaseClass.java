package Utilities;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

public class BaseClass {

    // Thread-safe driver instance for parallel execution
    public static ThreadLocal<WebDriver> iDriver = new ThreadLocal<>();
    public WebDriver browserDriver;
    public WebDriverWait expWait;
    public AppIndependent appInd;
    public AppDependent appDep;
    public DataTable data;
    public final int wait = 20;

    public WebDriver getDriver() {
        return iDriver.get();
    }

    @Parameters({"os", "browser"})
    @BeforeClass(alwaysRun = true)
    public void setUp(@Optional("windows") String os, @Optional("chrome") String browser, ITestContext context) throws Throwable {
        WebDriver localDriver;
        
        switch (browser.toLowerCase()) {
        case "chrome":localDriver = new ChromeDriver();break;
        case "edge":localDriver = new EdgeDriver();break;
        case "firefox":localDriver = new FirefoxDriver();break;
        default:throw new IllegalArgumentException("❌ Invalid browser: " + browser);
    }
        iDriver.set(localDriver);
        browserDriver = getDriver();

        browserDriver.manage().deleteAllCookies();
        browserDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        browserDriver.manage().window().maximize();

        expWait = new WebDriverWait(browserDriver, Duration.ofSeconds(wait));
        appInd = new AppIndependent();
        appDep = new AppDependent();
        data = new DataTable();
    
        browserDriver.get(appInd.getKeyValue(data.ProFilePath, "URL"));
        
        WebElement In4SuiteLogo = browserDriver.findElement(By.xpath("//img[@id='imgIn4Logo']"));
        Assert.assertEquals(In4SuiteLogo.isDisplayed(), true);

        context.setAttribute("WebDriver", browserDriver);
    }

    @AfterClass(alwaysRun = true)
    public void tearDown() {
        browserDriver = getDriver();
        if (browserDriver != null) {
        	browserDriver.quit();
            iDriver.remove();
        }
    }
}