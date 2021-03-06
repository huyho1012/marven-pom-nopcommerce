package testcases.Nopcommerce.User;

import NopCommerce.PageObject.User.UserHomePage;
import NopCommerce.PageObject.User.PageGenratorManager;
import NopCommerce.PageObject.User.UserRegisterPage;
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
    UserHomePage userHomePage;
    UserRegisterPage userRegisterPage;

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
        userHomePage = PageGenratorManager.getHomepage(driver);
        userRegisterPage = userHomePage.clickRegisterButton();
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
        verifyTrue(userRegisterPage.checkRegisterPageDisplay());
        userRegisterPage.setDelayTime(1);

        userRegisterPage.chooseGender("M");
        userRegisterPage.enterDataToDynamicField(driver,"FirstName",firstName);
        System.out.println(firstName);
        userRegisterPage.enterDataToDynamicField(driver,"LastName", lastName);
        System.out.println(lastName);
        userRegisterPage.chooseBirthday(driver,"12","October","1992","DateOfBirthDay","DateOfBirthMonth","DateOfBirthYear");
        userRegisterPage.enterDataToDynamicField(driver,"Email",email);
        userRegisterPage.enterDataToDynamicField(driver,"Company",companyName);
        userRegisterPage.enterDataToDynamicField(driver,"Password","12346");
        userRegisterPage.enterDataToDynamicField(driver,"ConfirmPassword","123456");

        userRegisterPage.clickRegisterButton();
        System.out.println(userRegisterPage.getValidateErrorMessage(driver,"Password"));
        verifyEquals(userRegisterPage.getValidateErrorMessage(driver,"Password"),"Password must meet the following rules:\n" +
                "must have at least 6 characters");
    }

    @Test
    public void TC_05_Register_With_ConfirmPass_Not_Same(){
        log.info("Check Register Page display");
        verifyTrue(userRegisterPage.checkRegisterPageDisplay());
        userRegisterPage.setDelayTime(1);

        log.info("Click Register button ");

        userRegisterPage.chooseGender("M");
        userRegisterPage.enterDataToDynamicField(driver,"FirstName",firstName);
        userRegisterPage.enterDataToDynamicField(driver,"LastName", lastName);
        userRegisterPage.chooseBirthday(driver,"12","October","1992","DateOfBirthDay","DateOfBirthMonth","DateOfBirthYear");
        userRegisterPage.enterDataToDynamicField(driver,"Email",email);
        userRegisterPage.enterDataToDynamicField(driver,"Company",companyName);
        userRegisterPage.enterDataToDynamicField(driver,"Password","123456");
        userRegisterPage.enterDataToDynamicField(driver,"ConfirmPassword","1234567");

        userRegisterPage.clickRegisterButton();
        verifyEquals(userRegisterPage.getValidateErrorMessage(driver,"ConfirmPassword"),"The password and confirmation password do not match.");
    }
    @Test
    public void TC_05_Register_With_Valid_Email(){
        log.info("Check Register Page display");
        verifyTrue(userRegisterPage.checkRegisterPageDisplay());
        userRegisterPage.setDelayTime(1);

        log.info("Click Register button ");

        userRegisterPage.chooseGender("M");
        userRegisterPage.enterDataToDynamicField(driver,"FirstName",firstName);
        userRegisterPage.enterDataToDynamicField(driver,"LastName", lastName);
        userRegisterPage.chooseBirthday(driver,"12","October","1992","DateOfBirthDay","DateOfBirthMonth","DateOfBirthYear");
        userRegisterPage.enterDataToDynamicField(driver,"Email",email);
        userRegisterPage.enterDataToDynamicField(driver,"Company",companyName);
        userRegisterPage.enterDataToDynamicField(driver,"Password","123456");
        userRegisterPage.enterDataToDynamicField(driver,"ConfirmPassword","123456");

        userRegisterPage.clickRegisterButton();
        userRegisterPage.setDelayTime(3);
        verifyTrue(userRegisterPage.getRegisterSuccessMessage(driver));
    }

}
