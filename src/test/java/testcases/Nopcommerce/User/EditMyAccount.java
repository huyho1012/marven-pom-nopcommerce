package testcases.Nopcommerce.User;

import NopCommerce.PageObject.User.MyAccount.UserMyAccountAddressTab;
import NopCommerce.PageObject.User.MyAccount.UserMyAccountChangePassword;
import NopCommerce.PageObject.User.MyAccount.UserMyAccountCustomerInfoTab;
import NopCommerce.PageObject.User.PageGenratorManager;
import NopCommerce.PageObject.User.UserHomePage;
import NopCommerce.PageObject.User.UserRegisterPage;
import NopCommerce.Variable;
import actions.browserFactory.BrowserDriver;
import actions.browserFactory.DriverManager;
import actions.common.functionHelper.AbstractTest;
import actions.common.functionHelper.DataHelper;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class EditMyAccount extends AbstractTest {
    String firstName,lastName;
    String email;
    String newEmail;

    DriverManager driverManager;
    WebDriver driver;
    UserHomePage userHomePage;
    UserRegisterPage userRegisterPage;
    UserMyAccountCustomerInfoTab myAccountCustomerInfoTab;
    UserMyAccountChangePassword myAccountChangePassword;
    UserMyAccountAddressTab myAccountAddressTab;
    DataHelper dataHelper = DataHelper.getData();
    @Parameters("browser")
    @BeforeTest
    public void preconditionTest(String browserName) {
        firstName = dataHelper.getFirstName();
        lastName = dataHelper.getLastName();
        email = "huyho.doan" + randomNumber()+ "@mailinator.com";
        newEmail = "automationfc"+randomNumber()+".vn@gmail.com";

        log.info("Precondition -  Step 1 - Khởi tạo browser");
        driverManager = BrowserDriver.getBrowser(browserName);
        log.info("Precondition - Step 2 - Connect tới trang");
        driver = driverManager.getDriver(Variable.URL_USER_PAGE);
        userHomePage = PageGenratorManager.getHomepage(driver);
        log.info("Precondition - Step 3 - Đăng ký tài khoản");
        userRegisterPage = userHomePage.clickRegisterButton();
        userHomePage = userRegisterPage.RegisterUserAccount(driver,"M",firstName,lastName,"12","October","1992",email,"Hang Không FC","123456","123456");
        verifyTrue(userHomePage.checkLoginSuccess());
        log.info("Precondition - Step 4 - Nhấn vào xem My Account");
        myAccountCustomerInfoTab = userHomePage.clickToMyAccountLink();
        verifyTrue(myAccountCustomerInfoTab.checkMyaccountCustomerInfDisplay());
    }
    @Test
    public void TC01_Edit_My_Account_Info(){
        log.info("Update My account Info");
        myAccountCustomerInfoTab.chooseCustomerGender("F");
        myAccountCustomerInfoTab.enterDynamicDataOnCustomerInfo("FirstName","Automation");
        myAccountCustomerInfoTab.enterDynamicDataOnCustomerInfo("LastName", "FC");
        myAccountCustomerInfoTab.chooseCustomerBirthday("1", "January","1999");
        myAccountCustomerInfoTab.enterDynamicDataOnCustomerInfo("Email",newEmail);
        myAccountCustomerInfoTab.enterDynamicDataOnCustomerInfo("Company","Automation FC");
        log.info("Click button Save");
        myAccountCustomerInfoTab.clickSaveButton();
        log.info("Verify input");
        verifyTrue(myAccountCustomerInfoTab.checkGenderChosen(driver, "F"));
        verifyEquals(myAccountCustomerInfoTab.getDynamicDataOnCustomer("FirstName"),"Automation");
        verifyEquals(myAccountCustomerInfoTab.getDynamicDataOnCustomer("LastName"),"FC");
        verifyEquals(myAccountCustomerInfoTab.getDynamicDataOnCustomer("Email"),newEmail);
        verifyEquals(myAccountCustomerInfoTab.getDynamicDataOnCustomer("Company"),"Automation FC");
    }
    @Test
    public void TC_03_Add_address(){
        log.info("Go to Address tab");
        myAccountCustomerInfoTab.clickAddressesLink();
        myAccountAddressTab = PageGenratorManager.getMyAccountAddressTab(driver);
        myAccountAddressTab.clicktoNewAddressButton();
        verifyTrue(myAccountAddressTab.checkAddNewAddressTabDisplay());
        log.info("Enter info of Address");
        myAccountAddressTab.enterDynamicDataOnAddress("Address_FirstName","Automation");
        myAccountAddressTab.enterDynamicDataOnAddress("Address_LastName","FC");
        myAccountAddressTab.enterDynamicDataOnAddress("Address_Email","automationfc.vn@gmail.com");
        myAccountAddressTab.enterDynamicDataOnAddress("Address_Company","Automation FC");
        myAccountAddressTab.selectCountry(driver,"United States");
        myAccountAddressTab.selectStateCity(driver,"Texas");
        myAccountAddressTab.enterDynamicDataOnAddress("Address_City","Đà Nẵng");
        myAccountAddressTab.enterDynamicDataOnAddress("Address_Address1","123/04 Lê Lai");
        myAccountAddressTab.enterDynamicDataOnAddress("Address_Address2","234/05 Hải phòng");
        myAccountAddressTab.enterDynamicDataOnAddress("Address_ZipPostalCode","550000");
        myAccountAddressTab.enterDynamicDataOnAddress("Address_PhoneNumber","0123456789");
        myAccountAddressTab.enterDynamicDataOnAddress("Address_FaxNumber","0987654321");
        myAccountAddressTab.clickSaveButton();
        verifyEquals(myAccountAddressTab.getOtherInfoIsDisplay("name"),"Automation" + " " + "FC");
        verifyEquals(myAccountAddressTab.getDataOfEmail(),"automationfc.vn@gmail.com");
        verifyEquals(myAccountAddressTab.getDataOfPhoneNumber(),"0123456789");
        verifyEquals(myAccountAddressTab.getDataOfTaxNumber(),"0987654321");
        verifyEquals(myAccountAddressTab.getOtherInfoIsDisplay("company"),"Automation FC");
        verifyEquals(myAccountAddressTab.getOtherInfoIsDisplay("address1"),"123/04 Lê Lai");
        verifyEquals(myAccountAddressTab.getOtherInfoIsDisplay("address2"),"234/05 Hải phòng");
        verifyEquals(myAccountAddressTab.getOtherInfoIsDisplay("city-state-zip"),"Đà Nẵng" +"," + " " +"Texas"+"," + " " + "550000");
        verifyEquals(myAccountAddressTab.getOtherInfoIsDisplay("country"),"United States");
    }
    public void TC_04_Change_Password(){
        log.info("Go to Address tab");
        myAccountChangePassword= myAccountAddressTab.clickChangePassLink();
        myAccountChangePassword.enterOldPassWord();
        myAccountChangePassword.enterNewPassWord();
        myAccountChangePassword.enterConfirmPassWord();
        myAccountChangePassword.clickConfirmChangePass();
        verifyTrue(myAccountChangePassword.checkChangePasswordSuccess());
        userHomePage = myAccountChangePassword.clickButtonLogout();


    }
}
