package actions.browserFactory.Manager;

import actions.browserFactory.DriverManager;
import actions.common.functionHelper.Constants;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.io.File;

public class ChromeDriverManager extends DriverManager {
    @Override
    protected void createDriver() {
        WebDriverManager.chromedriver().setup();
        File file = new File(Constants.ROOT_USER_FOLDER+ "\\LibraryAndSupport\\extension\\chropath.crx");
        System.setProperty("webdriver.chrome.args","--disable-logging");
        System.setProperty("webdriver.chrome.silentOutput","true");
        ChromeOptions options = new ChromeOptions();
        options.addExtensions(file);
        options.addArguments("--disable-extensions");
        options.addArguments("--disable-inforbars");
        options.addArguments("--start-maximized");
        options.addArguments("--disable-notifications");
        options.addArguments("--disable-geolocation");

        driver = new ChromeDriver(options);
    }
}
