package testcases.com.bankGuru;

import actions.browserFactory.BrowserDriver;
import actions.browserFactory.DriverManager;
import actions.common.AbstractTest;
import actions.pageObject.bankGuru.*;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class DynamicElement extends AbstractTest {
    WebDriver driver;

    HomePageObject homePage;
    LoginPageObject loginPage;
    RegisterPageObject registerPage;
    CustomerPageObject customerPage;
    DriverManager driverManager;
    String loginPageUrl;
    String userID, password;
    String fullName, gender, dob, add,city,state,pin,mobileNumber,pass;
    String addEdit,cityEdit,stateEdit,pinEdit,mobileNumberEdit,newEmail;

    String email = "huyo1210" +randomNumber()+"@gmail.com";
    @Parameters("browser")
    @BeforeTest
    public void openTest(String browserName){
        driverManager = BrowserDriver.getBrowser(browserName);
        driver = driverManager.getDriver("http://demo.guru99.com/v4");

        fullName= "Huy Ho";
        gender= "Male";
        dob= "1992-12-01";
        add= "400A DBP";
        city= "HCM";
        state= "HCM";
        pin= "123456";
        mobileNumber= "0903692059";
        pass= "123456";


        addEdit= "400ABBB DBP";
        cityEdit= "HCMAA";
        stateEdit= "HCMee";
        pinEdit= "123156";
        mobileNumberEdit= "090369205129";
        newEmail = "huy1210" +randomNumber()+"@gmail.com";

        loginPage = Pagenerator.getLoginPage(driver);
        loginPageUrl = loginPage.getCurrentURL(driver);
    }
    @Test
    public void TC_01_Register(){
        loginPage.clickToDynamicLink(driver,"here");
        registerPage = Pagenerator.getRegisterPage(driver);
        registerPage.inputToDynamicTextBox(driver,"emailid",email);
        registerPage.clickToDynamicButton(driver, "Submit");
        userID = registerPage.getDataOnDynamicColumn(driver,"User ID");
        password = registerPage.getDataOnDynamicColumn(driver,"Password");
        loginPage= registerPage.openLoginPage(loginPageUrl);
    }
    @Test
    public void TC_02_Login(){
        loginPage.inputToDynamicTextBox(driver,"uid",userID);
        loginPage.inputToDynamicTextBox(driver,"password",password);
        loginPage.clickToDynamicButton(driver,"LOGIN");
        homePage = Pagenerator.getHomePage(driver);
        verifyTrue(homePage.isDynamicMessageDisplay(driver,"Welcome To Manager"));
    }
    @Test
    public void TC_03_New_Customer(){
        homePage.clickToDynamicLink(driver,"New Customer");
        customerPage = Pagenerator.getCustomerPage(driver);
        customerPage.inputToDynamicTextBox(driver,"name",fullName);
        customerPage.clickToDynamicRadioButton(driver,"rad1");
        customerPage.inputToDynamicTextBox(driver,"dob",dob);
        customerPage.inputToDynamicTextArea(driver,"addr",add);
        customerPage.inputToDynamicTextBox(driver,"city",city);
        customerPage.inputToDynamicTextBox(driver,"state",state);
        customerPage.inputToDynamicTextBox(driver,"pinno",pin);
        customerPage.inputToDynamicTextBox(driver,"telephoneno",mobileNumber);
        customerPage.inputToDynamicTextBox(driver,"emailid",email);
        customerPage.inputToDynamicTextBox(driver,"password",pass);
        setDelayTime(1);
        customerPage.clickToDynamicButton(driver,"Submit");

        verifyEquals(customerPage.getDataOnDynamicColumn(driver,"Customer Name"),fullName);
        verifyEquals(customerPage.getDataOnDynamicColumn(driver,"Gender"),gender);
        verifyEquals(customerPage.getDataOnDynamicColumn(driver,"Birthdate"),dob);
        verifyEquals(customerPage.getDataOnDynamicColumn(driver,"Address"),add);
        verifyEquals(customerPage.getDataOnDynamicColumn(driver,"City"),city);
        verifyEquals(customerPage.getDataOnDynamicColumn(driver,"State"),state);
        verifyEquals(customerPage.getDataOnDynamicColumn(driver,"Pin"),pin);
        verifyEquals(customerPage.getDataOnDynamicColumn(driver,"Mobile No."),mobileNumber);
        verifyEquals(customerPage.getDataOnDynamicColumn(driver,"Email"),newEmail);
        userID = customerPage.getDataOnDynamicColumn(driver,"Customer ID");
    }
    @Test
    public void TC_04_Edit_Customer() {
        customerPage.clickToDynamicLink(driver,"Edit Customer");
        customerPage = Pagenerator.getEditCustomerPage(driver);
        customerPage.inputToDynamicTextBox(driver,"cusid",userID);
        customerPage.clickToDynamicButton(driver,"Submit");
        customerPage.inputToDynamicTextArea(driver,"addr",addEdit);
        customerPage.inputToDynamicTextBox(driver,"city",cityEdit);
        customerPage.inputToDynamicTextBox(driver,"state",stateEdit);
        customerPage.inputToDynamicTextBox(driver,"pinno",pinEdit);
        customerPage.inputToDynamicTextBox(driver,"telephoneno",mobileNumberEdit);
        customerPage.inputToDynamicTextBox(driver,"emailid",email);
        setDelayTime(1);
        customerPage.clickToDynamicButton(driver,"Submit");
    }
    @AfterClass
    public void closePage(){
        closeBrowserAndDriver(driver);
    }
}
