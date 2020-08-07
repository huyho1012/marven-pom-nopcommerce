package testcases.wordPress;


import actions.browserFactory.BrowserDriver;
import actions.browserFactory.DriverManager;
import actions.common.functionHelper.AbstractTest;
import actions.pageObject.wordpress.Admin.DashboardPageObject;
import actions.pageObject.wordpress.Admin.LoginPageObject;
import actions.pageObject.wordpress.common.PageGeneratorManager;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;


public class TC12_HTML_REPORT  extends AbstractTest {
    DriverManager driverManager;
    WebDriver driver;
    LoginPageObject loginPage;
    String loginPageUrl;
    DashboardPageObject dashboardPage;

    @Parameters("browser")
    @BeforeClass
    public void preconditionTest(String browserName){
        driverManager = BrowserDriver.getBrowser(browserName);
        driver = driverManager.getDriver();

        log.info("Preconditon - Step 01: Open Login Page");
        loginPage =  PageGeneratorManager.getLoginAdminPage(driver);
        loginPageUrl = loginPage.getLoginPageUrl(driver);

        log.info("Preconditon - Step 02: Input to Email");
        loginPage.inputUserName("automationeditor");

        log.info("Preconditon - Step 03: Click continue Button ");
        loginPage.clickToContinueButton();

        log.info("Preconditon - Step 04: Input to Password");
        loginPage.inputPassword("automationfc");

        log.info("Preconditon - Step 05: Click Login Button ");
        dashboardPage = loginPage.clickToDashboard(driver);

    }
    @Test
    public void TC01_Element_Un_Display_On_DOM(){
        log.info("TC01 - Step 01: Click Screen Button ");
        dashboardPage.clicktoScreenOption();
        dashboardPage.setDelayTime(2);
        log.info("TC01 - Step 02 Check display");
        verifyTrue(dashboardPage.isActivityCheckboxDisplayed());

        dashboardPage.clicktoScreenOption();
        dashboardPage.setDelayTime(2);

        verifyTrue(dashboardPage.isActivityCheckboxDisplayed());
        verifyFalse(dashboardPage.isDisplayAllPostSubMeneu());
    }
    @Test
    public void TC02_Element_Un_Display_Without_DOM(){

        verifyTrue(dashboardPage.isPlansMenuUnDisplay());
        verifyFalse(dashboardPage.isDisplayAllPostSubMeneu());
    }
    @AfterClass (alwaysRun = true)
    public void closePage(){
        closeBrowserAndDriver(driver);
    }
}
