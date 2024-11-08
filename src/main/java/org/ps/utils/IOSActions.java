package org.ps.utils;

import com.google.common.collect.ImmutableMap;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;

import java.util.HashMap;
import java.util.Map;

public class IOSActions {

    public IOSDriver iosDriver;

    public IOSActions(IOSDriver iosDriver) {
        this.iosDriver = iosDriver;
    }

    public void longPressAction(WebElement ele){

        //IOS Gestures
        Map<String,Object> params = new HashMap<>();
        params.put("element", ((RemoteWebElement)ele).getId());
        params.put("duration", 5);
        iosDriver.executeScript("mobile:touchAndHold", params);
    }

    public void scrollToEndAction(){
        boolean canScrollMore;
        do {
            canScrollMore = (Boolean)
                    ((JavascriptExecutor)iosDriver).executeScript("mobile: longClickGesture", ImmutableMap
                            .of("left", 100, "top", 100, "width", 200, "height", 200,
                                    "direction", "down",
                                    "percent", 3.0));
        } while(canScrollMore);
    }

    public void scrollToText(String text){
        iosDriver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\""+text+"\"))"));
    }

    public void swipeAction(WebElement ele, String direction){
        ((JavascriptExecutor)iosDriver).executeScript("mobile: swipeGesture", ImmutableMap.of("elementId",
                ((RemoteWebElement)ele).getId(), "direction", direction,
                "percent", 0.75));

    }

    public Double getFormattedAmount(String amount){
        Double price = Double.parseDouble(amount.substring(1));
        return price;
    }

}
