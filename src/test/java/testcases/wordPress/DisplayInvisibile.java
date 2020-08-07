package testcases.wordPress;


import actions.browserFactory.BrowserDriver;
import actions.browserFactory.DriverManager;
import actions.common.functionHelper.AbstractTest;
import actions.pageObject.wordpress.Admin.DashboardPageObject;
import actions.pageObject.wordpress.Admin.LoginPageObject;
import actions.pageObject.wordpress.common.PageGeneratorManager;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class DisplayInvisibile extends AbstractTest {
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
        loginPage =  PageGeneratorManager.getLoginAdminPage(driver);
        loginPageUrl = loginPage.getLoginPageUrl(driver);
        loginPage.inputUserName("automationeditor");
        loginPage.clickToContinueButton();
        loginPage.inputPassword("automationfc");
        dashboardPage = loginPage.clickToDashboard(driver);

    }
    @Test
    public void TC01_Element_Un_Display_On_DOM(){
        dashboardPage.clicktoScreenOption();
        dashboardPage.setDelayTime(3);
        System.out.println("Time check" + getDateTimeNow());
        Assert.assertTrue(dashboardPage.isActivityCheckboxDisplayed());
        System.out.println("Time end check" + getDateTimeNow());
        dashboardPage.clicktoScreenOption();
        dashboardPage.setDelayTime(3);
        System.out.println("Time check" + getDateTimeNow());
        Assert.assertFalse(dashboardPage.isActivityCheckboxDisplayed());
        System.out.println("Time end check" + getDateTimeNow());
        System.out.println("Time check" + getDateTimeNow());
        Assert.assertFalse(dashboardPage.isDisplayAllPostSubMeneu());
        System.out.println("Time end check" + getDateTimeNow());
    }
    @Test
    public void TC02_Element_Un_Display_Without_DOM(){
        Assert.assertTrue(dashboardPage.isPlansMenuUnDisplay());
    }
}
