package actions.browserFactory;

import actions.browserFactory.Manager.*;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class BrowserDriver {

    public static DriverManager getBrowser(String browserName){
        DriverManager driverManager;
        switch (browserName) {
            case "chrome":
                driverManager =new ChromeDriverManager();
                break;
            case "firefox":
                driverManager = new FirefoxDriverManager();
                break;
            case "coccoc":
                driverManager = new CocCocDriverManager();
                break;
            case "edge":
                driverManager = new EdgeDriverManager();
                break;
            case "chrome_headless":
                driverManager = new ChromeHeadlessManager();
                break;
            default:
                driverManager = new FirefoxHeadlessManager();
                break;
        }
        return driverManager;
    }

    public static class ChromeHeadlessManager extends DriverManager {
        @Override
        protected void createDriver() {
            WebDriverManager.chromedriver().setup();
            ChromeOptions options = new ChromeOptions();
            options.addArguments("headless");
            options.addArguments("window-size=1920x1080");
            driver = new ChromeDriver(options);
        }
    }
}
