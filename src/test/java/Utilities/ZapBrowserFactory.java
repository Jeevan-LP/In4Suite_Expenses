package Utilities;

import org.openqa.selenium.Proxy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ZapBrowserFactory extends BaseClass{

    public static WebDriver createDriver(String browser) {
        Proxy proxy = new Proxy();
        proxy.setHttpProxy("localhost:8090");
        proxy.setSslProxy("localhost:8090");

        WebDriver driver = null;

        switch (browser.toLowerCase()) {
            case "chrome":
                WebDriverManager.chromedriver().setup();
                ChromeOptions chromeOptions = new ChromeOptions();
                chromeOptions.setProxy(proxy);
                driver = new ChromeDriver(chromeOptions);
                break;

            case "firefox":
                WebDriverManager.firefoxdriver().setup();
                FirefoxOptions firefoxOptions = new FirefoxOptions();
                firefoxOptions.setProxy(proxy);
                driver = new FirefoxDriver(firefoxOptions);
                break;

            case "edge":
                WebDriverManager.edgedriver().setup();
                EdgeOptions edgeOptions = new EdgeOptions();
                edgeOptions.setProxy(proxy);
                driver = new EdgeDriver(edgeOptions);
                break;

            default:
                throw new IllegalArgumentException("❌ Unsupported browser: " + browser);
        }

        return driver;
    }
}
