package testcases.Nopcommerce.User;

import NopCommerce.Interface.RegisterPageUI;
import NopCommerce.PageObject.HomePage;
import NopCommerce.PageObject.PageGenratorManager;
import NopCommerce.PageObject.RegisterPage;
import NopCommerce.Variable;
import actions.browserFactory.BrowserDriver;
import actions.browserFactory.DriverManager;
import actions.common.functionHelper.AbstractTest;
import actions.common.functionHelper.DataHelper;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Register extends AbstractTest {

    WebDriver driver;
    DriverManager driverManager;
    DataHelper data = DataHelper.getData();
    HomePage homePage;
    RegisterPage registerPage;

    String firstName,lastName,gender;
    String monthBir, dayBirth, yearBirth;
    String companyName;
    String email;
    @Parameters("browser")
    @BeforeClass
    public void preconditionTest(String browserName) {
        firstName = data.getFirstName();
        lastName = data.getLastName();
        gender = "M";
        monthBir = "10";
        dayBirth = "12";
        yearBirth = "1992";
        companyName = data.getCompanyName();
        email = "huyho1210"+randomNumber()+"@mailinator.com";
        driverManager = BrowserDriver.getBrowser(browserName);
        driver = driverManager.getDriver(Variable.URL_USER_PAGE);
        homePage = PageGenratorManager.getHomepage(driver);
        registerPage = homePage.clickRegisterButton(driver);
    }
//    @Test
//    public void TC_01_Register_Empty_Data(){
//        log.info("Check Register Page display");
//        verifyTrue(registerPage.checkRegisterPageDisplay());
//
//        log.info("Click Register button ");
//        registerPage.clickRegisterButton();
//        verifyEquals(registerPage.getValidateErrorMessage(driver,"FirstName"),"First name is required.");
//        verifyEquals(registerPage.getValidateErrorMessage(driver,"LastName"),"Last name is required.");
//        verifyEquals(registerPage.getValidateErrorMessage(driver,"Email"),"Email is required.");
//        verifyEquals(registerPage.getValidateErrorMessage(driver,"Password"),"Password is required.");
//        verifyEquals(registerPage.getValidateErrorMessage(driver,"ConfirmPassword"),"Password is required.");
//    }
//    @Test
//    public void TC_02_Register_With_InvalidEmail(){
//        log.info("Check Register Page display");
//        verifyTrue(registerPage.checkRegisterPageDisplay());
//
//        log.info("Click Register button ");
//
//        registerPage.chooseGender("");
//        registerPage.enterDataToDynamicField(driver,"FirstName",firstName);
//        registerPage.enterDataToDynamicField(driver,"LastName",lastName);
//        registerPage.chooseBirthday(driver,"12","October","1992","DateOfBirthDay","DateOfBirthMonth","DateOfBirthYear");
//        registerPage.enterDataToDynamicField(driver,"Email","huyho...");
//        registerPage.enterDataToDynamicField(driver,"Company",companyName);
//        registerPage.enterDataToDynamicField(driver,"Password","123456");
//        registerPage.enterDataToDynamicField(driver,"ConfirmPassword","123456");
//
//        registerPage.clickRegisterButton();
//        verifyEquals(registerPage.getValidateErrorMessage(driver,"Email"),"Wrong email");
//    }
//    @Test
//    public void TC_03_Register_With_ExistedEmail(){
//        log.info("Check Register Page display");
//        verifyTrue(registerPage.checkRegisterPageDisplay());
//
//        log.info("Click Register button ");
//
//        registerPage.chooseGender("");
//        registerPage.enterDataToDynamicField(driver,"FirstName",firstName);
//        registerPage.enterDataToDynamicField(driver,"LastName",lastName);
//        registerPage.chooseBirthday(driver,"12","October","1992","DateOfBirthDay","DateOfBirthMonth","DateOfBirthYear");
//        registerPage.enterDataToDynamicField(driver,"Email",Variable.USER_ACCOUNT);
//        registerPage.enterDataToDynamicField(driver,"Company",companyName);
//        registerPage.enterDataToDynamicField(driver,"Password","123456");
//        registerPage.enterDataToDynamicField(driver,"ConfirmPassword","123456");
//
//        registerPage.clickRegisterButton();
//        verifyEquals(registerPage.getSummaryValidationErr(driver),"The specified email already exists");
//    }
    @Test
    public void TC_04_Register_With_Password_Less_Than_6_Chars(){
        log.info("Check Register Page display");
        verifyTrue(registerPage.checkRegisterPageDisplay());
        registerPage.setDelayTime(1);

        log.info("Click Register button ");

        registerPage.chooseGender("M");
        registerPage.enterDataToDynamicField(driver,"FirstName",firstName);
        System.out.println(firstName);
        registerPage.enterDataToDynamicField(driver,"LastName", lastName);
        System.out.println(lastName);
        registerPage.chooseBirthday(driver,"12","October","1992","DateOfBirthDay","DateOfBirthMonth","DateOfBirthYear");
        registerPage.enterDataToDynamicField(driver,"Email",email);
        registerPage.enterDataToDynamicField(driver,"Company",companyName);
        registerPage.enterDataToDynamicField(driver,"Password","12346");
        registerPage.enterDataToDynamicField(driver,"ConfirmPassword","123456");

        registerPage.clickRegisterButton();
        System.out.println(registerPage.getValidateErrorMessage(driver,"Password"));
        verifyEquals(registerPage.getValidateErrorMessage(driver,"Password"),"Password must meet the following rules:\n" +
                "must have at least 6 characters");
    }

    @Test
    public void TC_05_Register_With_ConfirmPass_Not_Same(){
        log.info("Check Register Page display");
        verifyTrue(registerPage.checkRegisterPageDisplay());
        registerPage.setDelayTime(1);

        log.info("Click Register button ");

        registerPage.chooseGender("M");
        registerPage.enterDataToDynamicField(driver,"FirstName",firstName);
        registerPage.enterDataToDynamicField(driver,"LastName", lastName);
        registerPage.chooseBirthday(driver,"12","October","1992","DateOfBirthDay","DateOfBirthMonth","DateOfBirthYear");
        registerPage.enterDataToDynamicField(driver,"Email",email);
        registerPage.enterDataToDynamicField(driver,"Company",companyName);
        registerPage.enterDataToDynamicField(driver,"Password","123456");
        registerPage.enterDataToDynamicField(driver,"ConfirmPassword","1234567");

        registerPage.clickRegisterButton();
        verifyEquals(registerPage.getValidateErrorMessage(driver,"ConfirmPassword"),"The password and confirmation password do not match.");
    }
    @Test
    public void TC_05_Register_With_Valid_Email(){
        log.info("Check Register Page display");
        verifyTrue(registerPage.checkRegisterPageDisplay());
        registerPage.setDelayTime(1);

        log.info("Click Register button ");

        registerPage.chooseGender("M");
        registerPage.enterDataToDynamicField(driver,"FirstName",firstName);
        registerPage.enterDataToDynamicField(driver,"LastName", lastName);
        registerPage.chooseBirthday(driver,"12","October","1992","DateOfBirthDay","DateOfBirthMonth","DateOfBirthYear");
        registerPage.enterDataToDynamicField(driver,"Email",email);
        registerPage.enterDataToDynamicField(driver,"Company",companyName);
        registerPage.enterDataToDynamicField(driver,"Password","123456");
        registerPage.enterDataToDynamicField(driver,"ConfirmPassword","123456");

        registerPage.clickRegisterButton();
        registerPage.setDelayTime(3);
        verifyTrue(registerPage.getRegisterSuccessMessage(driver));
    }

}
