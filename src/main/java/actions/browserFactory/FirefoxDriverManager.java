package actions.browserFactory;

import actions.common.Global_Constants;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;

import java.io.File;

public class FirefoxDriverManager extends DriverManager{
    @Override
    protected void createDriver() {
        WebDriverManager.firefoxdriver().setup();
        System.setProperty(FirefoxDriver.SystemProperty.DRIVER_USE_MARIONETTE,"true");
        System.setProperty(FirefoxDriver.SystemProperty.BROWSER_LOGFILE,Global_Constants.ROOT_USER_FOLDER+ "\\logBrowser\\Firefox.log");
        File file1 = new File(Global_Constants.ROOT_USER_FOLDER+ "\\libraries\\Extension\\chropath.xpi");
        FirefoxProfile profile = new FirefoxProfile();
        profile.addExtension(file1);
        FirefoxOptions options = new FirefoxOptions();
        options.setProfile(profile);
        driver = new FirefoxDriver(options);
    }
}
