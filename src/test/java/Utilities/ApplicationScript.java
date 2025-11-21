package Utilities;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class ApplicationScript extends BaseClass {

    public WebDriver browserDriver;
    public AppIndependent appInd;
    public AppDependent appDep;
    public WebDriverWait expWait;
    public DataTable data;
    public final int wait = 20;

    // WebElements
    @FindBy(id = "txtLoginId") public WebElement login;
    @FindBy(id = "txtPassword") public WebElement password;
    @FindBy(id = "cmbLogin") public WebElement loginBtn;
    @FindBy(id = "btnYes") public WebElement yesBtn;
    @FindBy(xpath = "//img[@src='../images/logout-icon.svg']") public WebElement logoutBtn;

    // ✅ Use default constructor
    public ApplicationScript() {
        this.browserDriver = getDriver(); // From BaseClass thread-local
        PageFactory.initElements(browserDriver, this);

        this.expWait = new WebDriverWait(browserDriver, Duration.ofSeconds(wait));

        this.appInd = new AppIndependent();
        appInd.appIndDriver = browserDriver;
        appInd.ExpWait = expWait;

        this.appDep = new AppDependent();
        appDep.appDepDriver = browserDriver;
        appDep.ExpWait = expWait;

        this.data = new DataTable();
    }

    @Test(priority = 1)
    public void loginTest() throws Throwable {
        login.sendKeys(appInd.getKeyValue(data.ProFilePath, "UserName"));
        Thread.sleep(1000);
        password.sendKeys(appInd.getKeyValue(data.ProFilePath, "PassWord"));
        appInd.waitForClickable(browserDriver, loginBtn, wait);
        loginBtn.click();

        appInd.waitForClickable(browserDriver, yesBtn, wait);
        yesBtn.click();
        System.out.println("In4Suite Login successful!.....");
    }

    @Test(priority = 7)
    public void logoutTest() {
        appDep.DefaultContentFrame();
        appDep.MainParentFrame();
        appDep.TopFrame();

        appInd.waitForClickable(browserDriver, logoutBtn, 20);
        logoutBtn.click();

        System.out.println("In4Suite Logout successful!.....");
    }
}
