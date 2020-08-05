package actions.common;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.joda.time.DateTime;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.logging.LogEntries;
import org.openqa.selenium.logging.LogEntry;
import org.testng.Assert;
import org.testng.Reporter;

import java.util.*;

public abstract class AbstractTest extends AbstractPage {
    private WebDriver driver;

    protected final Log log;

    protected AbstractTest() {
        log = LogFactory.getLog(getClass());
    }

    protected int randomNumber(){
        Random random = new Random();
        return  random.nextInt(999);
    }
    protected Date getDateTimeNow(){
        Date date = new Date();
        return date;
    }
    protected boolean verifyTrue(boolean condition) {
        boolean pass = true;
        try {
            Assert.assertTrue(condition);
        } catch (Throwable e) {
            pass = false;

            // Add lỗi vào ReportNG
            VerificationFailures.getFailures().addFailureForTest(Reporter.getCurrentTestResult(), e);
            Reporter.getCurrentTestResult().setThrowable(e);
        }
        return pass;
    }
    protected boolean verifyFalse(boolean condition) {
        boolean pass = true;
        try {
            Assert.assertFalse(condition);
        } catch (Throwable e) {
            pass = false;
            VerificationFailures.getFailures().addFailureForTest(Reporter.getCurrentTestResult(), e);
            Reporter.getCurrentTestResult().setThrowable(e);
        }
        return pass;
    }
    protected boolean verifyEquals(Object actual, Object expected) {
        boolean pass = true;
        try {
            Assert.assertEquals(actual, expected);
        } catch (Throwable e) {
            pass = false;
            VerificationFailures.getFailures().addFailureForTest(Reporter.getCurrentTestResult(), e);
            Reporter.getCurrentTestResult().setThrowable(e);
        }
        return pass;
    }
    protected void closeBrowserAndDriver(WebDriver driver) {
        try {
            String osName = System.getProperty("os.name").toLowerCase();
            // Khai báo 1 biến command line để thực thi
            String cmd = "";
            if (driver != null) {
                driver.quit();
            }

            if (driver.toString().toLowerCase().contains("chrome")) {
                if (osName.toLowerCase().contains("mac")) {
                    cmd = "pkill chromedriver";
                } else if (osName.toLowerCase().contains("windows")) {
                    cmd = "taskkill /F /FI \"IMAGENAME eq chromedriver*\"";
                }
            } else if (driver.toString().toLowerCase().contains("internetexplorer")) {
                if (osName.toLowerCase().contains("window")) {
                    cmd = "taskkill /F /FI \"IMAGENAME eq IEDriverServer*\"";
                }
            } else if (driver.toString().toLowerCase().contains("firefox")) {
                if (osName.toLowerCase().contains("mac")) {
                    cmd = "pkill geckodriver";
                } else if (osName.toLowerCase().contains("windows")) {
                    cmd = "taskkill /F /FI \"IMAGENAME eq geckodriver*\"";
                }
            }

            Process process = Runtime.getRuntime().exec(cmd);
            process.waitFor();

            log.info("---------- QUIT BROWSER SUCCESS ----------");
        } catch (Exception e) {
            log.info(e.getMessage());
        }
    }

    protected String getCurrentDay() {
        DateTime nowUTC = new DateTime();
        int day = nowUTC.getDayOfMonth();
        if (day < 10) {
            String dayValue = "0" + day;
            return dayValue;
        }
        return day + "";
    }

    protected String getCurrentMonth() {
        DateTime now = new DateTime();
        int month = now.getMonthOfYear();
        if (month < 10) {
            String monthValue = "0" + month;
            return monthValue;
        }
        return month + "";
    }

    protected String getCurrentYear() {
        DateTime now = new DateTime();
        return now.getYear() + "";
    }

    protected String getToday() {
        return getCurrentDay() + "/" + getCurrentMonth() + "/" + getCurrentYear();
    }

    public boolean isSortedAscending(WebDriver driver, String locator){
        ArrayList<String> arrayList = new ArrayList<>();
        List<WebElement> elementList = driver.findElements(By.xpath(locator));
        for(WebElement element: elementList){
            arrayList.add(element.getText());
        }
        ArrayList<String> sortedList = new ArrayList<>();
        for(String child: arrayList){
            sortedList.add(child);
        }
        Collections.sort(arrayList);
        return  sortedList.equals(arrayList);
    }
    public boolean isSortedDescending(WebDriver driver, String locator){
        ArrayList<String> arrayList = new ArrayList<>();
        List<WebElement> elementList = driver.findElements(By.xpath(locator));
        for(WebElement element: elementList){
            arrayList.add(element.getText());
        }
        ArrayList<String> sortedList = new ArrayList<>();
        for(String child: arrayList){
            sortedList.add(child);
        }
        Collections.sort(arrayList);
        Collections.reverse(arrayList);
        return  sortedList.equals(arrayList);
    }
    protected void printBrowserLog(WebDriver driver){
        LogEntries logs= driver.manage().logs().get("browser");
        List<LogEntry> logList = logs.getAll();
        for (LogEntry logging: logList){
            log.info(logging.getLevel().toString() +"\n"+ logging.getMessage());
        }


    }
}
