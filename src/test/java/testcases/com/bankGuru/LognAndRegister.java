package testcases.com.bankGuru;


import actions.common.AbstractTest;
import actions.pageObject.bankGuru.HomePageObject;
import actions.pageObject.bankGuru.LoginPageObject;
import actions.pageObject.bankGuru.RegisterPageObject;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class LognAndRegister extends AbstractTest {
    WebDriver driver;
    LoginPageObject loginPage;
    HomePageObject homePage;
    RegisterPageObject registerPage;
    String loginPageUrl;
    String email = "huyo1210" +randomNumber()+"@gmail.com";
    public static String userID, passID;
    @BeforeClass
    public void openPage(){
        System.setProperty("webdriver.chromw.driver","browserDriver/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.get("http://demo.guru99.com/v4");
        loginPageUrl = driver.getCurrentUrl();

    }
    @Test
    public void TC_01_Register(){
        loginPage.clickHereLink();
        registerPage = new RegisterPageObject(driver);
        registerPage.enterToEmailIDTextbox(email);
        registerPage.clickToSubmitButton();
        userID =registerPage.getValueOnEmailID();
        passID = registerPage.getValueOnPass();

        registerPage.openLoginPage(loginPageUrl);
        loginPage = new LoginPageObject(driver);

    }
    @Test
    public void TC_01_Login(){

    }
    @AfterTest
    public void closePage(){
        driver.close();
    }
}
