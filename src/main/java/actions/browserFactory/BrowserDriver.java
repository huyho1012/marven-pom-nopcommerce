package actions.browserFactory;

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
}
