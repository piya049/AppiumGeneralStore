package org.ps.pageObjects.ios;

import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.ps.utils.IOSActions;

public class AlertViews extends IOSActions {

    IOSDriver iosDriver;

    public AlertViews(IOSDriver iosDriver) {
        super(iosDriver);
        this.iosDriver = iosDriver;
        PageFactory.initElements(new AppiumFieldDecorator(iosDriver), this);

    }

    //xcuitest is the testing framework supported by ios to identify elements on the page.
    // appium internally uses this xcuitest frameowrk to automated IOS app
    // its internally taking help from native automation framework developed by apple.
    @iOSXCUITFindBy(accessibility = "Alert Views")
    private WebElement alertViews;
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeStaticText[`label =='Text Entry'`]`")
    private WebElement textEntryMenu;

    @iOSXCUITFindBy(iOSNsPredicate = "type == 'XCUIElementTypeStaticText' AND value BEGINSWITH[c] 'Confirm'")
    private WebElement confirmPopUp;

    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeCell")
    private WebElement textBox;

    @iOSXCUITFindBy(accessibility = "OK")
    private WebElement acceptPopUp;

    @iOSXCUITFindBy(iOSNsPredicate = "name BEGINSWITH[c] 'A Message'")
    private WebElement confirmMsg;

    @iOSXCUITFindBy(iOSNsPredicate = "label == 'Confirm'")
    private WebElement submit;

    public void selectAlertViews() {
        alertViews.click();
    }

    public void selectTextMenu(String text) {
        textEntryMenu.click();
        textBox.sendKeys(text);
        acceptPopUp.click();
    }

    public String getConfirmMsg() {
        confirmPopUp.click();
        return confirmMsg.getText();
    }


}
