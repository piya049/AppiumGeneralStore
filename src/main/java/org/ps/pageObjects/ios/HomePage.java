package org.ps.pageObjects.ios;

import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.ps.utils.IOSActions;

public class HomePage extends IOSActions {

    IOSDriver iosDriver;

    public HomePage(IOSDriver iosDriver) {
        super(iosDriver);
        this.iosDriver = iosDriver;
        PageFactory.initElements(new AppiumFieldDecorator(iosDriver), this);

    }

    //xcuitest is the testing framework supported by ios to identify elements on the page.
    // appium internally uses this xcuitest frameowrk to automated IOS app
    // its internally taking help from native automation framework developed by apple.
    @iOSXCUITFindBy(accessibility = "Alert Views")
    private WebElement alertViews;

    public AlertViews selectAlertViews(){
        alertViews.click();
        return new AlertViews(iosDriver);
    }



}
