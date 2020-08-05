package actions.browserFactory;

import common.Global_Constants;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.io.File;

public class ChromeDriverManager extends DriverManager {
    @Override
    protected void createDriver() {
        WebDriverManager.chromedriver().setup();
        File file = new File(Global_Constants.ROOT_USER_FOLDER+ "\\libraries\\Extension\\chropath.crx");
        System.setProperty("webdriver.chrome.args","--disable-logging");
        System.setProperty("webdriver.chrome.silentOutput","true");
        ChromeOptions options = new ChromeOptions();
        options.addExtensions(file);
        options.addArguments("--disable-notifications");
        options.addArguments("--disable-geolocation");
        options.addArguments("--disable-inforbars");
        driver = new ChromeDriver(options);
    }
}
