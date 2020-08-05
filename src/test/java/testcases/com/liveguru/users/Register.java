package testcases.com.liveguru.users;//package com.liveguru.users;
//
//import common.AbstractTest;
//import common.PageGenerator;
//import org.openqa.selenium.WebDriver;
//import org.testng.Assert;
//import org.testng.annotations.BeforeClass;
//import org.testng.annotations.Parameters;
//import org.testng.annotations.Test;
//import pageObject.liveGuru.HomePageObject;
//import pageObject.liveGuru.LoginPageObject;
//import pageObject.liveGuru.MyDashboardPageObject;
//import pageObject.liveGuru.RegisterPageObject;
//
//public class Register extends AbstractTest {
//    WebDriver driver;
//    HomePageObject homePage;
//    LoginPageObject loginPage;
//    MyDashboardPageObject dashboardPage;
//    RegisterPageObject regisPage;
//
//    @Parameters("browser")
//    @BeforeClass
////    public void beforeTest(String browserName){
//////        driver = getBrowser(browserName);
////        homePage = PageGenerator.getHomePage(driver);
////        homePage.clickMyAcountLink();
////        loginPage= PageGenerator.getLoginPage(driver);
////        loginPage.clickToCreateAccountButton();
////        regisPage=PageGenerator.getRegisterPage(driver);
////    }
//    @Test
//    public void TC01_EmptyDate(){
//        regisPage.clickToRegisterButton();
//
//        Assert.assertEquals(regisPage.getRequireMessageAtFirstNameTextbox(),"This is a required field.");
//        Assert.assertEquals(regisPage.getRequireMessageAtLastNameTextbox(),"This is a required field.");
//        Assert.assertEquals(regisPage.getRequireMessageAtEmailTextbox(),"This is a required field.");
//        Assert.assertEquals(regisPage.getRequireMessageAtPaswordTextbox(),"This is a required field.");
//        Assert.assertEquals(regisPage.getRequireMessageAtConfirmPassTextbox(),"This is a required field.");
//    }
//    @Test
//    public void TC01_InputInvalidEmail(){
//        regisPage.inputDataToEmailTextbox("huy@gmail.cád");
//        regisPage.clickToRegisterButton();
//        Assert.assertEquals(regisPage.getInvalidErrorMessageAtEmailTextbox(),"Please enter a valid email address. For example johndoe@domain.com.");
//    }
//    @Test
//    public void TC03_Register_Pass_Less_Than_6_Chars(){
//        regisPage.inputDataToPasswordTextbox("1234");
//        regisPage.clickToRegisterButton();
//        Assert.assertEquals(regisPage.getInvalidErrorPasswordTextbox(),"Please enter 6 or more characters without leading or trailing spaces.");
//    }
//    @Test
//    public void TC04_Register_Pass_Not_Same_Confirm(){
//        regisPage.inputDataToPasswordTextbox("123456");
//        regisPage.inputDataToConfirmPassTextbox("1234");
//        regisPage.clickToRegisterButton();
//        Assert.assertEquals(regisPage.getInvalidErrorConfirmPassTextbox(),"Please make sure your passwords match.");
//    }
//    @Test
//    public void TC05_Register_With_Valid_Data(){
//        regisPage.inputDataToLastNameTextbox("Huy");
//        regisPage.inputDataToFirstNameTextbox("Hồ");
//        regisPage.inputDataToEmailTextbox("huy"+ Random()+ "@mailinator.com");
//        regisPage.inputDataToPasswordTextbox("123456");
//        regisPage.inputDataToConfirmPassTextbox("123456");
//        regisPage.clickToRegisterButton();
//
//        dashboardPage = PageGenerator.getMyDashBoadPage(driver);
//
//        Assert.assertEquals(dashboardPage.getWelcomMessage(),"Thank you for registering with Main Website Store.");
//    }
//
//
//    public void closePage(){
//        driver.close();
//    }
//}
//
