package actions.browserFactory.Manager;

import actions.browserFactory.DriverManager;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class CocCocDriverManager extends DriverManager {

    @Override
    protected void createDriver() {
        WebDriverManager.chromiumdriver().driverVersion("81.0.4044.69").setup();
        ChromeOptions options = new ChromeOptions();
        options.setBinary("C:\\Users\\Win 10\\AppData\\Local\\CocCoc\\Browser\\Application\\browser.exe");
        driver = new ChromeDriver(options);
    }
}
