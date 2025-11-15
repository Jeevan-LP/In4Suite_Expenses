package Utilities;

import java.net.URL;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
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
        WebDriver localDriver = null;
        
        this.appInd = new AppIndependent();
        appInd.appIndDriver = browserDriver;
        appInd.ExpWait = expWait;
        this.data = new DataTable();
        //////for local environment execution
        if(appInd.getKeyValue(data.ProFilePath, "Execution_Env").equalsIgnoreCase("local")) {
        	switch (browser.toLowerCase()) {
        		case "chrome":localDriver = new ChromeDriver();break;
        		case "edge":localDriver = new EdgeDriver();break;
        		case "firefox":localDriver = new FirefoxDriver();break;
        		default:throw new IllegalArgumentException("❌ Invalid browser: " + browser);
        	}
        }
        
        //////for remote environment execution
        if (appInd.getKeyValue(data.ProFilePath, "Execution_Env").equalsIgnoreCase("remote")) {
            DesiredCapabilities capabilities = new DesiredCapabilities();

            // Set browser
            switch (browser.toLowerCase()) {
                case "chrome":capabilities.setBrowserName("chrome");break;
                case "firefox":capabilities.setBrowserName("firefox");break;
                case "edge":capabilities.setBrowserName("MicrosoftEdge");break;
                default:throw new IllegalArgumentException("❌ Invalid browser: " + browser);
            }

            // Set OS/platform
            switch (os.toLowerCase()) {
                case "windows":capabilities.setPlatform(Platform.WIN11); break;
                case "linux":capabilities.setPlatform(Platform.LINUX); break;   
                case "mac":capabilities.setPlatform(Platform.MAC);break;
                default:throw new IllegalArgumentException("❌ Invalid operating system: " + os);
            }
            // Accept insecure certs (optional, helps with HTTPS)
            capabilities.setAcceptInsecureCerts(true);
            // Create remote driver
            localDriver = new RemoteWebDriver(new URL("http://localhost:5555/wd/hub"), capabilities);
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