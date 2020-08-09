package testcases.Nopcommerce.User;

import NopCommerce.PageObject.User.MyAccount.UserMyAccountAddressTab;
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
        verifyTrue(myAccountCustomerInfoTab.checkDisplayMyAccountPage());
    }
//    @Test
//    public void TC01_Edit_My_Account_Info(){
//        log.info("Update My account Info");
//        myAccountCustomerInfoTab.chooseGender("F");
//        myAccountCustomerInfoTab.enterDataToDynamicField(driver,"FirstName","Automation");
//        myAccountCustomerInfoTab.enterDataToDynamicField(driver,"LastName", "FC");
//        myAccountCustomerInfoTab.chooseBirthday(driver,"1", "January","1999","DateOfBirthDay","DateOfBirthMonth","DateOfBirthYear");
//        myAccountCustomerInfoTab.enterDataToDynamicField(driver,"Email",newEmail);
//        myAccountCustomerInfoTab.enterDataToDynamicField(driver,"Company","Automation FC");
//        log.info("Click button Save");
//        myAccountCustomerInfoTab.clickSaveButton();
//        log.info("Verify input");
//        verifyTrue(myAccountCustomerInfoTab.checkGenderChosen(driver, "F"));
//        verifyTrue(myAccountCustomerInfoTab.checkDataDisplayonDynamicField(driver,"FirstName","Automation"));
//        verifyTrue(myAccountCustomerInfoTab.checkDataDisplayonDynamicField(driver,"LastName","FC"));
//        verifyTrue(myAccountCustomerInfoTab.checkDataDisplayonDynamicField(driver,"Email",newEmail));
//        verifyTrue(myAccountCustomerInfoTab.checkDataDisplayonDynamicField(driver,"Company","Automation FC"));
//    }
    @Test
    public void TC_03_Add_address(){
        log.info("Go to Address tab");
        myAccountCustomerInfoTab.clickAddressesLink();
        myAccountAddressTab = PageGenratorManager.getMyAccountAddressTab(driver);
        verifyTrue(myAccountAddressTab.checkAddressTabDisplay());
        log.info("Click to add new Address");
        myAccountAddressTab.clicktoNewAddressButton();
        verifyTrue(myAccountAddressTab.checkAddNewAddressTabDisplay());
        log.info("Enter info of Address");
        myAccountAddressTab.enterFirstName("Automation");
        myAccountAddressTab.enterLastName("FC");
        myAccountAddressTab.enterEmail("automationfc.vn@gmail.com");
        myAccountAddressTab.enterCompany("Automation FC");
        myAccountAddressTab.selectCountry(driver,"United States");
        myAccountAddressTab.selectStateCity(driver,"Texas");
        myAccountAddressTab.enterCity("Đà Nẵng");
        myAccountAddressTab.enterAddress1("123/04 Lê Lai");
        myAccountAddressTab.enterAddress2("234/05 Hải phòng");
        myAccountAddressTab.enterZipCode("550000");
        myAccountAddressTab.enterPhoneNumber("0123456789");
        myAccountAddressTab.enterFaxNumber("0987654321");
        myAccountAddressTab.clickSaveButton();
        verifyEquals(myAccountAddressTab.checkFullNameDisplay(driver),"Automation" + " " + "FC");
        verifyEquals(myAccountAddressTab.checkEmailDisplay(driver),"automationfc.vn@gmail.com");
        verifyEquals(myAccountAddressTab.checkPhoneNumber(driver),"0123456789");
        verifyEquals(myAccountAddressTab.checkFaxNumber(driver),"0987654321");
        verifyEquals(myAccountAddressTab.checkCompanyName(driver),"Automation FC");
        verifyEquals(myAccountAddressTab.checkAddress1Display(driver),"123/04 Lê Lai");
        verifyEquals(myAccountAddressTab.checkAddress2Display(driver),"234/05 Hải phòng");
        verifyEquals(myAccountAddressTab.checkCityStateZipCodeDisplay(driver),"Đà Nẵng" +"," + " " +"Texas"+"," + " " + "550000");
        verifyEquals(myAccountAddressTab.checkCountry(driver),"United States");

    }
}
