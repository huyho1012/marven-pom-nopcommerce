package actions.common;

import interfaces.wordPress.Admin.MediaPageUI;
import interfaces.wordPress.Common.CommonPageUI;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public abstract class AbstractPage {
    private Alert alert;
    private WebElement element;
    private Select select;
    private WebDriverWait explicitWait;
    private JavascriptExecutor jsExecutor;
    private List<WebElement> elements;
    private Actions action;

    // ImplicitWait
    public void setImplicitWait(WebDriver driver, long longTimeOut){
        driver.manage().timeouts().implicitlyWait(longTimeOut, TimeUnit.SECONDS);
    }

    // WebBrowser
    public void openPage(WebDriver driver , String urlLink){
        driver.get(urlLink);
    }
    public String getCurrentURL(WebDriver driver){
        return  driver.getCurrentUrl();
    }
    public void backToPage(WebDriver driver){
        driver.navigate().back();
    }
    public void forwardPage(WebDriver driver){
        driver.navigate().forward();
    }
    public void refreshCurrentPage(WebDriver driver){
        driver.navigate().refresh();
    }
    public String getLoginPageUrl(WebDriver driver){
        return driver.getCurrentUrl();
    }
    public boolean isPageLoaded(WebDriver driver,String pageUrl){
        String actualUrl = driver.getCurrentUrl();
        return actualUrl.contains(pageUrl);
    }

    // Alert
    public void waitAlertPresence(WebDriver driver){
        explicitWait = new WebDriverWait(driver, Global_Constants.LONG_TIMEOUT);
        explicitWait.until(ExpectedConditions.alertIsPresent());
    }
    public void acceptAlert(WebDriver driver){
        waitAlertPresence(driver);
        driver.switchTo().alert();
        alert.accept();
    }
    public void cancelAlert(WebDriver driver){
        waitAlertPresence(driver);
        driver.switchTo().alert();
        alert.dismiss();
    }
    public String getAlertText(WebDriver driver){
        waitAlertPresence(driver);
        driver.switchTo().alert();
        return alert.getText();
    }
    public void sendKeyToAlert(WebDriver driver, String text){
        waitAlertPresence(driver);
        driver.switchTo().alert();
        alert.sendKeys(text);
    }

    // Window
    public void switchWindowByID(WebDriver driver, String parentID){
        Set<String> allWindow = driver.getWindowHandles();
        for (String runWindow: allWindow) {
            if (!runWindow.equals(parentID)){
                driver.switchTo().window(runWindow);
                break;
            }
        }
    }
    public void  switchWindowByTitle(WebDriver driver , String title){
        Set<String> allWindows = driver.getWindowHandles();
        for(String runWindow: allWindows){
            driver.switchTo().window(runWindow);
            String curentWindow = driver.getTitle();
            if(curentWindow.equals(title)){
                break;
            }
        }
    }
    public void CloseAllWindowsWithoutParent(WebDriver driver, String parentID) {
        Set<String> allWindows = driver.getWindowHandles();
        for (String runWindow : allWindows) {
            if (!runWindow.equals(parentID)) {
                driver.switchTo().window(runWindow);
                driver.close();
            }
        }
        driver.switchTo().window(parentID);
    }

    // Frame - IFrame
    public void switchToFrameOrIFrame(WebDriver driver, String xpahtValue){
        driver.switchTo().frame(findElement(driver, xpahtValue));
    }
    public void switchToDefaultFrame(WebDriver driver){
        driver.switchTo().defaultContent();
    }

    // WebElement
    public By byXpath(String xpathValue){
        return By.xpath(xpathValue);
    }


    public WebElement findElement(WebDriver driver, String xpathValue){
        return driver.findElement(byXpath(xpathValue));
    }
    public List<WebElement> findElements(WebDriver driver, String xpathValue){
        return driver.findElements(byXpath(xpathValue));
    }

    public int countElementsNumber(WebDriver driver, String locator){
        elements = findElements(driver, locator);
        return elements.size();
    }
    public void sendKeyToElement(WebDriver driver, String xpathValue, String value){
        element = findElement(driver,xpathValue);
        element.clear();
        element.sendKeys(value);
    }
    public void clickToElement(WebDriver driver, String xpathValue){
        findElement(driver,xpathValue).click();
    }

    public String getTextElement(WebDriver driver, String xpathValue){
        return findElement(driver,xpathValue).getText();
    }
    public String getAttributeValue(WebDriver driver, String xpathValue, String attributeName){
        return findElement(driver,xpathValue).getAttribute(attributeName);
    }
    public String getTextElement(WebDriver driver, String locator, String... values){
            return findElement(driver,castToObject(locator, values)).getText();
    }
    public Boolean isElementDisplay(WebDriver driver, String locator){
        try {
            element = findElement(driver, locator);
            return element.isDisplayed();
        }catch (NoSuchElementException noSuchException){
            return false;
        }
    }
    public void overrideGlobalTimeout(WebDriver driver, long timeOut){
        driver.manage().timeouts().implicitlyWait(timeOut,TimeUnit.SECONDS);
    }
    public Boolean isElementUnDisplay(WebDriver driver, String locator){
        overrideGlobalTimeout(driver, Global_Constants.SHORT_TIMEOUT);
        elements  = findElements(driver,locator);
        if(elements.size()==0){
            overrideGlobalTimeout(driver,Global_Constants.LONG_TIMEOUT);
            return true;
        }else if(elements.size()>0 && !elements.get(0).isDisplayed()){
            overrideGlobalTimeout(driver,Global_Constants.SHORT_TIMEOUT);
            return true;
        }else {
            overrideGlobalTimeout(driver, Global_Constants.LONG_TIMEOUT);
            return false;
        }
    }
    public Boolean isElementSelected(WebDriver driver, String locator) {
        return findElement(driver, locator).isSelected();
    }
    public Boolean isElementEnable(WebDriver driver, String locator){
        return  findElement(driver,locator).isEnabled();
    }
    // Default Dropdown
    public void selectItemOnDropdown(WebDriver driver, String xpathValue, String itemValue){
        select = new Select(findElement(driver,xpathValue));
        select.selectByVisibleText(itemValue);
    }
    public String getSelectedItemOnDropdown(WebDriver driver, String xpathValue){
        select = new Select(findElement(driver,xpathValue));
        return select.getFirstSelectedOption().getText();
    }

    // Custom Dropdown
    public Boolean isDropdownMultiple(WebDriver driver, String xpathValue){
        select = new Select(findElement(driver, xpathValue));
        return select.isMultiple();
    }
    public void selectItemInCustomDropdown(WebDriver driver,String parentLocator, String childItemLocator, String expectedItem){
        findElement(driver,parentLocator).click();
        setDelayTime(1);
        explicitWait = new WebDriverWait(driver, Global_Constants.LONG_TIMEOUT);
        explicitWait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(byXpath(childItemLocator)));
        elements = findElements(driver,childItemLocator);
        for (WebElement item : elements){
            if(item.getText().equals(expectedItem)){
                jsExecutor = (JavascriptExecutor) driver;
                jsExecutor.executeScript("arguments[0].scrollIntoView(true);",item);
                setDelayTime(1);
                item.click();
                setDelayTime(1);
                break;
            }
        }
    }
    // Checkbox - RadioButton
    public void checkCheckBox(WebDriver driver, String locator){
        element = findElement(driver, locator);
        if(!element.isSelected()){
           element.click();
        }
    }
    public void uncheckCheckBox(WebDriver driver, String locator){
        element = findElement(driver, locator);
        if(element.isSelected()){
            element.click();
        }
    }
    public void checkCheckBox(WebDriver driver, String locator, String...values){
        element = findElement(driver, castToObject(locator, values));
        if(!element.isSelected()){
            element.click();
        }
    }
    public void uncheckCheckBox(WebDriver driver, String locator, String...values){
        element = findElement(driver, castToObject(locator,values));
        if(element.isSelected()){
            element.click();
        }
    }
    // Action
    public void hoverToElement(WebDriver driver, String xpathValue){
        action = new Actions(driver);
        action.moveToElement(findElement(driver,xpathValue)).perform();
    }
    public void rightClickElement(WebDriver driver, String xpathValue){
        action = new Actions(driver);
        action.contextClick(findElement(driver,xpathValue)).perform();
    }
    public void doubleClick(WebDriver driver, String xpathValue){
        action = new Actions(driver);
        action.doubleClick(findElement(driver,xpathValue)).perform();
    }
    public void sendKeyBoardToElement(WebDriver driver, String xpathValue, Keys key){
        action = new Actions(driver);
        action.sendKeys(findElement(driver,xpathValue), key).perform();
    }

    // JS Executor
    public void highlightElement(WebDriver driver, String locator){
        element = findElement(driver,locator);
        String originalStyle = element.getAttribute("style");
        jsExecutor = (JavascriptExecutor) driver;
        jsExecutor.executeScript("arguments[0].setAttribute(arguments[1], arguments[2])", element, "style", "border: 5px solid red; border-style: dashed;");
        setDelayTime(1);
        jsExecutor.executeScript("arguments[0].setAttribute(arguments[1], arguments[2])", element, "style", originalStyle);
    }
    public void clickToElementByJS(WebDriver driver, String locator){
        element = findElement(driver, locator);
        jsExecutor = (JavascriptExecutor) driver;
        jsExecutor.executeScript("arguments[0].click();",element);
    }
    public void clickToElementByJS(WebDriver driver, String locator,String...values){
        element = findElement(driver, castToObject(locator, values));
        jsExecutor = (JavascriptExecutor) driver;
        jsExecutor.executeScript("arguments[0].click();",element);
    }
    public void scrollIntoViewByJS(WebDriver driver, String xpathValue){
        jsExecutor = (JavascriptExecutor) driver;
        jsExecutor.executeScript("arguments[0].scrollIntoView(true);",findElement(driver, xpathValue));
    }
    public void scrollIntoViewByJS(WebDriver driver, String locator,String... values){
        jsExecutor = (JavascriptExecutor) driver;
        jsExecutor.executeScript("arguments[0].scrollIntoView(true);",findElement(driver, castToObject(locator, values)));
        setDelayTime(1);
    }
    public void sendKeyToElementByJS(WebDriver driver, String xpathValue, String value) {
        jsExecutor = (JavascriptExecutor) driver;
        jsExecutor.executeScript("arguments[0].setAttribute('value', '" + value + "')", findElement(driver, xpathValue));
    }
    public void removeAttributeInDOM(WebDriver driver, String locator, String attributeRemove) {
        jsExecutor = (JavascriptExecutor) driver;
        jsExecutor.executeScript("arguments[0].removeAttribute('" + attributeRemove + "');", findElement(driver, locator));
    }
    public void removeAttributeInDOM(WebDriver driver, String locator, String attributeRemove, String... values) {
        jsExecutor = (JavascriptExecutor) driver;
        jsExecutor.executeScript("arguments[0].removeAttribute('" + attributeRemove + "');", findElement(driver, castToObject(locator,values)));
    }

    // WebDriver Wait
    public void waitForElementVisible(WebDriver driver, String xpathValue){
        explicitWait = new WebDriverWait(driver,Global_Constants.LONG_TIMEOUT);
        explicitWait.until(ExpectedConditions.visibilityOfElementLocated(byXpath(xpathValue)));
    }
    public void waitForElementInVisible(WebDriver driver, String xpathValue){
        explicitWait = new WebDriverWait(driver,Global_Constants.LONG_TIMEOUT);
        explicitWait.until(ExpectedConditions.invisibilityOfElementLocated(byXpath(xpathValue)));
    }
    public void waitForElementClickable(WebDriver driver, String xpathValue){
        explicitWait = new WebDriverWait(driver,Global_Constants.LONG_TIMEOUT);
        explicitWait.until(ExpectedConditions.elementToBeClickable(byXpath(xpathValue)));
    }
    public void setDelayTime(long time){
        try {
            Thread.sleep(time *1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
    // Dynamic Element
    public String castToObject(String locator, String... values){
        return  String.format(locator, values);
    }
    public void clickToElement(WebDriver driver, String locator, String... values){
        findElement(driver,castToObject(locator,values)).click();
    }
    public Boolean isElementDisplay(WebDriver driver, String locator, String... values){
        return findElement(driver, castToObject(locator,values)).isDisplayed();
    }
    public void waitForElementVisible(WebDriver driver, String locator, String... values){
        explicitWait = new WebDriverWait(driver,Global_Constants.LONG_TIMEOUT);
        explicitWait.until(ExpectedConditions.visibilityOfElementLocated(byXpath(castToObject(locator,values))));
    }
    public void waitForElementClickable(WebDriver driver, String locator, String... values){
        explicitWait = new WebDriverWait(driver,Global_Constants.LONG_TIMEOUT);
        explicitWait.until(ExpectedConditions.elementToBeClickable(byXpath(castToObject(locator,values))));
    }
    public void sendKeyToElement(WebDriver driver, String locator, String value, String... values){
        element = findElement(driver,castToObject(locator,values));
        element.clear();
        element.sendKeys(value);
    }
    public void sendKeyBoardToElement(WebDriver driver, String locator, Keys key, String... values){
        action = new Actions(driver);
        action.sendKeys(findElement(driver,castToObject(locator,values)), key).perform();
    }
    public int countElementsNumber(WebDriver driver, String locator, String... values){
        elements = findElements(driver,castToObject(locator,values));
        return elements.size();
    }
    public void waitForElementsInvisible(WebDriver driver, String locator){
        explicitWait = new WebDriverWait(driver,Global_Constants.LONG_TIMEOUT);
        elements = findElements(driver,locator);
        explicitWait.until(ExpectedConditions.invisibilityOfAllElements(elements));
    }
    public void waitForElementsVisible(WebDriver driver, String locator){
        explicitWait = new WebDriverWait(driver,Global_Constants.LONG_TIMEOUT);
        elements = findElements(driver,locator);
        explicitWait.until(ExpectedConditions.visibilityOfAllElements(elements));
    }
    public void waitForElementsVisible(WebDriver driver, String locator, String...values){
        explicitWait = new WebDriverWait(driver,Global_Constants.LONG_TIMEOUT);
        elements = findElements(driver,castToObject(locator, values));
        explicitWait.until(ExpectedConditions.visibilityOfAllElements(elements));
    }
    // Upload
    public void uploadMultipleFiles(WebDriver driver, String... fileNames){
        String fullFileName = "";
        for(String file: fileNames){
            fullFileName = fullFileName+ Global_Constants.ROOT_UPLOAD_FILE+ file+ "\n";
        }
        fullFileName = fullFileName.trim();
        sendKeyToElement(driver, CommonPageUI.UploadButton,fullFileName);
    }
    public boolean checkUploadFileDisplay(WebDriver driver, String... fileNames){
        boolean status = false;
        int numberFile = fileNames.length;
        waitForElementsInvisible(driver, MediaPageUI.UPLOADING_PROCESS);
        setDelayTime(6);
        elements = findElements(driver, CommonPageUI.LIST_FILE_UPLOADED);
        List<String> imageValue = new ArrayList<String>();
        int i =0;
        for(WebElement item :  elements) {
            System.out.println(item.getAttribute("src"));
            imageValue.add(item.getAttribute("src"));
            i++;
            if (i == numberFile) {
                break;
            }
        }
        for (String fileName :fileNames){
            String[] files = fileName.split("\\.");
            fileName =files[0].toLowerCase();
            for(i =0 ; i< imageValue.size(); i++){
                if(!imageValue.get(i).contains(fileName)){
                    status = false;
                    if(i == imageValue.size()-1){
                        return status;
                    }
                }else {
                    status = true;
                    break;
                }
            }
        }
        return status;
    }

    // Check image
    public boolean isImageLoaded(WebDriver driver, String locator){
        jsExecutor = (JavascriptExecutor) driver;
        element = findElement(driver,locator);
        boolean status = (boolean) jsExecutor.executeScript("return arguments[0].complete && typeof arguments[0]" + ".naturalWidth != 'undefine && arguments[0]"+  ".naturalWidth>0",element);
        return status;
    }
    public boolean isImageLoaded(WebDriver driver, String locator, String...values){
        jsExecutor = (JavascriptExecutor) driver;
        element = findElement(driver,castToObject(locator, values));
        boolean status = (boolean) jsExecutor.executeScript("return arguments[0].complete && typeof arguments[0]" + ".naturalWidth != 'undefine && arguments[0]"+  ".naturalWidth>0",element);
        return status;
    }

}

