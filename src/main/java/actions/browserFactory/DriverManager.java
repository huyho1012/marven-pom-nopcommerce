package actions.browserFactory;

import actions.common.functionHelper.Constants;
import org.openqa.selenium.WebDriver;

import java.util.concurrent.TimeUnit;

public abstract class DriverManager {
    protected WebDriver driver;
    protected abstract void createDriver();
    public void quitDriver() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }

    }
    public WebDriver getDriver(){
        if(driver ==null){
            createDriver();
        }
        driver.get(Constants.WORD_PRESS_URL);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Constants.LONG_TIMEOUT, TimeUnit.SECONDS);
        return driver;
    }
    public WebDriver getDriver(String urlLink){
        if(driver ==null){
            createDriver();
        }
        driver.get(urlLink);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Constants.LONG_TIMEOUT, TimeUnit.SECONDS);
        return driver;
    }
}

